/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.Business;
import Business.Customer.Customer;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.Organization;
import Business.Product.Product;
import Business.UserAcount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class BrowseProductCatalog extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Business business;
    private Customer customer;
    private Order order;
    // private SaleOrganization saleOrganization;

    /**
     * Creates new form BrowseProductCatalog
     */
    public BrowseProductCatalog(JPanel userProcessContainer, Business business, Customer customer) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.customer = customer;

        SaleComboBox.removeAllItems();

        for (Organization organization : business.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                if (organization.getName().equals("Sale Organization")) {
                    SaleComboBox.addItem(userAccount.getSale().getName());
                }
            }

        }
        populateProductTable();
        populateOrderTable();
    }

    public void populateProductTable() {
        DefaultTableModel dtm = (DefaultTableModel) ProductTable.getModel();
        dtm.setRowCount(0);
        for (Product p : business.getInventory().getProductList()) {
            Object row[] = new Object[4];
            row[0] = p;
            row[1] = p.getModelNumber();
            row[2] = p.getCeilingPrice();
            row[3] = p.getAvailablity();

            dtm.addRow(row);
        }
    }

    public void populateOrderTable() {
        int rowCount = OrderTable.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) OrderTable.getModel()).removeRow(i);
        }
        DefaultTableModel dtm = (DefaultTableModel) OrderTable.getModel();
        dtm.setRowCount(0);
        for (OrderItem oi : customer.getCustomerWishOrder().getCustomerWishList()) {
            Object row[] = new Object[4];
            row[0] = oi;
            row[1] = oi.getSalesPrice();
            row[2] = oi.getQuantity();
            row[3] = oi.getSalesPrice() * oi.getQuantity();

            dtm.addRow(row);
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
        jLabel4 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnViewItem = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        ModifySpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        txtWishPrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        quantitySpinner = new javax.swing.JSpinner();
        btnAdd = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        SaleComboBox = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel1.setText("Welcome to Buy");

        jLabel4.setText("Item in Cart");

        btnSearch.setText("Search Product by ID");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel5.setText("All Product");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnViewItem.setText("View Item");
        btnViewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewItemActionPerformed(evt);
            }
        });

        btnView.setText("View Details");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        jLabel2.setText("Wish Price");

        btnRemove.setText("Remove Item");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantity");

        btnAdd.setText("Add to Cart");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnModify.setText("Modify Quantity");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Name", "Wish Price", "Quantity", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(OrderTable);

        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "ID", "Price", "Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ProductTable);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit Order to");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        SaleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaleComboBoxActionPerformed(evt);
            }
        });

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel6.setText("(Sales)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                .addComponent(btnSubmit)
                .addGap(18, 18, 18)
                .addComponent(SaleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(58, 58, 58))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearch)
                            .addGap(18, 18, 18)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancel))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnView)
                            .addGap(31, 31, 31)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtWishPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd)
                            .addGap(20, 20, 20))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnViewItem)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                            .addComponent(btnModify)
                            .addGap(18, 18, 18)
                            .addComponent(ModifySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56)
                            .addComponent(btnRemove)
                            .addGap(24, 24, 24))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(28, 28, 28)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 427, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(SaleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack)
                    .addComponent(jLabel6))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancel))
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnView)
                        .addComponent(jLabel2)
                        .addComponent(txtWishPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd))
                    .addGap(26, 26, 26)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnViewItem)
                        .addComponent(ModifySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRemove)
                        .addComponent(btnModify))
                    .addContainerGap(58, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        int keyWord = Integer.parseInt(txtSearch.getText());
        int rowCount = ProductTable.getRowCount();
        DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        for (Product p : business.getInventory().getProductList()) {
            if (keyWord == p.getModelNumber()) {
                Object row[] = new Object[4];
                row[0] = p;
                row[1] = p.getModelNumber();
                row[2] = p.getCeilingPrice();
                row[3] = p.getAvailablity();

                model.addRow(row);
            }
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnViewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewItemActionPerformed
        int selectedRow = OrderTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first to view detail", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            OrderItem orderItem = (OrderItem) OrderTable.getValueAt(selectedRow, 0);
            ViewItemDetailJPanel panel = new ViewItemDetailJPanel(userProcessContainer, orderItem);
            userProcessContainer.add("ViewItem", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnViewItemActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        int selectedRow = ProductTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first to view detail", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            Product product = (Product) ProductTable.getValueAt(selectedRow, 0);
            ViewProductDetailJPanel panel = new ViewProductDetailJPanel(userProcessContainer, product);
            userProcessContainer.add("ViewProduct", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int selectedRowCount = OrderTable.getSelectedRowCount();
        if (selectedRowCount <= 0) {
            JOptionPane.showMessageDialog(null, "You didn't select any rows from the orderItem table!");
            return;
        }

        int row = OrderTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Failed to retrive selected row");
            return;
        }

        OrderItem orderItem = (OrderItem) OrderTable.getValueAt(row, 0);
        int originalQuan = orderItem.getProduct().getAvailablity();
        int orderItemQuan = orderItem.getQuantity();
        int newQuan = originalQuan + orderItemQuan;
        orderItem.getProduct().setAvailablity(newQuan);
        customer.getCustomerWishOrder().deleteCustomerWishOrder(orderItem);
        JOptionPane.showMessageDialog(null, "The order item of " + orderItemQuan + "of " + orderItem + " has been removed.");
        populateOrderTable();
        populateProductTable();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int selectedRow = ProductTable.getSelectedRow();
        Product selectedProduct;
        int salesPrice = 0;
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Select a row", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            selectedProduct = (Product) ProductTable.getValueAt(selectedRow, 0);
        }

        try {
            salesPrice = Integer.parseInt(txtWishPrice.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Enter valid sales price", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (salesPrice < selectedProduct.getFloorPrice()) {
            JOptionPane.showMessageDialog(this, "Sales Price should be more actual", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int origialQ = (Integer) quantitySpinner.getValue();
        if (origialQ <= 0) {
            JOptionPane.showMessageDialog(this, "Selected atlest 1 quantity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (origialQ <= selectedProduct.getAvailablity()) {
            boolean isPresent = false;
            for (OrderItem orderItem : customer.getCustomerWishOrder().getCustomerWishList()) {
                if (orderItem.getProduct() == selectedProduct) {
                    int oldAvail = selectedProduct.getAvailablity();
                    int newAvail = oldAvail - origialQ;
                    selectedProduct.setAvailablity(newAvail);
                    orderItem.setQuantity(origialQ + orderItem.getQuantity());
                    isPresent = true;
                    populateOrderTable();
                    populateProductTable();

                    txtWishPrice.setText("");
                    break;
                }
            }

            if (!isPresent) {
                int oldAvail = selectedProduct.getAvailablity();
                int newAvail = oldAvail - origialQ;
                selectedProduct.setAvailablity(newAvail);
                customer.getCustomerWishOrder().addCustomerWishOrder(selectedProduct, origialQ, salesPrice);

                populateOrderTable();
                populateProductTable();
                txtWishPrice.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Quantity > Availability!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        int selectedRow = OrderTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Select a row", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!ModifySpinner.getValue().equals("0")) {
            OrderItem orderItem = (OrderItem) OrderTable.getValueAt(selectedRow, 0);
            int currentAvail = orderItem.getProduct().getAvailablity();
            int oldQuan = orderItem.getQuantity();
            int newQuan = (Integer) ModifySpinner.getValue();
            if (newQuan > (currentAvail + oldQuan)) {
                JOptionPane.showMessageDialog(null, "Quantity is more than the availability");

            } else {
                if (newQuan <= 0) {
                    JOptionPane.showMessageDialog(null, "Invalid quantity");
                    return;
                }
                orderItem.setQuantity(newQuan);
                orderItem.getProduct().setAvailablity(currentAvail + (oldQuan - newQuan));
                populateOrderTable();
                populateProductTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Quantity cannot be zero!!");
        }
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        populateProductTable();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (customer.getCustomerWishOrder().getCustomerWishList().size() > 0) {

            for (Organization organization : business.getOrganizationDirectory().getOrganizationList()) {
                for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                    if (organization.getName().equals("Sale Organization")) {
                        if (SaleComboBox.getSelectedItem().equals(userAccount.getSale().getName())) {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to submit Sale " + userAccount.getSale().getName() + " this order?", "Information", dialogButton);
                            if (dialogResult == JOptionPane.YES_OPTION) {
                                order = new Order();
                                order.setStatus("Initilization");
                                order.setCustomer(customer);
                                order.setSale(userAccount.getSale());

                                for (OrderItem oI : customer.getCustomerWishOrder().getCustomerWishList()) {
                                    order.getOrderItemList().add(oI);

                                }

                                business.getOrderCatalog().addOrder(order);
                                customer.getOrderCatalog().addCustomerOrder(order);
                                userAccount.getSale().getSaleOrderCatalog().addSaleOrder(order);
                                customer.getCustomerWishOrder().getCustomerWishList().clear();

                                populateOrderTable();
                                JOptionPane.showMessageDialog(null, "Submit Successfully!!");
                            }
                            break;
                        }
                    }

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Order not added as there are no items!!");
        }


    }//GEN-LAST:event_btnSubmitActionPerformed

    private void SaleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaleComboBoxActionPerformed

    }//GEN-LAST:event_SaleComboBoxActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);// TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner ModifySpinner;
    private javax.swing.JTable OrderTable;
    private javax.swing.JTable ProductTable;
    private javax.swing.JComboBox<String> SaleComboBox;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnViewItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtWishPrice;
    // End of variables declaration//GEN-END:variables
}
