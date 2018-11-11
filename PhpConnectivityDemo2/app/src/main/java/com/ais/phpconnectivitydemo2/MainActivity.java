package com.ais.phpconnectivitydemo2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    LinearLayout lyt_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lyt_root = findViewById(R.id.lyt_root);

        LoadData lvLoadData = new LoadData();
        lvLoadData.execute("http://10.0.2.2:8080/testproduct/getTypes.php");

    }

    private class LoadData extends AsyncTask <String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder sb = new StringBuilder("x");
            try {
                URL url = new URL(strings[0]);
                URLConnection connection = url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line = "";

                while ((line = reader.readLine()) != null) {
                    Log.d("linnn: ", line);
                    sb.append(line);
                }

            } catch (Exception e) {
                Log.d("db test: ", e.getMessage());
            }

            return sb.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONArray array = new JSONArray(s);
                for (int i = 0; i < array.length(); i++) {

                    JSONObject obj = array.getJSONObject(i);
                    String type = obj.getString("productType");

                    TextView tv = new TextView(MainActivity.this);
                    tv.setText(type);
                    lyt_root.addView(tv);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
}
