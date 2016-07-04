package com.sam.popupexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_pop_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_pop_up = (Button) findViewById(R.id.btn_pop_up);
        btn_pop_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPopUp = new Intent(MainActivity.this, PopUp2.class);
                startActivity(intentPopUp);
            }
        });
    }
}
