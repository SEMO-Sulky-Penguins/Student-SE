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

/*This is the file for SQLite instances
 * It's a little unconventional since it doesn't directly extend from SQLiteOpenHelper, but it works
 * Also, our program is a little unconventional since we're utilising an external db instead of
 * one that is made through a java library like all the tutorials suggest.
*/

//Note: Android Studio keeps yelling that the public methods can be private. They can't. DBActivity calls on them.
public class DBAccessor {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DBAccessor instance; //get an instance of our database

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
        this.db = openHelper.getReadableDatabase(); //opens the connection
    }

    public void close() {
        if (db != null) this.db.close(); //closes the connection
    }

    public List<String> getEvents() { //forms the query string for events
        return getData("SELECT * FROM events",1,4);
    }

    public List<String> getInternships() { //forms the query string for internships
        return getData("SELECT * FROM opportunities WHERE isJob = 0 AND isInternship = 1 AND isResearch = 0",1,3);
    }

    public List<String> getResearch() { //forms the query string for research
        return getData("SELECT * FROM opportunities WHERE isJob = 0 AND isInternship = 0 AND isResearch = 1",1,3);
    }
    //this one is currently not used since we're experimenting with using an api for jobs
    public List<String> getJobs() { //forms the query string for jobs
        return getData("SELECT * FROM opportunities WHERE isJob = 1 AND isInternship = 0 AND isResearch = 0",1,3);
    }
    //takes in a query, executes it, gets data from our sqlite table, then returns it in list format
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
