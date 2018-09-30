package com.ais.demoeventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout lytroot;
    Button btn1, btn5;
    int counter = 0;
    TextView tvresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lytroot = (LinearLayout) findViewById(R.id.lytRoot);

        btn1 = new Button(this);
        btn5 = new Button(this);

        btn1.setText("increase by 1");
        btn5.setText("increase by 5");

        lytroot.addView(btn1);
        lytroot.addView(btn5);

        btn1.setOnClickListener(this);
        btn5.setOnClickListener(this);

        btn1.setOnLongClickListener(new SubLong());
        btn5.setOnLongClickListener(new SubLong());

        tvresult = new TextView(this);
        tvresult.setText("Result shows here: " + counter);
        tvresult.setTextSize(30);
        lytroot.addView(tvresult);

    }

    @Override
    public void onClick(View v) {
        if (v == btn1) {
            counter += 1;
            Toast.makeText(this, "after plusing 1 :"  + counter, Toast.LENGTH_SHORT).show();
        } else {
            counter += 5;
            Toast.makeText(this, "plus 5 :"  + counter, Toast.LENGTH_SHORT).show();
        }
        tvresult.setText("Result shows here: " + counter);
    }
    class SubLong implements View.OnLongClickListener{

        @Override
        public boolean onLongClick(View v) {
            if (v == btn1) {
                counter += 10;
                Toast.makeText(Main2Activity.this, "loooong 10 :"  + counter, Toast.LENGTH_SHORT).show();
            } else {
                counter += 50;
                Toast.makeText(Main2Activity.this, "for looooong 50 :"  + counter, Toast.LENGTH_SHORT).show();
            }
            tvresult.setText("Result shows here: " + counter);
            return false;
        }
    }
}
