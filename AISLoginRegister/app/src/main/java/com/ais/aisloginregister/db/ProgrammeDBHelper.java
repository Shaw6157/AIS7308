package com.ais.aisloginregister.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ais.aisloginregister.bean.ProgrammeBean;

import java.util.ArrayList;

/**
 * Copyright (C) 2018 CYu. All rights reserved.
 *
 * @Package: com.ais.aisloginregister
 * @Description:
 * @author: Shaw
 * @date: 17/10
 */
public class ProgrammeDBHelper extends SQLiteOpenHelper {
    public static final String TAG = "ProgrammeDBHelper";
    public static final String DATABASE_NAME = "dbAISProgramme";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "tblProgramme";
    public static final String COL1_ID = "ID";
    public static final String COL2_NAME = "ProgrammeName";
    public static final String COL3_TYPE = "ProgrammeType";

    public ProgrammeDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_create = "CREATE TABLE " + TABLE_NAME
                + " (" + COL1_ID + " INTEGER PRIMARY KEY, "
                + COL2_NAME + " TEXT, "
                + COL3_TYPE + " TEXT)";
        db.execSQL(sql_create);

        String sql_insert1 = "INSERT INTO " + TABLE_NAME + " VALUES ( "
                + 1 + ", 'Dipoma in Business Admin', 'Business Administration')";
        db.execSQL(sql_insert1);
        String sql_insert2 = "INSERT INTO " + TABLE_NAME + " VALUES ( "
                + 2 + ", 'PGD in Business Admin', 'Business Administration')";
        db.execSQL(sql_insert2);
        String sql_insert3 = "INSERT INTO " + TABLE_NAME + " VALUES ( "
                + 3 + ", 'Master in Business Admin', 'Business Administration')";
        db.execSQL(sql_insert3);

        String sql_insert4 = "INSERT INTO " + TABLE_NAME + " VALUES ( "
                + 4 + ", 'Diploma in IT', 'Information Technology')";
        db.execSQL(sql_insert4);
        String sql_insert5 = "INSERT INTO " + TABLE_NAME + " VALUES ( "
                + 5 + ", 'Bachelor of IT', 'Information Technology')";
        db.execSQL(sql_insert5);
        String sql_insert6 = "INSERT INTO " + TABLE_NAME + " VALUES ( "
                + 6 + ", 'Graduate Diploma in IT', 'Information Technology')";
        db.execSQL(sql_insert6);

        String sql_insert7 = "INSERT INTO " + TABLE_NAME + " VALUES ( "
                + 7 + ", 'Barista Skills Certificate', 'Hospitality Management')";
        db.execSQL(sql_insert7);
        String sql_insert8 = "INSERT INTO " + TABLE_NAME + " VALUES ( "
                + 8 + ", 'NZ Certificate in Food', 'Hospitality Management')";
        db.execSQL(sql_insert8);
        String sql_insert9 = "INSERT INTO " + TABLE_NAME + " VALUES ( "
                + 9 + ", 'NZD in Hospitality MGT', 'Hospitality Management')";
        db.execSQL(sql_insert9);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<String> getTypes() {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT DISTINCT (" + COL3_TYPE + ") FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        ArrayList<String> listData = new ArrayList<>();
        while (cursor.moveToNext()) {
            listData.add(cursor.getString(0));
        }

        cursor.close();
        db.close();
        return listData;
    }

    public ArrayList<ProgrammeBean> getProgrammes(String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<ProgrammeBean> listProgrammes = new ArrayList<ProgrammeBean> ();

        String sql_query = "SELECT * FROM " + TABLE_NAME
                + " WHERE " + COL3_TYPE + " ='" + type + "'";
        Cursor cursor = db.rawQuery(sql_query, null);

        Log.d(TAG, "getProgrammes: " + sql_query);
        while (cursor.moveToNext()) {
            ProgrammeBean oneProgramme = new ProgrammeBean(
                    cursor.getString(1),
                    cursor.getString(2)
            );
            listProgrammes.add(oneProgramme);
        }

        cursor.close();
        db.close();
        return listProgrammes;
    }

}
