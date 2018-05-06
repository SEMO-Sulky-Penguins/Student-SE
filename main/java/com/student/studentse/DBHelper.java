package com.student.studentse;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by stephen on 5/5/2018.
 */


public class DBHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "studentse.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
