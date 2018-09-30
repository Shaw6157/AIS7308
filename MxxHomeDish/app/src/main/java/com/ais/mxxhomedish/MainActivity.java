package com.ais.mxxhomedish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    String[] menus = {"a", "b"};
    LinearLayout lytMenu;
    Button[] btns = new Button[menus.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lytMenu = (LinearLayout) findViewById(R.id.lytMenu);
        for (int i = 0; i < menus.length; i++){
            btns[i] = new Button(this);
            btns[i].setText("" + menus[i]);
            lytMenu.addView(btns[i]);
        }


    }

//    public  void click_menu1(View v) {
//        Intent intent_menu = new Intent(this, MenuActivity.class);
//        intent_menu.putExtra("menuType", 0);
//        startActivity(intent_menu);
//    }
//
//    public  void click_menu2(View v) {
//        Intent intent_menu = new Intent(this, MenuActivity.class);
//        intent_menu.putExtra("menuType", 1);
//        startActivity(intent_menu);
//    }
//
//    public  void click_menu3(View v) {
//        Intent intent_menu = new Intent(this, MenuActivity.class);
//        intent_menu.putExtra("menuType", 2);
//        startActivity(intent_menu);
//    }

}
