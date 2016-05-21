package com.uygulama.haluk.gazeteapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.uygulama.haluk.gazeteapplication.R;
import com.uygulama.haluk.gazeteapplication.activity.HaberActivity;
import com.uygulama.haluk.gazeteapplication.model.Haber;
import com.uygulama.haluk.gazeteapplication.util.HaberYukleyici;
import com.uygulama.haluk.gazeteapplication.util.Util;

/**
 * Created by Haluk on 30.04.2016.
 */

//
public class MainFragment extends ListFragment {
    public static final String XML_ADDRESS = "http://t24.com.tr/rss";

    private HaberYukleyici haberYukleyici;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Util.getInstance(getActivity()).isInternetUygun()) {
            haberYukleyici = new HaberYukleyici(this); // gonderrek iki COntext arasında baglantı olusturuyoruz
            haberYukleyici.execute(XML_ADDRESS);// doInbackGround esnası ile eşleşen sistem params() burdaki giden parametre
        } else {
            Toast.makeText(getActivity(), R.string.baglanti_hatasi, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
      /* BIRINCI SECENEK
      Haber haber = haberYukleyici.getHaberler().get(position);// ilgili haber elimizde
        Intent intent = new Intent(getActivity(), HaberActivity.class);
        intent.putExtra(HaberActivity.EXTRA_NEWS_LINK, haber.getBaglanti());
        startActivity(intent);

        super.onListItemClick(l, v, position, id);
    */


        Haber haber = haberYukleyici.getHaberler().get(position);
        Intent intent = new Intent(getActivity(), HaberActivity.class);
        intent.putExtra(HaberActivity.EXTRA_NEWS_LINK, haber.getBaglanti());
        Toast.makeText(getActivity(),"URL "+haber.getResimUrl(),Toast.LENGTH_LONG).show();
        startActivity(intent);
        super.onListItemClick(l, v, position, id);


    }
}
