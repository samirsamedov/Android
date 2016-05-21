package com.sqllitelife.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sqllitelife.R;
import com.sqllitelife.model.dbUtil.DBContext;
import com.sqllitelife.util.Util;

public class UpdateEmploye extends AppCompatActivity {

    EditText txt_employee_name;
    EditText txt_employee_surname;
    Button btn_employe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_employe);

        btn_employe=(Button)findViewById(R.id.btn_employe);
        txt_employee_name =(EditText)findViewById(R.id.txt_employee_name);
        txt_employee_surname =(EditText)findViewById(R.id.txt_employee_surname);

        btn_employe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txt_employee_name.getText().toString();
                String surName = txt_employee_surname.getText().toString();
                SharedPreferences shp = getSharedPreferences("pref", MODE_PRIVATE);
                String idmiz = shp.getString("ismiz", "noname");// ikinci parametre default gelen
                if( !(name.equals("")) && !(surName.equals("")) ){
                    DBContext.getInstance(UpdateEmploye.this).updateById(name,surName,idmiz);
                    Util.showMessage(UpdateEmploye.this,"Guncellendi");
                }
                else{
                    Util.showMessage(UpdateEmploye.this,"Eksik Girdi");
                }
            }
        });

    }
}
