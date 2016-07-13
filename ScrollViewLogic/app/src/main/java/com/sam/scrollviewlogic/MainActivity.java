package com.sam.scrollviewlogic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * Everthing is in layout
        *
        * ScrollView is main Frame
        * inside is we need a layout , I Choosed Linerlayout
        * and dont forget to close with what you opened
        * <ScrollView   // open
                android:layout_width="match_parent"
                android:layout_height="wrap_content">

                 <LinearLayout  // open
                    android:orientation="vertical"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent">

                 </LinearLayout> // close

            </ScrollView> // close
        * */
    }
}
