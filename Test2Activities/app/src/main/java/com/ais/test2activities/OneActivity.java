package com.ais.test2activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class OneActivity extends AppCompatActivity {

    EditText et_name, et_position, et_type, et_salary;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        et_name = findViewById(R.id.et_name);
        et_position = findViewById(R.id.et_position);
        et_type = findViewById(R.id.et_type);
        et_salary = findViewById(R.id.et_salary);
        btn_register = findViewById(R.id.btn_register);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pname = et_name.getText() + "";
                String pposition = et_position.getText() + "";
                String ptype = et_type.getText() + "";
                int psalary = Integer.parseInt(et_salary.getText() + "");
            }
        });

        EmployeeDBHelper db = new EmployeeDBHelper(this);



    }
}
