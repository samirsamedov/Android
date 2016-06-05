package com.dogalterapi.util;


import android.content.Context;
import android.widget.Toast;

/**
 * Created by Samir on 9.5.2016.
 */
public final class Util {
    private static Util INSTANCE;
    private Util util;

    private Util(Context context){
        this.util = new Util(context);
        // böyleikle bu sınıfı cagırıp ve içine ilgili activitiyi gönderdigimizde ilişkilendirmiş oluyoruz
    }

    // sınıfın nesnesini olusturamadıgımız için getInstance() methodlu ile nesnesine ulaşıp onun uzerinden başka method caıgıyoruz
    public static Util getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Util(context);
        }
        return INSTANCE;
    }

    public static void showMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
