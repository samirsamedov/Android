package com.dailyworship.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dailyworship.R;

import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    ImageView imageView;


    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_page, container, false);
        imageView = (ImageView) view.findViewById(R.id.img_view_sayfalar);
        //return inflater.inflate(R.layout.fragment_page, container, false);

        Bundle bundle = getArguments();
        String message = Integer.toString(bundle.getInt("count"));
        imageView.getResources().getDrawable(R.drawable.sayfa2);
        return view; // yukardaki otomatik gelen view biz kendimiz yaptık
    }

}
