package com.sam.bundleobjectpass;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

/**
 * Created by Samir on 31.8.2016.
 */
public class ReceiverActivity extends Activity {

    TextView txt_name;
    TextView txt_surname;
    TextView txt_age;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        txt_name = (TextView)findViewById(R.id.txt_name);
        txt_surname = (TextView)findViewById(R.id.txt_surname);
        txt_age = (TextView)findViewById(R.id.txt_age);

        Model model = (Model) getIntent().getSerializableExtra("Editing");

        txt_name.setText(model.getName());
        txt_surname.setText(model.getSurName());
        txt_age.setText(""+model.getAge());


    }
}
