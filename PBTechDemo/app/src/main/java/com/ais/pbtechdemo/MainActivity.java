package com.ais.pbtechdemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    TextView txtProductID, txtProductName, txtProductPrice, txtProductType;
    Button btnSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtProductID = findViewById(R.id.txtProductID);
        txtProductName = findViewById(R.id.txtProductID);
        txtProductPrice = findViewById(R.id.txtProductPrice);
        txtProductType = findViewById(R.id.txtProductType);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtProductID.getText().toString().length() < 1){
                    Toast.makeText(MainActivity.this, "Please enter ID here!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                new SaveProduct().execute();
            }
        });

    }

    class SaveProduct extends AsyncTask <Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {
            StringBuilder sb = null;
            try {
                URL url = new URL(ApplicationSettings.URL_ADDRESS + "phpSaveProduct.php");
                URLConnection lvConnection = url.openConnection();

                String param = URLEncoder.encode("productID", "UTF-8") + "="
                        + URLEncoder.encode("" + txtProductID.getText(), "UTF-8") + "&"
                        + URLEncoder.encode("productName", "UTF-8") + "="
                        + URLEncoder.encode("" + txtProductName.getText(), "UTF-8") + "&"
                        + URLEncoder.encode("productPrice", "UTF-8") + "="
                        + URLEncoder.encode("" + txtProductPrice.getText(), "UTF-8") + "&"
                        + URLEncoder.encode("productType", "UTF-8") + "="
                        + URLEncoder.encode("" + txtProductType.getText(), "UTF-8");

                lvConnection.setDoOutput(true);
                OutputStreamWriter writer = new OutputStreamWriter(lvConnection.getOutputStream());

                writer.write(param);
                writer.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(lvConnection.getInputStream()));
                String line = null;
                sb = new StringBuilder();

                while ((line = reader.readLine()) != null) {

                    sb.append(line);
                }

                Log.d("save>>> ", sb.toString());


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return Integer.parseInt(sb.toString());
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            int result = integer;
            if (result < 1) {
                //error
            } else {
                Toast.makeText(MainActivity.this, "Save successfully!!", Toast.LENGTH_SHORT).show();

                txtProductID.setText("");
                txtProductName.setText("");
                txtProductPrice.setText("");
                txtProductType.setText("");
            }

        }
    }

}
