package com.student.studentse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by stephen on 5/5/2018.
 */

public class DBHelper extends SQLiteOpenHelper{

    private String dbPath = null;
    private static String dbName = "studentse";
    private SQLiteDatabase db;
    private final Context newContext;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.newContext = context;
        this.dbPath = context.getDatabasePath(dbName).getPath();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
