package com.ais.aisloginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ais.aisloginregister.db.StudentDBHelper;

public class AIS_LoginStudentActivity extends AppCompatActivity{
    public static final String TAG = "AIS_LoginStudentActivity";

    Button btn_login, btn_home;
    EditText et_id, et_password;
    String str_id, str_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ais__login_student);

        btn_home = (Button) findViewById(R.id.btn_ls_home);
        btn_login = (Button) findViewById(R.id.btn_ls_login);
        et_id = (EditText) findViewById(R.id.et_ls_login);
        et_password = (EditText) findViewById(R.id.et_ls_password);

//        str_id = "" + et_id.getText();
//        str_pwd = "" + et_password.getText();

        btn_home.setOnClickListener(new HomeListener());
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                str_id = "" + et_id.getText();
                str_pwd = "" + et_password.getText();

                Log.d("LS Activity", "doLogin: " + str_id + " " + str_pwd);

                //check login info
                boolean flag = new StudentDBHelper(AIS_LoginStudentActivity.this).doLogin(str_id, str_pwd);

                //navigation
                if (flag) {
                    Intent intentToLogin = new Intent(AIS_LoginStudentActivity.this, AIS_HomeActivity.class);
                    startActivity(intentToLogin);
                } else {
                    Toast.makeText(AIS_LoginStudentActivity.this, "wrong id or password, please check", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public class HomeListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intentToLogin = new Intent(AIS_LoginStudentActivity.this, AIS_LoginRegisterActivity.class);
            startActivity(intentToLogin);
        }
    }
}
