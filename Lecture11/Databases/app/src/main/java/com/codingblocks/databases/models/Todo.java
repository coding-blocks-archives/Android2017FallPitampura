package com.codingblocks.databases.models;

/**
 * Created by arnav on 9/24/2017.
 */

public class Todo {
    int id;
    String task;
    boolean done;

    public Todo(int id, String task, boolean done) {
        this.id = id;
        this.task = task;
        this.done = done;
    }

    public Todo(String task, boolean done) {
        this.task = task;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public boolean isDone() {
        return done;
    }
}
