package com.sam.fragrmentdatashare;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentTwo extends Fragment {

    TextView txt_second_msg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_two, container, false);
        txt_second_msg = (TextView) view.findViewById(R.id.txt_second_msg);


        return view;
    }

    public void getData(String msg) {
        txt_second_msg.setText(msg);
    }
}
