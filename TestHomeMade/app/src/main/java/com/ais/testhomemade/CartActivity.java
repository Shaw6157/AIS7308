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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        lytorders = findViewById(R.id.lytorders);

//        ArrayList<ShawMenu> myorders = (ArrayList<ShawMenu>) this.getIntent().getSerializableExtra("myorders");

//        Intent intent = getIntent();
//        Bundle args = intent.getBundleExtra("myorders");
//        ArrayList<ShawMenu> myorders = (ArrayList<ShawMenu>) args.getSerializable("ARRAYLIST");

//        ArrayList<ShawMenu> lvMyorders =
//                (ArrayList<ShawMenu>) this.getIntent().getSerializableExtra("myorders");
//
        Bundle bundle = getIntent().getExtras();
        ArrayList<String> lvMyorders = (ArrayList<String>) bundle.getStringArrayList("myorders");


        if (lvMyorders != null){
            Toast.makeText(this, "asdfasdf: " + lvMyorders.size(), Toast.LENGTH_SHORT).show();
        }

        for (int i = 0; i < lvMyorders.size(); i ++) {
            String oneorder = lvMyorders.get(i);
            TextView tvID = new TextView(this);
            TextView tvName = new TextView(this);
            int num = i + 1;
            tvID.setText(" " + num + " ");
            tvName.setText("             " + oneorder);

            lytorders.addView(tvID);
            lytorders.addView(tvName);
        }

    }
}
