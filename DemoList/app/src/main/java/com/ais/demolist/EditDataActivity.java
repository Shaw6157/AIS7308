package com.ais.demolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditDataActivity extends AppCompatActivity {
    private static final String TAG = "EditDataActivity";
    private Button btnSave, btnDelete;
    private EditText edtText;
    DatabaseHelper mDatabaseHelper;

    private String mSelName;
    private int mSelID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDel);
        edtText = (EditText) findViewById(R.id.etString);

        mDatabaseHelper = new DatabaseHelper(this);
        Intent comeIntent = getIntent();
        mSelID = comeIntent.getIntExtra("id", -1);
        mSelName = comeIntent.getStringExtra("name");
        edtText.setText(mSelName);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = edtText.getText().toString();
                if (!"".equals(item)) {
                    mDatabaseHelper.updateName(item, mSelID, mSelName);
                }

                Intent intent = new Intent(EditDataActivity.this, ListDataActivity.class);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseHelper.delName(mSelID, mSelName);
                edtText.setText("");

                Intent intent = new Intent(EditDataActivity.this, ListDataActivity.class);
                startActivity(intent);
            }
        });

    }


    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
