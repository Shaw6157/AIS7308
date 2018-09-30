package com.ais.demoeventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class SeparateActivity extends AppCompatActivity {

    Button btn1, btn2;
    LinearLayout lytroot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_separate);

        btn1 = new Button(this);
        btn2 = new Button(this);
        btn1.setText("try Separate class");
        btn2.setText("Exit");

        lytroot = (LinearLayout) findViewById(R.id.lytRoot);
        lytroot.addView(btn1);
        lytroot.addView(btn2);

        btn1.setOnClickListener(new SaveDataListener(this));
    }

}
