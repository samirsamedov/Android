package com.sam.progressbarexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by uno on 12/04/2016.
 */
public class ProgresBarActivity extends AppCompatActivity {
    private static final long SPLASH_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progresbar);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent().setClass(ProgresBarActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_TIME);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(ProgresBarActivity.this, "Pogres Ended", Toast.LENGTH_SHORT).show();
    }
}
