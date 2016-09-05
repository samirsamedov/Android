package com.sam.cloudinaryex;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.sam.cloudinaryex.mCloud.MyCOnfiguration;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Samir on 5.9.2016.
 */
public class SecondActivity extends Activity {
    File photoFile;
    public static final int REQUEST_TAKE_PHOTO = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Button btn_capture_img = (Button) findViewById(R.id.btn_capture_img);
        Button btn_upload = (Button) findViewById(R.id.btn_upload);

        btn_capture_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenImatToSec = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intenImatToSec, REQUEST_TAKE_PHOTO);
            }
        });// end onf button event

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File("malzemeler.jpg");
                try {

                    HashMap config = new HashMap();
                    config.put("cloud_name", "www-samirsamedov-com");
                    config.put("app_key", "987524313965712");
                    config.put("app_secret", "ztxsBzMmuFeZfju7G5OiHfA7CoY");
                    Cloudinary cloudinary2 = new Cloudinary(config);
                   // Map uploadResult = cloudinary2.uploader().upload(file, ObjectUtils.emptyMap());

                    File toUpload = new File("malzemeler.jpg");
                    Map uploadResult2 = cloudinary2.uploader().upload(toUpload, ObjectUtils.emptyMap());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }// end of onCreate


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_TAKE_PHOTO) {
            if (resultCode == RESULT_OK) {

                //File to upload to cloudinary

                Bundle bundle = data.getExtras();
                Bitmap bitmap = (Bitmap) bundle.get("data");
                Uri imgUri = getImageUri(SecondActivity.this, bitmap);
                String imgFileUrl = getRealPathFromURI(imgUri);
                /*
               Map config = new HashMap();
                config.put("cloud_name", "dkepfkeuu");
                config.put("api_key", "552563677649679");
                config.put("api_secret", "7n8wJ42Hr_6nqZ4aOMDXjTIZ4P0");
                Cloudinary cloudinary = new Cloudinary(config);*/
                Cloudinary cloudinary = new Cloudinary(MyCOnfiguration.getMyConfigs());
                try {

                    cloudinary.uploader().upload(imgFileUrl,
                            ObjectUtils.emptyMap());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
                //finish();
            }
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "capturedImage";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        return image;
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

}
