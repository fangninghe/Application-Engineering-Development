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
public class ManageSessionJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Business business;

    /**
     * Creates new form ManageSessionJPanel
     */
    public ManageSessionJPanel(JPanel userProcessContainer, Business business) {
        initComponents();
        this.business = business;
        this.userProcessContainer = userProcessContainer;

        populateSessionTable();
    }

    public void populateSessionTable() {
        DefaultTableModel dtm = (DefaultTableModel) SessionTable.getModel();
        dtm.setRowCount(0);
        for (Session session : business.getSessionBackup()) {
            Object row[] = new Object[7];
            row[0] = session.getUserAccount().getUsername();
            row[1] = session.getUserAccount().getRole();
            row[2] = session.getLogIn().getTime();
            if (session.getLogOut() == null) {
                row[3] = "aborting";

            } else {
                row[3] = session.getLogOut().getTime();

            }
            row[4] = session;
            row[5] = "untrust";
            for (Organization organization : business.getOrganizationDirectory().getOrganizationList()) {
                for (String IP : organization.getTrustIP()) {
                    if (session.getIP().equals(IP)) {
                        row[5] = "trust";
                        break;
                    }

                }
            }
            row[6] = "Non-exist";
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

    public void setColor(Session session) {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SessionTable = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        detailTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel1.setText("Manage Session");

        SessionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "User Name", "User Role", "Login Time", "Logout Time", "IP", "IP Status", "Threat Activity"
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

        btnView.setText("View Detial");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        jLabel2.setText("Session Table");

        jLabel3.setText("Activity Table");

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
        jScrollPane3.setViewportView(detailTable);

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
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnView))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnView)
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addGap(65, 65, 65)
                .addComponent(btnBack)
                .addGap(149, 149, 149))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        int selectedRow = SessionTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first to view detail", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            Session session = (Session) SessionTable.getValueAt(selectedRow, 4);
            if (session != null) {
                populateActivityTable(session);
            }

        }
    }//GEN-LAST:event_btnViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable SessionTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnView;
    private javax.swing.JTable detailTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
