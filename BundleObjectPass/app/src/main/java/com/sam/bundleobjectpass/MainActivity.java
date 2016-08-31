package com.sam.bundleobjectpass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Model model = new Model("Samir", "Samedov",32);

        Intent i = new Intent(MainActivity.this, ReceiverActivity.class);
        i.putExtra("Editing", model);
        startActivity(i);

    }
}
