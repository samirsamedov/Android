package com.sam.bitmaptranfer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Samir on 28.6.2016.
 */


public class DisplayBitmap extends Activity {

    ImageView img_display;
    Button btn_goback;
    public static final String IMG_KEY = "image_key";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_bitmap_activity);


        img_display = (ImageView) findViewById(R.id.img_display);
        btn_goback = (Button) findViewById(R.id.btn_goback);

        Intent intentIMG = getIntent();
        Bundle bundle = new Bundle();
        bundle = intentIMG.getExtras();
        Bitmap bitmap;
        bitmap = (Bitmap) bundle.get(IMG_KEY);

        img_display.setImageBitmap(bitmap);
        btn_goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
