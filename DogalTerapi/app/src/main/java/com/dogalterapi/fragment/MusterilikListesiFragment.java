package com.dogalterapi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dogalterapi.R;
import com.dogalterapi.activity.MainActivity;
import com.dogalterapi.activity.MusteriPagerActivity;
import com.dogalterapi.model.User;
import com.dogalterapi.util.DBContext;

import java.util.List;

/**
 * Created by Samir on 24.5.2016.
 * Bu Classımız bize ekranda kayıtlı musterileri Listview yapısı ile scroll bicimde getirme ayarlarını içeriyor
 */
public class MusterilikListesiFragment extends ListFragment {
    private List<User> musteriListesi;
    Button btn_mus_guncelle;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User count = new User();

        musteriListesi = DBContext.getInstance(getActivity()).getAllEmployees();// butün musteri listesini "musteriListesi" dizimize atadık
        DBContext.getInstance(getActivity()).closeDB();
        // bundan sonra adapt
        BaseAdapter baseAdapter = new MusteriListesiAdapter();
        setListAdapter(baseAdapter);
        //Toast.makeText(getActivity(), "MusterilikListesiFragment", Toast.LENGTH_SHORT).show();


    }

    // Item Uzerine Tıklandıgında
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // o anki tıklanan musteriyi tespit ettik
        User musteri = (User) getListAdapter().getItem(position);
        // Pager sınıfımıza yonlendirdik
        Intent intentMusteriPager = new Intent(getActivity(), MusteriPagerActivity.class);
        // ve bilgileri fragment aracılıg ile aynı layoutta ekrana getirmek üzre tıklanan musterinin id sini İntent veri taşıma
        // yolu ile ilgili fragmente yönlendirdik
        intentMusteriPager.putExtra(MusteriFragment.EXTRA_MUSTERI_ID, musteri.getId());
        startActivity(intentMusteriPager);

    }

    @Override
    public void onResume() {
        super.onResume();
        MusteriListesiAdapter adapter = (MusteriListesiAdapter) getListAdapter();
        adapter.notifyDataSetChanged();
    }


    private class MusteriListesiAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return musteriListesi.size();
        }

        @Override
        public Object getItem(int position) {
            return musteriListesi.get(position);
        }

        @Override
        public long getItemId(int position) {
            //return musteriListesi.get(position).getId().getMostSignificantBits();
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // o anki musteri bilgilerine eriştik
            musteriListesi = DBContext.getInstance(getActivity()).getAllEmployees();
            DBContext.getInstance(getActivity()).closeDB();
            User suankiMusteri = musteriListesi.get(position);
            //Toast.makeText(getActivity(), "MusterilikListesiFragment", Toast.LENGTH_SHORT).show();


            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.musteri_item, parent, false);
            }
            TextView txt_mus_item_ad = (TextView) convertView.findViewById(R.id.txt_mus_item_ad);
            {
                txt_mus_item_ad.setText(suankiMusteri.getAd());
            }

            TextView txt_mus_item_soyad = (TextView) convertView.findViewById(R.id.txt_mus_item_soyad);
            {
                txt_mus_item_soyad.setText(suankiMusteri.getSoyad());
            }
            /*
            TextView txt_mus_item_telefon = (TextView) convertView.findViewById(R.id.txt_mus_item_telefon);
            {
                txt_mus_item_telefon.setText(suankiMusteri.getTelefon_no());
            }
            */
            ImageView img_mus_item_gender = (ImageView) convertView.findViewById(R.id.img_mus_item_gender);
            if (suankiMusteri.getCinsiyet().equals("K")) {
                img_mus_item_gender.setImageResource(R.drawable.female);
            } else {
                img_mus_item_gender.setImageResource(R.drawable.male);
            }
            
            return convertView;
        }
    }
}
