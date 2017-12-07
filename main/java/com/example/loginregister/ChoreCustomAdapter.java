package com.example.loginregister;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



import java.util.ArrayList;


/**
 * Created by Imaan on 2017-12-06.
 */

public class ChoreCustomAdapter extends ArrayAdapter {

    private final Context context;
    private final ArrayList<Chore> chores;

    public ChoreCustomAdapter(Context context, ArrayList<Chore> values) {
        super(context, R.layout.chore_item_layout,values);
        this.context = context;
        this.chores = values;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.chore_item_layout, parent, false);

        TextView choreNameTextField = (TextView) rowView.findViewById(R.id.itemName);
        TextView choreDescriptionTextField = (TextView) rowView.findViewById(R.id.itemDescription);

        Chore curChore = chores.get(position);

        choreNameTextField.setText(curChore.getName());
        choreDescriptionTextField.setText(curChore.getDescription());

        return rowView;

    }
}
