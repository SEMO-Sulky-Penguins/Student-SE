package com.student.studentse;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by stephen on 5/5/2018.
 */

//This file maintains our database name and version
// It's basically used for helping create a new instance
//Might just make this into a subclass of DBAccessor in the future

public class DBHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "studentse.db";
    private static final int DATABASE_VERSION = 1;

    //this gets a reference to our database
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
