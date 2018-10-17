package com.ais.aisloginregister.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Copyright (C) 2018 CYu. All rights reserved.
 *
 * @Package: com.ais.aisloginregister
 * @Description:
 * @author: Shaw
 * @date: 17/10
 */
public class StudentDBHelper extends SQLiteOpenHelper {
    public static final String TAG = "StudentDBHelper";
    public static final String DATABASE_NAME = "dbAIS";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "tblUsers";
    public static final String COL1_ID = "ID";
    public static final String COL2_PASSWORD = "PASSWORD";

    public StudentDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_create = "CREATE TABLE " + TABLE_NAME
                + " (" + COL1_ID + " TEXT PRIMARY KEY, "
                + COL2_PASSWORD + " TEXT)";
        db.execSQL(sql_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean doLogin(String id, String pwd) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT " + COL2_PASSWORD + " FROM " + TABLE_NAME
                + " WHERE " + COL1_ID + " = '" + id + "'";
        Cursor cursor = db.rawQuery(query, null);

        Log.d(TAG, "doLogin: " + query);
        String str_password = "0";
        while (cursor.moveToNext()) {
            str_password = cursor.getString(0);
        }

        Log.d(TAG, "doLogin: " + str_password);

        cursor.close();
        db.close();
        return str_password.equals(pwd) ? true : false;
    }

    public boolean doRegister(String id, String pwd) {
        if (doCheck(id)) {
            return false;
        }

        SQLiteDatabase db = this.getWritableDatabase();
//        String sql_register = "INSERT INTO " + TABLE_NAME + " VALUES ( "
//                + "'" + id + "', '" + pwd + "')";
//        db.execSQL(sql_register);

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1_ID, id);
        contentValues.put(COL2_PASSWORD, pwd);

        long lvInsert = db.insert(TABLE_NAME, null, contentValues);
        db.close();

        if (lvInsert > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean doCheck(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String sql_query = "SELECT * FROM " + TABLE_NAME
                + " WHERE " + COL1_ID + " ='" + id + "'";
        Cursor cursor = db.rawQuery(sql_query, null);

        Log.d(TAG, "doCheck: " + sql_query);


        while (cursor.moveToNext()) {
            cursor.close();
            db.close();
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }

}
