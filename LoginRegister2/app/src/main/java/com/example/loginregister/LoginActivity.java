package com.example.loginregister;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.CoordinatorLayout;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //SQLiteDatabase mydatabase = openOrCreateDatabase("myappdb",MODE_PRIVATE,null);
        //mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Users(name VARCHAR,username VARCHAR,password VARCHAR,age INT);");

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);

        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final TextView registerLink = (TextView) findViewById(R.id.tvRegisterHere);

        registerLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                String message = "Wrong";
                DBHandler dbHandler = new DBHandler(this);

                Account account =dbHandler.getAccount(username);

                if (account.getPassword()==password){
                    if(account.getType()){
                        Intent registerIntent = new Intent(LoginActivity.this, ParentActivity.class);
                        LoginActivity.this.startActivity(registerIntent);
                    }
                    else{
                        Intent registerIntent = new Intent(LoginActivity.this, ChildActivity.class);
                        LoginActivity.this.startActivity(registerIntent);
                    }
                }
                else{
                    Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                    LoginActivity.this.startActivity(registerIntent);
                }


                /*
                if (account ==null) {


                }
                else if(account.getPassword !=)
                */


            }



        });
    }
}
