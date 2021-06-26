/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

import java.util.Random;
//Random sınıfı için gerekli kütüphaneyi import ettim.

public class BankaHesabi {

    private int iban;
    private double bakiye;

    //UML diyagramlarının gerektirdiği BankaHesabi constructorını ve toString metodunu oluşturdum
    @Override
    public String toString() {
        return super.toString()+ "BankaHesabi{" + "\t iban=" + iban + ",\t bakiye=" + bakiye + '}';
    }

    //private değişkenler için ilgili get ve set metotlarını tanımladım
    public double getIban() {
        return this.iban;
    }

    //iban değişkeni rastgele sayılar aldığı için setter metotunu tanımlamadım
    
    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    //Random sınıfından yeni integer nesnesi oluşturarak iban için rastgele tam sayılar ürettim
    public BankaHesabi(double bakiye) {
        this.bakiye = bakiye;
        Random random = new Random();
        this.iban = random.nextInt(100000) + 10000;
    
    }
}


