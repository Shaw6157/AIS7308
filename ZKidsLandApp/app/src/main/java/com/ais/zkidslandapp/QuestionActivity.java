package com.ais.zkidslandapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class QuestionActivity extends AppCompatActivity {

    TextView tvTitle_Q, tvQuestion;
    Button btnNum1, btnNum2, btnNum3, btnNum4;

    int gv_answer = 0;
    int gv_numbtn = 4;
    String pi_operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        tvTitle_Q = (TextView) findViewById(R.id.tvTitle_Q);
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);

        btnNum1 = (Button) findViewById(R.id.btnNum1);
        btnNum2 = (Button) findViewById(R.id.btnNum2);
        btnNum3 = (Button) findViewById(R.id.btnNum3);
        btnNum4 = (Button) findViewById(R.id.btnNum4);

        pi_operator = this.getIntent().getExtras().get("p_operator").toString();

        loadData();
    }

    public void btnCheck (View v){
        loadData();
    }

    private void loadData(){
        int lv_num1 = rollDice(10);
        int lv_num2 = rollDice(10);

//        String lv_operator = "+";

        tvQuestion.setText(lv_num1 + pi_operator + lv_num2 + " = ? ");

        gv_answer = findAnswer(pi_operator, lv_num1, lv_num2);
        placeNumbers();

    }

    private int findAnswer(String operator, int num1, int num2){
        if (operator.equals("+")){
            return num1 + num2;
        } else if (operator.equals("-")){
            return num1 - num2;
        } else if (operator.equals("*")){
            return num1 * num2;
        } else {
            return num1 / num2;
        }
    }

    private void placeNumbers(){
        int lv_postion = rollDice(gv_numbtn);

        Button btns[] = {btnNum1, btnNum2, btnNum3, btnNum4};   //hard code
        for (int i = 0; i < gv_numbtn; i++){
            if (lv_postion == i){
                btns[i].setText("" + gv_answer);
            } else {
                btns[i].setText("" + generateWrongAnswer());
            }
        }
    }

    private int generateWrongAnswer(){
        return new Random().nextInt(8) + gv_answer - 3;
    }

    private int rollDice(int sides) {
        return new Random().nextInt(sides);
    }





}
