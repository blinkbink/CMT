/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class modelCustomer {
    private String namacustomer;
    private String alamat;
    private String penanggungjawab;
    private String telepon;
    private String fax;
    
    public modelCustomer(){
    
    }
    
    public modelCustomer(String namacustomer, String alamat, String penanggungjawab, String telepon, String fax){
        this.namacustomer = namacustomer;
        this.alamat = alamat;
        this.penanggungjawab = penanggungjawab;
        this.telepon = telepon;
        this.fax = fax;
    }

    public String getNamaCustomer() {
        return namacustomer;
    }

    public void setNamaCustomer (String namacustomer) {
        this.namacustomer = namacustomer;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPenanggungJawab() {
        return penanggungjawab;
    }

    public void setPenanggungJawab(String penanggungjawab) {
        this.penanggungjawab = penanggungjawab;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
    
    public String getFax(){
        return fax;
    }
    
    public void setFax(String fax){
        this.fax = fax;
    }
}
