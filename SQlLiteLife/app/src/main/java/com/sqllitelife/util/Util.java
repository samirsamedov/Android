package com.sqllitelife.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Samir on 8.5.2016.
 */
public class Util {
    public static void showMessage(Context context, String message) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
