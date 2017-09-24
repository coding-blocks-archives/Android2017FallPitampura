package com.codingblocks.databases.db.tables;

/**
 * Created by arnav on 9/24/2017.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.codingblocks.databases.models.Todo;

import java.util.ArrayList;

import static com.codingblocks.databases.db.tables.DbConsts.*;

public class TodoTable {
    public static final String TABLE_NAME = "todos";

    public interface Columns {
        String ID = "id";
        String TASK = "task";
    }

    public static final String CMD_CREATE =
            CMD_CREATE_TABLE_INE + TABLE_NAME +
                    LBR +
                    Columns.ID + TYPE_INT + TYPE_PK + TYPE_AI + COMMA +
                    Columns.TASK + TYPE_TEXT +
                    RBR +
                    SEMI;
    public static ArrayList<Todo> getAllTodos (SQLiteDatabase db) {
        ArrayList<Todo> todos = new ArrayList<>();

        Cursor c = db.query(
                TABLE_NAME,
                new String[] {Columns.ID, Columns.TASK},
                null,
                null,
                null,
                null,
                null
        );
        int colForId = c.getColumnIndex(Columns.ID);
        int colForTask = c.getColumnIndex(Columns.TASK);
        while (c.moveToNext()) {
            todos.add(
                    new Todo(
                            c.getInt(colForId),
                            c.getString(colForTask),
                            false
                    )
            );
        }
        return  todos;
    }

    public static long insertTodo (SQLiteDatabase db, Todo todo) {
        ContentValues todoData = new ContentValues();
        todoData.put(Columns.TASK, todo.getTask());
        return db.insert(
                TABLE_NAME,
                null,
                todoData
        );
    }

    public static void deleteTodo (SQLiteDatabase db, int todoId) {

    }


}
