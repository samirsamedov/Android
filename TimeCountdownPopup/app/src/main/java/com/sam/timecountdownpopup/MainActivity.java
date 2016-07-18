package com.sam.timecountdownpopup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Intent timeCOunter = new Intent(MainActivity.this, TimeCounterActivity.class);
        //startActivity(timeCOunter);


        findViewById(R.id.btn_time_counter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertTimer alertTimer = new AlertTimer();
                alertTimer.show(getSupportFragmentManager(), "timepopup");
            }
        });

    }
}
