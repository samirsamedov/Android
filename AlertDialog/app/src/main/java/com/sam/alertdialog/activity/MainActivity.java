package com.sam.alertdialog.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sam.alertdialog.R;
import com.sam.alertdialog.dialog.MyAlert;

public class MainActivity extends AppCompatActivity {
    Button btn_show_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_show_dialog = (Button) findViewById(R.id.btn_show_dialog);
        btn_show_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAlert myAlert = new MyAlert();
                String tag = "My Alert";
                myAlert.show(getSupportFragmentManager(), tag);

            }
        });

    }


}
