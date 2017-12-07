package com.example.loginregister;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Latitude XT3 on 12/4/2017.
 */

public class ParentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        //Setting buttons
        final Button bAddMenu = (Button) findViewById(R.id.bAddMenu);
        final Button bEditMenu = (Button) findViewById(R.id.bAddMenu);
        final Button bChoresMenu = (Button) findViewById(R.id.bChoresMenu);

        //Connecting buttons to locations
        bAddMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent registerIntent = new Intent(ParentActivity.this, AddActivity.class);
                ParentActivity.this.startActivity(registerIntent);






            }
        });
        bEditMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent registerIntent = new Intent(ParentActivity.this, EditActivity.class);
                ParentActivity.this.startActivity(registerIntent);






            }
        });
        bChoresMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent registerIntent = new Intent(ParentActivity.this, ChoresActivity.class);
                ParentActivity.this.startActivity(registerIntent);






            }
        });


    }

    
}
