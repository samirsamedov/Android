package com.dogalterapi.model;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Samir on 18.5.2016.
 */
public class User {
    //private UUID id;
    private long id;
    private String ad;
    private String soyad;
    private String cinsiyet;
    private String telefon_no;
    private String yas;
    private String kilo;
    private String eposta;
    private String adres;
    private String date;
    private String lenf;

    private int countDB;

    public User() {
        countDB =0;
        long range = 1234567L;
        Random r = new Random();
        id = (long)(r.nextDouble()*range);
    }

    public int getCountDB() {
        return countDB;
    }

    public void setCountDB(int countDB) {
        this.countDB = countDB;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getTelefon_no() {
        return telefon_no;
    }

    public void setTelefon_no(String telefon_no) {
        this.telefon_no = telefon_no;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String getKilo() {
        return kilo;
    }

    public void setKilo(String kilo) {
        this.kilo = kilo;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLenf() {
        return lenf;
    }

    public void setLenf(String lenf) {
        this.lenf = lenf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return id == user.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", cinsiyet='" + cinsiyet + '\'' +
                ", telefon_no='" + telefon_no + '\'' +
                ", yas='" + yas + '\'' +
                ", kilo='" + kilo + '\'' +
                ", eposta='" + eposta + '\'' +
                ", adres='" + adres + '\'' +
                ", date='" + date + '\'' +
                ", lenf='" + lenf + '\'' +
                '}';
    }
}
