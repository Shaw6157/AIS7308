package com.ais.puzzlewords;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PuzzleActivity extends AppCompatActivity implements View.OnClickListener {
    String[] sports = {"football", "chess", "marathon", "golf", "tennis"};
    String[] colours = {"violet", "orchid", "mintcream", "khaki", "silver"};
    String[] androids = {"lollipop", "oreo", "froyo", "donut", "kitkat", "nougat"};
    String[] questions;
    String str_question;
    int gv_wrong = 0;   //how many times you pressed the wrong letter
    int gv_left = 0;

    ImageView imgx1, imgx2, imgx3, imghman;
    TextView tv_hint;
    LinearLayout lytanswer;
    TextView[] tv_letters;
    Button btnquit;
    Button btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19,
            btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29,
            btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn31;
    Button[] btns = {btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19,
            btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29,
            btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38};
    int[] btnids = {R.id.btn11, R.id.btn12, R.id.btn13, R.id.btn14, R.id.btn15, R.id.btn16, R.id.btn17, R.id.btn18, R.id.btn19,
            R.id.btn21, R.id.btn22, R.id.btn23, R.id.btn24, R.id.btn25, R.id.btn26, R.id.btn27, R.id.btn28, R.id.btn29,
            R.id.btn31, R.id.btn32, R.id.btn33, R.id.btn34, R.id.btn35, R.id.btn36, R.id.btn37, R.id.btn38 };
    char[] charletters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                        'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        //initialize the UI
        initView();

        //get value from MainActivity
        if (this.getIntent().getExtras().get("questions") == null) {
            Toast.makeText(this, " MAIN DB ERROR !", Toast.LENGTH_SHORT);
            return;
        }
        String p_value = this.getIntent().getExtras().get("questions").toString();
        if ("s".equals(p_value)){
            questions = sports;
            tv_hint.setText("HINT:  SPORTS");
        } else if ("c".equals(p_value)) {
            questions = colours;
            tv_hint.setText("HINT:  COLOURS");
        } else {
            questions = androids;
            tv_hint.setText("HINT:  ANDROIDS");
        }

        initData();
    }

    private void initView() {
        imgx1   = findViewById(R.id.img_x1);
        imgx2   = findViewById(R.id.img_x2);
        imgx3   = findViewById(R.id.img_x3);
        imghman = findViewById(R.id.img_hman);

        tv_hint = findViewById(R.id.tv_hint);
        btnquit = findViewById(R.id.btn_quit);
        lytanswer = findViewById(R.id.lyt_answer);

        //Event handler binding
        for (int i = 0; i < btns.length; i++) {
            initBtn(btns[i], btnids[i]);
        }
        btnquit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //play jump
                Intent intentHome = new Intent(PuzzleActivity.this, MainActivity.class);
                startActivity(intentHome);
            }
        });
    }

    private void initBtn(Button btnobj, int btnid) {
        btnobj = findViewById(btnid);
        btnobj.setOnClickListener(this);
    }

    private void initData() {
        imgx1.setImageResource(0);
        imgx2.setImageResource(0);
        imgx3.setImageResource(0);
        imghman.setImageResource(R.drawable.hman0);
        lytanswer.removeAllViews();

        str_question = questions[rollDice(questions.length)];
        Log.d("==========answer:  ", str_question);

        if (str_question != null && str_question.length() > 0) {
            gv_left = str_question.length();
            tv_letters = new TextView[gv_left];
            for (int i = 0; i < str_question.length(); i++){
                TextView tv_letter = new TextView(this);
                tv_letters[i] = tv_letter;
                lytanswer.addView(tv_letter);
            }
        } else {
            Toast.makeText(this, " DB error !", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private int rollDice(int sides) {
        return new Random().nextInt(sides);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "ddd", Toast.LENGTH_SHORT);
//        int index_key = 0;      //which key is pressed
//        int index_answer = 0;   //which letter is shown
//        char c_show = '0';
//        boolean isRight = false;
//
//        //compare to get the pressed key
//        for (int i = 0; i < btnids.length; i ++) {
//            if (btnids[i] == v.getId()) {
//                index_key = i;
//                break;
//            }
//        }
//
//        //compare key with answer string
//        char[] chars = str_question.toCharArray();
//        for (int j = 0; j < chars.length; j ++){
//            if (chars[j] == charletters[index_key]){
//                index_answer = j;
//                c_show = chars[j];
//                Log.d("==========correct:  ", "" + c_show);
//
//                tv_letters[j].setText("" + c_show);
//                gv_left--;
//                isRight = true;
//            }
//        }
//
//        if (isRight) {
//            if (gv_left == 0) {
//                //win the game!!
//                //play win
//            }
//            //play coin
//        } else {
////            playClick(soundWrong);
//            gv_wrong++;
//            if (gv_wrong == 1) {
//                imghman.setImageResource(R.drawable.hman1);
//                imgx1.setImageResource(R.drawable.xmark);
//            } else if (gv_wrong == 2) {
//                imghman.setImageResource(R.drawable.hman2);
//                imgx2.setImageResource(R.drawable.xmark);
//            } else {
//                imghman.setImageResource(R.drawable.hman3);
//                imgx3.setImageResource(R.drawable.xmark);
//            }
//        }

    }
}
