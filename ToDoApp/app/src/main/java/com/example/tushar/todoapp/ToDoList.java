package com.example.tushar.todoapp;

import java.util.Random;

/**
 * Created by Tushar on 02-11-2016.
 */

public class ToDoList {

    private String description;
    private String message;

    public ToDoList()
    {

    }

    public ToDoList( String message, String description) {
        this.description = description;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
