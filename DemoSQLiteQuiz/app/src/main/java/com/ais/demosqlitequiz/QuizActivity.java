package com.ais.demosqlitequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    LinearLayout layout;
    TextView tv_title, tv_question;
    RadioButton rbOption1, rbOption2, rbOption3, rbOption4;
    ArrayList<CompleteQuestion> allQuestions;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        layout = (LinearLayout) findViewById(R.id.lytroot);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_question = (TextView) findViewById(R.id.tv_question);

        String quizname = this.getIntent().getExtras().getString("quizname");
        tv_title.setText(quizname + " questions!");

        rbOption1 = findViewById(R.id.option1);
        rbOption2 = findViewById(R.id.option2);
        rbOption3 = findViewById(R.id.option3);
        rbOption4 = findViewById(R.id.option4);

        allQuestions = new Database(this).getALLQuestions(quizname);
        loadData();
    }

    private void loadData() {
        tv_question.setText(allQuestions.get(counter).getQuestion());
        rbOption1.setText(allQuestions.get(counter).getOption1());
        rbOption2.setText(allQuestions.get(counter).getOption2());
        rbOption3.setText(allQuestions.get(counter).getOption3());
        rbOption4.setText(allQuestions.get(counter).getOption4());
    }
}
