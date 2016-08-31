package com.sam.bundleobjectpass;

import java.io.Serializable;

/**
 * Created by Samir on 31.8.2016.
 */
public class Model implements Serializable {
    private String name;
    private String surName;
    private int age;

    public Model(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
