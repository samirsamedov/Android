package com.sam.xmlparsing;

/**
 * Created by Samir on 25.6.2016.
 */
public class XMLDataCollector {
    int temp = 0;
    String city = null;


    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String dataToString() {
        return "In " + city + " the Current Temperature is " + temp + " degree";
    }

}
