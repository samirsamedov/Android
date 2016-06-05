package com.dogalterapi.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;

import com.dogalterapi.R;
import com.dogalterapi.util.Util;

/**
 * Created by Samir on 24.5.2016.
 */
public abstract class AbsrtactSingleFragment extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        //Util.showMessage(getApplication(), "AbsrtactSingleFragment içi");
        // fragment null ise "createFragment" methodumuz yeni bir fragment donuyor
        // yukarda tanımlı fragmentManager aracılı ile ilgili fragmentimizi containere yüklüyoruz
        if (fragment == null) {
            fragment = createFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }



    abstract Fragment createFragment();
}
