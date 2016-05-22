package com.uygulama.haluk.gazeteapplication.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Samir on 30.04.2016.
 */
public class Util {
    private static Util INSTANCE;

    private final Context context;

    private Util(Context context) {
        this.context = context;
    }

    // SInıfın nesnesini bir methodla çağıgrıyoruz
    public static Util getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Util(context);
        }
        return INSTANCE;
    }

    public boolean isInternetUygun() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null) && (networkInfo.isConnected());
    }

    public Bitmap downLoadImage(String resimUrl) {
        Bitmap bitmap = null;
        InputStream inputSream = null;
        try {
            inputSream = new URL(resimUrl).openStream();
            bitmap = BitmapFactory.decodeStream(inputSream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputSream != null) {
                    inputSream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bitmap;
    }
}
