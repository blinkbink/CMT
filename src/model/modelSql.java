/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author asass
 */
public class modelSql {
    private static Connection koneksi;
    
    public void cek(String status)
    {
        
    }
    public static Connection getKoneksi(){
        
        if (koneksi == null){
            
            try{
                String url = "jdbc:mysql://localhost:3306/cmt?useSSL=true";
                String user = "root";
                String pass = "0110";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                
                koneksi = DriverManager.getConnection(url, user, pass);
            }
            catch(SQLException x){
                System.err.println("Error Membuat Koneksi Database");
            }
        }
        
        return koneksi;
    }
    
}