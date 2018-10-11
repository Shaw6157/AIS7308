package com.ais.demosqlitequiz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public static final String DATABSE_NAME = "dbQuiz";
    public static final int DATABASE_VERSION = 2;

    public static final String TABLE_NAME = "tblQuestions";
    public static final String COLUMN_QUESTION_ID = "questionID";
    public static final String COLUMN_QUESTION = "question";
    public static final String COLUMN_QUIZNAME = "quizName";
    public static final String COLUMN_OPTION1 = "option1";
    public static final String COLUMN_OPTION2 = "option2";
    public static final String COLUMN_OPTION3 = "option3";
    public static final String COLUMN_OPTION4 = "option4";
    public static final String COLUMN_CORRECT_OPTION = "correntOption";

    public Database(Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_QUESTION_ID + " INTEGER PRIMARY KEY, "
                + COLUMN_QUESTION + " TEXT, "
                + COLUMN_QUIZNAME + " TEXT, "
                + COLUMN_OPTION1 + " TEXT, "
                + COLUMN_OPTION2 + " TEXT, "
                + COLUMN_OPTION3 + " TEXT, "
                + COLUMN_OPTION4 + " TEXT, "
                + COLUMN_CORRECT_OPTION + " INTEGER)";
        db.execSQL(query);

        String insertstr = "INSERT INTO " + TABLE_NAME + " VALUES( " + 1 + ", "
                + "'what is HTML?', 'HTML', 'HTMLLL', 'aaa', 'bbbb', 'ccccc', 1 )";
        db.execSQL(insertstr);

        String insertstr2 = "INSERT INTO " + TABLE_NAME + " VALUES( " + 2 +", "
                + "'what is java?', 'JAVA', 'eeeee', 'aaa', 'JAVA', 'ccccc', 3 )";
        db.execSQL(insertstr2);

        String insertstr3 = "INSERT INTO " + TABLE_NAME + " VALUES( " + 3 +", "
                + "'java code?', 'JAVA', 'new', 'aaa', 'bbbb', 'ccccc', 1 )";
        db.execSQL(insertstr3);

        String insertstr4 = "INSERT INTO " + TABLE_NAME + " VALUES( " + 4 +", "
                + "'C# product?', 'C#', 'microsoft', 'google', 'oracle', 'IBM', 1 )";
        db.execSQL(insertstr4);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<String> getQuizNames() {
        String query = "SELECT DISTINCT (" + COLUMN_QUIZNAME + ") FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        ArrayList<String> listData = new ArrayList<>();
        while (cursor.moveToNext()) {
            listData.add(cursor.getString(0));
        }
        return listData;
    }

    public ArrayList<CompleteQuestion> getALLQuestions(String p_quizName) {
        String query = "SELECT * FROM " + TABLE_NAME + " where " + COLUMN_QUIZNAME + " = '" + p_quizName + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        ArrayList<CompleteQuestion> listQuestions = new ArrayList<>();
        while (cursor.moveToNext()) {
            CompleteQuestion eachQuestion = new CompleteQuestion(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getInt(7),
                    cursor.getString(2)
            );
            listQuestions.add(eachQuestion);
        }
        return listQuestions;
    }
}
