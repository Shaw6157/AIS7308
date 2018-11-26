package com.ais.loadimagedemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    ImageView img_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_photo = findViewById(R.id.img_photo);

        //local image loader
//        new LoadImages(img_photo).execute("iris_siberica.jpg", "pelargonium.jpg");

        //online image loader
        new GetImages().execute();

    }

    @Override
    protected void onStop() {
        Log.d("stop >>>", "");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.d("pause >>>", "");
        super.onPause();

        ShowImages.setShowImages(false);
    }

    @Override
    protected void onPostResume() {
        Log.d("resume >>>", "");
        super.onPostResume();

//        new GetImages().execute();
    }

    private class GetImages extends AsyncTask<Void, Void, String> {


        @Override
        protected String doInBackground(Void... voids) {
            StringBuilder sb = new StringBuilder("");
            try {
                URL url = new URL("http://10.0.2.2:8080/img/phpGetImages.php");
                URLConnection lvConnection = url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(lvConnection.getInputStream()));

                String line = "";
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

            } catch (Exception e) {
                Log.d("Async GetImg err>>>> ", e.getMessage());
            }
            return sb.toString();
        }

        @Override
        protected void onPostExecute(String image_url_json) {
            super.onPostExecute(image_url_json);

            try {
                JSONArray array = new JSONArray(image_url_json);
                String[] strs = new String[array.length()];
                for (int i = 0; i < array.length() - 1; i++) {
                    JSONObject obj = array.getJSONObject(i);
                    Log.d("Async GetImg post >>>", obj.toString());
//                    strs[i] = obj.getString("url");
                    strs[i] = obj.getString("title") + ".jpg";
                }

                Log.d("Async post here >>>", "");
                new LoadImages(img_photo).execute(strs);

            } catch (Exception e) {
                Log.d("Async Img psterr>>>> ", e.getMessage());
            }

        }
    }

}
