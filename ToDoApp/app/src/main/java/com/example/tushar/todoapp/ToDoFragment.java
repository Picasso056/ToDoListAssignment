package com.example.tushar.todoapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.tushar.todoapp.MainActivity.tolist;

public class ToDoFragment extends AppCompatActivity {

    private EditText msgText ;
    private EditText descText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       final  DatabaseHandler db = new DatabaseHandler(this);
        setContentView(R.layout.activity_to_do_fragment);
        msgText = (EditText) findViewById(R.id.todoItem);
        descText = (EditText) findViewById(R.id.description);

        Toolbar toolbar = (Toolbar) findViewById(R.id.My_toolbar);
        setSupportActionBar(toolbar);

        ActionBar action = getSupportActionBar();
        action.setDisplayHomeAsUpEnabled(true);
        action.setBackgroundDrawable(new ColorDrawable(Color.RED));

        addButton = (Button) findViewById(R.id.addbutton);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



                String message = msgText.getText().toString();
                String desc = descText.getText().toString();

                ToDoList t = new ToDoList(message, desc);
                tolist.add(t);
                db.addContact(t);
                Toast.makeText(ToDoFragment.this,"Item Added",Toast.LENGTH_SHORT).show();
            }
        });
    }




}
