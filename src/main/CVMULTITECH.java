/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import model.modelSql;
import view.mainFrame;
import view.Master.tambahsupplierDialog;
import view.Transaksi.tambahsuratjalanDialog;
import view.loginFrame;
import view.viewCustomerInsert;
import view.viewLogin;
import view.viewSupplierInsert;
import view.viewSupplier;
/**
 *
 * @author asass
 */
public class CVMULTITECH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ui();
        modelSql sql = new modelSql();

        loginFrame frame = new loginFrame();
        frame.setVisible(true);   
    }
    
    public static void ui()
    {
            try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to cross-platform
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                // not worth my time
            }
        }
}
    
}
