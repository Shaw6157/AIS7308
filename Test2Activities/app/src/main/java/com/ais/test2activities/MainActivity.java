package com.ais.test2activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnf, btnp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnf = findViewById(R.id.btnf);
        btnp = findViewById(R.id.btnp);


        //TODO use separate class
        btnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toOne = new Intent(MainActivity.this, TwoActivity.class);
                toOne.putExtra("type", "fulltime");
                startActivity(toOne);
            }
        });

        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toOne = new Intent(MainActivity.this, TwoActivity.class);
                toOne.putExtra("type", "parttime");
                startActivity(toOne);
            }
        });
    }
}
