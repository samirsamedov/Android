package com.sam.cloudinaryex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cloudinary.Cloudinary;
import com.sam.cloudinaryex.mCloud.CloudinaryClient;
import com.sam.cloudinaryex.mPicasso.PicassoClient;

public class MainActivity extends AppCompatActivity {

    boolean resize = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView img = (ImageView) findViewById(R.id.img);
        Button btn = (Button) findViewById(R.id.btn);
        Button btn_nextAct = (Button) findViewById(R.id.btn_nextAct);

        btn_nextAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (resize) {
                    PicassoClient.downloadImage(MainActivity.this, CloudinaryClient.resize(), img);
                    resize = false;
                } else {
                    PicassoClient.downloadImage(MainActivity.this, CloudinaryClient.getRoundedCorners(), img);
                    resize = true;
                }
            }
        });
    }
}
