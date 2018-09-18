package com.ais.simplecalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtnum1, txtnum2, txtResult;
    int lv_num1, lv_num2, lv_sum;

    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnum1 = (TextView) findViewById(R.id.txtNum1);
        txtnum2 = (TextView) findViewById(R.id.txtNum2);
        txtResult = (TextView) findViewById(R.id.txtResult);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //        imm.showSoftInput(view,InputMethodManager.SHOW_FORCED);
    }

    public void btnPlus(View v){
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0); //强制隐藏键盘
        if (checkBothNum()) {
            lv_sum = lv_num1 + lv_num2;
            txtResult.setText(lv_sum + "");
        }
    }

    public void btnMinus(View v) {
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0); //强制隐藏键盘
        if (checkBothNum()) {
            lv_sum = lv_num1 - lv_num2;
            txtResult.setText(lv_sum + "");
        }
    }

    public void btnMultiply(View v) {
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0); //强制隐藏键盘
        if (checkBothNum()) {
            lv_sum = lv_num1 * lv_num2;
            txtResult.setText(lv_sum + "");
        }
    }

    public void btnDivide(View v) {
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0); //强制隐藏键盘
        if (checkBothNum()) {
            if (lv_num2 == 0) {
                txtResult.setText("E");
                Toast.makeText(this, "Oops, NUM2 cannot be 0 !", Toast.LENGTH_SHORT).show();
            } else {
                lv_sum = lv_num1 / lv_num2;
                txtResult.setText(lv_sum + "");
            }
        }
    }

    private static boolean isNullStr(String str) {
        return (str == null) || (str.length() < 1);
    }

    private static boolean isNullStr(CharSequence str) {
        return (str == null) || (str.length() < 1);
    }

    private boolean checkBothNum() {
        if (isNullStr(txtnum1.getText()) || isNullStr(txtnum2.getText())) {
            Toast.makeText(this, "Oops, NUM1 or NUM2 cannot be blank!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            lv_num1 = Integer.parseInt(txtnum1.getText().toString());
            lv_num2 = Integer.parseInt(txtnum2.getText().toString());
        }
        return true;
    }

}
