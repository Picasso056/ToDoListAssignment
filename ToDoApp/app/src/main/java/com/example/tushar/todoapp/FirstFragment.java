package com.example.tushar.todoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Tushar on 08-11-2016.
 */

public class FirstFragment extends Fragment {


    public static FirstFragment newInstance(ToDoList item) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle bundle = new Bundle();
        bundle.putString("msg", item.getMessage());
        bundle.putString("desc",item.getDescription());
        fragmentFirst.setArguments(bundle);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        String Tmessage = (String)getArguments().getSerializable("msg");
        String Tdesc = (String)getArguments().getSerializable("desc");

        TextView tvLabel = (TextView) view.findViewById(R.id.todoItem);
        TextView label2 = (TextView)view.findViewById(R.id.description);
         tvLabel.setText(Tmessage);
         label2.setText(Tdesc);
        return view;
    }
}
