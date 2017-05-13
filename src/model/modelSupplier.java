/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author asass
 */
public class modelSupplier {
    private String namaSupplier;
    private String Alamat;
    private String penanggungJawab;
    private String Kontak;
    
    public modelSupplier(){
    
    }
    
    public modelSupplier(String namaSupplier, String Alamat, String penanggungJawab, String Kontak){
        this.namaSupplier = namaSupplier;
        this.Alamat = Alamat;
        this.penanggungJawab = penanggungJawab;
        this.Kontak = Kontak;
    }

    public String getNamaSupplier() {
        return namaSupplier;
    }

    public void setNamaSupplier(String namaSupplier) {
        this.namaSupplier = namaSupplier;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getPenanggungJawab() {
        return penanggungJawab;
    }

    public void setPenanggungJawab(String penanggungJawab) {
        this.penanggungJawab = penanggungJawab;
    }

    public String getKontak() {
        return Kontak;
    }

    public void setKontak(String Kontak) {
        this.Kontak = Kontak;
    }
}
