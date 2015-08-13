/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Tonia
 */
public class VendingMachineGUI extends javax.swing.JFrame {

    private GuiSubject subject;
    /**
     * Creates new form VendingMachineGUI
     */
    public VendingMachineGUI() {
        initComponents();
        subject = new GuiSubject();
    }
    
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requirementsPanel = new javax.swing.JPanel();
        cbCalorieCount = new javax.swing.JCheckBox();
        cbSugarContent = new javax.swing.JCheckBox();
        cbFatContent = new javax.swing.JCheckBox();
        cbPriceRange = new javax.swing.JCheckBox();
        cbFoodType = new javax.swing.JCheckBox();
        btnProceed = new javax.swing.JButton();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        requirementsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose your options"));

        cbCalorieCount.setText("Calorie Count");
        cbCalorieCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCalorieCountActionPerformed(evt);
            }
        });

        cbSugarContent.setText("Sugar Content");
        cbSugarContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSugarContentActionPerformed(evt);
            }
        });

        cbFatContent.setText("Fat Content");
        cbFatContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFatContentActionPerformed(evt);
            }
        });

        cbPriceRange.setText("Price Range ");
        cbPriceRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPriceRangeActionPerformed(evt);
            }
        });

        cbFoodType.setText("Food Type");
        cbFoodType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFoodTypeActionPerformed(evt);
            }
        });

        btnProceed.setText("Proceed");
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout requirementsPanelLayout = new javax.swing.GroupLayout(requirementsPanel);
        requirementsPanel.setLayout(requirementsPanelLayout);
        requirementsPanelLayout.setHorizontalGroup(
            requirementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requirementsPanelLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(requirementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSugarContent)
                    .addComponent(cbCalorieCount)
                    .addComponent(cbFatContent)
                    .addComponent(cbPriceRange)
                    .addComponent(cbFoodType))
                .addContainerGap(154, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, requirementsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProceed)
                .addGap(21, 21, 21))
        );
        requirementsPanelLayout.setVerticalGroup(
            requirementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requirementsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbCalorieCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbSugarContent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFatContent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPriceRange)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFoodType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProceed)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 3, 24)); // NOI18N
        titleLabel.setText("FOODEX");

        welcomeLabel.setText("Welcome  ");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeLabel)
                .addGap(107, 107, 107)
                .addComponent(titleLabel)
                .addContainerGap(235, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(welcomeLabel)
                .addContainerGap())
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(titleLabel)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(requirementsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(requirementsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCalorieCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCalorieCountActionPerformed
        // TODO add your handling code here:
        if(cbCalorieCount.isSelected()) {
            new CalorieCountGUI(subject).setVisible(true);
        }
        
    }//GEN-LAST:event_cbCalorieCountActionPerformed

    private void cbSugarContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSugarContentActionPerformed
        // TODO add your handling code here:
        if(cbSugarContent.isSelected()) {
            new SugarContentGUI(subject).setVisible(true);
        }
    }//GEN-LAST:event_cbSugarContentActionPerformed

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        // TODO add your handling code here:
        
        boolean[] arr = new boolean[5];
        if(!(cbCalorieCount.isSelected()|| cbSugarContent.isSelected()|| cbFatContent.isSelected() || 
                cbPriceRange.isSelected() || cbFoodType.isSelected())) {
            JOptionPane.showMessageDialog(null, " Select atleast one checkbox ", "error messages", JOptionPane.ERROR_MESSAGE);
        } else {
           
            arr[0] = cbCalorieCount.isSelected();
            arr[1] = cbSugarContent.isSelected();
            arr[2] = cbFatContent.isSelected();
            arr[3] = cbPriceRange.isSelected();
            arr[4] = cbFoodType.isSelected();
            
            subject.notifyObserver(arr);
            //new CartGUI().setVisible(true);
        }
        
        
    }//GEN-LAST:event_btnProceedActionPerformed

    private void cbFatContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFatContentActionPerformed
        // TODO add your handling code here:
        if(cbFatContent.isSelected()) {
            new FatContentGUI(subject).setVisible(true);
        }
    }//GEN-LAST:event_cbFatContentActionPerformed

    private void cbPriceRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPriceRangeActionPerformed
        // TODO add your handling code here:
        if(cbPriceRange.isSelected()) {
            new PriceRangeGUI(subject).setVisible(true);
        }
    }//GEN-LAST:event_cbPriceRangeActionPerformed

    private void cbFoodTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFoodTypeActionPerformed
        // TODO add your handling code here:
        if(cbFoodType.isSelected()) {
            new FoodTypeGUI(subject).setVisible(true);
        }
    }//GEN-LAST:event_cbFoodTypeActionPerformed

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
            java.util.logging.Logger.getLogger(VendingMachineGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendingMachineGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendingMachineGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendingMachineGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendingMachineGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProceed;
    private javax.swing.JCheckBox cbCalorieCount;
    private javax.swing.JCheckBox cbFatContent;
    private javax.swing.JCheckBox cbFoodType;
    private javax.swing.JCheckBox cbPriceRange;
    private javax.swing.JCheckBox cbSugarContent;
    private javax.swing.JPanel requirementsPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}


