package com.sam.timecountdownpopup;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

/**
 * Created by Samir on 18.7.2016.
 */

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class TimeCounterActivity extends Activity {

    TextView txt_time_counter;
    ImageView img_start;
    ImageView img_stop;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_counter);

        txt_time_counter = (TextView) findViewById(R.id.txt_time_counter);
        img_start = (ImageView) findViewById(R.id.img_start);
        img_stop = (ImageView) findViewById(R.id.img_stop);
        String time = "00:03:00"; // göstermelik

        txt_time_counter.setText(time);

        final CountDownTimer timer = new CounterClass(180000, 1000);// serverdan alıcaz ve şu anki zmanla kıyasla ölçücez
        timer.start();

        img_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
            }
        });

        img_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
            }
        });


    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @SuppressLint("NewApi")
        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        @Override
        public void onTick(long l) {

            long millis = l;
            // int progress = (int) (l/1000);
            //txt_time_counter.setText(Integer.toString(progress));

            String hms = String.format("%02d:%02d:%2d:", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MICROSECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MICROSECONDS.toMinutes(millis)));
            // Toast.makeText(getApplicationContext(), "Time : " + hms, Toast.LENGTH_SHORT).show();
            txt_time_counter.setText(hms);
        }

        @Override
        public void onFinish() {
            txt_time_counter.setText("Completed.");
        }
    }
}
