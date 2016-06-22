package com.sam.volleylmgurlswap.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sam.volleylmgurlswap.fragment.DisplayImgFrag;
import com.sam.volleylmgurlswap.R;

public class MainActivity extends AppCompatActivity {

    DisplayImgFrag displayImgFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayImgFrag = new DisplayImgFrag();

        findViewById(R.id.btn_image_display).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityDisplay.class));


            }
        });
    }
}
