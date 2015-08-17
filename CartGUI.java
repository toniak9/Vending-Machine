/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


/**
 *
 * @author Sruti
 */
public class CartGUI extends javax.swing.JFrame {

    /**
     * Creates new form CartGUI
     */
     DefaultTableModel model = new DefaultTableModel();
     DefaultTableModel model3 = null;
     DefaultTableModel model1 = null;

     private JTable outputTable;
     private JTable wishListTable;
     private JTable nutritionalFactsTable;
     
  
     double totalPrice = 0.0;
     List userRequirements;
    
     public CartGUI() {
         //initComponents();
     }
     
    public CartGUI(List userRequirements) {
        initComponents();
        this.userRequirements = userRequirements;
        addJTable(); 
        
      /*  JScrollPane cartScrollpane = new JScrollPane();
        cartScrollpane.setPreferredSize(new Dimension(200, 200));
        cartPanel.setLayout(new BorderLayout());
        cartPanel.add(cartScrollpane, BorderLayout.CENTER); */
       
    }

    private static class JTableButtonRenderer implements TableCellRenderer {        
        @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton)value;
            return button;  
        }
    }
    
    private static class JTableComboBoxRenderer implements TableCellRenderer {        
        @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JComboBox combobox = (JComboBox)value;
            return combobox;  
        }
    }
  
     
   
     public void addJTable() {
        //System.out.println("In cart GUI");
        //System.out.println(userRequirements);
         outputTable = new JTable(model);
         outputPanel.setSize(new Dimension(100, 100));
         model.addColumn("ItemCode");
         model.addColumn("ItemName");
         model.addColumn("Price");
         model.addColumn("Nutritional Values");

         
        Iterator<HashMap> iterator = userRequirements.iterator();
	while (iterator.hasNext()) {
            HashMap hashRow = iterator.next();
            JButton cbView = new JButton("View");
            TableCellRenderer buttonRenderer = new JTableButtonRenderer();
           // outputTable.getColumn("Button2").setCellRenderer(buttonRenderer);
            
            Vector row = new Vector();
            row.add(hashRow.get("itemCode"));
            row.add(hashRow.get("itemName"));
            row.add(hashRow.get("itemCost"));
            row.add("view"); 
            Action view = new AbstractAction() {
                public void actionPerformed(ActionEvent e)
                {
                    
                //  System.out.println("Button action performed:" +e.getSource());
                    JTable table = (JTable)e.getSource();
                    int modelRow = Integer.valueOf(e.getActionCommand());
                   
                    

                    // Selected Row, column 1 (itemCode)
                     addJTable2((long)table.getValueAt(modelRow, 0));                     
                }
            };
            ButtonColumn buttonColumn = new ButtonColumn(outputTable, view, 3);
            // buttonColumn.setMnemonic(KeyEvent.VK_D);
          
            
            model.addRow(row);
	}
        
        JScrollPane outputScrollpane = new JScrollPane(outputTable);
    	// create a window
        outputScrollpane.setPreferredSize(new Dimension(500, 200));
    	outputPanel.setLayout(new BorderLayout());
    	outputPanel.add(outputScrollpane, BorderLayout.CENTER);
        outputPanel.revalidate();

     }
     
     public void addJTable2(long itemCode) {
         if (model1 == null) {
            model1 = new DefaultTableModel();
            model1.addColumn("Nutritional Facts");
            model1.addColumn("Values");
         } else {
            model1.removeRow(0);
            model1.removeRow(0);
            model1.removeRow(0);
         }
        nutritionalFactsTable = new JTable(model1);
        
        Iterator<HashMap> iterator2 = userRequirements.iterator();
	while (iterator2.hasNext()) {
            HashMap hashRow = iterator2.next();
            Set<String> keys = hashRow.keySet();
            for(String key: keys){
                if(key.equals("itemCode") && (Long)hashRow.get(key) == itemCode) {
                    Vector row = new Vector();
                    
                    row.add("Calories");
                    row.add(hashRow.get("itemCalories"));
                    model1.addRow(row);
                    
                    Vector row1 = new Vector();
                    row1.add("Sugars");
                    row1.add(hashRow.get("itemSugars"));
                    model1.addRow(row1);
                    
                    Vector row2 = new Vector();
                    row2.add("Fat");
                    row2.add(hashRow.get("itemFat"));
                    model1.addRow(row2);
                    
                    break;
                    
                }
            }
        }
        
        model1.fireTableDataChanged();
        
        JScrollPane nutritionsScrollpane = new JScrollPane(nutritionalFactsTable);
        nutritionsScrollpane.setPreferredSize(new Dimension(100, 200));
        nutritionalFactsPanel.setLayout(new BorderLayout());
        nutritionalFactsPanel.add(nutritionsScrollpane, BorderLayout.CENTER);
        nutritionalFactsPanel.revalidate();
       
    } 
     
    
     public void addJTable3(long guiCode) {
         String [] values = {"1", "2", "3","4","5"};
         
         if (model3 == null) {
            model3 = new DefaultTableModel();
            model3.addColumn("ItemCode");
            model3.addColumn("ItemName");
            model3.addColumn("Qunatity");
            model3.addColumn("Price");
            model3.addColumn("Remove");

         } 
         wishListTable = new JTable(model3);
         
         Iterator<HashMap> iterator = userRequirements.iterator();
	 while (iterator.hasNext()) {
            HashMap hashRow = iterator.next();
            
            
            long code =(long) hashRow.get("itemCode");
         // System.out.println("code is"+code);
            Vector row = new Vector();
            if(code == guiCode) {
                row.add(hashRow.get("itemCode"));
                row.add(hashRow.get("itemName"));
                row.add("");
                row.add("$"+ hashRow.get("itemCost"));
                row.add("delete");
               
                model3.addRow(row);
                
               
                String a = (String)wishListTable.getValueAt((wishListTable.getRowCount()-1), 3);
                a = a.substring(1);
                totalPrice = totalPrice + Double.parseDouble(a);
                checkoutTextField.setText(Double.toString(totalPrice));
                TableCellRenderer buttonRenderer = new JTableButtonRenderer();
                Action delete = new AbstractAction() {
                    public void actionPerformed(ActionEvent e)
                    {
                        JTable table = (JTable)e.getSource();
                        int modelRow = Integer.valueOf(e.getActionCommand()); 

                        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
                        
                        totalPrice = 0;
                        for(int i = 0; i < table.getRowCount(); i++) {
                            String a = (String)table.getValueAt(i, 3);
                            totalPrice = totalPrice + Double.parseDouble(a.substring(1));
                        }
                        checkoutTextField.setText(Double.toString(totalPrice));
                    }
                };
                ButtonColumn buttonColumn = new ButtonColumn(wishListTable, delete, 4);

                /* jCombo Action */
                ComboColumn comboColumn = null;
                TableCellRenderer comboRenderer = new JTableComboBoxRenderer();
                Action update;
                update = new AbstractAction() {
                    public void actionPerformed(ActionEvent e)
                    {
                        // System.out.println("Combo action performed:" +e);
                        JTable table = (JTable)e.getSource();
                       // System.out.println("Table row is: " + table.getSelectedRow());
                        
                        // Selected Row, column 3 (itemCode)
                        long itemCode = (long) table.getValueAt(table.getSelectedRow(), 0);
                        // System.out.println("Quantity:" + e.getModifiers());
                        Iterator<HashMap> iterator = userRequirements.iterator();
                        while (iterator.hasNext()) {
                            HashMap hashRow = iterator.next();
                            if (itemCode == (long) hashRow.get("itemCode")) {
                                double price = ((double)hashRow.get("itemCost")) * e.getModifiers();
                                table.setValueAt("$"+price, table.getSelectedRow(), 3);
                                model3.fireTableCellUpdated(table.getSelectedRow(), 3);
                               
                                totalPrice = 0;
                                for(int i = 0; i < table.getRowCount(); i++) {
                                    String a = (String)table.getValueAt(i, 3);
                                    totalPrice = totalPrice + Double.parseDouble(a.substring(1));

                                }
                                checkoutTextField.setText(Double.toString(totalPrice));
                                break; 
                            }
                            
                        }
                    }
                };
                comboColumn = new ComboColumn(wishListTable, update, 2, values);
                break;
         
            } 
        }
         
            
         
        JScrollPane wishListScrollpane = new JScrollPane(wishListTable);
        wishListScrollpane.setPreferredSize(new Dimension(500, 200));
    	wishListPanel.setLayout(new BorderLayout());
    	wishListPanel.add(wishListScrollpane, BorderLayout.CENTER);
        wishListPanel.revalidate();
        
        keyPadTextField.setText("");
        
       
     }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cartPanel = new javax.swing.JPanel();
        outputPanel = new javax.swing.JPanel();
        wishListPanel = new javax.swing.JPanel();
        keyPadPanel = new javax.swing.JPanel();
        keyPadTextField = new javax.swing.JTextField();
        Button1 = new javax.swing.JButton();
        Button2 = new javax.swing.JButton();
        Button3 = new javax.swing.JButton();
        ButtonX = new javax.swing.JButton();
        Button4 = new javax.swing.JButton();
        Button5 = new javax.swing.JButton();
        Button7 = new javax.swing.JButton();
        Button6 = new javax.swing.JButton();
        Button8 = new javax.swing.JButton();
        Button9 = new javax.swing.JButton();
        Button0 = new javax.swing.JButton();
        ButtonADD = new javax.swing.JButton();
        nutritionalFactsPanel = new javax.swing.JPanel();
        checkoutPanel = new javax.swing.JPanel();
        checkoutLabel = new javax.swing.JLabel();
        checkoutTextField = new javax.swing.JTextField();
        CheckoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        outputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Suggestion List"));

        javax.swing.GroupLayout outputPanelLayout = new javax.swing.GroupLayout(outputPanel);
        outputPanel.setLayout(outputPanelLayout);
        outputPanelLayout.setHorizontalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        outputPanelLayout.setVerticalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        wishListPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Wish List"));

        javax.swing.GroupLayout wishListPanelLayout = new javax.swing.GroupLayout(wishListPanel);
        wishListPanel.setLayout(wishListPanelLayout);
        wishListPanelLayout.setHorizontalGroup(
            wishListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );
        wishListPanelLayout.setVerticalGroup(
            wishListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        keyPadPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("KeyPad"));

        Button1.setText("1");
        Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button1ActionPerformed(evt);
            }
        });

        Button2.setText("2");
        Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button2ActionPerformed(evt);
            }
        });

        Button3.setText("3");
        Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button3ActionPerformed(evt);
            }
        });

        ButtonX.setText("X");
        ButtonX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonXActionPerformed(evt);
            }
        });

        Button4.setText("4");
        Button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button4ActionPerformed(evt);
            }
        });

        Button5.setText("5");
        Button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button5ActionPerformed(evt);
            }
        });

        Button7.setText("7");
        Button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button7ActionPerformed(evt);
            }
        });

        Button6.setText("6");
        Button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button6ActionPerformed(evt);
            }
        });

        Button8.setText("8");
        Button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button8ActionPerformed(evt);
            }
        });

        Button9.setText("9");
        Button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button9ActionPerformed(evt);
            }
        });

        Button0.setText("0");
        Button0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button0ActionPerformed(evt);
            }
        });

        ButtonADD.setText("ADD");
        ButtonADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonADDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout keyPadPanelLayout = new javax.swing.GroupLayout(keyPadPanel);
        keyPadPanel.setLayout(keyPadPanelLayout);
        keyPadPanelLayout.setHorizontalGroup(
            keyPadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyPadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(keyPadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(keyPadPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(keyPadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(keyPadPanelLayout.createSequentialGroup()
                                .addGroup(keyPadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(keyPadPanelLayout.createSequentialGroup()
                                        .addComponent(Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(keyPadPanelLayout.createSequentialGroup()
                                        .addComponent(Button4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Button5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(keyPadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Button6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(keyPadPanelLayout.createSequentialGroup()
                                .addComponent(Button0, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButtonX, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonADD, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(keyPadPanelLayout.createSequentialGroup()
                                .addComponent(Button7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(Button8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(keyPadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        keyPadPanelLayout.setVerticalGroup(
            keyPadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyPadPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(keyPadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(keyPadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button1)
                    .addComponent(Button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(keyPadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button4)
                    .addComponent(Button5)
                    .addComponent(Button6))
                .addGap(10, 10, 10)
                .addGroup(keyPadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button7)
                    .addComponent(Button8)
                    .addComponent(Button9))
                .addGap(11, 11, 11)
                .addGroup(keyPadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button0)
                    .addComponent(ButtonX)
                    .addComponent(ButtonADD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(189, 189, 189))
        );

        nutritionalFactsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Nutritional Facts"));

        javax.swing.GroupLayout nutritionalFactsPanelLayout = new javax.swing.GroupLayout(nutritionalFactsPanel);
        nutritionalFactsPanel.setLayout(nutritionalFactsPanelLayout);
        nutritionalFactsPanelLayout.setHorizontalGroup(
            nutritionalFactsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        nutritionalFactsPanelLayout.setVerticalGroup(
            nutritionalFactsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );

        checkoutPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Checkout"));

        checkoutLabel.setText("Total Cost in USD :");

        CheckoutButton.setText("CheckOut");
        CheckoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout checkoutPanelLayout = new javax.swing.GroupLayout(checkoutPanel);
        checkoutPanel.setLayout(checkoutPanelLayout);
        checkoutPanelLayout.setHorizontalGroup(
            checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutPanelLayout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(checkoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(checkoutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CheckoutButton)
                .addContainerGap())
        );
        checkoutPanelLayout.setVerticalGroup(
            checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckoutButton)
                    .addComponent(checkoutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cartPanelLayout = new javax.swing.GroupLayout(cartPanel);
        cartPanel.setLayout(cartPanelLayout);
        cartPanelLayout.setHorizontalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cartPanelLayout.createSequentialGroup()
                        .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(outputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wishListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nutritionalFactsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(keyPadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(checkoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        cartPanelLayout.setVerticalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nutritionalFactsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wishListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keyPadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(checkoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button1ActionPerformed
        // TODO add your handling code here:
       keyPadTextField.setText(keyPadTextField.getText()+"1");
    }//GEN-LAST:event_Button1ActionPerformed

    private void Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button2ActionPerformed
        // TODO add your handling code here:
         keyPadTextField.setText(keyPadTextField.getText()+"2");
    }//GEN-LAST:event_Button2ActionPerformed

    private void Button0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button0ActionPerformed
        // TODO add your handling code here:
         keyPadTextField.setText(keyPadTextField.getText()+"0");
    }//GEN-LAST:event_Button0ActionPerformed

    private void Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button3ActionPerformed
        // TODO add your handling code here:
         keyPadTextField.setText(keyPadTextField.getText()+"3");
    }//GEN-LAST:event_Button3ActionPerformed

    private void Button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button4ActionPerformed
        // TODO add your handling code here:
         keyPadTextField.setText(keyPadTextField.getText()+"4");
    }//GEN-LAST:event_Button4ActionPerformed

    private void Button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button5ActionPerformed
        // TODO add your handling code here:
         keyPadTextField.setText(keyPadTextField.getText()+"5");
    }//GEN-LAST:event_Button5ActionPerformed

    private void Button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button6ActionPerformed
        // TODO add your handling code here:
         keyPadTextField.setText(keyPadTextField.getText()+"6");
    }//GEN-LAST:event_Button6ActionPerformed

    private void Button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button7ActionPerformed
        // TODO add your handling code here:
         keyPadTextField.setText(keyPadTextField.getText()+"7");
    }//GEN-LAST:event_Button7ActionPerformed

    private void Button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button8ActionPerformed
        // TODO add your handling code here:
         keyPadTextField.setText(keyPadTextField.getText()+"8");
    }//GEN-LAST:event_Button8ActionPerformed

    private void Button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button9ActionPerformed
        // TODO add your handling code here:
         keyPadTextField.setText(keyPadTextField.getText()+"9");
    }//GEN-LAST:event_Button9ActionPerformed

    private void ButtonXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonXActionPerformed
        // TODO add your handling code here:
        keyPadTextField.setText("");
    }//GEN-LAST:event_ButtonXActionPerformed

    private void ButtonADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonADDActionPerformed
        // TODO add your handling code here:
       long guiCode = Long.parseLong(keyPadTextField.getText());
     //  System.out.println("guicode"+guiCode);
       addJTable3(guiCode);
       
      
       
    }//GEN-LAST:event_ButtonADDActionPerformed

    private void CheckoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutButtonActionPerformed
        // TODO add your handling code here:
        new PaymentGUI(checkoutTextField.getText()).setVisible(true);
                
    }//GEN-LAST:event_CheckoutButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new CartGUI().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button0;
    private javax.swing.JButton Button1;
    private javax.swing.JButton Button2;
    private javax.swing.JButton Button3;
    private javax.swing.JButton Button4;
    private javax.swing.JButton Button5;
    private javax.swing.JButton Button6;
    private javax.swing.JButton Button7;
    private javax.swing.JButton Button8;
    private javax.swing.JButton Button9;
    private javax.swing.JButton ButtonADD;
    private javax.swing.JButton ButtonX;
    private javax.swing.JButton CheckoutButton;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JLabel checkoutLabel;
    private javax.swing.JPanel checkoutPanel;
    private javax.swing.JTextField checkoutTextField;
    private javax.swing.JPanel keyPadPanel;
    private javax.swing.JTextField keyPadTextField;
    private javax.swing.JPanel nutritionalFactsPanel;
    private javax.swing.JPanel outputPanel;
    private javax.swing.JPanel wishListPanel;
    // End of variables declaration//GEN-END:variables
}
