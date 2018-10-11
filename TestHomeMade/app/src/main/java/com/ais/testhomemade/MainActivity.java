package com.ais.testhomemade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout lytroot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lytroot = findViewById(R.id.lytroot);

        DbMenu db = new DbMenu(this);
        ArrayList<String> menulist = db.getMenuType();
        for (int i = 0; i <menulist.size(); i++) {
            Button btn = new Button(this);
            final String txt = menulist.get(i);
            btn.setText(txt);
            btn.setWidth(200);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                    intent.putExtra("menutype", txt);
                    startActivity(intent);
                }
            });
            lytroot.addView(btn);
        }

    }
}
