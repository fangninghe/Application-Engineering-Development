/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Sale;

import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Order.SaleOrderCatalog;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class ServeCustomerJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private SaleOrderCatalog saleOrderCatalog;
    private Order order;

    /**
     * Creates new form ServeCustomerJPanel
     */
    public ServeCustomerJPanel(JPanel userProcessContainer, SaleOrderCatalog saleOrderCatalog) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.saleOrderCatalog = saleOrderCatalog;
        populateOrderTable();
    }
    
    public void populateOrderTable() {
        int i = 1;
        DefaultTableModel dtm = (DefaultTableModel) OrderTable.getModel();
        dtm.setRowCount(0);
        for (Order o : saleOrderCatalog.getSaleOrderCatalog()) {
            Object row[] = new Object[4];
            row[0] = i;
            row[1] = o;
            row[2] = o.getCustomer().getName() + " ( " + o.getCustomer().getStatus() + " )";
            row[3] = o.getStatus();

            dtm.addRow(row);
            i++;
        }
    }
    
    public void populateOrderItemTable(Order order) {
        OrderItemTable.setEnabled(true);
        DefaultTableModel dtm = (DefaultTableModel) OrderItemTable.getModel();
        dtm.setRowCount(0);
        for (OrderItem oi : order.getOrderItemList()) {
            Object row[] = new Object[4];
            row[0] = oi;
            row[1] = oi.getSalesPrice();
            row[2] = oi.getQuantity();
            row[3] = oi.getProduct().getTargetPrice();

            dtm.addRow(row);
        }
        if (order.getStatus().equals("Finished") || order.getStatus().equals("Cancel")) {
            OrderItemTable.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        OrderItemTable = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();
        btnReply = new javax.swing.JButton();
        btnAdjust = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel1.setText("Order List");

        jLabel2.setText("Order Item");

        OrderItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Wish Price", "Quantity", "Target Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(OrderItemTable);

        btnView.setText("View Detials");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order Number", "Order Id", "Customer", "Satus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(OrderTable);

        btnReply.setText("Reply");
        btnReply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplyActionPerformed(evt);
            }
        });

        btnAdjust.setText("Adjust");
        btnAdjust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdjustActionPerformed(evt);
            }
        });

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCheckOut.setText("Check Out");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnView)
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(332, Short.MAX_VALUE)
                        .addComponent(btnAdjust)
                        .addGap(33, 33, 33)
                        .addComponent(btnReply))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheckOut)
                        .addGap(49, 49, 49)))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnView)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdjust)
                    .addComponent(btnReply))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckOut)
                    .addComponent(btnBack))
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        int selectedRow = OrderTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first to view detail", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            order = (Order) OrderTable.getValueAt(selectedRow, 1);
            if (order != null) {
                populateOrderItemTable(order);
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnReplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplyActionPerformed
        int selectedRow = OrderTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first to view detail", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            Order order = (Order) OrderTable.getValueAt(selectedRow, 1);
            if (order.getStatus().equals("Finished")) {
                JOptionPane.showMessageDialog(null, "The order is done!!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (order.getStatus().equals("Cancel")) {
                JOptionPane.showMessageDialog(null, "The order is canceled already!!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure to submit the order?", "Information", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    order.setStatus("Reconsider");
                    populateOrderTable();
                }
            }
        }// TODO add your handling code here:.
    }//GEN-LAST:event_btnReplyActionPerformed

    private void btnAdjustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjustActionPerformed
        int selectedRow = OrderItemTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first to view detail", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            OrderItem orderItem = (OrderItem) OrderItemTable.getValueAt(selectedRow, 0);
            OrderItemJPanel panel = new OrderItemJPanel(userProcessContainer, order, orderItem);
            userProcessContainer.add("ViewOrderItem", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnAdjustActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);// TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        int selectedRow = OrderTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first to view detail", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            Order orderCheck = (Order) OrderTable.getValueAt(selectedRow, 1);
            if (orderCheck.getStatus().equals("Finished")) {
                JOptionPane.showMessageDialog(null, "The order is done!!", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (orderCheck.getStatus().equals("Cancle")) {
                JOptionPane.showMessageDialog(null, "The order is canceled already!!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure to submit the order?", "Information", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {

                    orderCheck.setStatus("Finished");
                    int aboveTarget = 0, belowTarget = 0;
                    for (OrderItem orderItem : orderCheck.getOrderItemList()) {
                        orderItem.getProduct().addProfit(orderItem.getQuantity() * orderItem.getSalesPrice());
                        if (orderItem.getSalesPrice() > orderItem.getProduct().getTargetPrice()) {
                            aboveTarget += orderItem.getQuantity();
                        }
                        if (orderItem.getSalesPrice() < orderItem.getProduct().getTargetPrice()) {
                            belowTarget += orderItem.getQuantity();
                        }
                        orderCheck.getSale().aboveTarget(aboveTarget);
                        orderCheck.getSale().belowTarget(belowTarget);
                        orderCheck.calculateAmount();
                        orderCheck.getSale().Profit(orderCheck.getAmount());
                        orderCheck.getCustomer().Consume(orderCheck.getAmount());
                    }
                    populateOrderTable();
                    populateOrderItemTable(order);
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCheckOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable OrderItemTable;
    private javax.swing.JTable OrderTable;
    private javax.swing.JButton btnAdjust;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnReply;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
