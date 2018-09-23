package com.ais.zkidslandapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSetting = (Button) findViewById(R.id.btnSetting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ittSettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(ittSettings);
            }
        });



        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        StringBuilder builder = new StringBuilder();

        builder.append("\n" + "Perform Sync:\t" + sharedPrefs.getBoolean("perform_sync", false));
        builder.append("\n" + "Sync Intervals:\t" + sharedPrefs.getString("sync_interval", "-1"));
        builder.append("\n" + "Name:\t" + sharedPrefs.getString("full_name", "Not known to us"));
        builder.append("\n" + "Email Address:\t" + sharedPrefs.getString("email_address", "No EMail Address Provided"));
        builder.append("\n\nClick on Settings Button at bottom right corner to Modify Your Prefrences");

        TextView settingsTextView = (TextView) findViewById(R.id.textView);
        settingsTextView.setText(builder.toString());


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

    public void goAbout (View v) {
        Intent intentToA = new Intent(this, AboutActivity.class);
        startActivity(intentToA);
    }

//    public void goSetting (View v) {
//        Intent intentToS = new Intent(this, SettingActivity.class);
//        startActivity(intentToS);
//    }

}
