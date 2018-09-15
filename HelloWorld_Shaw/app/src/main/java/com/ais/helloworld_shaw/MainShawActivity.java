package com.ais.helloworld_shaw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainShawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_shaw);

//        Button button = findViewById(R.id.button);
    }

    public void onButtonClick(View v){
//        v.get
//        i = i++;
        Toast t_click = Toast.makeText(getApplicationContext(), "number here: " + i, Toast.LENGTH_LONG);
        t_click.show();
    }

    private int i = 0;
}
