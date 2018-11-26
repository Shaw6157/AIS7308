package com.ais.loadimagedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 20/11/2018
 *
 * @author Shaw
 * @version 1.0
 */
public class LoadImages extends AsyncTask<String, Void, Bitmap[]> {
    private ImageView img_photo;

    public LoadImages(ImageView img_photo) {
        this.img_photo = img_photo;
    }

    @Override
    protected Bitmap[] doInBackground(String... images) {
        Bitmap bitmaps[] = new Bitmap[images.length];
        try {
            for (int i = 0; i < images.length - 1; i++) {
                InputStream inputStream = (InputStream) new URL(AppSettings.URL_ADDRESS + images[i]).getContent();
                bitmaps[i] = BitmapFactory.decodeStream(inputStream);
                Log.d("Bitmap >>>>>   ", "img   " + i);
            }
//            return BitmapFactory.decodeStream(inputStream);
            return bitmaps;
        } catch (Exception e) {
            Log.d("Bitmap >>>>>   ", "img   " + e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap[] bitmaps) {
        super.onPostExecute(bitmaps);
//        img_photo.setImageBitmap(bitmaps[0]);
            Log.d("Bitmap  post >>>>>   ", "img   " + bitmaps.length);
        new ShowImages(img_photo, bitmaps).start();
    }

}
