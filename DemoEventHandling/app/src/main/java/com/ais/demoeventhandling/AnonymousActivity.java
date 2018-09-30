package com.ais.demoeventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AnonymousActivity extends AppCompatActivity {

    Button btn1, btn2;
    LinearLayout lytroot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anonymous);

        btn1 = new Button(this);
        btn2 = new Button(this);
        btn1.setText("Click here");
        btn2.setText("Exit");

        lytroot = (LinearLayout) findViewById(R.id.lytRoot);
        lytroot.addView(btn1);
        lytroot.addView(btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AnonymousActivity.this, "here u go", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AnonymousActivity.this, "See you!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
