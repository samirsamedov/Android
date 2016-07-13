package com.sam.scrollviewlogic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

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
        * <ScrollView // // open
                android:layout_width="match_parent"
                android:layout_height="wrap_content">

                 <LinearLayout  // open
                    android:orientation="vertical"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent">

                 </LinearLayout> //Close

            </ScrollView> // close
        * */

        /*
        ScrollView parentScroll = (ScrollView) findViewById(R.id.parentScroll);
        ScrollView childScroll = (ScrollView) findViewById(R.id.childScroll);


        parentScroll.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                Log.v("PARENT", "PARENT TOUCH");
                findViewById(R.id.childScroll).getParent()
                        .requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        childScroll.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                Log.v("CHILD", "CHILD TOUCH");
                // Disallow the touch request for parent scroll on touch of
                // child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        */
    }
}
