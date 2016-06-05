package com.dogalterapi.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.dogalterapi.R;
import com.dogalterapi.fragment.MusteriFragment;
import com.dogalterapi.model.User;
import com.dogalterapi.util.DBContext;

import java.util.List;
import java.util.UUID;

/**
 * Created by Samir on 25.5.2016.
 * Bu Pager Sınıfı aracılı ile bir layout üzerinde fragment dondurucez
 */
public class MusteriPagerActivity extends FragmentActivity {
    private ViewPager viewPager;
    private List<User> musteriListesi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPager = new ViewPager(this);
        // values klasor altında "ids" adı ile olusturdugumuz xml de özel yapı kullanarak bir id verdik
        viewPager.setId(R.id.musteri_view_pager);
        // yeni goruntu yuklendi
        setContentView(viewPager);
        // Butun Kayıtlı Mutserileri Cektik
        musteriListesi = DBContext.getInstance(this).getAllEmployees();
        FragmentManager fragmentManager = getSupportFragmentManager();

        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                User musteri = musteriListesi.get(position);
                return MusteriFragment.newInstance(musteri.getId());
            }

            @Override
            public int getCount() {
                return musteriListesi.size();
            }
        });


        //UUID id = (UUID) getIntent().getSerializableExtra(MusteriFragment.EXTRA_MUSTERI_ID);
        long id = (long) getIntent().getSerializableExtra(MusteriFragment.EXTRA_MUSTERI_ID);
        viewPager.setCurrentItem(DBContext.getInstance(this).getMusteriIndisi(id)); // gelen id'ye gore sayfada gosterim
    }
}
