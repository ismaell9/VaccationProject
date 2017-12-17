package Frames;

import Frames.Panels.StoreKeeper_EditVaccinePanel;
import Frames.Panels.StoreKeeper_ListVaccinePanel;
import Frames.Panels.StoreKeeper_addVaccinePanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class StoreFrame extends javax.swing.JInternalFrame {

    GridBagLayout layout = new GridBagLayout();
    StoreKeeper_addVaccinePanel P1;
    StoreKeeper_EditVaccinePanel P2;
 //   StoreKeeper_ListVaccinePanel P3;

    public StoreFrame() {

        initComponents();
        P1 = new StoreKeeper_addVaccinePanel();
        P2 = new StoreKeeper_EditVaccinePanel();
      //  P3 = new StoreKeeper_ListVaccinePanel();

        DynamicPanel.setLayout(layout);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        DynamicPanel.add(P1, c);
        DynamicPanel.add(P2, c);
        //DynamicPanel.add(P3, c);

        P1.setVisible(false);
        P2.setVisible(false);
        //P3.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1_add_vaccine = new javax.swing.JButton();
        jButton7_edit_vaccine = new javax.swing.JButton();
        jButton5_listVaccine = new javax.swing.JButton();
        DynamicPanel = new javax.swing.JPanel();

        setClosable(true);

        jButton1_add_vaccine.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1_add_vaccine.setText("Add Vaccine");
        jButton1_add_vaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_add_vaccineActionPerformed(evt);
            }
        });

        jButton7_edit_vaccine.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton7_edit_vaccine.setText("Edit/Delete Vaccine");
        jButton7_edit_vaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7_edit_vaccineActionPerformed(evt);
            }
        });

        jButton5_listVaccine.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton5_listVaccine.setText("List Vaccine");
        jButton5_listVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5_listVaccineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7_edit_vaccine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1_add_vaccine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5_listVaccine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButton1_add_vaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(jButton7_edit_vaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(jButton5_listVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout DynamicPanelLayout = new javax.swing.GroupLayout(DynamicPanel);
        DynamicPanel.setLayout(DynamicPanelLayout);
        DynamicPanelLayout.setHorizontalGroup(
            DynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );
        DynamicPanelLayout.setVerticalGroup(
            DynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );

        getContentPane().add(DynamicPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1_add_vaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_add_vaccineActionPerformed
        // TODO add your handling code here:
        P1.setVisible(true);
        P2.setVisible(false);
     //   P3.setVisible(false);
    }//GEN-LAST:event_jButton1_add_vaccineActionPerformed

    private void jButton7_edit_vaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7_edit_vaccineActionPerformed
        // TODO add your handling code here:
        P1.setVisible(false);
        P2.setVisible(true);
     //   P3.setVisible(false);
    }//GEN-LAST:event_jButton7_edit_vaccineActionPerformed

    private void jButton5_listVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5_listVaccineActionPerformed
        // TODO add your handling code here:
        P1.setVisible(false);
        P2.setVisible(false);
      //  P3.setVisible(true);
    }//GEN-LAST:event_jButton5_listVaccineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DynamicPanel;
    private javax.swing.JButton jButton1_add_vaccine;
    private javax.swing.JButton jButton5_listVaccine;
    private javax.swing.JButton jButton7_edit_vaccine;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}