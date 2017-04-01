/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Security;

import Business.Activity.Activity;
import Business.Business;
import Business.DB40Util.DB4OUtil;
import Business.Organization.Organization;
import Business.Session.Session;
import Business.UserAcount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class MonitorJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Business business;
    private DB4OUtil b4OUtil;// = DB4OUtil.getInstance();
    private UserAccount userAccount;

    /**
     * Creates new form MonitorJPanel
     */
    public MonitorJPanel(JPanel userProcessContainer, Business business, UserAccount userAccount, DB4OUtil b4OUtil) throws UnknownHostException {
        initComponents();
        // this.business = b4OUtil.retrieveSystem();
        this.business = business;
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.b4OUtil = b4OUtil;

        populateTimeFilterCombox();
        populateSessionTable();
    }

    private void populateSessionTable(int i) {
        DefaultTableModel dtm = (DefaultTableModel) SessionTable.getModel();
        dtm.setRowCount(0);

        for (Organization organization : business.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount account : organization.getUserAccountDirectory().getUserAccountList()) {
                for (Session session : account.getSessionHistory().getSessionList()) {

                    SimpleDateFormat currentTime = new SimpleDateFormat("yyyyMMdd");
                    String CurrentTime = currentTime.format(new Date());
                    int currenttime = Integer.parseInt(CurrentTime.substring(4, 8)); // convert date to Integer

                    String timeFilter = session.getLogIn().getTime();
                    int TimeFilter = Integer.parseInt(timeFilter.substring(5, 7) + timeFilter.substring(8, 10));
                    // convert logintime to inte
                    if (TimeFilter > currenttime - i) {
                        Object row[] = new Object[6];
                        row[0] = account;
                        row[1] = account.getRole();
                        row[2] = session.getLogIn().getTime();
                        if (session.getLogOut() == null) {
                            row[3] = "aborting";
                        } else {
                            row[3] = session.getLogOut().getTime();
                        }
                        row[4] = session;
                        row[5] = "untrust";

                        for (String getIp : organization.getTrustIP()) {
                            if (session.getIP().equals(getIp)) {
                                row[5] = "trust";
                                break;
                            }
                        }
                        color(SessionTable);
                        dtm.addRow(row);
                    }

                }
            }
        }
    }

    public void populateSessionTable() {
        DefaultTableModel dtm = (DefaultTableModel) SessionTable.getModel();
        dtm.setRowCount(0);

        for (Organization organization : business.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount account : organization.getUserAccountDirectory().getUserAccountList()) {
                for (Session session : account.getSessionHistory().getSessionList()) {
                    Object row[] = new Object[7];
                    row[0] = account;
                    row[1] = account.getRole();
                    row[2] = session.getLogIn().getTime();
                    if (session.getLogOut() == null) {
                        row[3] = "aborting";
                    } else {
                        row[3] = session.getLogOut().getTime();
                    }
                    row[4] = session;
                    row[5] = "untrust";
                    for (String getIp : organization.getTrustIP()) {
                        if (session.getIP().equals(getIp)) {
                            row[5] = "trust";
                            break;
                        }
                    }
                    row[6] = "Non-Exist";
                    for (Activity activity : session.getActivityHistory().getActivityList()) {
                        if (!activity.getStatus().equals("Normal")) {
                            row[6] = "Exist";
                            break;
                        }
                    }
                    color(SessionTable);
                    dtm.addRow(row);

                }
            }
        }
    }

    public void populatedetailTable(Session session) {
        DefaultTableModel dtm = (DefaultTableModel) detailTable.getModel();
        dtm.setRowCount(0);
        for (Activity activity : session.getActivityHistory().getActivityList()) {
            Object row[] = new Object[3];
            row[0] = activity;
            row[1] = activity.getTime();
            row[2] = activity.getStatus();
            activititycolor(detailTable);
            dtm.addRow(row);
        }

    }

    private void populateTimeFilterCombox() {
        timeFilterComboBox.addItem("All");
        timeFilterComboBox.addItem("Latest Week");
        timeFilterComboBox.addItem("Latest Month");

    }

    private void color(JTable table) {
        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table,
                        Object value, boolean isSelected, boolean hasFocus,
                        int row, int column) {
                    if (table.getValueAt(row, 6).equals("Exist")) {
                        setBackground(Color.ORANGE);
                    } else if (table.getValueAt(row, 5).equals("untrust") || (table.getValueAt(row, 3).equals("aborting"))) {
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
        }
    }

    private void activititycolor(JTable table) {
        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table,
                        Object value, boolean isSelected, boolean hasFocus,
                        int row, int column) {
                    if (table.getValueAt(row, 2).equals("Normal")) {
                        setBackground(Color.WHITE);
                    } else {
                        setBackground(Color.RED);
                    }
                    return super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);
                }
            };
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
            }
        } catch (Exception ex) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        SessionTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        detailTable = new javax.swing.JTable();
        btnViewDetial = new javax.swing.JButton();
        btnIPManagment = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        timeFilterComboBox = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        btnSendUser = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel1.setText("Session History");

        jLabel2.setText("Session Table");

        SessionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "User Name", "User Role", "Login Time", "Logout Time", "User IP", "IP Status", "Threat Activity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(SessionTable);

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        detailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Activity", "Time", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(detailTable);

        btnViewDetial.setText("View Detail");
        btnViewDetial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetialActionPerformed(evt);
            }
        });

        btnIPManagment.setText("IP Managment");
        btnIPManagment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIPManagmentActionPerformed(evt);
            }
        });

        btnSend.setText("Send to Admin");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnSearch.setText("Search User");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        timeFilterComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                timeFilterComboBoxItemStateChanged(evt);
            }
        });
        timeFilterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeFilterComboBoxActionPerformed(evt);
            }
        });

        txtMessage.setColumns(20);
        txtMessage.setRows(5);
        jScrollPane3.setViewportView(txtMessage);

        btnSendUser.setText("Send to User");
        btnSendUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(timeFilterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 527, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(90, 90, 90)
                .addComponent(btnSend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSendUser)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnViewDetial)
                        .addGap(57, 57, 57)
                        .addComponent(btnIPManagment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(38, 38, 38)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancel, btnSearch});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBack, btnIPManagment, btnSend, btnViewDetial});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(timeFilterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewDetial)
                    .addComponent(btnIPManagment))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSend)
                    .addComponent(btnBack)
                    .addComponent(btnSendUser))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewDetialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetialActionPerformed
        int selectedRow = SessionTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first to view detail", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            Session session = (Session) SessionTable.getValueAt(selectedRow, 4);
            if (session != null) {
                populatedetailTable(session);
            }

        }
    }//GEN-LAST:event_btnViewDetialActionPerformed

    private void btnIPManagmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIPManagmentActionPerformed
        IPManagmentJPanel panel = new IPManagmentJPanel(userProcessContainer, business, b4OUtil, userAccount);
        userProcessContainer.add("TrustIP", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnIPManagmentActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        int selectedRow = detailTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first to view detail", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            Activity activity = (Activity) detailTable.getValueAt(selectedRow, 0);
            for (Organization organization : business.getOrganizationDirectory().getOrganizationList()) {
                for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                    if (userAccount.getUsername().equals("admin")) {
                        userAccount.getAdmin().getActivityList().add(activity);
                    }

                }
            }

            JOptionPane.showMessageDialog(null, "Send to Admin successfully", "Information", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyWord = txtSearch.getText();
        DefaultTableModel dtm = (DefaultTableModel) SessionTable.getModel();
        dtm.setRowCount(0);
        for (Organization organization : business.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount account : organization.getUserAccountDirectory().getUserAccountList()) {
                for (Session session : account.getSessionHistory().getSessionList()) {
                    if (keyWord.equals(account.getUsername())) {
                        Object row[] = new Object[6];
                        row[0] = account;
                        row[1] = account.getRole();
                        row[2] = session.getLogIn().getTime();
                        if (session.getLogOut() == null) {
                            row[3] = "aborting";
                        } else {
                            row[3] = session.getLogOut().getTime();
                        }
                        row[4] = session;
                        row[5] = "untrust";

                        for (String getIp : organization.getTrustIP()) {
                            if (session.getIP().equals(getIp)) {
                                row[5] = "trust";
                                break;
                            }
                        }
                        dtm.addRow(row);
                    }

                }
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        populateSessionTable();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSendUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendUserActionPerformed
        int selectedRow = SessionTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first to view detail", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (txtMessage.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Message cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            UserAccount ua = (UserAccount) SessionTable.getValueAt(selectedRow, 0);
            ua.addMessage(txtMessage.getText(), userAccount, ua);
            JOptionPane.showMessageDialog(null, "Send successfully", "Information", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btnSendUserActionPerformed

    private void timeFilterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeFilterComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeFilterComboBoxActionPerformed

    private void timeFilterComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_timeFilterComboBoxItemStateChanged
        switch (timeFilterComboBox.getSelectedIndex()) {
            case 0:
                populateSessionTable();
                break;
            case 1:
                populateSessionTable(30);
                break;
            case 2:
                populateSessionTable(1);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_timeFilterComboBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable SessionTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnIPManagment;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSendUser;
    private javax.swing.JButton btnViewDetial;
    private javax.swing.JTable detailTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> timeFilterComboBox;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
