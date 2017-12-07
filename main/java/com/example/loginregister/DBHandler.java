package com.example.loginregister; /**
 * Created by Imaan on 2017-12-03.
 */

//Code from this source was modified: http://mobilesiri.com/android-sqlite-database-tutorial-using-android-studio/
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "choreManager";
    // Accounts table name
    private static final String TABLE_ACCOUNTS = "accounts";
    // Accounts Table Column names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PASSWORD = "passsword";
    private static final String KEY_POINTS = "points";
    private static final String KEY_TYPE = "type";
    //Chores table name
    private static final String TABLE_CHORES = "chores";
    //Chores Table Column names
    private static final String KEY_CHORE = "chore";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_ACCOUNTNAME = "accountName";

    //Instance of DBandler
    private static DBHandler helper;
    private Context context;

    public DBHandler(View.OnClickListener context) {
        super((Context) context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public static synchronized DBHandler getInstance(Context context)
    {
        if(helper == null)
        {
            helper = new DBHandler(context);

        }

        return helper;
    }

    public DBHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FIRST_TABLE = "CREATE TABLE " + TABLE_ACCOUNTS + "("
        + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
        + KEY_PASSWORD + " TEXT," + KEY_POINTS + " TEXT," + KEY_TYPE + " TEXT" + ")";
        String CREATE_SECOND_TABLE = "CREATE TABLE " + TABLE_CHORES + "("
        + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CHORE + " TEXT," + KEY_ACCOUNTNAME + " TEXT," + KEY_DESCRIPTION + " TEXT" + ")";

        db.execSQL(CREATE_FIRST_TABLE);
        db.execSQL(CREATE_SECOND_TABLE);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNTS);
// Creating tables again
        onCreate(db);
    }

    public void addAccount(Account account){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, account.getName()); // Account Name
        values.put(KEY_PASSWORD, account.getPassword()); // Account Password
        values.put(KEY_POINTS, account.getPoints());
        values.put(KEY_TYPE, account.getType());
        // Inserting Row
        db.insert(TABLE_ACCOUNTS, null, values);
        db.close(); // Closing database connection
    }

    public Account getAccount(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * FROM Accounts WHERE USERNAME = " + username, null);
        if (cursor != null)
            cursor.moveToFirst();
        Account account = new Account(cursor.getString(1),
                cursor.getString(2), Integer.parseInt(cursor.getString(3)), Boolean.valueOf(cursor.getString(4)));
// return account
        return account;
    }

    public void addChore(Chore chore){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CHORE, chore.getName()); // Account Name
        values.put(KEY_DESCRIPTION, chore.getDescription()); // Account Password
        values.put(KEY_ACCOUNTNAME, chore.getAssignedTo());
        db.insert(TABLE_ACCOUNTS, null, values);
        db.close(); // Closing database connection

    }

    public Chore getChore(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CHORES, new String[] { KEY_ID,
                        KEY_CHORE, KEY_DESCRIPTION, KEY_ACCOUNTNAME }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Chore contact = new Chore(cursor.getString(1),
                cursor.getString(2), cursor.getString(3));
// return account
        return contact;

    }

    public ArrayList<Chore> getAllChores() {
        ArrayList<Chore> choreList = new ArrayList<Chore>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_CHORES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Chore chore = new Chore(cursor.getString(1), cursor.getString(2), cursor.getString(3));
// Adding contact to list
                choreList.add(chore);
            } while (cursor.moveToNext());
        }
// return contact list
        return choreList;
    }

    public int updateChore(Chore chore) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CHORE, chore.getName());
        values.put(KEY_DESCRIPTION, chore.getDescription());
        values.put(KEY_ACCOUNTNAME, chore.getAssignedTo());
// updating row
        return db.update(TABLE_CHORES, values, KEY_CHORE + " = ?",
                new String[]{String.valueOf(chore.getName())});
    }

    public void deleteChore(String choreName){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CHORES, KEY_CHORE + " = ?",
        new String[] { choreName });
        db.close();
    }

}
