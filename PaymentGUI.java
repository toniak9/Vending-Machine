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
public class PaymentGUI extends javax.swing.JFrame {

    /**
     * Creates new form PaymentGUI
     */
    public PaymentGUI() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        paymentPanel = new javax.swing.JPanel();
        javax.swing.JPanel summaryPanel = new javax.swing.JPanel();
        summaryLabel = new javax.swing.JLabel();
        paymentOptionsPanel = new javax.swing.JPanel();
        paymentOptionsLabel = new javax.swing.JLabel();
        rbCoins = new javax.swing.JRadioButton();
        rbCard = new javax.swing.JRadioButton();
        coinsPanel = new javax.swing.JPanel();
        nickelCoinButton = new javax.swing.JButton();
        dimeCoinButton = new javax.swing.JButton();
        quarterCoinButton = new javax.swing.JButton();
        dollarCoinButton = new javax.swing.JButton();
        coinsTotalTextField = new javax.swing.JTextField();
        coinsClearButton = new javax.swing.JButton();
        coinConfirmButton = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        cardErrorMsgLabel = new javax.swing.JLabel();
        cardNumberLabel = new javax.swing.JLabel();
        cardNumberField = new javax.swing.JTextField();
        accessCodeLabel = new javax.swing.JLabel();
        javax.swing.JTextField accessCodeTextField = new javax.swing.JTextField();
        cardConfirmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        summaryLabel.setText("Total Price in USD : ");

        javax.swing.GroupLayout summaryPanelLayout = new javax.swing.GroupLayout(summaryPanel);
        summaryPanel.setLayout(summaryPanelLayout);
        summaryPanelLayout.setHorizontalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryPanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(summaryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        summaryPanelLayout.setVerticalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(summaryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        paymentOptionsLabel.setText("Select a payment option: ");

        buttonGroup1.add(rbCoins);
        rbCoins.setText("Coins");

        buttonGroup1.add(rbCard);
        rbCard.setText("SmartCal card");

        javax.swing.GroupLayout paymentOptionsPanelLayout = new javax.swing.GroupLayout(paymentOptionsPanel);
        paymentOptionsPanel.setLayout(paymentOptionsPanelLayout);
        paymentOptionsPanelLayout.setHorizontalGroup(
            paymentOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentOptionsPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(paymentOptionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(paymentOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbCoins)
                    .addComponent(rbCard))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paymentOptionsPanelLayout.setVerticalGroup(
            paymentOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentOptionsPanelLayout.createSequentialGroup()
                .addGroup(paymentOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paymentOptionsPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(paymentOptionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paymentOptionsPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(rbCoins)
                        .addGap(18, 18, 18)
                        .addComponent(rbCard)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        nickelCoinButton.setText("Nickel - 5c");

        dimeCoinButton.setText("Dime - 10c");

        quarterCoinButton.setText("Quarter - 25c");

        dollarCoinButton.setText("Dollar - 1$");

        coinsTotalTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coinsTotalTextFieldActionPerformed(evt);
            }
        });

        coinsClearButton.setText("clear");

        coinConfirmButton.setText("Confirm");

        javax.swing.GroupLayout coinsPanelLayout = new javax.swing.GroupLayout(coinsPanel);
        coinsPanel.setLayout(coinsPanelLayout);
        coinsPanelLayout.setHorizontalGroup(
            coinsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coinsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coinsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quarterCoinButton)
                    .addComponent(dollarCoinButton)
                    .addComponent(nickelCoinButton)
                    .addComponent(dimeCoinButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(coinsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coinsPanelLayout.createSequentialGroup()
                        .addComponent(coinsTotalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coinsPanelLayout.createSequentialGroup()
                        .addGroup(coinsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(coinConfirmButton)
                            .addComponent(coinsClearButton))
                        .addGap(39, 39, 39))))
        );
        coinsPanelLayout.setVerticalGroup(
            coinsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coinsPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(coinsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nickelCoinButton)
                    .addComponent(coinsTotalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(coinsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dimeCoinButton)
                    .addComponent(coinsClearButton))
                .addGroup(coinsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coinsPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quarterCoinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dollarCoinButton))
                    .addGroup(coinsPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(coinConfirmButton)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        cardErrorMsgLabel.setText("Error");

        cardNumberLabel.setText("Card Number :");

        accessCodeLabel.setText("Access Code : ");

        cardConfirmButton.setText("Confirm");
        cardConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardConfirmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cardPanelLayout = new javax.swing.GroupLayout(cardPanel);
        cardPanel.setLayout(cardPanelLayout);
        cardPanelLayout.setHorizontalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPanelLayout.createSequentialGroup()
                .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardPanelLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(cardErrorMsgLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(cardPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cardNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accessCodeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accessCodeTextField)
                            .addComponent(cardNumberField))))
                .addContainerGap())
            .addGroup(cardPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(cardConfirmButton)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        cardPanelLayout.setVerticalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardErrorMsgLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accessCodeLabel)
                    .addComponent(accessCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cardConfirmButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paymentPanelLayout = new javax.swing.GroupLayout(paymentPanel);
        paymentPanel.setLayout(paymentPanelLayout);
        paymentPanelLayout.setHorizontalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addComponent(summaryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentPanelLayout.createSequentialGroup()
                        .addComponent(coinsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paymentOptionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        paymentPanelLayout.setVerticalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(summaryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paymentOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coinsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paymentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paymentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void coinsTotalTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coinsTotalTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coinsTotalTextFieldActionPerformed

    private void cardConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardConfirmButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardConfirmButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PaymentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accessCodeLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cardConfirmButton;
    private javax.swing.JLabel cardErrorMsgLabel;
    private javax.swing.JTextField cardNumberField;
    private javax.swing.JLabel cardNumberLabel;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JButton coinConfirmButton;
    private javax.swing.JButton coinsClearButton;
    private javax.swing.JPanel coinsPanel;
    private javax.swing.JTextField coinsTotalTextField;
    private javax.swing.JButton dimeCoinButton;
    private javax.swing.JButton dollarCoinButton;
    private javax.swing.JButton nickelCoinButton;
    private javax.swing.JLabel paymentOptionsLabel;
    private javax.swing.JPanel paymentOptionsPanel;
    private javax.swing.JPanel paymentPanel;
    private javax.swing.JButton quarterCoinButton;
    private javax.swing.JRadioButton rbCard;
    private javax.swing.JRadioButton rbCoins;
    private javax.swing.JLabel summaryLabel;
    // End of variables declaration//GEN-END:variables
}
