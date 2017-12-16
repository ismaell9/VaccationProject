/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaffPersonGUI;

import Frames.Admin_DoctorsFrame;
import Frames.Admin_StoreKepperFrame;
import Frames.Admin_ReserveOfficerFrame;
import Frames.Panels.ChartPanel;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
  */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard() {
        setLocation(250, 10);
        setTitle("Admin Dashboard");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        jMenuItemEmail = new javax.swing.JMenuItem();
        menuReport = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();
        menuUsers = new javax.swing.JMenu();
        menuDoctors = new javax.swing.JMenuItem();
        menuStoreKeeper = new javax.swing.JMenuItem();
        menuReservOfficer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktop.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        menuFile.setText("File");

        jMenuItemEmail.setText("Email");
        jMenuItemEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEmailActionPerformed(evt);
            }
        });
        menuFile.add(jMenuItemEmail);

        menuReport.setText("Reports");
        menuReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReportActionPerformed(evt);
            }
        });
        menuFile.add(menuReport);

        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menuFile.add(menuExit);

        jMenuBar1.add(menuFile);

        menuUsers.setText("Users");

        menuDoctors.setText("Doctors");
        menuDoctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDoctorsActionPerformed(evt);
            }
        });
        menuUsers.add(menuDoctors);

        menuStoreKeeper.setText("StoreKeepers");
        menuStoreKeeper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuStoreKeeperActionPerformed(evt);
            }
        });
        menuUsers.add(menuStoreKeeper);

        menuReservOfficer.setText("ReservOfficer");
        menuReservOfficer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReservOfficerActionPerformed(evt);
            }
        });
        menuUsers.add(menuReservOfficer);

        jMenuBar1.add(menuUsers);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        // TODO add your handling code here:
        int c = JOptionPane.showConfirmDialog(null, "Are you Sure, System will Exit");
        if (c == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_menuExitActionPerformed

    private void menuDoctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDoctorsActionPerformed
        // TODO add your handling code here:
        Admin_DoctorsFrame f = new Admin_DoctorsFrame();
        desktop.add(f);   
         f.setVisible(true);
        
    }//GEN-LAST:event_menuDoctorsActionPerformed

    private void menuStoreKeeperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuStoreKeeperActionPerformed
        // TODO add your handling code here:
        Admin_StoreKepperFrame f = new Admin_StoreKepperFrame();
        desktop.add(f);        

        f.setVisible(true);
        
    }//GEN-LAST:event_menuStoreKeeperActionPerformed

    private void menuReservOfficerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReservOfficerActionPerformed
        // TODO add your handling code here:
        Admin_ReserveOfficerFrame f = new Admin_ReserveOfficerFrame();
         desktop.add(f);        
        f.setVisible(true);
       
    }//GEN-LAST:event_menuReservOfficerActionPerformed

    
    private void menuReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReportActionPerformed

            
       
    }//GEN-LAST:event_menuReportActionPerformed

    
    
    private void jMenuItemEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEmailActionPerformed
     
        
               
        
    }//GEN-LAST:event_jMenuItemEmailActionPerformed

   
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemEmail;
    private javax.swing.JMenuItem menuDoctors;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuReport;
    private javax.swing.JMenuItem menuReservOfficer;
    private javax.swing.JMenuItem menuStoreKeeper;
    private javax.swing.JMenu menuUsers;
    // End of variables declaration//GEN-END:variables
}
