package com.sam.picassolmageloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView txt_see_image = (TextView) findViewById(R.id.txt_see_image);

        txt_see_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URL = "http://wallpapercave.com/wp/5SjVAtN.jpg";
                Picasso.with(getApplicationContext())
                        .load(URL)
                        .placeholder(R.drawable.wait)   // optional
                        .error(R.drawable.sorry)      // optional
                        .fit()
                        //.resize(1000, 1000)                        // optional
                        .into(imageView);
                        //.rotate(90)                             // optional

            }
        });

    }
}
