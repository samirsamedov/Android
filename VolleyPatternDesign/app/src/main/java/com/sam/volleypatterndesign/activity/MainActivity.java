package com.sam.volleypatterndesign.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sam.volleypatterndesign.R;
import com.sam.volleypatterndesign.Util.Singleton;

public class MainActivity extends AppCompatActivity {

    Button btn_main_get_server_data;
    TextView txt_server_ip_data;
    String SERVER_URL = "http://ip.jsontest.com/?callback=showMyIP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_main_get_server_data = (Button) findViewById(R.id.btn_main_get_server_data);
        txt_server_ip_data = (TextView) findViewById(R.id.txt_server_ip_data);

        btn_main_get_server_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final StringRequest stringRequest = new StringRequest(Request.Method.POST, SERVER_URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                txt_server_ip_data.setText(response);

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        txt_server_ip_data.setText("Error....");
                        error.printStackTrace();
                    }
                });
                Singleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
            }
        });


    }
}
