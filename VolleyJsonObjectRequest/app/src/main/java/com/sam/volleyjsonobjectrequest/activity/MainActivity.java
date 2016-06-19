package com.sam.volleyjsonobjectrequest.activity;

import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.sam.volleyjsonobjectrequest.R;
import com.sam.volleyjsonobjectrequest.util.Singleton;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button btn_get_json_object;
    TextView txt_one;
    TextView txt_two;
    String JSON_URL = "http://echo.jsontest.com/key/value/one/two";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_one = (TextView) findViewById(R.id.txt_one);
        txt_two = (TextView) findViewById(R.id.txt_two);
        btn_get_json_object = (Button) findViewById(R.id.btn_get_json_object);

        btn_get_json_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, JSON_URL, (String) null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            txt_one.setText(response.getString("one"));
                            txt_two.setText(response.getString("key"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Something Wrong", Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                    }
                });

                Singleton.getInstance(MainActivity.this).addToRequestQueue(jsonObjectRequest);

            }
        });
    }
}
