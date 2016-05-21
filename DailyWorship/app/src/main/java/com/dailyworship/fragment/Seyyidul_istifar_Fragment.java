package com.dailyworship.fragment;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dailyworship.R;

/**
 * Created by Samir on 5.5.2016.
 */
public class Seyyidul_istifar_Fragment extends Fragment {

    ImageView img_seyyidul_istifar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_yasini_serif,container,false);
    }
}
