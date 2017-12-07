package com.example.loginregister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Latitude XT3 on 12/6/2017.
 */

public class ChoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chores);

        DBHandler db = DBHandler.getInstance(ChoresActivity.this);

        ArrayList<Chore> chores = db.getAllChores();

        ListView lvChores = (ListView) findViewById(R.id.lvChores);

        ChoreCustomAdapter adapter = new ChoreCustomAdapter(this,chores);

        lvChores.setAdapter(adapter);

    }

}


