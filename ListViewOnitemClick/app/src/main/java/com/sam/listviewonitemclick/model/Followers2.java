package com.sam.listviewonitemclick.model;

/**
 * Created by Samir on 20.7.2016.
 */
public class Followers2 {
    private int id;
    private String name;
    private String score;
    private boolean follow;


    public Followers2(String name, String score, boolean follow) {
        this.name = name;
        this.score = score;
        this.follow = follow;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public boolean isFollow() {
        return follow;
    }

    public void setFollow(boolean follow) {
        this.follow = follow;
    }
}
