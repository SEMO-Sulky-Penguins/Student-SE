package com.student.studentse;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephen on 5/5/2018.
 */

public class DBAccessor {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DBAccessor instance;

    private DBAccessor(Context context) {
        this.openHelper = new DBHelper(context);
    }

    public static DBAccessor getInstance(Context context) {
        if (instance == null) {
            instance = new DBAccessor(context);
        }
        return instance;
    }

    public void open() {
        this.db = openHelper.getReadableDatabase();
    }

    public void close() {
        if (db != null) this.db.close();
    }

    public List<String> getEvents() {
        return getData("SELECT * FROM events",1,4);
    }

    public List<String> getInternships() {
        return getData("SELECT * FROM opportunities WHERE isJob = 0 AND isInternship = 1 AND isResearch = 0",1,3);
    }

    public List<String> getResearch() {
        return getData("SELECT * FROM opportunities WHERE isJob = 0 AND isInternship = 0 AND isResearch = 1",1,3);
    }

    public List<String> getJobs() {
        return getData("SELECT * FROM opportunities WHERE isJob = 1 AND isInternship = 0 AND isResearch = 0",1,3);
    }

    private List<String> getData(String queryString, int colTitle, int colDate) {
            List<String> list = new ArrayList<>();
            Cursor cursor = db.rawQuery(queryString, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String listItemInfo = cursor.getString(colTitle) + " " + cursor.getString(colDate);
                list.add(listItemInfo);
                cursor.moveToNext();
            }
            cursor.close();
            return list;
    }
}
