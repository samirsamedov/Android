package com.uygulama.haluk.gazeteapplication.model;

import android.graphics.Bitmap;

/**
 * Created by Samir on 30.4.2016.
 */
public class Haber
{

    private String etiket;
    private String aciklama;
    private String baglanti;
    private String kaynak;
    private String resimUrl;
    private Bitmap resim;

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }


    public String getKaynak() {
        return kaynak;
    }

    public void setKaynak(String kaynak) {
        this.kaynak = kaynak;
    }

    public String getBaglanti() {
        return baglanti;
    }

    public void setBaglanti(String baglanti) {
        this.baglanti = baglanti;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getEtiket() {
        return etiket;
    }

    public void setEtiket(String etiket) {
        this.etiket = etiket;
    }

    public Bitmap getResim() {
        return resim;
    }

    public void setResim(Bitmap resim) {
        this.resim = resim;
    }

    @Override
    public String toString() {
        return "Haber{" +
                "etiket='" + etiket + '\'' +
                ", aciklama='" + aciklama + '\'' +
                ", baglanti='" + baglanti + '\'' +
                ", kaynak='" + kaynak + '\'' +
                ", resimUrl='" + resimUrl + '\'' +
                ", resim=" + resim +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Haber haber = (Haber) o;

        if (kaynak != null ? !kaynak.equals(haber.kaynak) : haber.kaynak != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return kaynak != null ? kaynak.hashCode() : 0;
    }
}
