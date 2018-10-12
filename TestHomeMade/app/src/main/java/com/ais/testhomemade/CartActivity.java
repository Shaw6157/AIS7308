package com.ais.testhomemade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    GridLayout lytorders;
    ArrayList<ShawMenu> lvMyorders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        lytorders = findViewById(R.id.lytorders);


//        Bundle bundle = getIntent().getExtras();
//        ArrayList<String> lvMyorders = (ArrayList<String>) bundle.getStringArrayList("myorders");

        Bundle bundle = getIntent().getExtras();
        lvMyorders = (ArrayList<ShawMenu>) bundle.getSerializable("orderlist");


        if (lvMyorders != null){
            Toast.makeText(this, "asdfasdf: " + lvMyorders.size(), Toast.LENGTH_SHORT).show();
        }

        for (int i = 0; i < lvMyorders.size(); i ++) {
//            String oneorder = lvMyorders.get(i);
            ShawMenu oneorder = lvMyorders.get(i);
            TextView tvID = new TextView(this);
            TextView tvName = new TextView(this);
            int num = i + 1;
            tvID.setText(" " + num + " ");
            tvName.setText("             " + oneorder.getName());

            lytorders.addView(tvID);
            lytorders.addView(tvName);
        }

    }
}
