package com.sam.bitmaptranfer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn_take_photo;
    int REQUEST_CODE = 2;
    public static final String IMG_KEY = "image_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_take_photo = (Button) findViewById(R.id.btn_take_photo);


        btn_take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenImatToSec = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intenImatToSec.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intenImatToSec, REQUEST_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = new Bundle();
                bundle = data.getExtras();
                Bitmap bitmap;
                bitmap = (Bitmap) bundle.get("data");
                Intent intentBitMap = new Intent(getApplicationContext(), DisplayBitmap.class);
                intentBitMap.putExtra(IMG_KEY, bitmap);
                startActivity(intentBitMap);

                //imgv_main_camera.setImageBitmap(bitmap);
            }
        }
    }
}
