/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tonia
 */
public class AdminLoginGUI extends javax.swing.JFrame {
    String adminMessage = null;
    List itemSummary;
    Role role;
   
    DefaultTableModel model = new DefaultTableModel();
    

     private JTable summaryTable;
    /**
     * Creates new form AdminLoginGUI
     */
    
    public AdminLoginGUI() {
    }
     
    public AdminLoginGUI(List itemSummary) {
        this.itemSummary = itemSummary;
         initComponents();
        addJTableItemSummary();
        
    }
     
    public AdminLoginGUI(String userRole) {
        if(userRole.equalsIgnoreCase("Admin")){
            role = new AdminRole();
            AddButton.setEnabled(false);
            DeleteButton.setEnabled(false);
        }
        if(userRole.equalsIgnoreCase("Manager")) {
            role = new ManagerRole();
           
        }
    }
   /* public AdminLoginGUI(String message) {
       // this.adminMessage = message;
        System.out.println("msg in adminGUI"+message);
        adminLoginMessage.setText(message);
        initComponents();
    }*/
   
   
    void addJTableItemSummary() {
         summaryTable = new JTable(model);
         summaryTable.setSize(new Dimension(100, 100));
         model.addColumn("ItemCode");
         model.addColumn("ItemName");
         model.addColumn("ItemCategory");
         model.addColumn("ItemCost");
         model.addColumn("ItemCount");
      //   summaryTable.getCellEditor(1, 4);
         Action action = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                TableCellListener tcl = (TableCellListener)e.getSource();
                /*System.out.println("Row   : " + tcl.getRow());
                System.out.println("Column: " + tcl.getColumn());
                System.out.println("Old   : " + tcl.getOldValue());
                System.out.println("New   : " + tcl.getNewValue());*/
                
                for (int i = 0; i < summaryTable.getRowCount(); i ++) {
                    System.out.println("itemCount" + i +": " + summaryTable.getValueAt(i, 4));
                }
            }
        };

        TableCellListener tcl = new TableCellListener(summaryTable, action);


        
          Iterator<HashMap> iterator = itemSummary.iterator();
        //  System.out.println("size"+iterator.);
         
	 while (iterator.hasNext()) {
            HashMap hashRow = iterator.next();
            
            Vector row = new Vector();
            row.add(hashRow.get("itemCode"));
            row.add(hashRow.get("itemName"));
            row.add(hashRow.get("itemCategory"));
            row.add(hashRow.get("itemCost"));
            row.add(hashRow.get("itemCount"));
            
            model.addRow(row);
             System.out.println("table values:"+hashRow);
         }
        
         
         
         JScrollPane itemSummaryScrollpane = new JScrollPane(summaryTable);
    	// create a window
        itemSummaryScrollpane.setPreferredSize(new Dimension(500, 200));
    	adminSummaryPanel.setLayout(new BorderLayout());
    	adminSummaryPanel.add(itemSummaryScrollpane, BorderLayout.CENTER);
     //   itemSummary.revalidate();
        
    }   
        
       
    
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        adminLoginMessage = new javax.swing.JLabel();
        vendingMachinePanel = new javax.swing.JPanel();
        sanJoseVMButton = new javax.swing.JRadioButton();
        snataClaraVMButton = new javax.swing.JRadioButton();
        adminSummaryPanel = new javax.swing.JPanel();
        adminFileterPanel = new javax.swing.JPanel();
        snacksCheckBox = new javax.swing.JCheckBox();
        beveragesCheckBox = new javax.swing.JCheckBox();
        candiesCheckBox = new javax.swing.JCheckBox();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        adminLoginMessage.setText("Message:");

        buttonGroup1.add(sanJoseVMButton);
        sanJoseVMButton.setText("San Jose Vending Machine");
        sanJoseVMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sanJoseVMButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(snataClaraVMButton);
        snataClaraVMButton.setText("Santa Clara Vending Machine");

        javax.swing.GroupLayout vendingMachinePanelLayout = new javax.swing.GroupLayout(vendingMachinePanel);
        vendingMachinePanel.setLayout(vendingMachinePanelLayout);
        vendingMachinePanelLayout.setHorizontalGroup(
            vendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vendingMachinePanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(vendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(snataClaraVMButton)
                    .addComponent(sanJoseVMButton))
                .addContainerGap(498, Short.MAX_VALUE))
        );
        vendingMachinePanelLayout.setVerticalGroup(
            vendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vendingMachinePanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(sanJoseVMButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(snataClaraVMButton)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout adminSummaryPanelLayout = new javax.swing.GroupLayout(adminSummaryPanel);
        adminSummaryPanel.setLayout(adminSummaryPanelLayout);
        adminSummaryPanelLayout.setHorizontalGroup(
            adminSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        adminSummaryPanelLayout.setVerticalGroup(
            adminSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );

        snacksCheckBox.setText("Snacks");
        snacksCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snacksCheckBoxActionPerformed(evt);
            }
        });

        beveragesCheckBox.setText("Beverages");

        candiesCheckBox.setText("Candies");

        AddButton.setText("Add");

        DeleteButton.setText("Delete");

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminFileterPanelLayout = new javax.swing.GroupLayout(adminFileterPanel);
        adminFileterPanel.setLayout(adminFileterPanelLayout);
        adminFileterPanelLayout.setHorizontalGroup(
            adminFileterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminFileterPanelLayout.createSequentialGroup()
                .addGroup(adminFileterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminFileterPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(snacksCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(beveragesCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(candiesCheckBox))
                    .addGroup(adminFileterPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(AddButton)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(UpdateButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adminFileterPanelLayout.setVerticalGroup(
            adminFileterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminFileterPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(adminFileterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(snacksCheckBox)
                    .addComponent(beveragesCheckBox)
                    .addComponent(candiesCheckBox))
                .addGap(18, 18, 18)
                .addGroup(adminFileterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton)
                    .addComponent(DeleteButton)
                    .addComponent(UpdateButton))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(adminLoginMessage))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vendingMachinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminSummaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(adminFileterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(adminLoginMessage)
                .addGap(36, 36, 36)
                .addComponent(vendingMachinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adminSummaryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminFileterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sanJoseVMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sanJoseVMButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sanJoseVMButtonActionPerformed

    private void snacksCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snacksCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snacksCheckBoxActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
        
        HashMap updatedHashMap;
        List<HashMap> updatedList =new ArrayList<>();
         for(int i = 0; i < summaryTable.getRowCount(); i++) {
               updatedHashMap = new HashMap();
               //System.out.println("I:" + i);
               long itemCode = 0;
               String itemCount = "";
               try {
                itemCode = (long) summaryTable.getValueAt(i, 0);
                // long a = Long.valueOf(itemCode);
                itemCount = (String) summaryTable.getValueAt(i, 4);
                
                // long b = Long.valueOf(itemCount);
               } catch (Exception e) {
                  System.out.println("I:" + i);
                  System.out.println("Item Count is " + summaryTable.getValueAt(i, 4));
                  e.printStackTrace();
                  return;
               }
                updatedHashMap.put("itemCode",itemCode);
                updatedHashMap.put("itemCount", Long.parseLong(itemCount));
                
                updatedList.add(updatedHashMap);
                // System.out.println("updated values"+updatedHashMap);
          
         }
         role = new AdminRole();
         role.restockAction(updatedList);
        
    }//GEN-LAST:event_UpdateButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AdminLoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JPanel adminFileterPanel;
    private javax.swing.JLabel adminLoginMessage;
    private javax.swing.JPanel adminSummaryPanel;
    private javax.swing.JCheckBox beveragesCheckBox;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox candiesCheckBox;
    private javax.swing.JRadioButton sanJoseVMButton;
    private javax.swing.JCheckBox snacksCheckBox;
    private javax.swing.JRadioButton snataClaraVMButton;
    private javax.swing.JPanel vendingMachinePanel;
    // End of variables declaration//GEN-END:variables
}
