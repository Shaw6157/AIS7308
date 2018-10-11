package com.ais.testhomemade;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    LinearLayout lytroot;
    GridLayout lytmenu;
    TextView tv_number, tv_amount;
    Button btncart;
    int gv_number = 0;
    int gv_amount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        lytroot = findViewById(R.id.lytroot);
        lytmenu = findViewById(R.id.lytmenu);
        tv_number = findViewById(R.id.tv_number);
        tv_amount = findViewById(R.id.tv_amount);
        btncart = findViewById(R.id.btncart);

        DbMenu db = new DbMenu(this);

        String p_menutype = this.getIntent().getExtras().getString("menutype");
        ArrayList<ShawMenu> menus = db.getAllMenus(p_menutype);
        final ArrayList<String> myorders = new ArrayList<String>();

        for (int i = 0; i < menus.size(); i ++) {
            final ShawMenu eachMenu = menus.get(i);

            TextView tvid = new TextView(this);
            TextView tvname = new TextView(this);
            TextView tvprice = new TextView(this);
            Button btnAdd = new Button(this);
//            Button btnAdd = new Button(this, null, R.style.CartButton);

            final int price = eachMenu.getPrice();

            tvid.setText(eachMenu.getMenuID() + "");
            tvname.setText(eachMenu.getName());
            tvprice.setText("   " + price + "");
            btnAdd.setText(" Add ");
//            btnAdd.setWidth(40);
//            btnAdd.setHeight(40);
//            btnAdd.setsty
//            btnAdd.setBackgroundResource(R.drawable.cartadd_smal);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gv_number++;
                    gv_amount += price;
                    tv_number.setText("  " + gv_number + "  ");
                    tv_amount.setText(" " + gv_amount);
                    myorders.add(eachMenu.getName());
                }
            });

            lytmenu.addView(tvid);
            lytmenu.addView(tvname);
            lytmenu.addView(tvprice);
            lytmenu.addView(btnAdd);

        }
        btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, CartActivity.class);

//                Bundle args = new Bundle();
//                args.putSerializable("ARRAYLIST",(Serializable)myorders);
//                intent.putExtra("myorders",args);

                intent.putExtra("myorders", myorders);
//                intent.putExtra("amount", myorders);
//
//                tv_number.setText("  " + gv_number + "  ");
//                tv_amount.setText(" " + gv_amount);
                startActivity(intent);
            }
        });


    }
}
