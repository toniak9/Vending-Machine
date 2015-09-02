/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import javax.swing.JOptionPane;

/**
 *
 * @author Tonia
 */
public class AddAdmin extends javax.swing.JFrame {
    Role role = new ManagerRole();
    /**
     * Creates new form AddAdmin
     */
    public AddAdmin() {
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
        addAdminUsername = new javax.swing.JLabel();
        addAdminUsernameTextField = new javax.swing.JTextField();
        addAdminPwdjLabel = new javax.swing.JLabel();
        addAdminPwdjTextField = new javax.swing.JTextField();
        addAdminjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        addAdminUsername.setText("Set User");
        jPanel1.add(addAdminUsername);
        addAdminUsername.setBounds(130, 80, 51, 16);

        addAdminUsernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdminUsernameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(addAdminUsernameTextField);
        addAdminUsernameTextField.setBounds(230, 70, 139, 28);

        addAdminPwdjLabel.setText("Set Password ");
        jPanel1.add(addAdminPwdjLabel);
        addAdminPwdjLabel.setBounds(130, 130, 100, 30);

        addAdminPwdjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdminPwdjTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(addAdminPwdjTextField);
        addAdminPwdjTextField.setBounds(230, 130, 138, 28);

        addAdminjButton.setText("add user");
        addAdminjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdminjButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addAdminjButton);
        addAdminjButton.setBounds(180, 200, 98, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/Tonia/Desktop/images/addUserImage.jpg")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-9, -10, 540, 320);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addAdminUsernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdminUsernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addAdminUsernameTextFieldActionPerformed

    private void addAdminPwdjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdminPwdjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addAdminPwdjTextFieldActionPerformed

    private void addAdminjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdminjButtonActionPerformed
        role.addAdmin(addAdminUsernameTextField.getText(), addAdminPwdjTextField.getText());
        JOptionPane.showMessageDialog(null, "User "+addAdminUsernameTextField.getText()+" added");
        this.dispose();
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
            java.util.logging.Logger.getLogger(AddAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addAdminPwdjLabel;
    private javax.swing.JTextField addAdminPwdjTextField;
    private javax.swing.JLabel addAdminUsername;
    private javax.swing.JTextField addAdminUsernameTextField;
    private javax.swing.JButton addAdminjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
