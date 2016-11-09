package com.example.tushar.todoapp;

/**
 * Created by Tushar on 04-11-2016.
 */


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;



        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder> {

    private List<ToDoList> todoList;

    public  class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        public TextView titles;
        private  Context context;

        public MyViewHolder(View view) {
            super(view);
            titles = (TextView) view.findViewById(R.id.title);
            context = view.getContext();
            view.setClickable(true);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent;
            intent = new Intent(context,rowActivity.class);
            MainActivity.position = getAdapterPosition();
            context.startActivity(intent);

           /* if(getAdapterPosition() == 0)
                Toast.makeText(context,"hello",Toast.LENGTH_SHORT).show();

            else if(getAdapterPosition() == 1)
                Toast.makeText(context,"hello op",Toast.LENGTH_SHORT).show();*/
            //System.out.println("onclick " + getAdapterPosition() );
        }
    }

    public ToDoAdapter(List<ToDoList> todoList) {
        this.todoList = todoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.to_do_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ToDoList todo = todoList.get(position);
        holder.titles.setText(todo.getMessage());
      //  holder.itemView.setOnClickListener();

    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
}