
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
import java.awt.Color;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
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
    private String userRole;
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
        this.userRole = userRole;

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
        //statsImageLabel.setIcon(new ImageIcon("/Users/Tonia/Desktop/images/pie.thumbnail.png"));
        
        adminLoginMessage.setText("Welcome "+username);
      //  sanJoseVMButton.setSelected(true);
        
       //depending on the user logged, role object is created
        if(this.userRole.equalsIgnoreCase("Admin")){
            role = new AdminRole();
            AddButton.setEnabled(false);
            DeleteButton.setEnabled(false);
            addAdminjButton.setEnabled(false);
        } else if(this.userRole.equalsIgnoreCase("Manager")) {
            role = new ManagerRole();
        } else {
            System.out.println("No one to handle");
        }
        
    }

    //addJTableItemSummary displays the list of all items present in the selected Vending Machine
    void addJTableItemSummary() {
        
        if(model == null){
          //  System.out.println("model value" +model);
            if(this.userRole.equalsIgnoreCase("Admin")){
                model = new DefaultTableModel() {    
                @Override
                public boolean isCellEditable(int row, int column) {
                    return column == 4;
                }
                };
            } else {
                model = new DefaultTableModel();
            }
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
        
        summaryTable.setSelectionBackground(Color.gray);
       // summaryTable.setBackground(Color.lightGray);
        summaryTable.setForeground(Color.black);
       /* summaryTable.setOpaque(false);
        summaryTable.setShowGrid(false);
      //  ((DefaultTableCellRenderer)summaryTable.getDefaultRenderer(Object.class)).setOpaque(false);
        itemSummaryScrollpane.setOpaque(false);
        itemSummaryScrollpane.getViewport().setOpaque(false);*/
        adminSummaryPanel.revalidate();
        adminSummaryPanel.repaint();
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
        updateMessagejLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
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
        addAdminjButton = new javax.swing.JButton();
        userLogoutButton = new javax.swing.JButton();
        amountDisplayLabel = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        amountDisplayPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setLayout(null);

        adminLoginMessage.setText("Message:");
        jPanel1.add(adminLoginMessage);
        adminLoginMessage.setBounds(50, 20, 310, 20);

        vendingMachinePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Vending Machines LIst"));
        vendingMachinePanel.setOpaque(false);

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
                .addContainerGap()
                .addComponent(sanJoseVMButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(santaClaraVMButton)
                .addGap(89, 89, 89)
                .addComponent(statisticsButton)
                .addGap(509, 509, 509))
        );
        vendingMachinePanelLayout.setVerticalGroup(
            vendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vendingMachinePanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(vendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sanJoseVMButton)
                    .addComponent(santaClaraVMButton))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vendingMachinePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statisticsButton)
                .addContainerGap())
        );

        jPanel1.add(vendingMachinePanel);
        vendingMachinePanel.setBounds(70, 60, 680, 90);

        adminSummaryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Items Summary"));
        adminSummaryPanel.setOpaque(false);

        javax.swing.GroupLayout adminSummaryPanelLayout = new javax.swing.GroupLayout(adminSummaryPanel);
        adminSummaryPanel.setLayout(adminSummaryPanelLayout);
        adminSummaryPanelLayout.setHorizontalGroup(
            adminSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
        );
        adminSummaryPanelLayout.setVerticalGroup(
            adminSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );

        jPanel1.add(adminSummaryPanel);
        adminSummaryPanel.setBounds(70, 160, 680, 280);

        adminFileterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Category Filters"));
        adminFileterPanel.setOpaque(false);

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

        AddButton.setText("Add Item");
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

        addAdminjButton.setText("Add Admin");
        addAdminjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdminjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminFileterPanelLayout = new javax.swing.GroupLayout(adminFileterPanel);
        adminFileterPanel.setLayout(adminFileterPanelLayout);
        adminFileterPanelLayout.setHorizontalGroup(
            adminFileterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminFileterPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(adminFileterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminFileterPanelLayout.createSequentialGroup()
                        .addComponent(snacksCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(beveragesCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(candiesCheckBox))
                    .addGroup(adminFileterPanelLayout.createSequentialGroup()
                        .addComponent(AddButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addAdminjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UpdateButton)))
                .addContainerGap(57, Short.MAX_VALUE))
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
                    .addComponent(UpdateButton)
                    .addComponent(addAdminjButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(adminFileterPanel);
        adminFileterPanel.setBounds(70, 460, 500, 120);

        userLogoutButton.setText("Logout");
        userLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userLogoutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(userLogoutButton);
        userLogoutButton.setBounds(880, 20, 88, 29);

        amountDisplayLabel.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        amountDisplayLabel.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(amountDisplayLabel);
        amountDisplayLabel.setBounds(640, 500, 80, 50);

        amountLabel.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        amountLabel.setText("Amount");
        jPanel1.add(amountLabel);
        amountLabel.setBounds(630, 470, 110, 30);

        amountDisplayPanel.setOpaque(false);

        javax.swing.GroupLayout amountDisplayPanelLayout = new javax.swing.GroupLayout(amountDisplayPanel);
        amountDisplayPanel.setLayout(amountDisplayPanelLayout);
        amountDisplayPanelLayout.setHorizontalGroup(
            amountDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        amountDisplayPanelLayout.setVerticalGroup(
            amountDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        jPanel1.add(amountDisplayPanel);
        amountDisplayPanel.setBounds(600, 470, 150, 110);

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/Tonia/Desktop/images/adminBackground.jpg")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateMessagejLabel))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(updateMessagejLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
               double itemCost =0.0;
               try {   
                itemCode = Long.valueOf(summaryTable.getValueAt(i, 0).toString());
                // long a = Long.valueOf(itemCode);
                itemCount = (String) summaryTable.getValueAt(i, 4);
                   System.out.println("price update"+summaryTable.getValueAt(i, 3).toString());
                itemCost = (double) Double.valueOf(summaryTable.getValueAt(i, 3).toString());
                
                // long b = Long.valueOf(itemCount);
               } catch (Exception e) {
                  System.out.println("I:" + i);
                  System.out.println("Item Count is " + summaryTable.getValueAt(i, 4));
                  e.printStackTrace();
                  return;
               }
                updatedHashMap.put("itemCode",itemCode);
                updatedHashMap.put("itemCount", Long.parseLong(itemCount));
                updatedHashMap.put("itemCost", itemCost);
                
                updatedList.add(updatedHashMap);
         
         }
         //role = new AdminRole();
         role.restockAction(updatedList);
         JOptionPane.showMessageDialog(null, " Item is Updated");
         

        
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
        new AddItem(filename).setVisible(true);
    }//GEN-LAST:event_AddButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
           timer.restart();
           summaryTable.revalidate();
           int x = summaryTable.getSelectedRow();
           
           long deleteItemCode = (long) summaryTable.getValueAt(x, 0);
           model.removeRow(x);
          
         //  role = new ManagerRole();
           role.deleteItem(deleteItemCode);
           summaryTable.revalidate();
           JOptionPane.showMessageDialog(null, " Item is deleted");
           
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void userLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userLogoutButtonActionPerformed
        
        new LoginGUI().setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_userLogoutButtonActionPerformed

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

    private void santaClaraVMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_santaClaraVMButtonActionPerformed
        timer.restart();
        if(santaClaraVMButton.isSelected()){
            filename = "SantaClaraVMFood.json";
            role.setFilename(filename);
            double amount = role.getQuantity(filename);
            amountDisplayLabel.setText(Double.toString(amount));
            addJTableItemSummary();
        }
    }//GEN-LAST:event_santaClaraVMButtonActionPerformed

    private void sanJoseVMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sanJoseVMButtonActionPerformed
        timer.restart();
        //  System.out.println("Selected : " + sanJoseVMButton.isSelected());
        if(sanJoseVMButton.isSelected()){
            filename = "SanJoseVMFood.json";
            role.setFilename(filename);
            double amount = role.getQuantity(filename);
            amountDisplayLabel.setText(Double.toString(amount));
            addJTableItemSummary();
        }
    }//GEN-LAST:event_sanJoseVMButtonActionPerformed

    private void addAdminjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdminjButtonActionPerformed
        new AddAdmin().setVisible(true);
    }//GEN-LAST:event_addAdminjButtonActionPerformed

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
    private javax.swing.JButton addAdminjButton;
    private javax.swing.JPanel adminFileterPanel;
    private javax.swing.JLabel adminLoginMessage;
    private javax.swing.JPanel adminSummaryPanel;
    private javax.swing.JLabel amountDisplayLabel;
    private javax.swing.JPanel amountDisplayPanel;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JCheckBox beveragesCheckBox;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox candiesCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton sanJoseVMButton;
    private javax.swing.JRadioButton santaClaraVMButton;
    private javax.swing.JCheckBox snacksCheckBox;
    private javax.swing.JButton statisticsButton;
    private javax.swing.JLabel updateMessagejLabel;
    private javax.swing.JButton userLogoutButton;
    private javax.swing.JPanel vendingMachinePanel;
    // End of variables declaration//GEN-END:variables
}
