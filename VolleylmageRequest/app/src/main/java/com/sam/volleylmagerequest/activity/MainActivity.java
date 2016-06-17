package com.sam.volleylmagerequest.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.sam.volleylmagerequest.R;
import com.sam.volleylmagerequest.util.Singleton;

public class MainActivity extends AppCompatActivity {

    ImageView img_view;
    Button btn_get_image;
    String IMG_URL = "http://kingofwallpapers.com/forest/forest-009.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_view = (ImageView) findViewById(R.id.img_view);
        btn_get_image = (Button) findViewById(R.id.btn_get_image);

        btn_get_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageRequest imageRequest = new ImageRequest(IMG_URL, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        img_view.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, "Something Wrong", Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                    }
                });
                Singleton.getInstance(MainActivity.this).addToRequestQueue(imageRequest);
            }
        });

    }
}
