package com.ais.demoeventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout lytroot;
    Button btnCounter;
    Button btnCounter2;
    Button btnCounter3;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lytroot = (LinearLayout) findViewById(R.id.lytRoot);

        btnCounter = new Button(this);
        btnCounter2 = new Button(this);
        btnCounter3 = new Button(this);

        defineButton(btnCounter, "Total until now: " + counter, false);
        defineButton(btnCounter2, "also click: " + counter, false);
        defineButton(btnCounter3, "Subclass approach", true);
    }

    public void defineButton(Button btn, String text, Boolean isSub) {
//        btn = new Button(this);
        btn.setText(text);
        lytroot.addView(btn);

        if (isSub) {
            btn.setOnClickListener(new SubClassLis());
            btn.setOnLongClickListener(new SubClassLisLong());
        } else {
            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v){
        if (v ==btnCounter) {
            Toast.makeText(this, "You clicked" +(v == btnCounter) + ++counter + " times", Toast.LENGTH_SHORT).show();
        } else {
            counter += 5;
            Toast.makeText(this, "You clicked another one:  " +(v == btnCounter)  + counter + " times", Toast.LENGTH_SHORT).show();
        }
    }

    class SubClassLis implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "SubClass runs", Toast.LENGTH_SHORT).show();
        }
    }


    class SubClassLisLong implements View.OnLongClickListener {
        @Override
        public boolean onLongClick(View v) {
            Toast.makeText(MainActivity.this, "looooooooong", Toast.LENGTH_LONG).show();
            return false;
        }
    }



}
