package com.dogalterapi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;


import com.dogalterapi.R;
import com.dogalterapi.model.User;
import com.dogalterapi.util.DBContext;
import com.dogalterapi.util.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewRecordActivity extends AppCompatActivity {

    EditText txt_singup_name;
    EditText txt_singup_surname;
    EditText txt_sinup_phone;
    EditText txt_singup_yas;
    EditText txt_singup_kilo;
    EditText txt_singup_email;
    EditText txt_singup_adress;

    CheckBox chk_singup_female;
    CheckBox chk_singup_male;
    CheckBox chk_singup_hacamat;
    CheckBox chk_singup_leech_therapy;
    CheckBox chk_singup_lefro_therapy;

    String cinsiyet = "";

    Button btn_singup_save;
    Button btn_singup_temizle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kullanici_bilgi_girisi);

        initializeComponents();


        //******************************* MACTION METHODS ***************************
        btn_singup_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFieldEmpty(txt_singup_name, txt_singup_surname, txt_sinup_phone, txt_singup_yas, txt_singup_kilo, txt_singup_email, txt_singup_adress, chk_singup_female, chk_singup_male, chk_singup_hacamat, chk_singup_leech_therapy, chk_singup_lefro_therapy);
                try {
                    boolean bosmu = false;// alanlar bosmu kontrol etmek için
                    boolean inserOldumu = false;
                    Thread.sleep(1000);
                    // alanlardan herhangi biri boşsa boolean true doner
                    bosmu = isFieldEmpty(txt_singup_name, txt_singup_surname, txt_sinup_phone, txt_singup_yas, txt_singup_kilo, txt_singup_email, txt_singup_adress, chk_singup_female, chk_singup_male, chk_singup_hacamat, chk_singup_leech_therapy, chk_singup_lefro_therapy);

                    //isFieldisNotEmpty(txt_singup_name, txt_singup_surname, txt_sinup_phone, txt_singup_yas, txt_singup_kilo, txt_singup_email, txt_singup_adress, chk_singup_female, chk_singup_male, chk_singup_hacamat, chk_singup_leech_therapy, chk_singup_lefro_therapy);

                    if (chk_singup_female.isChecked()) {
                        cinsiyet = "K";
                    }
                    if (chk_singup_male.isChecked()) {
                        cinsiyet = "E";
                    }
                    User user = new User();
                    user.setAd(txt_singup_name.getText().toString());
                    user.setSoyad(txt_singup_surname.getText().toString());
                    user.setCinsiyet(cinsiyet);
                    user.setTelefon_no(txt_sinup_phone.getText().toString());
                    user.setYas(txt_singup_yas.getText().toString());
                    user.setKilo(txt_singup_kilo.getText().toString());
                    user.setEposta(txt_singup_email.getText().toString());
                    user.setAdres(txt_singup_adress.getText().toString());

                    if (!bosmu) {
                        // alanlar boş degilse insert işlemine izin verir ve işlem sorunsuz gerçekleşirse "inserOldumu" true doner
                        inserOldumu = DBContext.getInstance(NewRecordActivity.this).insertUser(user);
                        DBContext.getInstance(NewRecordActivity.this).closeDB();

                    }

                    if (!bosmu && inserOldumu) {
                        Util.showMessage(NewRecordActivity.this, "Kayıt Başarılı");
                        Intent intentToMain = new Intent(NewRecordActivity.this, MainActivity.class);
                        intentToMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intentToMain);

                    } else {
                        Util.showMessage(NewRecordActivity.this, getResources().getString(R.string.empty_message));
                        //Util.showMessage(NewRecordActivity.this, "Kayıt Başarısız");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // TEMIZLEBUTONU
        btn_singup_temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alanlarıBosalt();// alanları eski haline getirir bos ve uyarı stili olmayan
            }
        });
        // FEMALE CHECKBOX
        chk_singup_female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    chk_singup_female.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
                    chk_singup_male.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
                    chk_singup_male.setEnabled(false);
                } else {
                    chk_singup_female.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
                    chk_singup_male.setEnabled(true);
                }
            }
        });

        chk_singup_male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    chk_singup_female.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
                    chk_singup_male.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
                    chk_singup_female.setEnabled(false);
                } else {
                    chk_singup_male.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
                    chk_singup_female.setEnabled(true);
                }
            }
        });

        chk_singup_hacamat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    chk_singup_hacamat.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
                    chk_singup_leech_therapy.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
                    chk_singup_lefro_therapy.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
                }
            }
        });

        chk_singup_leech_therapy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    chk_singup_hacamat.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
                    chk_singup_leech_therapy.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
                    chk_singup_lefro_therapy.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
                }
            }
        });

        chk_singup_lefro_therapy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    chk_singup_hacamat.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
                    chk_singup_leech_therapy.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
                    chk_singup_lefro_therapy.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
                }
            }
        });

    }

    private void alanlarıBosalt() {
        txt_singup_name.setText(null);
        txt_singup_name.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
        txt_singup_surname.setText(null);
        txt_singup_surname.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
        txt_singup_adress.setText(null);
        txt_singup_adress.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
        txt_sinup_phone.setText(null);
        txt_sinup_phone.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
        txt_singup_yas.setText(null);
        txt_singup_yas.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
        txt_singup_kilo.setText(null);
        txt_singup_kilo.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
        txt_singup_email.setText(null);
        txt_singup_email.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
        chk_singup_male.setChecked(false);
        chk_singup_female.setChecked(false);
        chk_singup_hacamat.setChecked(false);
        chk_singup_leech_therapy.setChecked(false);
        chk_singup_lefro_therapy.setChecked(false);
    }

    //************************************ METHODS *****************************
    public boolean isFieldEmpty(EditText name, EditText surname, EditText phone, EditText yas, EditText kilo, EditText email, EditText adres, CheckBox female, CheckBox male, CheckBox hacamat, CheckBox leech_therapy, CheckBox refro_therapy) {
        boolean onay = false;
        if (TextUtils.isEmpty(name.getText().toString())) {
            name.setError(getString(R.string.singup_empty_field_message));
            onay = true;
        }
        if (TextUtils.isEmpty(surname.getText().toString())) {
            surname.setError(getString(R.string.singup_empty_field_message));
            onay = true;
        }
        if (TextUtils.isEmpty(phone.getText().toString())) {
            phone.setError(getString(R.string.singup_empty_field_message));
            onay = true;
        }
        if (TextUtils.isEmpty(yas.getText().toString())) {
            yas.setError(getString(R.string.singup_empty_field_message));
            onay = true;
        }
        if (TextUtils.isEmpty(kilo.getText().toString())) {
            kilo.setError(getString(R.string.singup_empty_field_message));
            onay = true;
        }
        if (TextUtils.isEmpty(email.getText().toString())) {
            email.setError(getString(R.string.singup_empty_field_message));
            onay = true;
        }
        if (TextUtils.isEmpty(adres.getText().toString())) {
            adres.setError(getString(R.string.singup_empty_field_message));
            onay = true;
        }
        if (!(female.isChecked() || male.isChecked())) {
            female.setBackground(getResources().getDrawable(R.drawable.ios_textview_alrt));
            male.setBackground(getResources().getDrawable(R.drawable.ios_textview_alrt));
            onay = true;
        }
        if (!(hacamat.isChecked() || leech_therapy.isChecked() || refro_therapy.isChecked())) {
            hacamat.setBackground(getResources().getDrawable(R.drawable.ios_textview_alrt));
            leech_therapy.setBackground(getResources().getDrawable(R.drawable.ios_textview_alrt));
            refro_therapy.setBackground(getResources().getDrawable(R.drawable.ios_textview_alrt));
            onay = true;
        }
        if (!onay) {
            //Util.showMessage(NewRecordActivity.this, getResources().getString(R.string.empty_message));
        }
        return onay;
    }

    public boolean isFieldisNotEmpty(EditText name, EditText surname, EditText phone, EditText yas, EditText kilo, EditText email, EditText adres, CheckBox female, CheckBox male, CheckBox hacamat, CheckBox leech_therapy, CheckBox refro_therapy) {
        boolean onay = false;
        if (!TextUtils.isEmpty(name.getText().toString())) {
            name.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
            onay = true;
        }
        if (!TextUtils.isEmpty(surname.getText().toString())) {
            surname.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
            onay = true;
        }
        if (!TextUtils.isEmpty(phone.getText().toString())) {
            phone.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
            onay = true;
        }
        if (!TextUtils.isEmpty(yas.getText().toString())) {
            yas.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
            onay = true;
        }
        if (!TextUtils.isEmpty(kilo.getText().toString())) {
            kilo.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
            onay = true;
        }
        if (!TextUtils.isEmpty(email.getText().toString())) {
            email.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
            onay = true;
        }
        if (!TextUtils.isEmpty(adres.getText().toString())) {
            adres.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
            onay = true;
        }
        if ((female.isChecked() || male.isChecked())) {
            female.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
            male.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
            onay = true;
        }
        if ((hacamat.isChecked() || leech_therapy.isChecked() || refro_therapy.isChecked())) {
            hacamat.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
            leech_therapy.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
            refro_therapy.setBackground(getResources().getDrawable(R.drawable.ios_textview_style));
            onay = true;

        }
        if (!onay) {
            Util.showMessage(NewRecordActivity.this, getResources().getString(R.string.empty_message));
        }
        return onay;//
    }


    // Email Validation Method
    public boolean validateEmail(String email) {
        String emailPattrent = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+";
        Pattern pattern = Pattern.compile(emailPattrent);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void initializeComponents() {
        txt_singup_name = (EditText) findViewById(R.id.txt_singup_name);
        txt_singup_surname = (EditText) findViewById(R.id.txt_singup_surname);
        txt_sinup_phone = (EditText) findViewById(R.id.txt_sinup_phone);
        txt_singup_yas = (EditText) findViewById(R.id.txt_singup_yas);
        txt_singup_kilo = (EditText) findViewById(R.id.txt_singup_kilo);
        txt_singup_email = (EditText) findViewById(R.id.txt_singup_email);
        txt_singup_adress = (EditText) findViewById(R.id.txt_singup_adress);
        chk_singup_female = (CheckBox) findViewById(R.id.chk_singup_female);
        chk_singup_male = (CheckBox) findViewById(R.id.chk_singup_male);
        chk_singup_hacamat = (CheckBox) findViewById(R.id.chk_singup_hacamat);
        chk_singup_leech_therapy = (CheckBox) findViewById(R.id.chk_singup_leech_therapy);
        chk_singup_lefro_therapy = (CheckBox) findViewById(R.id.chk_singup_lefro_therapy);
        btn_singup_save = (Button) findViewById(R.id.btn_singup_save);
        btn_singup_temizle = (Button) findViewById(R.id.btn_singup_temizle);
    }
}
