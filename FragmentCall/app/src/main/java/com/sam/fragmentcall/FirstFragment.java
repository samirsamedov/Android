package com.sam.fragmentcall;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Samir on 12.7.2016.
 */
public class FirstFragment extends Fragment {

    Button btn_first_goto_second_frag;
    EditText txt_main_message;
    TextView txt_first_data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);


        btn_first_goto_second_frag = (Button) view.findViewById(R.id.btn_first_goto_second_frag);
        txt_main_message = (EditText) getActivity().findViewById(R.id.txt_main_message);// this is from activity
        txt_first_data = (TextView) view.findViewById(R.id.txt_first_data);

        String message = txt_main_message.getText().toString();
        btn_first_goto_second_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SecondFragment secondFragment = new SecondFragment();
                fragmentTransaction.add(R.id.first_fragment_id, secondFragment);
                fragmentTransaction.addToBackStack(null); // When we Click Back Called Fragments gone
                fragmentTransaction.commit();

            }
        });


        txt_first_data.setText(message);
        return view;
    }
}
