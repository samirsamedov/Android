package com.uygulama.haluk.gazeteapplication.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.uygulama.haluk.gazeteapplication.fragment.HaberFragment;

/**
 * Created by Samir on 7.5.2016.
 */
public class HaberActivity extends AbstractSingleFragment {


    public static final String EXTRA_NEWS_LINK = "";

    @Override
    Fragment createFragment() {
        //BIRINCI SECENEK
        String haberBaglantısi = getIntent().getStringExtra(EXTRA_NEWS_LINK);
        Bundle args = new Bundle();
        args.putString(EXTRA_NEWS_LINK,haberBaglantısi);
        HaberFragment fragment = new HaberFragment();
        fragment.setArguments(args);
        return fragment  ;
    }
}
