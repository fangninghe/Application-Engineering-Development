/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Admin;

import Business.Activity.Activity;
import Business.Business;
import Business.Customer.Customer;
import Business.DB40Util.DB4OUtil;
import Business.Employee.Admin;
import Business.Employee.Employee;
import Business.Employee.Sale;
import Business.Employee.Security;
import Business.Organization.CustomerOrganization;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Session.Session;
import Business.UserAcount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class ManageUserJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Business business;
    //private SaleOrganization saleOrganization;
    private Organization organization;

    private UserAccount userAccount;
    private DB4OUtil dB4OUtil;

    /**
     * Creates new form ManageUserJPanel
     */
    public ManageUserJPanel(JPanel userProcessContainer, Business business, UserAccount userAccount, DB4OUtil dB4OUtil) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;

        this.userAccount = userAccount;
        this.dB4OUtil = dB4OUtil;

        populateChooseOrganizationCombox();
        populateOrganizationCombox();

        populateUserTable();
    }

    private void populateChooseOrganizationCombox() {
        ChooseOrganizationComboBox.removeAllItems();
        for (Organization organization : business.getOrganizationDirectory().getOrganizationList()) {
            ChooseOrganizationComboBox.addItem(organization);
        }
    }

    private void populateRoleCombox(Organization organization) {
        roleComboBox.removeAllItems();
        for (Role role : organization.getSupportedRole()) {
            roleComboBox.addItem(role);
        }
    }

    private void populateEmployeeComBox(Organization organization) {
        employeeComboBox.removeAllItems();
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
            employeeComboBox.addItem(employee);
        }
    }

    private void populateCustomerBox(CustomerOrganization customerOrganization) {
        customerComboBox.removeAllItems();
        for (Customer customer : customerOrganization.getCustomerDirectory().getCustomerList()) {
            customerComboBox.addItem(customer);
        }
    }

    private void populateUserTable() {
        DefaultTableModel model = (DefaultTableModel) UserTable.getModel();
        model.setRowCount(0);

        for (Organization organization : business.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[3];
                row[0] = ua;
                row[1] = ua.getRole();
                row[2] = "Inacitve";
                if (ua.isIsActive()) {
                    row[2] = "Active";
                }
                color(UserTable);
                model.addRow(row);
            }
        }
    }

    public void populateUserTable(Organization organization) {
        DefaultTableModel model = (DefaultTableModel) UserTable.getModel();
        model.setRowCount(0);

        //for (Organization o : business.getOrganizationDirectory().getOrganizationList()) {
        for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
            Object row[] = new Object[3];
            row[0] = ua;
            row[1] = ua.getRole();
            row[2] = "Inacitve";
            if (ua.isIsActive()) {
                row[2] = "Active";
            }
            color(UserTable);
            model.addRow(row);
        }
        // }
    }

    private void populateOrganizationCombox() {
        OrganizationComboBox.removeAllItems();
        for (Organization organization : business.getOrganizationDirectory().getOrganizationList()) {
            OrganizationComboBox.addItem(organization);
        }
    }

    private void color(JTable table) {
        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table,
                        Object value, boolean isSelected, boolean hasFocus,
                        int row, int column) {
                    if (table.getValueAt(row, 2).equals("Inacitve")) {
                        setBackground(Color.RED);
                    } else {
                        setBackground(Color.WHITE);
                    }
                    return super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);
                }
            };
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        UserTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ChooseOrganizationComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        roleComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        employeeComboBox = new javax.swing.JComboBox();
        btnCreateEmployee = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        customerComboBox = new javax.swing.JComboBox();
        btnCreateCustomer = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        OrganizationComboBox = new javax.swing.JComboBox();
        btnAll = new javax.swing.JButton();
        btnRecycle = new javax.swing.JButton();
        btnRecord = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel1.setText("Manage User Account");

        UserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "User Name", "Role", "Account Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(UserTable);

        jLabel2.setText("User Account Table");

        jLabel3.setText("Organization");

        ChooseOrganizationComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseOrganizationComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Username");

        jLabel5.setText("Password");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel6.setText("Role");

        jLabel7.setText("Employee");

        btnCreateEmployee.setText("Create for Employee");
        btnCreateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEmployeeActionPerformed(evt);
            }
        });

        jLabel8.setText("Customer");

        btnCreateCustomer.setText("Create for Customer");
        btnCreateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCustomerActionPerformed(evt);
            }
        });

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        OrganizationComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrganizationComboBoxActionPerformed(evt);
            }
        });

        btnAll.setText("All Users");
        btnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActionPerformed(evt);
            }
        });

        btnRecycle.setText("Recycle Bin");
        btnRecycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecycleActionPerformed(evt);
            }
        });

        btnRecord.setText("Log Record");
        btnRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 350, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRecycle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(employeeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(ChooseOrganizationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(roleComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnCreateEmployee)
                            .addComponent(btnCreateCustomer))
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(OrganizationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAll)
                .addGap(29, 29, 29))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ChooseOrganizationComboBox, customerComboBox, employeeComboBox, roleComboBox, txtPassword, txtUsername});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(OrganizationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRecord)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(employeeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCreateEmployee)
                            .addComponent(btnRecycle))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCreateCustomer))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ChooseOrganizationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCreateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEmployeeActionPerformed
        String userName = txtUsername.getText();
        String password = txtPassword.getText();
        Organization organization = (Organization) ChooseOrganizationComboBox.getSelectedItem();
        Employee employee = (Employee) employeeComboBox.getSelectedItem();
        Role role = (Role) roleComboBox.getSelectedItem();

        if (organization.getName().equals("Sale Organization")) {
            organization.getUserAccountDirectory().createSaleUserAccount(userName, password, (Sale) employee, role);
            JOptionPane.showMessageDialog(null, "Sale User Account added successfully.");
        } else if (organization.getName().equals("Security Organization")) {
            organization.getUserAccountDirectory().createSecurityUserAccount(userName, password, (Security) employee, role);
            JOptionPane.showMessageDialog(null, "Security User Account added successfully.");
        } else if (organization.getName().equals("Admin Organization")) {
            organization.getUserAccountDirectory().createAdminUserAccount(userName, password, (Admin) employee, role);
            JOptionPane.showMessageDialog(null, "Admin User Account added successfully.");
        }

        populateUserTable(organization);
        txtUsername.setText("");
        txtPassword.setText("");

        int lastSession = userAccount.getSessionHistory().getSessionList().size() - 1;
        Session session = userAccount.getSessionHistory().getSessionList().get(lastSession);
        Activity activity = session.getActivityHistory().addActivity();
        activity.setName("Create An Employee User");
        activity.setStatus("Normal");
        activity.setUserAccount(userAccount);
        dB4OUtil.storeSystem(business);
    }//GEN-LAST:event_btnCreateEmployeeActionPerformed

    private void ChooseOrganizationComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseOrganizationComboBoxActionPerformed
        Organization organization = (Organization) ChooseOrganizationComboBox.getSelectedItem();
        if ((organization != null)) {
            populateRoleCombox(organization);
            if (organization.getName().equals("Customer Organization")) {
                CustomerOrganization customerOrganization = (CustomerOrganization) organization;

                employeeComboBox.removeAllItems();
                populateCustomerBox(customerOrganization);
            } else {

                customerComboBox.removeAllItems();
                populateEmployeeComBox(organization);
            }
        }
    }//GEN-LAST:event_ChooseOrganizationComboBoxActionPerformed

    private void btnCreateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCustomerActionPerformed
        String userName = txtUsername.getText();
        String password = txtPassword.getText();
        Organization organization = (Organization) ChooseOrganizationComboBox.getSelectedItem();
        Customer customer = (Customer) customerComboBox.getSelectedItem();
        Role role = (Role) roleComboBox.getSelectedItem();

        organization.getUserAccountDirectory().createCustomerUserAccount(userName, password, customer, role);
        populateUserTable(organization);

        JOptionPane.showMessageDialog(null, "Customer User Account added successfully.");
        txtUsername.setText("");
        txtPassword.setText("");

        int lastSession = userAccount.getSessionHistory().getSessionList().size() - 1;
        Session session = userAccount.getSessionHistory().getSessionList().get(lastSession);
        Activity activity = session.getActivityHistory().addActivity();
        activity.setName("Create A Customer User");
        activity.setStatus("Normal");
        activity.setUserAccount(userAccount);
        dB4OUtil.storeSystem(business);
    }//GEN-LAST:event_btnCreateCustomerActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = UserTable.getSelectedRow();
        if (selectedRow >= 0) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to delete the user?", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                //Organization 
                organization = (Organization) OrganizationComboBox.getSelectedItem();

                UserAccount ua = (UserAccount) UserTable.getValueAt(selectedRow, 0);

                userAccount.getAdmin().getUaRecycelBin().add(ua); // recycle the uer
                organization.getUserAccountDirectory().deleteAccount(ua);

                populateUserTable(organization);
                JOptionPane.showMessageDialog(null, "User deleted successfully");

                int lastSession = userAccount.getSessionHistory().getSessionList().size() - 1;
                Session session = userAccount.getSessionHistory().getSessionList().get(lastSession);
                Activity activity = session.getActivityHistory().addActivity();
                activity.setName("Delete a user");
                activity.setStatus("Normal");
                activity.setUserAccount(userAccount);
                //dB4OUtil.storeSystem(business);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void OrganizationComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrganizationComboBoxActionPerformed
        Organization organization = (Organization) OrganizationComboBox.getSelectedItem();
        if (organization != null) {
            populateUserTable(organization);
        }
    }//GEN-LAST:event_OrganizationComboBoxActionPerformed

    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
        populateUserTable();
    }//GEN-LAST:event_btnAllActionPerformed

    private void btnRecycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecycleActionPerformed
        RecycleBinJPanel panel = new RecycleBinJPanel(userProcessContainer, userAccount, organization);
        userProcessContainer.add("Recycle Bin", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRecycleActionPerformed

    private void btnRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordActionPerformed
        int selectedRow = UserTable.getSelectedRow();
        if (selectedRow >= 0) {
            UserAccount ua = (UserAccount) UserTable.getValueAt(selectedRow, 0);
            UserRecordJPanel panel = new UserRecordJPanel(userProcessContainer, ua, business);
            userProcessContainer.add("User Log Record", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }else {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnRecordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ChooseOrganizationComboBox;
    private javax.swing.JComboBox OrganizationComboBox;
    private javax.swing.JTable UserTable;
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateCustomer;
    private javax.swing.JButton btnCreateEmployee;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRecord;
    private javax.swing.JButton btnRecycle;
    private javax.swing.JComboBox customerComboBox;
    private javax.swing.JComboBox employeeComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox roleComboBox;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
