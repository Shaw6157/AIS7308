package com.ais.asynctaskdemo1;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] images = {"image1", "image2", "image3"};
//    ArrayList<int> Images = {}；

    LinearLayout lyt_root;
    TextView tv_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lyt_root = findViewById(R.id.lyt_root);

        LoadImage lvLoadImage = new LoadImage();
        lvLoadImage.execute(images);

    }

    class LoadImage extends AsyncTask <String[], String, Void> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Loading..");
            dialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            TextView tv = new TextView(MainActivity.this);
            tv.setText(values[0]);
            lyt_root.addView(tv);
        }

        @Override
        protected Void doInBackground(String[]... strings) {
            for (int i = 0; i < strings[0].length; i++) {

                publishProgress(strings[0][i]);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Log.d("Main load image:","sleep error");
                }
            }

            return null;
        }
    }


}
