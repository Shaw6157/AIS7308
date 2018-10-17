package com.ais.aisloginregister;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ais.aisloginregister.bean.ProgrammeBean;
import com.ais.aisloginregister.db.ProgrammeDBHelper;

import java.util.ArrayList;

public class AIS_ProgrammeActivity extends AppCompatActivity {
    public static final String TAG = "AIS_ProgrammeActivity";

    LinearLayout lyt_btns;
    TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ais__programme);

        lyt_btns = findViewById(R.id.lyt_p_btns);
        tv_title = findViewById(R.id.tv_title);

        //get extras
        String type = getIntent().getExtras().getString("type");

        //set title
        tv_title.setText(type);

        //get db data
        ArrayList<ProgrammeBean> listProgramme = new ProgrammeDBHelper(this).getProgrammes(type);

        for (int i = 0; i < listProgramme.size(); i++) {
            TextView textView = new TextView(this);
            ProgrammeBean eachProgramme = (ProgrammeBean) listProgramme.get(i);
            textView.setWidth(150);
            textView.setText(eachProgramme.getName());
            lyt_btns.addView(textView);
        }

        Button btnBack = new Button(this);
        btnBack.setWidth(150);
        btnBack.setText("Back");
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToHome = new Intent(AIS_ProgrammeActivity.this, AIS_HomeActivity.class);
                startActivity(intentToHome);
            }
        });
        lyt_btns.addView(btnBack);
    }
}
