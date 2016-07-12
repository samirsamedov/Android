package com.sam.fragmentcall;

import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn_main_goto_second_frag;
    EditText txt_main_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_main_goto_second_frag = (Button) findViewById(R.id.btn_main_goto_second_frag);
        txt_main_message = (EditText) findViewById(R.id.txt_main_message);

        btn_main_goto_second_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FirstFragment firstFragment = new FirstFragment();
                fragmentTransaction.replace(R.id.main_activity_id, firstFragment);
                fragmentTransaction.addToBackStack(null); // When we Click Back Called Fragments gone
                fragmentTransaction.commit();
            }
        });

    }
}
