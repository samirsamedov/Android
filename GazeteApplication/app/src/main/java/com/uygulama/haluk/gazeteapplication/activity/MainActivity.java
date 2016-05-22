package com.uygulama.haluk.gazeteapplication.activity;

import android.support.v4.app.Fragment;

import com.uygulama.haluk.gazeteapplication.fragment.MainFragment;

/**
 * Created by Samir on 30.04.2016.
 */
public class MainActivity extends AbstractSingleFragment
{

    @Override
    Fragment createFragment()
    {
        return new MainFragment();
    }

}
