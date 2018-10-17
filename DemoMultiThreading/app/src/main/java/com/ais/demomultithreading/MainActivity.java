package com.ais.demomultithreading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        CounterThread counter = new CounterThread(1, true);
//        counter.start();

        EventNumberThread lvEventNumberThread = new EventNumberThread();
        lvEventNumberThread.start();

        OddNumberThread lvOddNumberThread = new OddNumberThread();
        Thread lvThread = new Thread(lvOddNumberThread);
        lvThread.start();

    }

    class CounterThread extends Thread {
        int counter = 0;
        int position = 1;
        boolean isRunning = false;

        public CounterThread(int position, boolean isRunning) {
            this.counter = position;
            this.isRunning = isRunning;
        }

        public void run() {
            counter = position;
            while (isRunning) {
                Log.d("counter :  ", "" + ++counter);
            }
        }
    }

    class EventNumberThread extends Thread {
        public void run() {
            for (int evenNumber = 0; evenNumber < 10; evenNumber += 2){
                Log.d("Even number :", " " + evenNumber);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class OddNumberThread implements Runnable {
        @Override
        public void run() {
            for (int evenNumber = 1; evenNumber < 10; evenNumber += 2){
                Log.d("Odd number :", " " + evenNumber);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
