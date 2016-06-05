package com.dogalterapi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dogalterapi.R;
import com.dogalterapi.activity.MainActivity;
import com.dogalterapi.model.User;
import com.dogalterapi.util.DBContext;
import com.dogalterapi.util.Util;

import java.util.UUID;

/**
 * Created by Samir on 25.5.2016.
 */
public class MusteriFragment extends Fragment {
    public static final String EXTRA_MUSTERI_ID ="";// MusteriFragment.class.getPackage() + ".etkinlik_id";
    private User suankiMusteri;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // MusterilikListesiFragment dan İntent Yapısı ile Gonderilern ID Yı aldık
       // UUID id = (UUID) getArguments().get(EXTRA_MUSTERI_ID);
        long id = (long) getArguments().get(EXTRA_MUSTERI_ID);
        // Gonderilen Id yi ilgili methodumuza verip ilgili musteriyi tespit ettik
        suankiMusteri = DBContext.getInstance(getActivity()).getMusteriById(id);
        DBContext.getInstance(getActivity()).closeDB();
    }

    @Override
    public void onResume() {
        super.onResume();
        long id = (long) getArguments().get(EXTRA_MUSTERI_ID);
        suankiMusteri = DBContext.getInstance(getActivity()).getMusteriById(id);
        DBContext.getInstance(getActivity()).closeDB();
    }

    public static MusteriFragment newInstance(long id) {//UUID id
        MusteriFragment fragment = new MusteriFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_MUSTERI_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.musteri_bilgisi_goster, container, false);
        /* ve suankiMusteri bilgilerini ekrana yüklüyoruz
         yukarda id ye göre ilgili musteriyi tespit ettigimiz için burda tekrar aynı işleme gerek yok
         txtTitle.setText(etkinlik.getEtiket());
         */
        long id = (long) getArguments().get(EXTRA_MUSTERI_ID);
        suankiMusteri = DBContext.getInstance(getActivity()).getMusteriById(id);
        DBContext.getInstance(getActivity()).closeDB();

        final EditText txt_mus_ad = (EditText) view.findViewById(R.id.txt_mus_ad);
        {
            txt_mus_ad.setText(suankiMusteri.getAd());
        }
        final EditText txt_mus_soyad = (EditText) view.findViewById(R.id.txt_mus_soyad);
        {
            txt_mus_soyad.setText(suankiMusteri.getSoyad());
        }
        final EditText txt_mus_telefon = (EditText) view.findViewById(R.id.txt_mus_telefon);
        {
            txt_mus_telefon.setText(suankiMusteri.getTelefon_no());
        }
        final EditText txt_mus_yas = (EditText) view.findViewById(R.id.txt_mus_yas);
        {
            txt_mus_yas.setText(suankiMusteri.getYas());
        }
        final EditText txt_mus_kilo = (EditText) view.findViewById(R.id.txt_mus_kilo);
        {
            txt_mus_kilo.setText(suankiMusteri.getKilo());
        }
        final EditText txt_mus_eposta = (EditText) view.findViewById(R.id.txt_mus_eposta);
        {
            txt_mus_eposta.setText(suankiMusteri.getEposta());
        }
        final EditText txt_mus_adres = (EditText) view.findViewById(R.id.txt_mus_adres);
        {
            txt_mus_adres.setText(suankiMusteri.getAdres());
        }
        Button btn_mus_bil_guncelle = (Button)view.findViewById(R.id.btn_mus_bil_guncelle);

        btn_mus_bil_guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                long id = suankiMusteri.getId();
                user.setAd(txt_mus_ad.getText().toString().trim());
                user.setSoyad(txt_mus_soyad.getText().toString().trim());
                user.setTelefon_no(txt_mus_telefon.getText().toString().trim());
                user.setYas(txt_mus_yas.getText().toString().trim());
                user.setKilo(txt_mus_kilo.getText().toString().trim());
                user.setEposta(txt_mus_eposta.getText().toString().trim());
                user.setAdres(txt_mus_adres.getText().toString().trim());
                int guncellenen  = DBContext.getInstance(getActivity()).updateUser(user,id);
                DBContext.getInstance(getActivity()).closeDB();
                Util.showMessage(getActivity(), guncellenen == 0 ? " Guncellenemedi" : id + " nolu Müşteri Guncellendi");
            }
        });

        Button btn_mus_bil_sil = (Button)view.findViewById(R.id.btn_mus_bil_sil);
        btn_mus_bil_sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                long id = suankiMusteri.getId();
                int silinen =   DBContext.getInstance(getActivity()).deleteUser(id);
                Util.showMessage(getActivity(), silinen == 0 ? "Kayıt Silinemedi" : id + " nolu Müşteri Silindi");
                Intent intentMain = new Intent(getActivity(),MainActivity.class);
                //intentMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentMain);
            }
        });

        return view;// Bilgilerini Yuklediğimiz View ı Ekrana verdik
    }
}
