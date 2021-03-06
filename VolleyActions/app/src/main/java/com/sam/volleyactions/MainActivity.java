package com.sam.volleyactions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button btn_request;
    Button btn_second;
    TextView txt_response;
    String server_url ="http://ip.jsontest.com/?callback=showMyIP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_request = (Button) findViewById(R.id.btn_request);
        btn_second = (Button) findViewById(R.id.btn_second);
        txt_response = (TextView) findViewById(R.id.txt_response);

        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSecond = new Intent(MainActivity.this,VolleyCachNetwork.class);
                startActivity(intSecond);
            }
        });

        btn_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                txt_response.setText(response);
                                requestQueue.stop(); // after action we need to stop requestQueue
                            }
                        }, new Response.ErrorListener() { // this parameter is for if any errros will occure
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        txt_response.setText("Error Something Wrong");
                        error.printStackTrace();
                        requestQueue.stop(); // again after action we need to stop requestQueue
                    }
                });
                requestQueue.add(stringRequest);
            }
        });
    }
}
