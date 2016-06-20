package com.sam.checklternet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sam.checklternet.R;
import com.sam.checklternet.util.Util;

public class MainActivity extends AppCompatActivity {

    Button btn_general;
    Button btn_wifi;
    Button btn_mobile_internet;
    TextView txt_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_general = (Button) findViewById(R.id.btn_general);
        btn_wifi = (Button) findViewById(R.id.btn_wifi);
        btn_mobile_internet = (Button) findViewById(R.id.btn_mobile_internet);
        txt_message = (TextView) findViewById(R.id.txt_message);

        btn_general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean internet = Util.getInstance(MainActivity.this).checkGeneralInternet();
                if(internet){
                    txt_message.setText("Genal Internet is Available");
                }else {
                    txt_message.setText("Genal Internet is Not Available");
                }
            }
        });

        btn_wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean internet = Util.getInstance(MainActivity.this).checkMobileInternetConnWIFI();
                if(internet){
                    txt_message.setText("WIFI Internet is Available");
                }else {
                    txt_message.setText("WIFI Internet is Not Available");
                }
            }
        });



        btn_mobile_internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean internet = Util.getInstance(MainActivity.this).checkInternetConnMOBILE();
                if(internet){
                    txt_message.setText("MOBILE Internet is Available");
                }else {
                    txt_message.setText("MOBILE Internet is Not Available");
                }
            }
        });





    }
}
