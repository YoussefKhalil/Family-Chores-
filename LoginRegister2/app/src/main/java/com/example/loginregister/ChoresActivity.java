package com.example.loginregister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by Latitude XT3 on 12/6/2017.
 */

public class ChoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chores);

        final ListView lvChores = (ListView) findViewById(R.id.lvChores);

    }

}


