package com.cameraactions;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    Button btn_cmain_camera;
    ImageView imgv_main_camera;
    int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_cmain_camera = (Button) findViewById(R.id.btn_cmain_camera);
        imgv_main_camera = (ImageView) findViewById(R.id.imgv_main_camera);

        btn_cmain_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // camera application is avaliable check
                if (intentCamera.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intentCamera, REQUEST_CODE);
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
                imgv_main_camera.setImageBitmap(bitmap);
            }
        }
    }
}
