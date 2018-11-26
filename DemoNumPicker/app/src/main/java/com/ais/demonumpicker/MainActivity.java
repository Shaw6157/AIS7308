package com.ais.demonumpicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    NumberPicker numberpicker,
            np11, np12, np13, np14,
            np21, np22, np23//, np24
            ;

    com.shawnlin.numberpicker.NumberPicker np24;

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNumberPicker(np11, R.id.numberPicker11);
        initNumberPicker(np12, R.id.numberPicker12);
        initNumberPicker(np13, R.id.numberPicker13);
        initNumberPicker(np14, R.id.numberPicker14);
        initNumberPicker(np21, R.id.numberPicker21);
        initNumberPicker(np22, R.id.numberPicker22);
        initNumberPicker(np23, R.id.numberPicker23);
        initNumberPicker(np24, R.id.numberPicker24);


        textview = findViewById(R.id.textView1);

//        numberpicker.setMinValue(0);
//        numberpicker.setMaxValue(4);
//        numberpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//                textview.setText("Selected Value is : " + newVal);
//            }
//        });
//
//        numberpicker.setWrapSelectorWheel(false);
//        numberpicker.setOnFocusChangeListener(new NumberPicker.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//
//            }
//        });

    }

    public void initNumberPicker(NumberPicker np, int id) {
        np = findViewById(id);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                textview.setText("Selected Value is : " + newVal);
            }
        });
    }

    public void initNumberPicker(com.shawnlin.numberpicker.NumberPicker npQ, int id) {
        npQ = findViewById(id);
        npQ.setWrapSelectorWheel(false);
        npQ.setOrientation(1);
        // OnClickListener
        npQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("  >>>  ", "Click on current value");
            }
        });

        // OnValueChangeListener
        npQ.setOnValueChangedListener(new com.shawnlin.numberpicker.NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(com.shawnlin.numberpicker.NumberPicker picker, int oldVal, int newVal) {
                Log.d("  >>>  ", String.format(Locale.US, "oldVal: %d, newVal: %d", oldVal, newVal));
            }
        });


    }
}
