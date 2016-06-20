package com.sam.jsonarray.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Samir on 20.6.2016.
 */
public class Person {

    @SerializedName("Name")
    public String name;
    @SerializedName("City")
    public String city;
    @SerializedName("Country")
    public String country;
}
