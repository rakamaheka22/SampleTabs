package com.example.rakamaheka.sampletabs.model;

/**
 * Created by RakaWorld on 18/11/2016.
 */

public class ListItem {

    String judul;
    String desc;
    int image;

    public ListItem(String judul, String desc, int image) {
        this.judul = judul;
        this.desc = desc;
        this.image = image;
    }

    public String getJudul() {
        return judul;
    }

    public String getDesc() {
        return desc;
    }

    public int getImage() {
        return image;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
