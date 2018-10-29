package com.ais.demotab;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TabHost mTabHost;
    TextView tv;

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

        tv = findViewById(R.id.tv_dia);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTitleDialog(MainActivity.this, tv);
            }
        });

    }

    public void showTitleDialog(Context context, final TextView textView) {
        final String[] titles = new String[]{"Mr.", "Mrs", "Dr", "Miss", "Ms"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);// 自定义对话框
        builder.setSingleChoiceItems(titles, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {// which是被选中的位置
                textView.setText(titles[which]);
                dialog.dismiss();// 随便点击一个item消失对话框，不用点击确认取消
            }
        });
        builder.show();// 让弹出框显示
    }
}
