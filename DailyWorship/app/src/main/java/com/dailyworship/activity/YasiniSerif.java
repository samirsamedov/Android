package com.dailyworship.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dailyworship.R;
import com.dailyworship.adapter.SwipeYasiniSerifAdapter;

public class YasiniSerif extends FragmentActivity {

    ViewPager view_pager_yasini_serif;
    SwipeYasiniSerifAdapter swipeYasiniSerifAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yasini_serif);

        // yukleme işlemini bu sınıfdan yapıyoruz adapter olusturdukdan sonra
        view_pager_yasini_serif = (ViewPager) findViewById(R.id.view_pager_yasini_serif);
        swipeYasiniSerifAdapter = new SwipeYasiniSerifAdapter(this);
        view_pager_yasini_serif.setAdapter(swipeYasiniSerifAdapter);

        // Adapter lazım fragment lazım
    }
}
