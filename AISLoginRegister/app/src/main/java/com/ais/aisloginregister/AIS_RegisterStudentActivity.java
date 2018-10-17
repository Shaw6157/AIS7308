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

public class AIS_RegisterStudentActivity extends AppCompatActivity {
    public static final String TAG = "AIS_RegisterStudent";

    EditText et_login, et_password, et_password_repeat;
    Button btn_save;

    String str_id, str_pwd, str_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ais__register_student);

        et_login = (EditText) findViewById(R.id.et_rs_login);
        et_password = (EditText) findViewById(R.id.et_rs_password);
        et_password_repeat = (EditText) findViewById(R.id.et_rs_password_repeat);
        btn_save = (Button) findViewById(R.id.btn_rs_save);

//        str_id = "" + et_login.getText();
//        str_pwd = "" + et_password.getText();
//        str_confirm = "" + et_password_repeat.getText();

        Log.d(TAG, "string:" + str_id + " = " + str_pwd);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                str_id = "" + et_login.getText();
                str_pwd = "" + et_password.getText();
                str_confirm = "" + et_password_repeat.getText();

                if (str_id == null || str_id.trim().length() < 1){
                    Toast.makeText(AIS_RegisterStudentActivity.this, "pleas enter a student id", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (str_pwd == null || str_pwd.trim().length() < 1){
                    Toast.makeText(AIS_RegisterStudentActivity.this, "pleas enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (! str_pwd.equals(str_confirm)) {
                    Toast.makeText(AIS_RegisterStudentActivity.this, "different password typed", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (str_pwd.length() < 6) {
                    Toast.makeText(AIS_RegisterStudentActivity.this, "Your password need to be more than 6 characters", Toast.LENGTH_SHORT).show();
                    return;
                }

                //save to db
                boolean flag = new StudentDBHelper(AIS_RegisterStudentActivity.this).doRegister(str_id, str_pwd);

                if (flag) {
                    Toast.makeText(AIS_RegisterStudentActivity.this, "registration successful", Toast.LENGTH_SHORT).show();
                    //navigate back
                    Intent intentToLogin = new Intent(AIS_RegisterStudentActivity.this, AIS_LoginRegisterActivity.class);
                    startActivity(intentToLogin);
                } else {
                    Toast.makeText(AIS_RegisterStudentActivity.this, "student id exists", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
