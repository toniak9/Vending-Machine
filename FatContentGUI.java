/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

/**
 *
 * @author Sruti
 */
public class FatContentGUI extends javax.swing.JFrame {
    
    private GuiSubject subject;
    
    /**
     * Creates new form FatContentGUI
     */
    public FatContentGUI() {
        
    }

    public FatContentGUI(GuiSubject subject) {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        fatContentPanel = new javax.swing.JPanel();
        fatContentLabel = new javax.swing.JLabel();
        FatTextField = new javax.swing.JTextField();
        fatContentButton = new javax.swing.JButton();
        fatSlider = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fatContentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Fat Content"));

        fatContentLabel.setText("Enter the range of fat content (0 - 200)");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, fatSlider, org.jdesktop.beansbinding.ELProperty.create("${value}"), FatTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        FatTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FatTextFieldActionPerformed(evt);
            }
        });

        fatContentButton.setText("Ok");
        fatContentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fatContentButtonActionPerformed(evt);
            }
        });

        fatSlider.setMajorTickSpacing(50);
        fatSlider.setMaximum(250);
        fatSlider.setMinorTickSpacing(20);
        fatSlider.setPaintLabels(true);
        fatSlider.setPaintTicks(true);
        fatSlider.setSnapToTicks(true);

        javax.swing.GroupLayout fatContentPanelLayout = new javax.swing.GroupLayout(fatContentPanel);
        fatContentPanel.setLayout(fatContentPanelLayout);
        fatContentPanelLayout.setHorizontalGroup(
            fatContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fatContentPanelLayout.createSequentialGroup()
                .addGap(0, 53, Short.MAX_VALUE)
                .addComponent(fatContentLabel)
                .addGap(51, 51, 51))
            .addGroup(fatContentPanelLayout.createSequentialGroup()
                .addGroup(fatContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fatContentPanelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(fatSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fatContentPanelLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(fatContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(fatContentPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(fatContentButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fatContentPanelLayout.setVerticalGroup(
            fatContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fatContentPanelLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(fatContentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fatSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fatContentButton)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(fatContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(fatContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FatTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FatTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FatTextFieldActionPerformed

    private void fatContentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatContentButtonActionPerformed
        // TODO add your handling code here:
        String fat = FatTextField.getText();
        subject.setFat(fat);
        this.dispose();
    }//GEN-LAST:event_fatContentButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FatContentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FatContentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FatContentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FatContentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FatContentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FatTextField;
    private javax.swing.JButton fatContentButton;
    private javax.swing.JLabel fatContentLabel;
    private javax.swing.JPanel fatContentPanel;
    private javax.swing.JSlider fatSlider;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
