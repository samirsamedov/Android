package com.sam.cameraactionsvideo;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button btn_record;
    Button btn_play;
    VideoView videoView;
    private int CODE_CAMERA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_play = (Button) findViewById(R.id.btn_play);
        btn_record = (Button) findViewById(R.id.btn_record);
        videoView = (VideoView) findViewById(R.id.videoView);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.start();

            }
        });

        btn_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intendPlayVideo = new Intent();
                intendPlayVideo.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(intendPlayVideo, CODE_CAMERA);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODE_CAMERA && resultCode == RESULT_OK) {
            Uri videoUrl = data.getData();
            videoView.setVideoURI(videoUrl);
        }
    }
}
