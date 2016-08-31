package com.sam.glidelmagelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity {
    String imgUrl;
    ImageView imageview;
    private String[] IMG_URL;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview = (ImageView) findViewById(R.id.imageview);
        IMG_URL = new String[3];
        IMG_URL[0] = "http://www.intrawallpaper.com/static/images/Hawaii-Beach-Wallpaper-HD_H47ejc9.jpg";
        IMG_URL[1] = "http://www.intrawallpaper.com/static/images/Nature-HD-1080P.jpg";
        IMG_URL[2] = "http://www.intrawallpaper.com/static/images/6937164-beautiful-summer-wallpaper-hd.jpg";
        count = 0;

        Glide.with(MainActivity.this).load(IMG_URL[count])
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.loading_icon)
                .centerCrop()
                .override(300, 200)
                .error(R.drawable.ic_3d_rotation_light_green_700_36dp)
                .into(imageview);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgUrl = IMG_URL[count];
                count++;
                if (count == 3)
                    count = 0;
                Glide.with(MainActivity.this).load(imgUrl)
                        .thumbnail(0.5f)
                        .crossFade()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.loading_icon)
                        .centerCrop()
                        .override(300, 200)
                        .error(R.drawable.ic_3d_rotation_light_green_700_36dp)
                        .into(imageview);

            }
        });
    }
}
