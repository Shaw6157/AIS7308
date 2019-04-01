package com.ais.mymemodemo;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText et_memoid, et_memoinfo, et_memotype, et_memodate;
    Button btn_add, btn_calendar;
    GridLayout lyt_memos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.d("cal::", "" + String.format("%05d", 123) + "|");
//        Log.d("cal::", "" + String.format("%50d", 123) + "|");
//        Log.d("cal::", "");
//

        new GetMemos().execute();

        et_memoid = findViewById(R.id.et_memoid);
        et_memoinfo = findViewById(R.id.et_memoinfo);
        et_memotype = findViewById(R.id.et_memotype);
        et_memodate = findViewById(R.id.et_memodate);
        btn_add = findViewById(R.id.btn_add);
        btn_calendar = findViewById(R.id.btn_calendar);
        lyt_memos = findViewById(R.id.lyt_memos);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_memoid.getText() == null || et_memoid.getText().length() < 1
                        || et_memoinfo.getText() == null || et_memoinfo.getText().length() < 1) {
                    Toast.makeText(MainActivity.this, "Please type ID and Info before saving!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    new SaveMemo().execute();

                    View view = MainActivity.this.getCurrentFocus();
                    if (view != null) {
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                }

            }
        });

        btn_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.READ_CALENDAR)
                        != PackageManager.PERMISSION_GRANTED) {
                    Log.d(">>>>>","nnnn  RRR");
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.READ_CALENDAR},
                            1);
                } else  if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.WRITE_CALENDAR)
                        != PackageManager.PERMISSION_GRANTED) {
                    Log.d(">>>>>","nnnn  WWW");
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_CALENDAR},
                            2);
                } else {


                    Log.d(">>>>>","yyyy");
                    ContentResolver cr = MainActivity.this.getContentResolver();
                    ContentValues cv = new ContentValues();

                    cv.put(CalendarContract.Events.TITLE, "new 11 event");
                    cv.put(CalendarContract.Events.DESCRIPTION, "QQQQQQQ");
                    cv.put(CalendarContract.Events.EVENT_LOCATION, "here");
                    cv.put(CalendarContract.Events.DTSTART, Calendar.getInstance().getTimeInMillis());
                    cv.put(CalendarContract.Events.DTEND, Calendar.getInstance().getTimeInMillis() + 60 * 60 * 1000 * 6);
                    cv.put(CalendarContract.Events.CALENDAR_ID, 3);
                    cv.put(CalendarContract.Events.EVENT_TIMEZONE, Calendar.getInstance().getTimeZone().getID());

                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {

                    Log.d(">>>>>","nnnn  222   WWW");
                    return;
                }

                    Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, cv);
                    Toast.makeText(MainActivity.this, "ok...", Toast.LENGTH_SHORT).show();


                }

            }
        });
    }

    private class SaveMemo extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            StringBuilder sb = null;

            try {
//                URL url = new URL("http://10.0.2.2:8080/memo/phpSaveMemo.php");
                URL url = new URL("http://shawyuais.co.nf/memo/phpSaveMemo.php");

                URLConnection lvConnection = url.openConnection();

                String param = URLEncoder.encode("memoID", "UTF-8") + "="
                        + URLEncoder.encode("" + et_memoid.getText(), "UTF-8") + "&"
                        + URLEncoder.encode("memoInfo", "UTF-8") + "="
                        + URLEncoder.encode("" + et_memoinfo.getText(), "UTF-8") + "&"
                        + URLEncoder.encode("memoType", "UTF-8") + "="
                        + URLEncoder.encode("" + et_memotype.getText(), "UTF-8") + "&"
                        + URLEncoder.encode("memoDate", "UTF-8") + "="
                        + URLEncoder.encode("" + et_memodate.getText(), "UTF-8");

                Log.d("param >>>>", param);
                lvConnection.setDoOutput(true);

                OutputStreamWriter writer = new OutputStreamWriter(lvConnection.getOutputStream());
                writer.write(param);
                writer.flush();

                //read data
                BufferedReader reader = new BufferedReader(new InputStreamReader(lvConnection.getInputStream()));
                String line = null;
                sb = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                Log.d("memooo:", sb.toString());

            } catch (Exception e) {

                Log.d("error >>>>", e.getMessage());
                return "";
            }
            return sb.toString();
        }

        @Override
        protected void onPostExecute(String memos) {
            super.onPostExecute(memos);

            if (memos == null || memos.length() < 1) {
                Toast.makeText(MainActivity.this, "errorr!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "memo added!", Toast.LENGTH_SHORT).show();

                Log.d("main  added >>>> ", "");

                new GetMemos().execute();

                Log.d("main  fetch >>>> ", "");


                et_memoid.setText("");
                et_memodate.setText("");
                et_memotype.setText("");
                et_memoinfo.setText("");
            }
        }
    }

    private class GetMemos extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            StringBuilder sb = new StringBuilder("");

            try {
//                URL url = new URL("http://10.0.2.2:8080/memo/phpGetMemos.php");
                URL url = new URL("http://shawyuais.co.nf/memo/phpGetMemos.php");

                URLConnection lvConnection = url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(lvConnection.getInputStream()));

                String line = "";
                while ((line = reader.readLine()) != null) {
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

            lyt_memos.removeAllViews();
            try {
                JSONArray array = new JSONArray(s);
                for (int i = 0; i < array.length() - 1; i++) {
                    JSONObject obj = array.getJSONObject(i);

                    Log.d("dsfs>>>>>>", obj.toString());

//                    ViewGroup.LayoutParams params1 = new TextView(MainActivity.this).getLayoutParams();
//                    params1.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//                    params1.width = 20;
//                    ViewGroup.LayoutParams params2 = new TextView(MainActivity.this).getLayoutParams();
//                    params2.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//                    params2.width = 100;


                    String str_id = obj.getString("memoID");
                    TextView tv_memoID = new TextView(MainActivity.this);
                    tv_memoID.setText(str_id);
                    tv_memoID.setWidth(150);
//                    tv_memoID.setLayoutParams(params1);
                    lyt_memos.addView(tv_memoID);

                    String str_type = obj.getString("memoType");
                    TextView tv_type = new TextView(MainActivity.this);
                    tv_type.setText(str_type);
                    tv_type.setWidth(150);
//                    tv_type.setLayoutParams(params1);
                    lyt_memos.addView(tv_type);

                    String str_info = obj.getString("memoInfo");
                    TextView tv_memo = new TextView(MainActivity.this);
                    tv_memo.setText(str_info);
                    tv_memo.setWidth(300);
//                    tv_memo.setLayoutParams(params2);
                    lyt_memos.addView(tv_memo);

                    String str_date = obj.getString("memoDate");
                    TextView tv_date = new TextView(MainActivity.this);
                    tv_date.setText(str_date);
//                    tv_date.setWidth(150);
//                    tv_date.setLayoutParams(params1);
                    lyt_memos.addView(tv_date);

                }
            } catch (Exception e) {
                Log.d("error>>>", "" + e.getMessage());
            }
        }
    }


}
