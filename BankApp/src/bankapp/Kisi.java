/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

public class Kisi {

//UML diyagramlarının istediği değişkenleri tanımladım, uzun olursa diye telefon numarasını long veri tipinde tanımladım.
private String ad, soyad, email;
private long telefonNumarasi;   

//UML diyagramlarının istediği parametreli Kisi constructorını ve toString metodunu oluşturdum
    public Kisi(String ad, String soyad, String email, long telefonNumarasi) {
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.telefonNumarasi = telefonNumarasi;
    }

    //private değişkenler için ilgili get ve set metotlarını tanımladım
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public void setTelefonNumarasi(long telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }

    @Override
    public String toString() {
        return "Kisi{" + "\n Ad=" + this.ad + ", \n Soyad=" + this.soyad + ", \n Email=" + this.email + ", \n Telefon Numarası=" + this.telefonNumarasi + '}';
    }

}
