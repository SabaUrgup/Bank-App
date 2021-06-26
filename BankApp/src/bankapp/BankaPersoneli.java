/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

import java.util.ArrayList;
import java.util.Random;
//Tanımlanan ArrayList ve Random sınıfları için gerekli kütüphaneleri import ettim

//BankaPersoneli isimli yavru sınıfın, ata sınıf olan Kisi sınıfını miras aldığını extends ifadesi ile belirttim
public class BankaPersoneli extends Kisi{

    //personalID değişkeni uzun olursa diye long veri tipinde tanımladım
    private long personalID;
    private  ArrayList<Musteri> Musteriler= new ArrayList<Musteri>();; 
    //ArrayList içerisinde ilgili müşteri nesnelerini saklatayack listeyi kurdum
    
    //UML diyagramlarının istediği parametreli BankaHesabi constructorını ve toString metodunu oluşturdum
    public BankaPersoneli(String ad, String soyad, String email, long telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        Random rand= new Random();
        this.personalID=rand.nextInt(100000)+100;
    }
    
    //private değişkenler için ilgili get ve set metotlarını tanımladım
    public void setMusteriler(ArrayList<Musteri> Musteriler) {
        this.Musteriler = Musteriler;
    }
    
    public ArrayList<Musteri> getMusteriler()
    {
        return Musteriler;
    }
    
    //Musteriler sınıfına musteri ekleyen ve silen ilgili metotları olusturdum ve konsola sonucu yazdırdım
    public void musteriEkle(Musteri musteriNumarasi){
        Musteriler.add(musteriNumarasi);
        System.out.println("Musteri eklendi!");
    }
    public void musteriSil(Musteri musteriNumarasi){
        Musteriler.remove(musteriNumarasi);
        System.out.println("Musteri silindi!");
    }
    
    public long getPersonelID(){
        return personalID;
    }

    @Override
    public String toString() {
        return "BankaPersoneli{" + "\n personalID=" + personalID +"\nMusteriler: "+this.getMusteriler()+ '}';
    }

}
