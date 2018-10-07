package com.ais.demosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_ID, tv_Name, tv_Age;
    Button btn_Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_ID   = findViewById(R.id.tvID);
        tv_Age  = findViewById(R.id.tvAge);
        tv_Name = findViewById(R.id.tvName);

        btn_Save = findViewById(R.id.btnSave);
        btn_Save.setOnClickListener(new SavingData());
    }

    private class SavingData implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //validation

            //save it
            DemoDB db = new DemoDB(MainActivity.this);
            db.insertStudents(tv_ID.getText().toString(), tv_Name.getText().toString(), Integer.parseInt(tv_Age.getText().toString()));

            Toast.makeText(MainActivity.this, db.getCountStudents() + " saved in db", Toast.LENGTH_LONG).show();
        }
    }
}
