package com.sam.volleylmgurlswap.activity;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sam.volleylmgurlswap.R;
import com.sam.volleylmgurlswap.fragment.DisplayImgFrag;

public class ActivityDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DisplayImgFrag displayImgFrag = new DisplayImgFrag();
        fragmentTransaction.add(R.id.fragment_container, displayImgFrag);
        fragmentTransaction.commit();


    }
}
