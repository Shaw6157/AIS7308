package nz.co.ais.aisapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BusinessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
    }


    public void btnToIT (View v){
        Intent intentToIT = new Intent(this, ITActivity.class);
        startActivity(intentToIT);
    }

    public void btnToBus (View v){
        Intent intentToBus = new Intent(this, BusinessActivity.class);
        startActivity(intentToBus);
    }

    public void btnToHos (View v){
        Intent intentToHos = new Intent(this, HospitalityActivity.class);
        startActivity(intentToHos);
    }

    public void btnToTou (View v){
        Intent intentToTou = new Intent(this, TourismActivity.class);
        startActivity(intentToTou);
    }

    public void btnToMain (View v){
        Intent intentToMain = new Intent(this, MainActivity.class);
        startActivity(intentToMain);
    }
}
