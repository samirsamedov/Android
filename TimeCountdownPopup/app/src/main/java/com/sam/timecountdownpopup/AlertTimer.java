package com.sam.timecountdownpopup;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by Samir on 18.7.2016.
 */
public class AlertTimer extends DialogFragment {


    TextView txt_popup_timer_time;
    ImageView img_popup_timer_accept;
    ImageView img_popup_timer_wait;
    ImageView img_popup_timer_cancel;
    ImageView img_popup_timer_watch_again;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popup_timer, container, false);

        txt_popup_timer_time = (TextView) view.findViewById(R.id.txt_popup_timer_time);
        img_popup_timer_accept = (ImageView) view.findViewById(R.id.img_popup_timer_accept);
        img_popup_timer_wait = (ImageView) view.findViewById(R.id.img_popup_timer_wait);
        img_popup_timer_cancel = (ImageView) view.findViewById(R.id.img_popup_timer_cancel);
        img_popup_timer_watch_again = (ImageView) view.findViewById(R.id.img_popup_timer_watch_again);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String time = "00:03:00"; // göstermelik

        txt_popup_timer_time.setText(time);

        final CountDownTimer timer = new CounterClass(180000, 1000);// serverdan alıcaz ve şu anki zmanla kıyasla ölçücez
        timer.start();


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
            txt_popup_timer_time.setText(hms);
        }

        @Override
        public void onFinish() {
            txt_popup_timer_time.setText("Completed.");
        }
    }
}
