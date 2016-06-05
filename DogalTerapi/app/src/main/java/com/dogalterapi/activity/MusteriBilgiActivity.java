package com.dogalterapi.activity;

import android.support.v4.app.Fragment;

import com.dogalterapi.fragment.MusterilikListesiFragment;
import com.dogalterapi.util.Util;

/**
 * Created by Samir on 24.5.2016.
 */
public class MusteriBilgiActivity extends AbsrtactSingleFragment {

    @Override
    Fragment createFragment() {
        //Util.showMessage(getApplication(),"MusteriBilgiActivity içi");
        return new MusterilikListesiFragment();
    }
}
