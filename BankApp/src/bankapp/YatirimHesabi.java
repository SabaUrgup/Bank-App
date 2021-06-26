/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

//YatirimHesabi isimli yavru sınıfın, ata sınıf olan BankaHesabi sınıfını miras aldığını extends ifadesi ile belirttim
public class YatirimHesabi extends BankaHesabi {

    private String hesapTuru;

//UML diyagramlarının istediği parametreli YatirimHesabi constructorını ve toString metodunu oluşturdum
    public YatirimHesabi(double bakiye, String hesapTuru) {
        super(bakiye);
        this.hesapTuru = "yatirim";     //hesapTuru değişkeninin bu sınıfın özelliği olarak yatirim şeklinde atadım
    }

    YatirimHesabi(double bakiye) {
        super(bakiye);
    }
    
    //private değişkenler için ilgili get ve set metotlarını tanımladım
    public String getHesapTuru() {
        return this.hesapTuru;
    }

    @Override
    public String toString() {
        return super.toString()+ "YatirimHesabi{" + "hesapTuru=" + this.hesapTuru + '}';
    }

//paraEkle metoduyla tutar'a bağlı olarak bakiyeyi güncelledim ve sonucu ekrana bildirdim    
    public void paraEkle(double tutar, YatirimHesabi hesap) {
         super.setBakiye(tutar +  super.getBakiye());
         System.out.println("Girilen tutar bakiyenize eklenmiştir.");
         System.out.println("Güncel Bakiye: "+hesap.getBakiye());
    }

//paraCek metoduyla tutar2'ye bağlı olarak bakiyeyi güncelledim ve sonucu ekrana bildirdim 
    public void paraCek(double tutar2, YatirimHesabi hesap) {

        if (tutar2 <= getBakiye()) {
             super.setBakiye( super.getBakiye() - tutar2);
             System.out.println("İstenilen tutar bakiyenizden çekilmiştir. \n Güncel Bakiye: "+hesap.getBakiye());
        } else {
            System.out.println("İstenilen tutar bakiyenizde bulunamamaktadır.");
            System.out.println("Güncel Bakiye: "+hesap.getBakiye());
        }
    }

}
