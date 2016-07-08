package com.sam.alertcustomdialog.activity;

import android.app.Dialog;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.sam.alertcustomdialog.R;
import com.sam.alertcustomdialog.dialog.MyAlert;

public class MainActivity extends AppCompatActivity {
    Button btn_show_dialog;
    Button btn_cancel;
    Button btn_login;
    EditText txt_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_show_dialog = (Button) findViewById(R.id.btn_show_dialog);

        btn_show_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Login Dialog");
                dialog.setContentView(R.layout.custom_dialog);
                dialog.show();

                txt_name = (EditText) dialog.findViewById(R.id.txt_name);
                btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
                btn_login = (Button) dialog.findViewById(R.id.btn_login);


                btn_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(getApplicationContext(), "Welcome " + txt_name.getText().toString(), Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });

            }
        });


    }
}
