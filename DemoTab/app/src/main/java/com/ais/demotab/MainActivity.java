package com.ais.demotab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabHost = findViewById(R.id.tabHost);
        mTabHost.setup();

        TabHost.TabSpec spec = mTabHost.newTabSpec("Tab One")
                .setContent(R.id.tab1)
                .setIndicator("Tab One");

        mTabHost.addTab(spec);

        spec = mTabHost.newTabSpec("Tab Twowooo");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Tab Twowooo");
        mTabHost.addTab(spec);

    }
}
