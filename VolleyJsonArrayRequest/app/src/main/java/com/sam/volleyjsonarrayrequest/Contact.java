package com.sam.volleyjsonarrayrequest;

/**
 * Created by Samir on 19.6.2016.
 */
public class Contact {

    private String name;
    private String city;
    private String country;

    public Contact(String name, String city, String country) {

        this.setName(name);
        this.setCity(city);
        this.setCountry(country);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
