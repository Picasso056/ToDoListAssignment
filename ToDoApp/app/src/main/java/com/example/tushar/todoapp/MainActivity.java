package com.example.tushar.todoapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    public static ArrayList<ToDoList>tolist =  new ArrayList<ToDoList>() ;
    private RecyclerView mRecyclerView;
    static int position = -1;
    private ToDoAdapter tAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);
        tolist = db.getAllContacts();

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundDrawable(new ColorDrawable(Color.RED));

        tAdapter =  new ToDoAdapter(tolist);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(tAdapter);
        mRecyclerView.addItemDecoration(new itemDecoration(this, LinearLayoutManager.VERTICAL));


        mRecyclerView.setAdapter(tAdapter);

        tAdapter.notifyDataSetChanged();


    }



    @Override
    protected void onResume() {
        super.onResume();
        tAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.todolistmenu, menu);
        return  true;
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.menu_item)
        {
            Intent intent = new Intent(MainActivity.this,ToDoFragment.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this," Add new item",Toast.LENGTH_SHORT).show();
        }
        return  true;
    }
}

