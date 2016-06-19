package com.sam.volleyjsonarrayrequest;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Samir on 19.6.2016.
 */
public class BackGroundTast {

    private Context context;
    ArrayList<Contact> arrayList;
    String JSON_URL = "http://www.w3schools.com/angular/customers.php";

    public BackGroundTast(Context context) {
        this.context = context;
    }

    public ArrayList<Contact> getArrayList() {
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, JSON_URL, (String) null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int count = 0;

                while (count < response.length()) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(count);
                        Contact contact = new Contact(jsonObject.getString("Name"), jsonObject.getString("City"), jsonObject.getString("Country"));
                        arrayList.add(contact);
                        count++;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error....", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });

        Singleton.getInstance(context).addToRequestQueue(jsonArrayRequest);
        return arrayList;

    }
}
