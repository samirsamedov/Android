package com.sam.jsonarray.application;

import android.app.Application;

import com.sam.jsonarray.BuildConfig;

import timber.log.Timber;

/**
 * Created by Samir on 20.6.2016.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // TIMBER SETUP
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

    }
}