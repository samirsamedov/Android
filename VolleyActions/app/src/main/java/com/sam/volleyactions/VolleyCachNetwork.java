package com.sam.volleyactions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyCachNetwork extends AppCompatActivity {

    Button btn_request2;
    Button btn_gomain;
    TextView txt_response2;
    String server_url ="http://date.jsontest.com/";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_cach_network);
        btn_request2 = (Button) findViewById(R.id.btn_request2);
        btn_gomain = (Button) findViewById(R.id.btn_gomain);
        txt_response2 = (TextView) findViewById(R.id.txt_response2);



        Cache cache = new DiskBasedCache(getCacheDir(),1024*1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache,network);
        requestQueue.start();

        btn_gomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMain = new Intent(VolleyCachNetwork.this,MainActivity.class);
                startActivity(intentMain);
            }
        });


        btn_request2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                txt_response2.setText(response);
                                requestQueue.stop(); // after action we need to stop requestQueue
                            }
                        }, new Response.ErrorListener() { // this parameter is for if any errros will occure
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        txt_response2.setText("Error Something Wrong");
                        error.printStackTrace();
                        requestQueue.stop(); // again after action we need to stop requestQueue
                    }
                });
                requestQueue.add(stringRequest);
            }
        });
    }
}
