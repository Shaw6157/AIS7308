package com.ais.mnc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ais.mnc.R;
import com.ais.mnc.bean.UserBean;
import com.ais.mnc.db.UserDBHelper;

public class UserSignUpActivity extends AppCompatActivity{

    Toolbar toolbar;
    EditText email,password,name;
    CheckBox checkBox;
    ImageButton signup;
    Button signin;

    UserDBHelper mUserDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        name = (EditText)findViewById(R.id.name);
        checkBox = (CheckBox)findViewById(R.id.checkbox);

        signup =(ImageButton)findViewById(R.id.signup);
        signin = (Button) findViewById(R.id.signin);

        mUserDBHelper = new UserDBHelper(this);

        final UserBean signup_user = new UserBean(
                name.getText().toString(),
                email.getText().toString(),
                password.getText().toString()
                );

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (mUserDBHelper.doSignUp(signup_user)) {
                    Toast.makeText(UserSignUpActivity.this,"Sign Up done",Toast.LENGTH_LONG).show();
                    jumpToLogin();
                } else {
                    Toast.makeText(UserSignUpActivity.this,"Sign Up error",Toast.LENGTH_LONG).show();
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                jumpToLogin();
            }
        });
    }

    private void jumpToLogin() {
        Intent i = new Intent(UserSignUpActivity.this, UserLoginActivity.class);
        startActivity(i);
    }
}