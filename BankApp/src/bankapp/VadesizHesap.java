/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

import bankapp.BankaHesabi;
import bankapp.KrediKarti;

//VadesizHesap isimli yavru sınıfın, ata sınıf olan BankaHesabi sınıfını miras aldığını extends ifadesi ile belirttim
public class VadesizHesap extends BankaHesabi {

//UML diyagramlarının istediği parametreli VadesizHesap constructorını ve toString metodunu oluşturdum
    public VadesizHesap(double bakiye) {
        super(bakiye);      //super metoduyla ata sınıftan ortak özellikleri getirdim
    }

    private String hesapTuru;

    public VadesizHesap(double bakiye, String hesapTuru) {
        super(bakiye);
        this.hesapTuru = "vadesiz";     //hesapTuru değişkeninin bu sınıfın özelliği olarak vadesiz şeklinde atadım
    }

    //private değişkenler için ilgili get ve set metotlarını tanımladım
    public String getHesapTuru() {
        return this.hesapTuru;
    }

//ParaTransferi metoduyla alıcı hesap, gonderen hesap ve miktar bilgileri parametreleri ile bakiyeye bağlı olarak transfer işlemini gerçekleştirdim ve sonucu ekrana bildirdim
    public void ParaTransferi(double tranferEdilecekTutar, BankaHesabi alici, BankaHesabi gonderen) {
        if (tranferEdilecekTutar > getBakiye()) {
            System.out.println("Hesabınızda istenilen bakiye bulunamamaktadır!");
        } else {
        gonderen.setBakiye(gonderen.getBakiye()-tranferEdilecekTutar);
        alici.setBakiye(alici.getBakiye()+tranferEdilecekTutar);
        System.out.println("Para transferi başarılı!");
        System.out.println("Gonderen güncel bakiye: "+gonderen.getBakiye() + "\n Alıcı güncel bakiye: "+alici.getBakiye());
        }
    }

//KrediKartiBorcOdeme metoduyla odenecekTutara bağlı olarak borç ödeme işlemini gerçekleştirdim ve sonucu ekrana bildirdim
    public void KrediKartiBorcOdeme(double odenecekTutar, KrediKarti krediKarti,BankaHesabi hesap) {
        krediKarti.setGuncelBorc(krediKarti.getGuncelBorc()-odenecekTutar);
        hesap.setBakiye(hesap.getBakiye() - odenecekTutar);
        System.out.println("Kredi kartı borc odemesi basarili!");
        System.out.println("Guncel Borc: "+krediKarti.getGuncelBorc() + "\n Guncel Bakiye:"+hesap.getBakiye());

    }
    
    @Override
    public String toString() {
        return (super.toString()+ "\n VadesizHesap{" +"\n Hesap Türü: "+this.hesapTuru + '}');
    }

}