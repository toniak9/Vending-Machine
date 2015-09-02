/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sruti
 */
public class AddItem extends javax.swing.JFrame {
    private Role role = new ManagerRole();
    private String filename;
    /**
     * Creates new form AddItem
     */
    public AddItem(String filename) {
        this.filename = filename;
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

        jPanel1 = new javax.swing.JPanel();
        AddItemPanel = new javax.swing.JPanel();
        itemTypeLabel = new javax.swing.JLabel();
        itemNameLabel = new javax.swing.JLabel();
        itemCategoryLabel = new javax.swing.JLabel();
        itemCodeLabel = new javax.swing.JLabel();
        itemCountLabel = new javax.swing.JLabel();
        itemCostLabel = new javax.swing.JLabel();
        calorieCountLabel = new javax.swing.JLabel();
        sugarsLabel = new javax.swing.JLabel();
        protiensLabel = new javax.swing.JLabel();
        fatContentLabel = new javax.swing.JLabel();
        itemTypeTextField = new javax.swing.JTextField();
        itemNameTextField = new javax.swing.JTextField();
        itemCategoryTextField = new javax.swing.JTextField();
        itemCodeTextField = new javax.swing.JTextField();
        itemCountTextField = new javax.swing.JTextField();
        itemCostTextField = new javax.swing.JTextField();
        calorieCountTextField = new javax.swing.JTextField();
        sugarsTextField = new javax.swing.JTextField();
        protiensTextField = new javax.swing.JTextField();
        fatContentTextField = new javax.swing.JTextField();
        ADDButton = new javax.swing.JButton();
        CLEARButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        AddItemPanel.setOpaque(false);

        itemTypeLabel.setText("Item Type");

        itemNameLabel.setText("Item Name");

        itemCategoryLabel.setText("Item Category");

        itemCodeLabel.setText("Item Code");

        itemCountLabel.setText("Item Count");

        itemCostLabel.setText("Item Cost");

        calorieCountLabel.setText("Calorie Count");

        sugarsLabel.setText("Sugars");

        protiensLabel.setText("Protiens");

        fatContentLabel.setText("Fat content");

        itemNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNameTextFieldActionPerformed(evt);
            }
        });

        ADDButton.setText("ADD");
        ADDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDButtonActionPerformed(evt);
            }
        });

        CLEARButton.setText("CLEAR");
        CLEARButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEARButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddItemPanelLayout = new javax.swing.GroupLayout(AddItemPanel);
        AddItemPanel.setLayout(AddItemPanelLayout);
        AddItemPanelLayout.setHorizontalGroup(
            AddItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddItemPanelLayout.createSequentialGroup()
                .addGroup(AddItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AddItemPanelLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(AddItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(AddItemPanelLayout.createSequentialGroup()
                                .addComponent(itemCostLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemCostTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddItemPanelLayout.createSequentialGroup()
                                .addComponent(itemCountLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddItemPanelLayout.createSequentialGroup()
                                .addComponent(itemCodeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddItemPanelLayout.createSequentialGroup()
                                .addComponent(itemCategoryLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddItemPanelLayout.createSequentialGroup()
                                .addComponent(itemNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddItemPanelLayout.createSequentialGroup()
                                .addComponent(itemTypeLabel)
                                .addGap(32, 32, 32)
                                .addComponent(itemTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addGroup(AddItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(AddItemPanelLayout.createSequentialGroup()
                                .addComponent(fatContentLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fatContentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddItemPanelLayout.createSequentialGroup()
                                .addComponent(protiensLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(protiensTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddItemPanelLayout.createSequentialGroup()
                                .addComponent(sugarsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sugarsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddItemPanelLayout.createSequentialGroup()
                                .addComponent(calorieCountLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calorieCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(AddItemPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ADDButton)
                        .addGap(48, 48, 48)
                        .addComponent(CLEARButton)
                        .addGap(139, 139, 139)))
                .addGap(66, 66, 66))
        );
        AddItemPanelLayout.setVerticalGroup(
            AddItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddItemPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(AddItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemTypeLabel)
                    .addComponent(itemTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calorieCountLabel)
                    .addComponent(calorieCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(AddItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemNameLabel)
                    .addComponent(itemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sugarsLabel)
                    .addComponent(sugarsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(AddItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemCategoryLabel)
                    .addComponent(itemCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(protiensLabel)
                    .addComponent(protiensTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(AddItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemCodeLabel)
                    .addComponent(itemCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fatContentLabel)
                    .addComponent(fatContentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemCountLabel)
                    .addComponent(itemCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(AddItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemCostLabel)
                    .addComponent(itemCostTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ADDButton)
                    .addComponent(CLEARButton))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel1.add(AddItemPanel);
        AddItemPanel.setBounds(0, 0, 690, 456);

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/Tonia/Desktop/images/addItemImage.jpg")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemNameTextFieldActionPerformed

    private void ADDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDButtonActionPerformed
        // TODO add your handling code here:
        String itemType = itemTypeTextField.getText();
        String itemName = itemNameTextField.getText();
        String itemCategory = itemCategoryTextField.getText();
        long itemCode = Long.parseLong(itemCodeTextField.getText());
        long itemCount = Long.parseLong(itemCountTextField.getText());
        double itemCost = Double.parseDouble(itemCostTextField.getText());
        long calorieCount = Long.parseLong(calorieCountTextField.getText());
        String sugars = sugarsTextField.getText();
        long proteins = Long.parseLong(protiensTextField.getText());
        long fat = Long.parseLong(fatContentTextField.getText());
        
        HashMap addToItemsMap = new HashMap();
        addToItemsMap.put("itemType", itemType);
        addToItemsMap.put("name", itemName);
        addToItemsMap.put("category", itemCategory);
        addToItemsMap.put("code", itemCode);
        addToItemsMap.put("count", itemCount);
        addToItemsMap.put("cost", itemCost);
        addToItemsMap.put("calorieCount", calorieCount);
        addToItemsMap.put("sugars",sugars);
        addToItemsMap.put("protein", proteins);
        addToItemsMap.put("fat", fat);
        
        role.setFilename(filename);
        role.addItem(addToItemsMap);
        
        JOptionPane.showMessageDialog(null, " Item is Added");
        this.dispose();
        System.out.println("item added");
        
    }//GEN-LAST:event_ADDButtonActionPerformed

    private void CLEARButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARButtonActionPerformed
        // TODO add your handling code here:
        itemTypeTextField.setText("");
        itemNameTextField.setText("");
        itemCategoryTextField.setText("");
        itemCodeTextField.setText("");
        itemCountTextField.setText("");
        itemCostTextField.setText("");
        calorieCountTextField.setText("");
        sugarsTextField.setText("");
        protiensTextField.setText("");
        fatContentTextField.setText("");
        
    }//GEN-LAST:event_CLEARButtonActionPerformed

    //AddItem.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    
    
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
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new AddItem().setVisible(true);
               
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDButton;
    private javax.swing.JPanel AddItemPanel;
    private javax.swing.JButton CLEARButton;
    private javax.swing.JLabel calorieCountLabel;
    private javax.swing.JTextField calorieCountTextField;
    private javax.swing.JLabel fatContentLabel;
    private javax.swing.JTextField fatContentTextField;
    private javax.swing.JLabel itemCategoryLabel;
    private javax.swing.JTextField itemCategoryTextField;
    private javax.swing.JLabel itemCodeLabel;
    private javax.swing.JTextField itemCodeTextField;
    private javax.swing.JLabel itemCostLabel;
    private javax.swing.JTextField itemCostTextField;
    private javax.swing.JLabel itemCountLabel;
    private javax.swing.JTextField itemCountTextField;
    private javax.swing.JLabel itemNameLabel;
    private javax.swing.JTextField itemNameTextField;
    private javax.swing.JLabel itemTypeLabel;
    private javax.swing.JTextField itemTypeTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel protiensLabel;
    private javax.swing.JTextField protiensTextField;
    private javax.swing.JLabel sugarsLabel;
    private javax.swing.JTextField sugarsTextField;
    // End of variables declaration//GEN-END:variables
}
