package com.sam.volleyjsonobjectrequest.util;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Samir on 13.6.2016.
 */
public class Singleton {

    private static Singleton mInstance;
    private RequestQueue requestQueue;
    private static Context mContext;

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return requestQueue;
    }

    private Singleton(Context context) {
        this.mContext = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized Singleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Singleton(context);
        }
        return mInstance;
    }

    public <T> void addToRequestQueue(Request<T> tRequest) {

        requestQueue.add(tRequest);
    }

}
