package com.ais.test2activities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Copyright (C) 2018 CYu. All rights reserved.
 *
 * @Package: com.ais.test2activities
 * @Description:
 * @author: Shaw
 * @date: 16/10
 */
public class EmployeeDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "tblEmployee";
    public static final String COL1_NAME = "Name";
    public static final String COL2_POSITION = "Position";
    public static final String COL3_TYPE = "Type";
    public static final String COL4_SALARY = "Salary";

    public EmployeeDBHelper(Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE " + TABLE_NAME
                + " (" + COL1_NAME + " TEXT PRIMARY KEY, "
                + COL2_POSITION + " TEXT, "
                + COL3_TYPE + " TEXT, "
                + COL4_SALARY + " INTEGER)";
        db.execSQL(create_table);

        String str_insert1 = "INSERT INTO " + TABLE_NAME + " VALUES ("
                + "'ShuaibM', "
                + "'Lecturer', "
                + "'parttime', "
                + 80 + ")";
        db.execSQL(str_insert1);
        String str_insert2 = "INSERT INTO " + TABLE_NAME + " VALUES ("
                + "'Mike', "
                + "'Lecturer', "
                + "'fulltime', "
                + 100 + ")";
        db.execSQL(str_insert2);
        String str_insert3 = "INSERT INTO " + TABLE_NAME + " VALUES ("
                + "'Jay', "
                + "'Asisstant', "
                + "'parttime', "
                + 50 + ")";
        db.execSQL(str_insert3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void getAllEmployees() {

    }

    public ArrayList<EmployeeBean> getEmployees(String pType) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();

        String sql = "SELECT * FROM " + TABLE_NAME
                + " WHERE " + COL3_TYPE + " = " +pType;
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            EmployeeBean oneEmployee = new EmployeeBean(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3)
            );
            list.add(oneEmployee);
        }

        return list;
    }

    public boolean addEmployee(String pName, String pPosition, String pType, int pSalary) {

        SQLiteDatabase db = this.getWritableDatabase();
        String str_insert3 = "INSERT INTO " + TABLE_NAME + " VALUES ("
                + "'Jay', "
                + "'Asisstant', "
                + "'parttime', "
                + 50 + ")";
        db.execSQL(str_insert3);
        return true;
    }

}
