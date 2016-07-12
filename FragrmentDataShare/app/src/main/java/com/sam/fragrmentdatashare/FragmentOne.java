package com.sam.fragrmentdatashare;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentOne extends Fragment {

    SendMessage SM;

    Button btn_first_send;
    EditText txt_first_getmessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_one, container, false);

        btn_first_send = (Button) view.findViewById(R.id.btn_send);
        txt_first_getmessage = (EditText) view.findViewById(R.id.txt_first_enter_info);

        btn_first_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SM.sendData(txt_first_getmessage.getText().toString());
            }
        });

        return view;
    }

    interface SendMessage {
        public void sendData(String message);
    }

    // Here we check i the sendmessage interface is implemented
    // An Instance we declared abowe

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            SM = (SendMessage) activity;
        } catch (ClassCastException cce) {
            throw new ClassCastException("You need to implement sendData method");
        }

    }
}
