package com.ais.loadimagedemo;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 20/11/2018
 *
 * @author Shaw
 * @version 1.0
 */
public class ShowImages extends Thread {

    static ImageView img_photo;
    static Bitmap[] bitmaps;
    int counter = 0;
    static boolean isRunning = false;

    Handler handler;

    public ShowImages(ImageView imgView, Bitmap[] bitmaps) {
        this.img_photo = imgView;
        this.bitmaps = bitmaps;
        handler = new Handler();
        isRunning = true;
    }


    @Override
    public void run() {
        while (isRunning) {

            handler.post(new Runnable() {
                @Override
                public void run() {
                    img_photo.setImageBitmap(bitmaps[counter]);
                }
            });

            Log.d("images....", "  counter:  " + counter);

            counter++;
            if (counter >= bitmaps.length) {
                counter = 0;
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }

        }
    }

    public static void setShowImages (boolean flag) {
        if (!flag) {
            isRunning = false;
        } else {
            new ShowImages(img_photo, bitmaps).start();
        }
    }

}
