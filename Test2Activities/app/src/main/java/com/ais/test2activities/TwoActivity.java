package com.ais.test2activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

//        String type = this.getIntent().getExtras().getString("type");
//        ArrayList<EmployeeBean> lvEmployees = db.getEmployees(type);

    }
}
