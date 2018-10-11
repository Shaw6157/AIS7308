package com.ais.testhomemade;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbMenu extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DBShaw";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "ShawMenu";
    public static final String COL_ID = "menuID";
    public static final String COL_NAME = "menuName";
    public static final String COL_PRICE = "menuPrice";
    public static final String COL_TYPE = "menuType";

    public DbMenu(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreate = "CREATE TABLE " + TABLE_NAME + " ("
                + COL_ID + " INTEGER PRIMARY KEY, "
                + COL_NAME + " TEXT, "
                + COL_PRICE + " INTEGER, "
                + COL_TYPE + " TEXT)";
        db.execSQL(queryCreate);

        String queryInsert1 = "INSERT INTO " + TABLE_NAME + " VALUES ("
                + 1 + ", 'chicken noodles', "
                + 5 + ", 'lunch')";
        db.execSQL(queryInsert1);

        String queryInsert2 = "INSERT INTO " + TABLE_NAME + " VALUES ("
                + 2 + ", 'French fries', "
                + 4 + ", 'lunch')";
        db.execSQL(queryInsert2);

        String queryInsert3 = "INSERT INTO " + TABLE_NAME + " VALUES ("
                + 3 + ", 'Lamb stake', "
                + 15 + ", 'dinner')";
        db.execSQL(queryInsert3);

        String queryInsert4 = "INSERT INTO " + TABLE_NAME + " VALUES ("
                + 4 + ", 'beef stake', "
                + 11 + ", 'dinner')";
        db.execSQL(queryInsert4);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<String> getMenuType() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> menuList = new ArrayList<String>();

        String query = "SELECT DISTINCT (" + COL_TYPE + ") FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            menuList.add(cursor.getString(0));
        }
        return menuList;
    }

    public ArrayList<ShawMenu> getAllMenus(String p_menutype) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<ShawMenu> allMenus = new ArrayList<ShawMenu>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_TYPE + " = '" + p_menutype + "'";
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            ShawMenu eachMenu = new ShawMenu(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3)
            );
            allMenus.add(eachMenu);
        }
        return allMenus;
    }

}
