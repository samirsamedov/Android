package com.sam.jsonarray.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.sam.jsonarray.R;
import com.sam.jsonarray.adapter.PersonsAdapter;
import com.sam.jsonarray.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

/**
 * Created by Samir on 20.06.2016.
 */

public class MainActivity extends AppCompatActivity {

    private String JSON_URL = "http://www.androidevreni.com/dersler/json_veri.txt";
    private OkHttpClient client = new OkHttpClient();
    private List<Person> personList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PersonsAdapter personsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timber.i("onCreate ..");

        // JSON DATAYI İNDİR
        new DownloadJSON().execute();

        // RECYCLERVIEW
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        personsAdapter = new PersonsAdapter(personList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(personsAdapter);

    }

    /**
     * OkHttp İLE ADRESTEKİ VERİYİ İNDİREN METODUMUZ
     *
     * @param url
     * @return
     * @throws IOException
     */
    private String run(String url) throws IOException {
        Timber.i("run ..");
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * JSON DATAYI ARKAPLANDA İNDİRMEMİZİ SAĞLAYACAK DownloadJSON ASYCTASK SINIFIMIZ
     */
    private class DownloadJSON extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            Timber.i("onPreExecute ..");

        }

        @Override
        protected String doInBackground(String... params) {
            Timber.i("doInBackground ..");

            // İNDİRME İŞİNİ BURADA YAPACAĞIZ
            String jsonData = null;
            try {
                jsonData = run(JSON_URL);
                Timber.i("JSON VERİMİZ : > " + jsonData);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // JSON VERİYİ NULL DEĞİLSE JAVA NESNELERİNE DÖNÜŞTÜR
            if (null != jsonData) {
                Timber.i("jsonData null değil ..");
                // VERİYİ GSON İLE NESNELERE DÖNÜŞTÜR
                Gson gson = new Gson();
                List<Person> persons = new ArrayList<Person>();
                persons = Arrays.asList(gson.fromJson(jsonData, Person[].class));

                // LİSTEYİ KONTROL AMAÇLI LOGCAT E YAZDIR & LİSTEYE AİT DİZİYE ELEMANLARI EKLE
                for (int i = 0; i < persons.size(); i++) {
                    Timber.i("name #" + i + " : > " + persons.get(i).name);
                    Timber.i("city #" + i + " : > " + persons.get(i).city);
                    Timber.i("country #" + i + " : > " + persons.get(i).country);
                    personList.add(persons.get(i));
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            Timber.i("onPostExecute ..");
            personsAdapter.notifyDataSetChanged();
        }
    }

}