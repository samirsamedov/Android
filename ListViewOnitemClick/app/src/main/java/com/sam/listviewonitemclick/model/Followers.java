package com.sam.listviewonitemclick.model;

/**
 * Created by Samir on 20.7.2016.
 */
public class Followers {
    private int number;
    private String name;

    public Followers(int num, String nam) {
        number = num;
        name = nam;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
