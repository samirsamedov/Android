package com.sqllitelife.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sqllitelife.R;
import com.sqllitelife.model.entity.Calisan;
import com.sqllitelife.model.dbUtil.DBContext;
import com.sqllitelife.util.Util;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_insert;
    private Button btn_delete;
    private Button btn_update;
    private Button btn_getall;
    private Button btn_find_by_id;
    private Button btn_update_new_activity;

    private EditText txt_first_name;
    private EditText txt_last_name;
    private EditText txt_find_by_id;

    public static final String DELIMETER = ";";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        setEvents();


    }


    private void initializeComponents() {
        txt_find_by_id = (EditText) findViewById(R.id.txt_find_by_id);
        txt_first_name = (EditText) findViewById(R.id.txt_ad);
        txt_last_name = (EditText) findViewById(R.id.txt_soyisim);

        btn_insert = (Button) findViewById(R.id.btn_insert);
        btn_getall = (Button) findViewById(R.id.btn_getall);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_find_by_id = (Button) findViewById(R.id.btn_find_by_id);
        btn_update_new_activity = (Button) findViewById(R.id.btn_update_new_activity);
    }

    private void setEvents() {
        btn_update_new_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UpdateEmploye.class);
                startActivity(intent);
                SharedPreferences shp = getSharedPreferences("pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = shp.edit();
                editor.putString("ismiz", txt_find_by_id.getText().toString());

                editor.commit();

            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txt_find_by_id.getText().toString();
                String ad = txt_first_name.getText().toString();
                String soyad = txt_last_name.getText().toString();

                if ((id != null) && (ad != null) && (soyad != null)) {
                    int guncellenen = DBContext.getInstance(MainActivity.this).updateById(ad, soyad, id);

                    String inputValue = txt_first_name.getText().toString();
                    //String oldName = inputValue.substring(0, inputValue.indexOf(DELIMETER));
                    //String newName = inputValue.substring(inputValue.indexOf(DELIMETER + 1));
                    //DBContext.getInstance(MainActivity.this).updateEmployee(oldName, newName);
                    Util.showMessage(MainActivity.this, guncellenen == 0 ? " Guncellenemedi" : id + " nolu Calısan Guncellendi");
                } else {
                    Util.showMessage(MainActivity.this, "Eksik Bilgi Girildi Güncellenemedi");
                }
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txt_find_by_id.getText().toString();
                int silinen = DBContext.getInstance(MainActivity.this).deleteById(id);
                Util.showMessage(MainActivity.this, silinen == 0 ? "Calisan Silinemedi" : id + " nolu Calısan Silindi");

            }
        });
        btn_find_by_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = Long.valueOf(txt_find_by_id.getText().toString());
                Calisan calisan = DBContext.getInstance(MainActivity.this).findById(id);
                Util.showMessage(MainActivity.this, calisan == null ? "ID Bulunamadı" : calisan.toString());
            }
        });
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calisan calisan = new Calisan();
                calisan.setAd(txt_first_name.getText().toString());
                calisan.setSoyad(txt_last_name.getText().toString());

                boolean result = DBContext.getInstance(MainActivity.this).insertEmpolyee(calisan);
                Util.showMessage(MainActivity.this, result ? "Calısan Eklendi" : " Calısan Eklenemedi");
            }
        });

        btn_getall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //boolean result = DBContext.getInstance(MainActivity.this).getAll();
                //Util.showMessage(MainActivity.this, result ? "Calısan Eklendi" : " Calısan Eklenemedi");
                List<Calisan> calisanListesi = DBContext.getInstance(MainActivity.this).getAllEmployees();
                Util.showMessage(MainActivity.this, "Kayıt Sayısı : " + calisanListesi.size());
                for (Calisan calisan : calisanListesi) {
                    // Util.showMessage(MainActivity.this, calisan.toString());
                }
            }
        });

    }
}
