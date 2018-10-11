package com.ais.demosqlitequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout) findViewById(R.id.lytroot);
        Database db = new Database(this);
        ArrayList<String> lvQuizNames = db.getQuizNames();

        for (int i = 0; i < lvQuizNames.size(); i++) {
            Button btn = new Button(this);
            final String lv_name = lvQuizNames.get(i);
            btn.setText(lv_name);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("quizname", lv_name);
                    startActivity(intent);
                }
            });
            layout.addView(btn);
        }
    }
}
