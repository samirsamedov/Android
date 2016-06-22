package com.sam.loginregisterfragment.activity;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sam.loginregisterfragment.fragment.LoginFragment;
import com.sam.loginregisterfragment.R;
import com.sam.loginregisterfragment.fragment.RegisterFragment;

public class MainActivity extends AppCompatActivity {

    TextView txt_new_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_new_user = (TextView) findViewById(R.id.txt_new_user);


        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();
        fragmentTransaction.add(R.id.fragment_container, loginFragment);
        fragmentTransaction.commit();

        txt_new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                RegisterFragment registerFragment = new RegisterFragment();
                fragmentTransaction.replace(R.id.fragment_container,registerFragment);
                fragmentTransaction.commit();

            }
        });


    }


}
