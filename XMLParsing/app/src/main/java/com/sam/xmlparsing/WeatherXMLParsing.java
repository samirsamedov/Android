package com.sam.xmlparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WeatherXMLParsing extends AppCompatActivity {
    EditText txt_city;
    EditText txt_state;
    TextView txt_results;
    Button btn_see_weather;
    static final String baseURL = "http://www.google.com/ig/api?weather=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_city = (EditText) findViewById(R.id.txt_city);
        txt_state = (EditText) findViewById(R.id.txt_state);
        txt_results = (TextView) findViewById(R.id.txt_results);
        btn_see_weather = (Button) findViewById(R.id.btn_see_weather);

        btn_see_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = txt_city.getText().toString().trim();
                String state = txt_state.getText().toString().trim();
                StringBuilder URL = new StringBuilder(baseURL);
                URL.append(city + "," + state);
                String fullURL = URL.toString();

                try {
                    URL website = new URL(fullURL);

                    SAXParserFactory saxParserFactory =  SAXParserFactory.newInstance();
                    SAXParser saxParser = saxParserFactory.newSAXParser();
                    XMLReader xmlReader = saxParser.getXMLReader();
                    HandlingXMLStuff doingWork = new HandlingXMLStuff();
                    xmlReader.setContentHandler(doingWork);
                    xmlReader.parse(new InputSource(website.openStream()));

                    String information = doingWork.getInformation();
                    txt_results.setText(information);

                } catch (Exception e) {
                    e.printStackTrace();
                    txt_results.setText("Error...");
                }
            }
        });
    }


}
