package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Latitude XT3 on 12/6/2017.
 */

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etDescription = (EditText) findViewById(R.id.etDescription);
        final EditText etAssign = (EditText) findViewById(R.id.etAssign);

        final Button bAdd = (Button) findViewById(R.id.bAdd);
        final Button bDelete = (Button) findViewById(R.id.bDelete);

        bAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String name = etName.getText().toString();
                final String description = etDescription.getText().toString();
                final String assign = etAssign.getText().toString();
                //calls on database isntance
                DBHandler dbHandler = DBHandler.getInstance(EditActivity.this);

                //Go back to Parent page
                Intent registerIntent = new Intent(EditActivity.this, ParentActivity.class);
                EditActivity.this.startActivity(registerIntent);






            }
        });
        bDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //calls on database isntance
                DBHandler dbHandler = DBHandler.getInstance(EditActivity.this);

                //Go back to Parent page
                Intent registerIntent = new Intent(EditActivity.this, ParentActivity.class);
                EditActivity.this.startActivity(registerIntent);






            }
        });


    }

}