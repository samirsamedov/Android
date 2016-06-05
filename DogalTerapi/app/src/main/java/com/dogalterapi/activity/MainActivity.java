package com.dogalterapi.activity;


import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.dogalterapi.R;
import com.dogalterapi.util.DBContext;
import com.dogalterapi.util.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/*
* Uygulama Bu Sınıfla Açılır Ve kUllanıcıya Menu Sunar Kullanıcının Menuden Sectigi Yonlendrimeler Bu Sınıf Aracılıgı İle Gerçekleşir*/

public class MainActivity extends AppCompatActivity {

    private Button btn_main_new_record;
    private Button btn_main_musterileri_goster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBContext.getInstance(MainActivity.this).getAllEmployees();
        DBContext.getInstance(MainActivity.this).closeDB();

        btn_main_new_record = (Button)findViewById(R.id.btn_main_new_record);
        btn_main_musterileri_goster = (Button)findViewById(R.id.btn_main_musterileri_goster);

        btn_main_new_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMain = new Intent(MainActivity.this, NewRecordActivity.class);
                // Geri Donus Stack Temizleme İşlemleri
                //intentMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentMain);
                //finish();

            }
        });
        btn_main_musterileri_goster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMusterGoster = new Intent(MainActivity.this,MusteriBilgiActivity.class);
                //intentMusterGoster.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentMusterGoster);
            }
        });
    }
}

/*
* btn_mus_guncelle = (Button)convertView.findViewById(R.id.btn_mus_guncelle);
            btn_mus_guncelle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMain = new Intent(getActivity(), MainActivity.class);
                    intentMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentMain);
                }
            });*/
