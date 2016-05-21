package com.uygulama.haluk.gazeteapplication.util;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.app.ListFragment;
import android.util.Log;

import com.uygulama.haluk.gazeteapplication.model.Haber;
import com.uygulama.haluk.gazeteapplication.model.HaberParser;

import java.util.List;

/**
 * Created by Haluk on 30.04.2016.
 */// Asycn parametrelerini biz ayarladık burda
public class HaberYukleyici extends AsyncTask<String, Void, List<Haber>> {

    private static final String TAG = HaberYukleyici.class.getName();

    private ProgressDialog progressDialog;

    private List<Haber> haberler;
    // constructore gelen ListFragment ile eşleştirmek için
    private ListFragment listFragment;

    public HaberYukleyici(ListFragment listFragment) {
        this.listFragment = listFragment;
    }

    // işlemler doInBackround devam ederken once ekranda neler görünsün
    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(listFragment.getActivity());
        this.progressDialog.setTitle("Guncelleniyor...");
        this.progressDialog.setMessage("Haberler indiriliyor");
        this.progressDialog.setCancelable(false);
        this.progressDialog.setIndeterminate(true); // ne kadar surecegi bilinmedigi icin
        progressDialog.show();

    }

    // burda yaptıgımız haberleri çekmel
    @Override
    protected List<Haber> doInBackground(String... params) {// Haber listesi dönücek
        HaberParser haberParser = new HaberParser(params[0]);// xml sayfasını gonderdik
        // param[0] xm_ url si
        try {
            haberler = haberParser.haberleriCek();
            for(Haber suankiHaber: haberler){
                suankiHaber.setResim(Util.getInstance(listFragment.getActivity()).downLoadImage(suankiHaber.getResimUrl()));
            }


        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
        return haberler;
    }

    public List<Haber> getHaberler() {
        return haberler;
    }

    @Override
    protected void onPostExecute(List<Haber> result) {
         //pars edilmiş haber listesini ekrana liste fragmenti olusturoyuırz
        this.progressDialog.dismiss();
        HaberListesiAdapter listeAdapter = new HaberListesiAdapter(result, listFragment);
        listFragment.setListAdapter(listeAdapter);
    }
}
