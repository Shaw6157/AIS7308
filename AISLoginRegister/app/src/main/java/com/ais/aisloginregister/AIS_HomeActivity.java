package com.ais.aisloginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ais.aisloginregister.db.ProgrammeDBHelper;

import java.util.ArrayList;

public class AIS_HomeActivity extends AppCompatActivity {
    public static final String TAG = "AIS_HomeActivity";

    LinearLayout lyt_btns;
    String str_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ais__home);

        lyt_btns = findViewById(R.id.lyt_h_btns);

        //get types and generate buttons
        ArrayList<String> typeList = new ProgrammeDBHelper(this).getTypes();
        if (typeList != null) {
            for (int i = 0; i < typeList.size(); i++) {
                Button btnType = new Button(this);
                str_type = typeList.get(i).toString();

                btnType.setWidth(150);
                btnType.setText(str_type);
                //set click and send extras
                btnType.setOnClickListener(new BtnListener());
                lyt_btns.addView(btnType);
            }
        }
    }

    public class BtnListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intentToProg = new Intent(AIS_HomeActivity.this, AIS_ProgrammeActivity.class);
            intentToProg.putExtra("type", ((Button) v).getText().toString());
            startActivity(intentToProg);
        }
    }
}
