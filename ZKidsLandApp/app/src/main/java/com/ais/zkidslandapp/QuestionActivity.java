package com.ais.zkidslandapp;

import android.annotation.SuppressLint;
import android.media.SoundPool;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvTitle_Q, tvQuestion, tv_time, tv_progress;
    Button btnNum1, btnNum2, btnNum3, btnNum4;
    ImageView imgx1, imgx2, imgx3, imglv, imgmark;

    int gv_answer = 0;
    int gv_numbtn = 4,
        gv_right = 0,
        gv_wrong = 0,
        gv_lvgap = 5,
        gv_amount = 15;
    int currentlv = 1;
    int rightid;
    boolean isOver = false;
    String pi_operator = "";
    List list = new ArrayList();

    //music part
    SoundPool soundPool;
    int soundRight, soundWrong, soundLvup, soundDeath, soundWin, soundStart, soundQuestion;
    int streamId;

    private int q_timer = 0;
    Handler handler = new Handler();
    Runnable runthread = new Runnable() {
        @Override
        public void run() {
            q_timer++;
            tv_time.setText("ticking: " + q_timer);
            handler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        //get operator from MainActivity
        pi_operator = this.getIntent().getExtras().get("p_operator").toString();
        //start the timer
        handler.postDelayed(runthread, 1000);

        initView();
        initSound();
        loadData();
    }

    private void initView() {
        tvQuestion  = findViewById(R.id.tv_Question);
        tv_time     = findViewById(R.id.tv_time);
        tv_progress = findViewById(R.id.tv_progress);
        tv_progress.setText("0/" + gv_amount);  //init the text
        imgx1       = findViewById(R.id.img_x1);
        imgx2       = findViewById(R.id.img_x2);
        imgx3       = findViewById(R.id.img_x3);
        imglv       = findViewById(R.id.img_lv);
        imgmark     = findViewById(R.id.img_Mark);

        btnNum1 = (Button) findViewById(R.id.btn_Num1);
        btnNum2 = (Button) findViewById(R.id.btn_Num2);
        btnNum3 = (Button) findViewById(R.id.btn_Num3);
        btnNum4 = (Button) findViewById(R.id.btn_Num4);

        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);

        imgmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOver){
                    soundPool.stop(streamId);
                    playClick(soundQuestion);
                    q_timer = 0;
                    gv_right = 0;
                    gv_wrong = 0;
                    currentlv = 1;
                    list.clear();
                    tv_progress.setText("0/" + gv_amount);
                    handler.postDelayed(runthread, 1000);

                    imgx1.setImageResource(0);
                    imgx2.setImageResource(0);
                    imgx3.setImageResource(0);
                    imgmark.setImageResource(R.drawable.qmarks2);

                    isOver = false;
                    loadData();
                }
            }
        });
    }

    @SuppressLint("NewApi")
    private void initSound() {
        soundPool = new SoundPool.Builder().build();

        soundRight = soundPool.load(this, R.raw.coin, 1);
        soundWrong = soundPool.load(this, R.raw.brockbreak, 1);
        soundDeath = soundPool.load(this, R.raw.death, 1);
        soundWin = soundPool.load(this, R.raw.goal, 1);
        soundLvup = soundPool.load(this, R.raw.powerup, 1);
        soundQuestion = soundPool.load(this, R.raw.jump, 1);
        soundStart = soundPool.load(this, R.raw.mario, 1);
    }

    private void loadData(){
        int lv_num2 = rollDice(10 * currentlv);
        int lv_num1 = 0;

        //make "divide" reasonable
        if ("/".equals(pi_operator)){
            lv_num1 = lv_num2 * (rollDice(4) + currentlv);
        } else {
            lv_num1 = rollDice(10 * currentlv);
        }

        list.clear();
        tvQuestion.setText(lv_num1 + " " + pi_operator + " " + lv_num2 + " =  ");
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
                rightid = btns[i].getId();
            } else {
                btns[i].setText("" + generateWrongAnswer());
            }
        }

        Integer marks[] = {R.drawable.qmarks1, R.drawable.qmarks2, R.drawable.qmarks3, R.drawable.qmarks4};
        imgmark.setImageResource(marks[lv_postion]);

    }

    private int generateWrongAnswer(){
        list.add(gv_answer);
        int num = 0;
        while(list.size() != 4){
            num = new Random().nextInt(8) + gv_answer - 3;
            if(!list.contains(num)){
                list.add(num);
                break;
            } else {
                continue;
            }
        }
        return num;
    }

    private int rollDice(int sides) {
        return new Random().nextInt(sides);
    }

    @Override
    public void onClick(View v) {
        if (isOver){
            return;
        }

        if (v.getId() == rightid){
            playClick(soundRight);

            gv_right++;
            currentlv = gv_right / gv_lvgap + 1;
            if (gv_right % gv_lvgap == 0) {
                playClick(soundLvup);
            }

            if (currentlv == 1) {
                imglv.setImageResource(R.drawable.lv1);
            } else if (currentlv == 2) {
                imglv.setImageResource(R.drawable.lv2);
            } else {
                imglv.setImageResource(R.drawable.lv3);
            }
        } else {
            playClick(soundWrong);
            gv_wrong++;
            if (gv_wrong == 1) {
                imgx1.setImageResource(R.drawable.xmark);
            } else if (gv_wrong == 2) {
                imgx2.setImageResource(R.drawable.xmark);
            } else {
                imgx3.setImageResource(R.drawable.xmark);
            }
        }

        if (gv_wrong == 3) {
            playClick(soundDeath);
            isOver = true;
            handler.removeCallbacks(runthread);
            tvQuestion.setText("Try again? ");
            imgmark.setImageResource(R.drawable.refresh);
            Toast.makeText(this, "Over !", Toast.LENGTH_SHORT).show();
        } else if (gv_right == gv_amount) {
            playClick(soundWin);
            imgx1.setImageResource(0);
            isOver = true;
            handler.removeCallbacks(runthread);
            tv_progress.setText(gv_right + "/" + gv_amount);
            tvQuestion.setText("Congrats !");
            imgmark.setImageResource(R.drawable.refresh);
            Toast.makeText(this, "Victory !", Toast.LENGTH_SHORT).show();
        } else {
            tv_progress.setText(gv_right + "/" + gv_amount);
            loadData();
        }
    }

    private void playClick(int musicID) {
        streamId= soundPool.play(musicID, 1,1,1,0,1);
        // soundPool.stop(streamId);
    }
}
