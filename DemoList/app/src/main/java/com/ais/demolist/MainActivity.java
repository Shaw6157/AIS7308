package com.ais.demolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    DatabaseHelper mDatabaseHelper
    private Button btnAdd, btnView;
    private EditText etStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etStr   = (EditText) findViewById(R.id.etString);
        btnAdd  = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btView);

        mDatabaseHelper = new DatabaseHelper(this);

    }
}
