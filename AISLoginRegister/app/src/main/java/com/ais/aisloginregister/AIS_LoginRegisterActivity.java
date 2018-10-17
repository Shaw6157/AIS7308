package com.ais.aisloginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AIS_LoginRegisterActivity extends AppCompatActivity {
    public static final String TAG = "AIS_LoginRegisterActivity";

    Button btn_login, btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ais__login_register);

        btn_login = findViewById(R.id.btn_lr_login);
        btn_register = findViewById(R.id.btn_lr_register);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToLogin = new Intent(AIS_LoginRegisterActivity.this, AIS_LoginStudentActivity.class);
                startActivity(intentToLogin);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToRegister = new Intent(AIS_LoginRegisterActivity.this, AIS_RegisterStudentActivity.class);
                startActivity(intentToRegister);
            }
        });
    }
}
