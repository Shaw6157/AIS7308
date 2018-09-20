package com.ais.zkidslandapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnToQ (View v){
        Intent intentToQ = new Intent(this, QuestionActivity.class);

        switch (v.getId()) {
            case R.id.btnPlus:
                intentToQ.putExtra("p_operator", "+");
                break;
            case R.id.btnMinus:
                intentToQ.putExtra("p_operator", "-");
                break;
            case R.id.btnMultiply:
                intentToQ.putExtra("p_operator", "*");
                break;
            case R.id.btnDivide:
                intentToQ.putExtra("p_operator", "/");
                break;
            default:
                intentToQ.putExtra("p_operator", "");
                break;
        }

        startActivity(intentToQ);
    }

}
