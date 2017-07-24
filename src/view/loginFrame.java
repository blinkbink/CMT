/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.modelSql;

/**
 *
 * @author ASUS
 */
public class loginFrame extends javax.swing.JFrame {

    /**
     * Creates new form viewLogin
     */
    public loginFrame() {
        initComponents();
        setTitle("Welcome");
        setLocationRelativeTo(this);
        setResizable(false);
        
        Connection koneksi=null;
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
                JOptionPane.showMessageDialog(null, "Koneksi Database Gagal, Periksa Koneksi atau database anda");
                System.exit(0);
            }
        }
        if (koneksi != null)
        {
            status.setText("Connected");
            status.setForeground(Color.green);
        }
        else    
        {
            status.setText("Disconnected");
            status.setForeground(Color.red);
        }
    }
    
    public void verify()
    {
        Statement Stm;
        ResultSet RsUser;
        
        try{
            String pass = password.getText();
            String user = username.getText();
            String admin = "admin";
            String karyawan = "karyawan";
            
            Stm = modelSql.getKoneksi().createStatement();
            RsUser = Stm.executeQuery("SELECT * FROM user WHERE  username = '"+user+"'"
                    +"AND password = '"+pass+"'"
                    +"AND role = '"+admin+"'");
            int baris = 0;
            while(RsUser.next()){
                baris = RsUser.getRow();
            }
            
            if(user.equals("") || pass.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Form Tidak Boleh Kosong");
            }
            else
            {
                if(baris == 1){
                    JOptionPane.showMessageDialog(null, "Selamat Datang, " +user);
                    this.dispose();
                    new mainFrame().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Username atau Password Yang Anda Masukan Salah !");
                }
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        status = new javax.swing.JLabel();
        panelLogin = new javax.swing.JPanel();
        username = new javax.swing.JTextField();
        labellupa = new javax.swing.JLabel();
        labelusername = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        labelpassword = new javax.swing.JLabel();
        login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Halaman Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        status.setText("Status");

        panelLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Login CMT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 36), new java.awt.Color(255, 0, 0))); // NOI18N

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        labellupa.setText("Lupa username/password?");

        labelusername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelusername.setText("Username");

        labelpassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelpassword.setText("Password");

        login.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelusername, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(labelpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(password)))
                    .addComponent(labellupa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelusername, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(username))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(password))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labellupa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(status))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(status)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        verify()
    }//GEN-LAST:event_loginActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labellupa;
    private javax.swing.JLabel labelpassword;
    private javax.swing.JLabel labelusername;
    private javax.swing.JButton login;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel status;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
