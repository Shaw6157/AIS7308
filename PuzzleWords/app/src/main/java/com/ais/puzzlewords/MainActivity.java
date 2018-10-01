package com.ais.puzzlewords;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSports, btnColours, btnAndroids, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btnSports   = findViewById(R.id.btn_sports);
        btnColours  = findViewById(R.id.btn_colours);
        btnAndroids = findViewById(R.id.btn_androids);
        btnAbout    = findViewById(R.id.btn_about);

        btnSports.setOnClickListener(this);
        btnColours.setOnClickListener(this);
        btnAndroids.setOnClickListener(this);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbout = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intentAbout);
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intentPuzzle = new Intent(MainActivity.this, PuzzleActivity.class);
        if (R.id.btn_sports == v.getId()){
            intentPuzzle.putExtra("questions", "s");
        } else if (R.id.btn_colours == v.getId()) {
            intentPuzzle.putExtra("questions", "c");
        } else {
            intentPuzzle.putExtra("questions", "a");
        }
        startActivity(intentPuzzle);
    }
}
