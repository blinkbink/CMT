/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import interfce.interfaceSupplier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.modelSupplier;
import model.modelSql;

/**
 *
 * @author asass
 */
public class controllerSupplier implements interfaceSupplier {

    public static void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void insert(String varnama, String varalamat, String varpenanggungjawab, String varkontak)
    {
            try
            {
                PreparedStatement st;

                st = modelSql.getKoneksi().prepareStatement("INSERT INTO supplier(NamaSupplier, Alamat, PenanggungJawab, Kontak) VALUES('"+varnama+"', '"+varalamat+"', '"+varpenanggungjawab+"', '"+varkontak+"')");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukan");
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
    }
    
    public void update()
    {
        
    }
    
    public static void delete(int id)
    {
        try
            {
                PreparedStatement st;

                st = modelSql.getKoneksi().prepareStatement("DELETE FROM supplier WHERE IDSupplier = '"+id+"'");
                st.executeUpdate();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
    }
    
    public List<modelSupplier> getAll() throws SQLException {
        Statement st;
        st = modelSql.getKoneksi().createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM supplier");
        List<modelSupplier> list = new ArrayList<modelSupplier>();
        while(rs.next())
        {
            modelSupplier supp = new modelSupplier();
            supp.setNamaSupplier(rs.getString("NamaSupplier"));
            supp.setAlamat(rs.getString("Alamat"));
            supp.setPenanggungJawab(rs.getString("PenanggungJawab"));
            supp.setKontak(rs.getString("Kontak"));
            list.add(supp);
        }
        return list;
    }
    
    
}
