package com.sam.alertcustomdialogfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by Samir on 8.7.2016.
 */
public class MyAlert extends DialogFragment {
    Button dosomething;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popup_fragment, container, false);

        //dosomething = (Button) view.findViewById(R.id.dosomething);

        /*
        dosomething.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().setTitle("Hello There");
                dismiss();
            }
        });
        */


        return view;
    }
}
