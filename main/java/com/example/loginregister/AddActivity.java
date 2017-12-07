package com.example.loginregister;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by Latitude XT3 on 12/4/2017.
 */

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etDescription = (EditText) findViewById(R.id.etDescription);
        final EditText etAssign = (EditText) findViewById(R.id.etAssign);

        final Button bAdd = (Button) findViewById(R.id.bAdd);

        bAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String name = etName.getText().toString();
                final String description = etDescription.getText().toString();
                final String assign = etAssign.getText().toString();
                //calls on database isntance
                DBHandler dbHandler = DBHandler.getInstance(AddActivity.this);

                //Go back to Parent page
                Intent registerIntent = new Intent(AddActivity.this, ParentActivity.class);
                AddActivity.this.startActivity(registerIntent);






            }
        });


    }

}
