package com.ais.zkidslandapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.SoundPool;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //music part
    SoundPool soundPool, soundPool2;
    int soundRight, soundWrong, soundLvup, soundDeath, soundWin, soundStart, soundQuestion;
    int streamId, streamMario;

    //view part
    Button btnPlu, btnMin, btnMul, btnDiv, btnAbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSound();
        initView();

//        Button btnSetting = (Button) findViewById(R.id.btnSetting);
//        btnSetting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent ittSettings = new Intent(MainActivity.this, SettingsActivity.class);
//                startActivity(ittSettings);
//            }
//        });

//        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
//
//        StringBuilder builder = new StringBuilder();
//
//        builder.append("\n" + "Perform Sync:\t" + sharedPrefs.getBoolean("perform_sync", false));
//        builder.append("\n" + "Sync Intervals:\t" + sharedPrefs.getString("sync_interval", "-1"));
//        builder.append("\n" + "Name:\t" + sharedPrefs.getString("full_name", "Not known to us"));
//        builder.append("\n" + "Email Address:\t" + sharedPrefs.getString("email_address", "No EMail Address Provided"));
//        builder.append("\n\nClick on Settings Button at bottom right corner to Modify Your Prefrences");
//
//        TextView settingsTextView = (TextView) findViewById(R.id.textView);
//        settingsTextView.setText(builder.toString());
    }

//    public void goSetting (View v) {
////        Intent intentToS = new Intent(this, SettingActivity.class);
////        startActivity(intentToS);
//
//        Toast.makeText(this, "Sorry, not yet !", Toast.LENGTH_SHORT).show();
//    }

    @SuppressLint("NewApi")
    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundPool2 = new SoundPool.Builder().build();

        soundRight = soundPool.load(this, R.raw.coin, 1);
        soundWrong = soundPool.load(this, R.raw.brockbreak, 1);
        soundDeath = soundPool.load(this, R.raw.death, 1);
        soundWin = soundPool.load(this, R.raw.goal, 1);
        soundLvup = soundPool.load(this, R.raw.powerup, 1);
        soundQuestion = soundPool.load(this, R.raw.jump, 1);
        soundStart = soundPool.load(this, R.raw.mario, 1);

        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                streamMario = soundPool.play(soundStart, 0.5f, 0.5f, 100, -1, 1);
            }
        });
    }

    private void playClick(int musicID) {
        streamId= soundPool.play(musicID, 1,1,1,0,1);
        // soundPool.stop(streamId);
    }

    private void initView() {
        btnPlu = (Button) findViewById(R.id.btn_Plus);
        btnMin = (Button) findViewById(R.id.btn_Minus);
        btnMul = (Button) findViewById(R.id.btn_Multiply);
        btnDiv = (Button) findViewById(R.id.btn_Divide);
        btnAbt = (Button) findViewById(R.id.btn_About);

        btnPlu.setOnClickListener(new MathsQuestion());
        btnMin.setOnClickListener(new MathsQuestion());
        btnMul.setOnClickListener(new MathsQuestion());
        btnDiv.setOnClickListener(new MathsQuestion());
        btnAbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.stop(streamMario);
                playClick(soundQuestion);
                Intent intentToA = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intentToA);
            }
        });
    }

    private class MathsQuestion implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            playClick(soundQuestion);
            Intent intentToQ = new Intent(MainActivity.this, QuestionActivity.class);
            switch (v.getId()) {
                case R.id.btn_Plus:
                    intentToQ.putExtra("p_operator", "+");
                    break;
                case R.id.btn_Minus:
                    intentToQ.putExtra("p_operator", "-");
                    break;
                case R.id.btn_Multiply:
                    intentToQ.putExtra("p_operator", "*");
                    break;
                case R.id.btn_Divide:
                    intentToQ.putExtra("p_operator", "/");
                    break;
                default:
                    intentToQ.putExtra("p_operator", "");
                    break;
            }
            startActivity(intentToQ);
        }
    }
}
