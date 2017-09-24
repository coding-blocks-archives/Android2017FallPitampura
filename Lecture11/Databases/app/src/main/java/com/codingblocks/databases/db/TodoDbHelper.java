package com.codingblocks.databases.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.codingblocks.databases.db.tables.TodoTable;

/**
 * Created by arnav on 9/24/2017.
 */

public class TodoDbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "todo.db";
    public static final int DB_VER = 2;



    public TodoDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TodoTable.CMD_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {

        if (oldVer == 1 && newVer == 2) {
            db.execSQL(TodoTable.CMD_UPD_1_2);
        }

    }
}
