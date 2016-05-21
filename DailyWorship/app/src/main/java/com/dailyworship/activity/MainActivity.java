package com.dailyworship.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dailyworship.R;

public class MainActivity extends AppCompatActivity {
    Button btn_main_yasini_serif;
    Button btn_main_ismi_azam;
    Button btn_main_seyidül_istiğfar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_main_yasini_serif = (Button)findViewById(R.id.btn_main_yasini_serif);

        // buSınıfdan sadece yonlendirme yapıyoruz
        btn_main_yasini_serif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentYasiniSefir = new Intent(MainActivity.this,YasiniSerif.class);
                startActivity(intentYasiniSefir);
            }
        });
    }
}
