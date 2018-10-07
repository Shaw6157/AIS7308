package com.ais.demosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DemoDB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dbStudent";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME  = "tblStudent";
    public static final String COLUMN_ID   = "stuID";
    public static final String COLUMN_NAME = "stuName";
    public static final String COLUMN_AGE  = "stuAge";

    public DemoDB (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "Create table " + TABLE_NAME + "(" +
                COLUMN_ID + " TEXT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_AGE + " INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertStudents(String id, String name, int age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(COLUMN_ID,     id);
        contentValue.put(COLUMN_NAME,   name);
        contentValue.put(COLUMN_AGE,    age);
        db.insert(TABLE_NAME, null, contentValue);
        db.close();
    }

    public int getCountStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        int count = cursor.getCount();
        db.close();
        cursor.close();
        return count;
    }


}
