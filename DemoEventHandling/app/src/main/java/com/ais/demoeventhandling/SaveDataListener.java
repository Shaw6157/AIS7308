package com.ais.demoeventhandling;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

class SaveDataListener implements View.OnClickListener {
    Context context;

    public SaveDataListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, "separate goes", Toast.LENGTH_SHORT).show();
    }
}
