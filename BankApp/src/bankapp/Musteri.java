/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//Tanımlanan ArrayList ve Random sınıfları için gerekli kütüphaneleri import ettim

//Musteri isimli yavru sınıfın, ata sınıf olan Kisi sınıfını miras aldığını extends ifadesi ile belirttim
public class Musteri extends Kisi {

    private ArrayList<KrediKarti> KrediKartlari = new ArrayList<>();
    private ArrayList<YatirimHesabi> yatirimHesaplari = new ArrayList<>();
    private ArrayList<VadesizHesap> VadesizHesaplar = new ArrayList<>();
    private ArrayList<BankaHesabi> hesaplar = new ArrayList<>();
    public ArrayList<Musteri> TumMusteriler = new ArrayList<>();
    private int musteriNumarasi;

//UML diyagramlarının istediği parametreli Musteri constructorını ve toString metodunu oluşturdum
    public Musteri(String ad, String soyad, String email, long telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        Random rand = new Random();
        this.musteriNumarasi = rand.nextInt(10000000)+1;    //1 ile 10000000 sayıları arasında rastgele sayıları musteriNumarasi değişkenine atadım
        TumMusteriler.add(this);    //oluşturulan musteriNumarasi değişkenlerini TumMusterileri barındıran array liste atadım
    }

    //private değişkenler için ilgili get ve set metotlarını tanımladım
    public int getMusteriNumarasi() {
        return this.musteriNumarasi;
    }

//KrediKartiEkle metoduyla gerekli parametrelerle birlikte KrediKartlari arraylistine yeni kredi kartı eklemesi yaptım ve ekrana sonucu yazdırdım
    public void KrediKartiEkle(double limit, double guncelBorc) {
        KrediKartlari.add(new KrediKarti(limit, guncelBorc));
        System.out.println("Kredi karti eklendi!");
    }

//KrediKartiSil metoduyla karttaki borca bağlı olarak KrediKartlari arraylistinden ilgili kartı kaldırdım ve duruma göre gerekli uyarıları ekrana yazdırdım
    public void KrediKartiSil(KrediKarti Kart) {
        if (Kart.getGuncelBorc() == 0.0) {
            KrediKartlari.remove(Kart);
            System.out.println("Kartınız Silindi");
        } else {
            System.out.println("Lütfen öncelikle borç ödemesi yapınız!");
        }
    }

    public List getKrediKartlari() {
        return this.KrediKartlari;
    }

    public ArrayList<BankaHesabi> getHesaplar() {
        return hesaplar;
    }

    //hesapEkle metoduyla hesap turune gore ilgili hesaba yeni hesap eklemesi yaptım ve ekrana sonucu yazdırdım
    public void hesapEkle(String hesapTuru, double bakiye) {
        if (hesapTuru.equals("vadesiz")) {
            VadesizHesap yeniVadesizHesap = new VadesizHesap(bakiye);
            this.hesaplar.add(yeniVadesizHesap);
            System.out.println("Vadesiz hesap eklendi!");
        } else if (hesapTuru.equals("yatirim")) {
            YatirimHesabi yeniYatirimHesabi = new YatirimHesabi(bakiye);
            this.hesaplar.add(yeniYatirimHesabi);
            System.out.println("Yatirim hesabi eklendi!");
        }

    }

    //hesapSil metoduyla hesaptaki bakiyeye bağlı olarak ilgili hesabı silme işlemi yaptım ve duruma göre gerekli uyarıları ekrana yazdırdım
    public void hesapSil(BankaHesabi Hesap) {
        if (Hesap.getBakiye() > 0) {
            System.out.println("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız");
        } else if (Hesap.getBakiye() < 0) {
            System.out.println("Lütfen öncelikle borç ödemesi yapınız!");
        } else {
            this.hesaplar.remove(Hesap);
            System.out.println("Hesabınız Silindi");
        }

    }

    //toString metodunda, super metoduyla birlikte Kisi sınıfının özelliklerini de geri döndürdüm
    @Override
    public String toString() {
        return (super.toString() + " \t Musteri{" + " \t Musteri Numarası: " + musteriNumarasi + '}');
    }
}


//UML diyagramlarının istediği KrediKarti sınıfını innerclass olarak oluşturdum ve sınıfın degiskenlerini tanımladım
class KrediKarti {

    private int kartNumarasi;
    private double limit;
    private double guncelBorc;
    private double kullanilabilirLimit;

    @Override
    public String toString() {
        return "KrediKarti{" + "\n Kart Numarasi=" + this.kartNumarasi + ", \n Limit=" + this.limit + ", \n Guncel Borc=" + this.guncelBorc + ", \n Kullanilabilir Limit=" + this.kullanilabilirLimit + '}';
    }

//UML diyagramlarının istediği parametreli KrediKarti constructorını ve toString metodunu oluşturdum    
    public KrediKarti(double limit, double guncelBorc) {

        this.limit = limit;
        this.guncelBorc = guncelBorc;
        this.kullanilabilirLimit = this.limit - this.guncelBorc;    //kullanilabilirLimit değişkenin gerekli şartlarını oluşturdum
        Random rand = new Random();
        this.kartNumarasi = rand.nextInt(10000000) + 10000000;  //rastgele sayıları kartNumarasi değişkenine atadım
    }

//private değişkenler için ilgili get ve set metotlarını tanımladım
    public double getKartNumarasi() {
        return this.kartNumarasi;
    }

    public double getLimit() {
        return this.limit;
    }

    public void setLimit(double yeniLimit) {
        this.limit = yeniLimit;
    }

    public double getGuncelBorc() {
        return this.guncelBorc;
    }

    public void setGuncelBorc(double sonGuncelBorc) {
        this.guncelBorc = sonGuncelBorc;
    }

    public double getKullanilabilirLimit() {
        return this.kullanilabilirLimit;
    }

    public void setKullanilabilirLimit(double yeniKullanilabilirLimit) {
        this.kullanilabilirLimit = yeniKullanilabilirLimit;
    }

}
