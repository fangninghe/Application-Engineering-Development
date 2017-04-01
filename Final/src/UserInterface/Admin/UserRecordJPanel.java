/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Admin;

import Business.Activity.Activity;
import Business.Business;
import Business.Organization.Organization;
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
public class UserRecordJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Business business;

    /**
     * Creates new form UserRecord
     */
    public UserRecordJPanel(JPanel userProcessContainer, UserAccount userAccount, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.business = business;

        txtName.setText(userAccount.getUsername());
        txtRole.setText(String.valueOf(userAccount.getRole()));

        populateSessionTable();
    }

    private void populateSessionTable() {
        DefaultTableModel dtm = (DefaultTableModel) SessionTable.getModel();
        dtm.setRowCount(0);
        for (Session session : userAccount.getSessionHistory().getSessionList()) {
            Object row[] = new Object[5];
            row[0] = session.getLogIn().getTime();
            if (session.getLogOut() == null) {
                row[1] = "aborting";
            } else {
                row[1] = session.getLogOut().getTime();
            }
            row[2] = session;
            row[3] = "untrust";
            for (Organization organization : business.getOrganizationDirectory().getOrganizationList()) {
                for (String IP : organization.getTrustIP()) {
                    if (session.getIP().equals(IP)) {
                        row[3] = "trust";
                        break;
                    }

                }
            }
            row[4] = "Non-xist";
            for (Activity activity : session.getActivityHistory().getActivityList()) {
                if (!activity.getStatus().equals("Normal")) {
                    row[4] = "Exist";
                    break;
                }
            }
            color(SessionTable);
            dtm.addRow(row);

        }
    }

    public void populateActivityTable(Session session) {
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

    private void color(JTable table) {
        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table,
                        Object value, boolean isSelected, boolean hasFocus,
                        int row, int column) {
                    if (table.getValueAt(row, 4).equals("Exist")) {
                        setBackground(Color.ORANGE);
                    } else if (table.getValueAt(row, 3).equals("untrust") || (table.getValueAt(row, 1).equals("aborting"))) {
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
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRole = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        SessionTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnViewDetial = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        detailTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel1.setText("User Log Record");

        jLabel2.setText("User Name");

        jLabel3.setText("Role");

        SessionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Login Time", "Logout Time", "User IP", "IP Status", "Threat Activity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(SessionTable);

        jLabel4.setText("Session Table");

        btnViewDetial.setText("View Detail");
        btnViewDetial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetialActionPerformed(evt);
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

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234))
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnViewDetial))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtName, txtRole});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnViewDetial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnBack)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDetialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetialActionPerformed
        int selectedRow = SessionTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first to view detail", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            Session session = (Session) SessionTable.getValueAt(selectedRow, 2);
            if (session != null) {
                populateActivityTable(session);
            }

        }
    }//GEN-LAST:event_btnViewDetialActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable SessionTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnViewDetial;
    private javax.swing.JTable detailTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRole;
    // End of variables declaration//GEN-END:variables
}
