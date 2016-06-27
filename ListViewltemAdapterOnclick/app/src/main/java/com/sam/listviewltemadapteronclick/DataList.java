package com.sam.listviewltemadapteronclick;

/**
 * Created by Samir on 27.6.2016.
 * This calss will provide usdata to play in Listview
 * ONE
 */
public class DataList {
    private String desc;
    private String title;
    private int imgResId;


    public DataList(String desc, String title, int imgResId) {
        this.desc = desc;
        this.title = title;
        this.imgResId = imgResId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }
}
