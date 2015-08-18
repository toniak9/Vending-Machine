/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.text.DecimalFormat;
/**
 *
 * @author Sruti
 */
public class PaymentGUI extends javax.swing.JFrame {

    private String totalPrice;
    private double coinValue = 0.0;
    Context context;
    /**
     * Creates new form PaymentGUI
     */
    public PaymentGUI() {
     //   initComponents();
    }
    
     public PaymentGUI(String totalPrice) {
         this.totalPrice = totalPrice;
         initComponents();
         performance();
         
    }

     
     public void performance() {
         paymentTextField.setText(totalPrice);
         coinsPanel.setVisible(false);
         cardPanel.setVisible(false);
           
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
        paymentTextField = new javax.swing.JTextField();
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
        coinsMsgLabel = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        cardErrorMsgLabel = new javax.swing.JLabel();
        cardNumberLabel = new javax.swing.JLabel();
        cardNumberField = new javax.swing.JTextField();
        accessCodeLabel = new javax.swing.JLabel();
        cardConfirmButton = new javax.swing.JButton();
        accessCodeTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        summaryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Summary"));

        summaryLabel.setText("Total Price in USD : ");

        javax.swing.GroupLayout summaryPanelLayout = new javax.swing.GroupLayout(summaryPanel);
        summaryPanel.setLayout(summaryPanelLayout);
        summaryPanelLayout.setHorizontalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryPanelLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(summaryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(paymentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        summaryPanelLayout.setVerticalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(summaryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        paymentOptionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Payment Type"));

        paymentOptionsLabel.setText("Select a payment option: ");

        buttonGroup1.add(rbCoins);
        rbCoins.setText("Coins");
        rbCoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCoinsActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbCard);
        rbCard.setText("SmartCal card");
        rbCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCardActionPerformed(evt);
            }
        });

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
                .addContainerGap(18, Short.MAX_VALUE))
        );

        coinsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Coins"));

        nickelCoinButton.setText("Nickel - 5c");
        nickelCoinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickelCoinButtonActionPerformed(evt);
            }
        });

        dimeCoinButton.setText("Dime - 10c");
        dimeCoinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dimeCoinButtonActionPerformed(evt);
            }
        });

        quarterCoinButton.setText("Quarter - 25c");
        quarterCoinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quarterCoinButtonActionPerformed(evt);
            }
        });

        dollarCoinButton.setText("Dollar - 1$");
        dollarCoinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dollarCoinButtonActionPerformed(evt);
            }
        });

        coinsTotalTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coinsTotalTextFieldActionPerformed(evt);
            }
        });

        coinsClearButton.setText("clear");
        coinsClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coinsClearButtonActionPerformed(evt);
            }
        });

        coinConfirmButton.setText("Confirm");
        coinConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coinConfirmButtonActionPerformed(evt);
            }
        });

        coinsMsgLabel.setText("Message");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(coinsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coinsPanelLayout.createSequentialGroup()
                        .addComponent(coinConfirmButton)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coinsPanelLayout.createSequentialGroup()
                        .addComponent(coinsClearButton)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coinsPanelLayout.createSequentialGroup()
                        .addComponent(coinsTotalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coinsPanelLayout.createSequentialGroup()
                        .addComponent(coinsMsgLabel)
                        .addGap(52, 52, 52))))
        );
        coinsPanelLayout.setVerticalGroup(
            coinsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coinsPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(coinsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(coinsPanelLayout.createSequentialGroup()
                        .addComponent(nickelCoinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dimeCoinButton)
                        .addGap(18, 18, 18)
                        .addComponent(quarterCoinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dollarCoinButton))
                    .addGroup(coinsPanelLayout.createSequentialGroup()
                        .addComponent(coinsMsgLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coinsTotalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coinsClearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coinConfirmButton)
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cardPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("SmartCal Card"));

        cardErrorMsgLabel.setText("Message");

        cardNumberLabel.setText("Card Number :");

        accessCodeLabel.setText(" Access Code : ");

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
                .addGap(19, 19, 19)
                .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(accessCodeLabel)
                    .addComponent(cardNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cardNumberField)
                    .addComponent(accessCodeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addGap(23, 23, 23))
            .addGroup(cardPanelLayout.createSequentialGroup()
                .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardPanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(cardConfirmButton))
                    .addGroup(cardPanelLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(cardErrorMsgLabel)))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        cardPanelLayout.setVerticalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cardErrorMsgLabel)
                .addGap(18, 18, 18)
                .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accessCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accessCodeLabel))
                .addGap(18, 18, 18)
                .addComponent(cardConfirmButton)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout paymentPanelLayout = new javax.swing.GroupLayout(paymentPanel);
        paymentPanel.setLayout(paymentPanelLayout);
        paymentPanelLayout.setHorizontalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(summaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addComponent(coinsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(paymentOptionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        paymentPanelLayout.setVerticalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(summaryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paymentOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(coinsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paymentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        double cardNumber = Double.parseDouble(cardNumberField.getText());
        double accessCode = Double.parseDouble(accessCodeTextField.getText());
        context = new Context(new OperationCardVerify());		
        String msg = context.executeStrategy(cardNumber, accessCode,Double.parseDouble(totalPrice));
        cardErrorMsgLabel.setText(msg);
    }//GEN-LAST:event_cardConfirmButtonActionPerformed

    private void rbCoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCoinsActionPerformed
        // TODO add your handling code here:
        if(rbCoins.isSelected()) {
             coinsPanel.setVisible(true);
             cardPanel.setVisible(false);
             coinsTotalTextField.setText(Double.toString(coinValue));
         } 
    }//GEN-LAST:event_rbCoinsActionPerformed

    private void rbCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCardActionPerformed
        // TODO add your handling code here:
        if(rbCard.isSelected()) {
             cardPanel.setVisible(true);
             coinsPanel.setVisible(false);
         }
    }//GEN-LAST:event_rbCardActionPerformed

    private void nickelCoinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nickelCoinButtonActionPerformed
        // TODO add your handling code here:
        
        
        DecimalFormat df = new DecimalFormat("#.##");
        double temp = 0.05 + Double.parseDouble(coinsTotalTextField.getText()) ;
        coinsTotalTextField.setText(df.format(temp));
        
              
    }//GEN-LAST:event_nickelCoinButtonActionPerformed

    private void dimeCoinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dimeCoinButtonActionPerformed
        // TODO add your handling code here:
        DecimalFormat df = new DecimalFormat("#.##");
        double temp = 0.1 + Double.parseDouble(coinsTotalTextField.getText()) ;
        coinsTotalTextField.setText(df.format(temp));
        
    }//GEN-LAST:event_dimeCoinButtonActionPerformed

    private void quarterCoinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quarterCoinButtonActionPerformed
        // TODO add your handling code here:
        DecimalFormat df = new DecimalFormat("#.##");
        double temp = 0.25 + Double.parseDouble(coinsTotalTextField.getText()) ;
        coinsTotalTextField.setText(df.format(temp));
        
    }//GEN-LAST:event_quarterCoinButtonActionPerformed

    private void dollarCoinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dollarCoinButtonActionPerformed
        // TODO add your handling code here:
        DecimalFormat df = new DecimalFormat("#.##");
        double temp = 1 + Double.parseDouble(coinsTotalTextField.getText()) ;
        coinsTotalTextField.setText(df.format(temp));
        
    }//GEN-LAST:event_dollarCoinButtonActionPerformed

    private void coinsClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coinsClearButtonActionPerformed
        // TODO add your handling code here:
        double temp = 0.0;
        DecimalFormat df = new DecimalFormat("#.##");
        coinsTotalTextField.setText((df.format(temp)));
    }//GEN-LAST:event_coinsClearButtonActionPerformed

    private void coinConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coinConfirmButtonActionPerformed
        // TODO add your handling code here:
        context = new Context(new OperationCoinsVerify());
        double coinsValue = Double.parseDouble(coinsTotalTextField.getText());
        double temp = 0.0;
        String msg = context.executeStrategy(Double.parseDouble(totalPrice), coinsValue, temp);
        coinsMsgLabel.setText(msg);

        
    }//GEN-LAST:event_coinConfirmButtonActionPerformed

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
                // new PaymentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accessCodeLabel;
    private javax.swing.JTextField accessCodeTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cardConfirmButton;
    private javax.swing.JLabel cardErrorMsgLabel;
    private javax.swing.JTextField cardNumberField;
    private javax.swing.JLabel cardNumberLabel;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JButton coinConfirmButton;
    private javax.swing.JButton coinsClearButton;
    private javax.swing.JLabel coinsMsgLabel;
    private javax.swing.JPanel coinsPanel;
    private javax.swing.JTextField coinsTotalTextField;
    private javax.swing.JButton dimeCoinButton;
    private javax.swing.JButton dollarCoinButton;
    private javax.swing.JButton nickelCoinButton;
    private javax.swing.JLabel paymentOptionsLabel;
    private javax.swing.JPanel paymentOptionsPanel;
    private javax.swing.JPanel paymentPanel;
    private javax.swing.JTextField paymentTextField;
    private javax.swing.JButton quarterCoinButton;
    private javax.swing.JRadioButton rbCard;
    private javax.swing.JRadioButton rbCoins;
    private javax.swing.JLabel summaryLabel;
    // End of variables declaration//GEN-END:variables
}
