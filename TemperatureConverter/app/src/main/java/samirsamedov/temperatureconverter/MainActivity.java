package samirsamedov.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerFrom;
    Spinner spinnerTo;
    ArrayAdapter<CharSequence> adapter;
    Button btn_convert;
    EditText edtInput;
    TextView txtConvertResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        adapter = ArrayAdapter.createFromResource(this, R.array.types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerFrom.setAdapter(adapter);

        spinnerTo = (Spinner) findViewById(R.id.spinnerTo);
        spinnerTo.setAdapter(adapter);


        btn_convert = (Button) findViewById(R.id.btn_convert); // convert et onay butonu

        txtConvertResult = (TextView) findViewById(R.id.txtConvertResult);
        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String girilenDereceTipi = spinnerFrom.getSelectedItem().toString();// girilenDereceTipi Derece Ölçü birimi
                String donusturulmekIstDereceTipi = spinnerTo.getSelectedItem().toString();// dönüştürülmek istenenDerece ölçü birimi

                edtInput = (EditText) findViewById(R.id.edtInput); // girilenDereceTipi rakamsal derece

                double txtConvertResulta_yazilacak = 0;
                try {
                    double    girilenDerece = Double.valueOf(edtInput.getText().toString()); // edittexten double değer alma
                    if (girilenDereceTipi == null && donusturulmekIstDereceTipi == null && edtInput == null) {
                        //Log.d("Lütfen boş değer girmeyiniz ", spinnerTo.getSelectedItem().toString());
                        Toast.makeText(getApplicationContext(),"Bos Deger Gırdınız",Toast.LENGTH_SHORT).show();

                    } else {
                        if (girilenDereceTipi.equals("Santigrat")) {
                            txtConvertResulta_yazilacak = fromSantigrat(girilenDerece, donusturulmekIstDereceTipi);
                        } else if (girilenDereceTipi.equals("Fahrenhayt")) {
                            txtConvertResulta_yazilacak = fromFahrenhayt(girilenDerece, donusturulmekIstDereceTipi);
                        } else if (girilenDereceTipi.equals("Reomür")) {
                            txtConvertResulta_yazilacak = fromReomur(girilenDerece, donusturulmekIstDereceTipi);
                        } else if (girilenDereceTipi.equals("Kelvin")) {
                            txtConvertResulta_yazilacak = fromKelvin(girilenDerece, donusturulmekIstDereceTipi);
                        }
                        //Math.round(sonuc * 100.0) / 100.0;
                        txtConvertResult.setText("   " + Math.round(txtConvertResulta_yazilacak * 100.0) / 100.0);

                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Bos Deger Gırdınız",Toast.LENGTH_SHORT).show();
                    Log.d("Hatamiz .................", e.getMessage());
                }


            }
        });


    }
    /*
    * Santigrat
    * Fahrenhayt
    * Reomür
    * Kelvin*/

    public double fromSantigrat(double derece, String toDeger) {// toDeger  Dönüştürülmek istenen Derece Tipiniidir
        double sonuc = 0;
        if (toDeger.equals("Fahrenhayt")) {
            //T(°F) = T(°C) × 9/5 + 32
            sonuc = derece * 1.8 + 32;
        } else if (toDeger.equals("Reomür")) {
            // Re =  C × 0.8
            sonuc = derece * 0.8;
        } else if (toDeger.equals("Kelvin")) {
            //K = C  + 273.15
            sonuc = derece + 273.15;
        }
        else if (toDeger.equals("Santigrat")) {
            //K = C  + 273.15
            sonuc = derece;
        }
        return sonuc;
    }

    public double fromFahrenhayt(double derece, String toDeger) {// toDeger  Dönüştürülmek istenen Derece Tipiniidir
        double sonuc = 0;
        if (toDeger.equals("Santigrat")) {
            //C = ( F - 32) / 1.8
            sonuc = (derece - 32) / 1.8;
        } else if (toDeger.equals("Reomür")) {
            // Re = ( F - 32) / 2.25
            sonuc = (derece - 32) * 2.25;
        } else if (toDeger.equals("Kelvin")) {
            //K = ( F + 459.67) / 1.8
            sonuc = (derece + 459.67) / 1.8;
        }
        else if (toDeger.equals("Fahrenhayt")) {
            //K = C  + 273.15
            sonuc = derece;
        }
        return sonuc;
    }

    public double fromReomur(double derece, String toDeger) {// toDeger  Dönüştürülmek istenen Derece Tipiniidir
        double sonuc = 0;
        if (toDeger.equals("Santigrat")) {
            //C =  Re × 1.25
            sonuc = derece * 1.25;
        } else if (toDeger.equals("Fahrenhayt")) {
            //  F =  Re × 2.25 + 32
            sonuc = (derece * 2.25) + 32;
        } else if (toDeger.equals("Reomür")) {
            //K =  Re × 1.25 + 273.15
            sonuc = derece * 1.25 + 273.15;
        }
        else if (toDeger.equals("Reomür")) {
            //K = C  + 273.15
            sonuc = derece;
        }

        return sonuc;
    }

    public double fromKelvin(double derece, String toDeger) {// toDeger  Dönüştürülmek istenen Derece Tipiniidir
        double sonuc = 0;
        if (toDeger.equals("Santigrat")) {
            //C = K - 273.15
            sonuc = derece - 273.15;
        } else if (toDeger.equals("Fahrenhayt")) {
            //  F = K × 1.8 - 459.67
            sonuc = (derece * 1.18) - 459.67;
        } else if (toDeger.equals("Reomür")) {
            //R = (K - 273.15) × 0.8
            sonuc = (derece - 273.15) * 0.8;
        }
        else if (toDeger.equals("Kelvin")) {
            //K = C  + 273.15
            sonuc = derece;
        }
        return sonuc;
    }
}
