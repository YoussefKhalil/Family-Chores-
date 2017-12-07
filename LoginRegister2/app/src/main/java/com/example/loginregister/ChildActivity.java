package com.example.loginregister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Latitude XT3 on 12/4/2017.
 */


public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

         DBHandler db = DBHandler.getInstance(ChildActivity.this);

        ArrayList<Chore> chores = db.getAllChores();

        ListView listView = (ListView) findViewById(R.id.lvChores);

        ChoreCustomAdapter adapter = new ChoreCustomAdapter(this,chores);

        listView.setAdapter(adapter);

    }
}
