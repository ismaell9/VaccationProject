package Frames.Panels;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import vaccinationsystem.Vaccine;

public class StoreKeeper_ListVaccinePanel extends javax.swing.JPanel {

  
    public StoreKeeper_ListVaccinePanel() {
        initComponents();
        addRowsTojTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TradeName", "Type", "Expiration Date", "Price", "Comment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

  public void addRowsTojTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[8];

        Vaccine v = new Vaccine();
        ArrayList<Vaccine> vacs = new ArrayList<Vaccine>();
        
       vacs = v.listvacs();
        
            for (Vaccine vac : vacs) {
            rowData[0] = vac.get_vacId();
            rowData[1] = vac.get_vacTradeName();
            rowData[2] = vac.get_vacType();
            rowData[3] = vac.get_vacExpirationYear();
            rowData[4] = vac.get_vacAbbreviation();
            rowData[5] = vac.get_price();
            rowData[6] = vac.get_vacComment();

               model.addRow(rowData);
            }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
