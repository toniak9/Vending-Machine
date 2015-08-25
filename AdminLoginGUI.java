
package projectvendingmachine;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class is responsible for Administrator/Manger GUI and provides limited or full view 
 * depending on the user logged in.
 * This class gets the backend data of selected vending machine form FileStrtegy class
 * The actions performed by each user is mentioned in the Role class
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Tonia
 */
public class AdminLoginGUI extends javax.swing.JFrame {
    String adminMessage = null;
    List itemSummary = new ArrayList();
    List filtersList = new ArrayList();
    private String filename = null;
    Role role;
    DefaultTableModel model = null;
    private JTable summaryTable;
    Timer timer;
    /**
     * Creates new form AdminLoginGUI
     */
    
    public AdminLoginGUI() {
      //  initComponents();
      //  addJTableItemSummary();
    }
 
    public AdminLoginGUI(String message, String userRole, String username) {
       // this.adminMessage = message;
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println( "Hello" );
                 new LoginGUI().setVisible(true);
                 dispose();
                 timer.stop();
            }
        };
        timer = new Timer( (15 * 60 * 1000), actionListener );
        timer.start();
        System.out.println("msg in adminGUI"+message);
        initComponents();
        adminLoginMessage.setText("Welcome "+username);
      //  sanJoseVMButton.setSelected(true);
        
       //depending on the user logged, role object is created
        if(userRole.equalsIgnoreCase("Admin")){
            role = new AdminRole();
            AddButton.setEnabled(false);
            DeleteButton.setEnabled(false);
        } else if(userRole.equalsIgnoreCase("Manager")) {
            role = new ManagerRole();
        } else {
            System.out.println("No one to handle");
        }
        
    }

    //addJTableItemSummary displays the list of all items present in the selected Vending Machine
    void addJTableItemSummary() {
        
        if(model == null){
          //  System.out.println("model value" +model);
            model = new DefaultTableModel();
            model.addColumn("ItemCode");
            model.addColumn("ItemName");
            model.addColumn("ItemCategory");
            model.addColumn("ItemCost");
            model.addColumn("ItemCount");
        } else {
            model.setRowCount(0);
        }
        
        summaryTable = new JTable(model);
        // summaryTable.setSize(new Dimension(100, 100));
        
        //checks if any filters are selected and calls the FilterStrategy class
        if(filtersList.isEmpty()) {
            if(! itemSummary.isEmpty()){
                itemSummary.clear();
            }
            
          //  System.out.println("Filename:" + filename);
            FilterContext context = new FilterContext(new ViewAllFilter(),filename);		
            this.itemSummary = context.executeStrategy();
         //   System.out.println("viewAll itemSummary"+itemSummary);

        } else {
            if(! itemSummary.isEmpty()){
                itemSummary.clear();
            }
            FilterContext context = new FilterContext(new ItemTypeFilter(filtersList),filename);		
            this.itemSummary = context.executeStrategy();
          //  System.out.println("ItemType filter itemSummary"+itemSummary);

        }
         
      //   summaryTable.getCellEditor(1, 4);
         Action action = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                TableCellListener tcl = (TableCellListener)e.getSource();
                for (int i = 0; i < summaryTable.getRowCount(); i ++) {
                    System.out.println("itemCount" + i +": " + summaryTable.getValueAt(i, 4));
                }
            }
        };
        
        TableCellListener tcl = new TableCellListener(summaryTable, action);

        Iterator<HashMap> iterator = itemSummary.iterator();
         // System.out.println("reached near iterator");
         
	 while (iterator.hasNext()) {
            HashMap hashRow = iterator.next();
            // System.out.println("reached into whileloop");
            Vector row = new Vector();
            row.add(hashRow.get("itemCode"));
            row.add(hashRow.get("itemName"));
            row.add(hashRow.get("itemCategory"));
            row.add(hashRow.get("itemCost"));
            row.add(hashRow.get("itemCount"));
            
            model.addRow(row);
        //    System.out.println("table values:"+hashRow);
         }
 
        JScrollPane itemSummaryScrollpane = new JScrollPane(summaryTable);
    	// create a window
        itemSummaryScrollpane.setPreferredSize(new Dimension(500, 200));
    	adminSummaryPanel.setLayout(new BorderLayout());
    	adminSummaryPanel.add(itemSummaryScrollpane, BorderLayout.CENTER);
     //   System.out.println("reached end of addjtable method");
        adminSummaryPanel.revalidate();
        
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
        santaClaraVMButton = new javax.swing.JRadioButton();
        statisticsButton = new javax.swing.JButton();
        adminSummaryPanel = new javax.swing.JPanel();
        adminFileterPanel = new javax.swing.JPanel();
        snacksCheckBox = new javax.swing.JCheckBox();
        beveragesCheckBox = new javax.swing.JCheckBox();
        candiesCheckBox = new javax.swing.JCheckBox();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        userLogoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        adminLoginMessage.setText("Message:");

        vendingMachinePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Vending Machines LIst"));

        buttonGroup1.add(sanJoseVMButton);
        sanJoseVMButton.setText("San Jose Vending Machine");
        sanJoseVMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sanJoseVMButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(santaClaraVMButton);
        santaClaraVMButton.setText("Santa Clara Vending Machine");
        santaClaraVMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                santaClaraVMButtonActionPerformed(evt);
            }
        });

        statisticsButton.setText("View Statistics");
        statisticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vendingMachinePanelLayout = new javax.swing.GroupLayout(vendingMachinePanel);
        vendingMachinePanel.setLayout(vendingMachinePanelLayout);
        vendingMachinePanelLayout.setHorizontalGroup(
            vendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vendingMachinePanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(vendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vendingMachinePanelLayout.createSequentialGroup()
                        .addComponent(sanJoseVMButton)
                        .addContainerGap(516, Short.MAX_VALUE))
                    .addGroup(vendingMachinePanelLayout.createSequentialGroup()
                        .addComponent(santaClaraVMButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statisticsButton)
                        .addGap(51, 51, 51))))
        );
        vendingMachinePanelLayout.setVerticalGroup(
            vendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vendingMachinePanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(vendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statisticsButton)
                    .addGroup(vendingMachinePanelLayout.createSequentialGroup()
                        .addComponent(sanJoseVMButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(santaClaraVMButton)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        adminSummaryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Items Summary"));

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

        adminFileterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Category Filters"));

        snacksCheckBox.setText("Snacks");
        snacksCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snacksCheckBoxActionPerformed(evt);
            }
        });

        beveragesCheckBox.setText("Beverages");
        beveragesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beveragesCheckBoxActionPerformed(evt);
            }
        });

        candiesCheckBox.setText("Candies");
        candiesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                candiesCheckBoxActionPerformed(evt);
            }
        });

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

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
                .addContainerGap(433, Short.MAX_VALUE))
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

        userLogoutButton.setText("Logout");
        userLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userLogoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(adminFileterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(adminLoginMessage)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userLogoutButton))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(vendingMachinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(adminSummaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(adminLoginMessage)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userLogoutButton)
                        .addGap(18, 18, 18)))
                .addComponent(vendingMachinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adminSummaryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(adminFileterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sanJoseVMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sanJoseVMButtonActionPerformed
        timer.restart();
      //  System.out.println("Selected : " + sanJoseVMButton.isSelected());
        if(sanJoseVMButton.isSelected()){
            filename = "SanJoseVMFood.json"; 
            role.setFilename(filename);
            addJTableItemSummary();
        }
    }//GEN-LAST:event_sanJoseVMButtonActionPerformed

    private void snacksCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snacksCheckBoxActionPerformed
        timer.restart();
        if(snacksCheckBox.isSelected()) {
            filtersList.add("Snacks");
            addJTableItemSummary();
            return;
        }
        if(snacksCheckBox.isSelected() == false){
            filtersList.remove("Snacks");
            addJTableItemSummary();
            return;
        }
    }//GEN-LAST:event_snacksCheckBoxActionPerformed

    //This method calls the Role class to update the backend JSON data
    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        timer.restart();
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
               
         }
         //role = new AdminRole();
         role.restockAction(updatedList);
         JOptionPane.showMessageDialog(null, " Item count is Updated");

        
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void beveragesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beveragesCheckBoxActionPerformed
                timer.restart();
        if(beveragesCheckBox.isSelected()) {
            filtersList.add("Beverages");
            addJTableItemSummary();
            return;
        }
        if(beveragesCheckBox.isSelected() == false){
            filtersList.remove("Beverages");
            addJTableItemSummary();
            return;
        }
    }//GEN-LAST:event_beveragesCheckBoxActionPerformed

    private void candiesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_candiesCheckBoxActionPerformed
               timer.restart();
        if(candiesCheckBox.isSelected()) {
            filtersList.add("Candies");
            addJTableItemSummary();
            return;
        }
        if(candiesCheckBox.isSelected() == false){
            filtersList.remove("Candies");
            addJTableItemSummary();
            return;
        }
    }//GEN-LAST:event_candiesCheckBoxActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
               timer.restart();
        new AddItem().setVisible(true);
    }//GEN-LAST:event_AddButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
               timer.restart();
           int x = summaryTable.getSelectedRow();
           long deleteItemCode = (long) summaryTable.getValueAt(x, 0);
           model.removeRow(x);
          
         //  role = new ManagerRole();
           role.deleteItem(deleteItemCode);
           summaryTable.revalidate();
           
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void santaClaraVMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_santaClaraVMButtonActionPerformed
        timer.restart();
        if(santaClaraVMButton.isSelected()){
            filename = "SantaClaraVMFood.json"; 
            role.setFilename(filename);
            addJTableItemSummary();
        }
    }//GEN-LAST:event_santaClaraVMButtonActionPerformed

    private void statisticsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticsButtonActionPerformed
        timer.restart();
        PieChart demo = new PieChart("Vending Machine");
        PieChartModel chartModel = new PieChartModel();
        PieChartController controller = new PieChartController(demo, chartModel);
        controller.setFilename(filename);
        controller.updateView();
        
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }//GEN-LAST:event_statisticsButtonActionPerformed

    private void userLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userLogoutButtonActionPerformed
        
        new LoginGUI().setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_userLogoutButtonActionPerformed

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
              //  new AdminLoginGUI().setVisible(true);
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
    private javax.swing.JRadioButton santaClaraVMButton;
    private javax.swing.JCheckBox snacksCheckBox;
    private javax.swing.JButton statisticsButton;
    private javax.swing.JButton userLogoutButton;
    private javax.swing.JPanel vendingMachinePanel;
    // End of variables declaration//GEN-END:variables
}
