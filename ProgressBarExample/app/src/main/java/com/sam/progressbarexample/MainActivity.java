package com.sam.progressbarexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_start_progresbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start_progresbar = (Button) findViewById(R.id.btn_start_progresbar);
        btn_start_progresbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent progres = new Intent(MainActivity.this, ProgresBarActivity.class);
                startActivity(progres);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "Main Ended", Toast.LENGTH_SHORT).show();
    }
}
