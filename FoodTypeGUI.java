/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import javax.swing.JOptionPane;



/**
 *
 * @author Sruti
 */
public class FoodTypeGUI extends javax.swing.JFrame {

    /**
     * Creates new form FoodTypeGUI
     */
    
    private GuiSubject subject;
    
    public FoodTypeGUI() {
        
    }
    
    public FoodTypeGUI(GuiSubject subject) {
        initComponents();
        this.subject = subject;
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
        jPanel2 = new javax.swing.JPanel();
        foodTypePanel = new javax.swing.JPanel();
        foodTypeLabel = new javax.swing.JLabel();
        okFoodTypeButton = new javax.swing.JButton();
        cbSnacks = new javax.swing.JCheckBox();
        cbCandies = new javax.swing.JCheckBox();
        cbBeverages = new javax.swing.JCheckBox();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        foodTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Food Type"));

        foodTypeLabel.setText("Select the type of food");

        okFoodTypeButton.setText("Ok");
        okFoodTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okFoodTypeButtonActionPerformed(evt);
            }
        });

        cbSnacks.setText("Snacks");
        cbSnacks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSnacksActionPerformed(evt);
            }
        });

        cbCandies.setText("Candies");

        cbBeverages.setText("Beverages");

        javax.swing.GroupLayout foodTypePanelLayout = new javax.swing.GroupLayout(foodTypePanel);
        foodTypePanel.setLayout(foodTypePanelLayout);
        foodTypePanelLayout.setHorizontalGroup(
            foodTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foodTypePanelLayout.createSequentialGroup()
                .addGroup(foodTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(foodTypePanelLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(okFoodTypeButton))
                    .addGroup(foodTypePanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(foodTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSnacks)
                            .addComponent(foodTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCandies)
                            .addComponent(cbBeverages))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        foodTypePanelLayout.setVerticalGroup(
            foodTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foodTypePanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(foodTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbSnacks)
                .addGap(18, 18, 18)
                .addComponent(cbCandies)
                .addGap(18, 18, 18)
                .addComponent(cbBeverages)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(okFoodTypeButton)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(foodTypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(foodTypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSnacksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSnacksActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cbSnacksActionPerformed

    private void okFoodTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okFoodTypeButtonActionPerformed
        // TODO add your handling code here:
        String snacks;
        String candies;
        String beverages;
        
        if(cbSnacks.isSelected()) {
            snacks = cbSnacks.getText();
            subject.setSnacks(snacks);
        }
        if(cbCandies.isSelected()) {
            candies = cbCandies.getText();
             subject.setCandies(candies);
        }
        if(cbBeverages.isSelected()) {
            beverages = cbBeverages.getText();
             subject.setBeverages(beverages);
        } 
        
        this.dispose();
    }//GEN-LAST:event_okFoodTypeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FoodTypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoodTypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoodTypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoodTypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FoodTypeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbBeverages;
    private javax.swing.JCheckBox cbCandies;
    private javax.swing.JCheckBox cbSnacks;
    private javax.swing.JLabel foodTypeLabel;
    private javax.swing.JPanel foodTypePanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton okFoodTypeButton;
    // End of variables declaration//GEN-END:variables
}
