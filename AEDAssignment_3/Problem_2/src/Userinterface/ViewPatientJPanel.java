/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Userinterface;

import Business.Account;
import Business.VitalSign;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.JFreeChart;
import Business.VitalSignHistory;
import java.awt.GridLayout;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.experimental.categories.Categories;

/**
 *
 * @author Alex
 */
public class ViewPatientJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private VitalSign vitalSign;
    private Account account;

    /**
     * Creates new form ViewPatientJPanel
     */
    public ViewPatientJPanel(JPanel userProcessContainer, Account account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        populateForm();
        populateTable();
        btnSave.setEnabled(false);
        
       
    }
    
    public void populateForm() {
        txtName.setText(account.getName());
        txtID.setText(account.getPif().getID());
        txtDocName.setText(account.getPif().getDocName());
        txtPhaName.setText(account.getPif().getPhaName());
        txtAge.setText(String.valueOf(account.getPif().getAge()));
        
    }
    
    public void refreshTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblVitalSignHistory.getModel();
        dtm.setRowCount(0);
        for (VitalSign v : account.getPif().getVsh().getVitalSignHistory()) {
            Object[] row = new Object[2];
            row[0] = v;
            
            if ((account.getPif().getAge() >= 1 && account.getPif().getAge() <= 3)) {
                if ((v.getBloodPressure() >= 80 && v.getBloodPressure() <= 110)
                        && (v.getHeartRate() >= 80 && v.getHeartRate() <= 130)
                        && (v.getWeight() >= 22 && v.getWeight() <= 31)
                        && (v.getRespiratoryRate() >= 20 && v.getRespiratoryRate() <= 30)) {
                    row[1] = "normal";
                } else {
                    row[1] = "abnormal";
                }
            }
            
            if (account.getPif().getAge() >= 4 && account.getPif().getAge() <= 5) {
                
                if ((v.getBloodPressure() >= 80 && v.getBloodPressure() <= 110)
                        && (v.getHeartRate() >= 80 && v.getHeartRate() <= 120)
                        && (v.getWeight() >= 31 && v.getWeight() <= 40)
                        && (v.getRespiratoryRate() >= 20 && v.getRespiratoryRate() <= 30)) {
                    row[1] = "normal";
                } else {
                    row[1] = "abnormal";
                }
            }
            if (account.getPif().getAge() >= 6 && account.getPif().getAge() <= 12) {
                
                if ((v.getBloodPressure() >= 80 && v.getBloodPressure() <= 120)
                        && (v.getHeartRate() >= 70 && v.getHeartRate() <= 110)
                        && (v.getWeight() >= 41 && v.getWeight() <= 92)
                        && (v.getRespiratoryRate() >= 20 && v.getRespiratoryRate() <= 30)) {
                    row[1] = "normal";
                } else {
                    row[1] = "abnormal";
                }
            }
            if (account.getPif().getAge() > 13) {
                
                if ((v.getBloodPressure() >= 110 && v.getBloodPressure() <= 120)
                        && (v.getHeartRate() >= 55 && v.getHeartRate() <= 105)
                        && (v.getWeight() >= 110)
                        && (v.getRespiratoryRate() >= 12 && v.getRespiratoryRate() <= 20)) {
                    row[1] = "normal";
                } else {
                    row[1] = "abnormal";
                }
            }
            
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

        txtDocName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtBloodPressure = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtRespiratoryRate = new javax.swing.JTextField();
        txtWeight = new javax.swing.JTextField();
        txtHeartRate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVitalSignHistory = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtPhaName = new javax.swing.JTextField();
        txtBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAddVS = new javax.swing.JButton();
        btnHealth = new javax.swing.JButton();

        txtDocName.setEditable(false);

        jLabel7.setText("Name");

        jLabel8.setText("ID");

        txtDate.setEnabled(false);

        jLabel9.setText("Age");

        jLabel1.setText("Blood Pressure");

        jLabel4.setText("Heart Rate");

        jLabel10.setText("DocName");

        jLabel13.setText("Patient Info");

        jLabel2.setText("Respiratory Rate");

        jLabel5.setText("Date");

        jLabel11.setText("PhaName");

        txtBloodPressure.setEnabled(false);

        jLabel3.setText("Weight");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Patient Detail");

        jLabel12.setText("Vital SIgn");

        txtRespiratoryRate.setEnabled(false);

        txtWeight.setEnabled(false);

        txtHeartRate.setEnabled(false);

        tblVitalSignHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVitalSignHistory);

        btnView.setText("View Details");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtName.setEditable(false);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtID.setEditable(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtAge.setEditable(false);

        txtPhaName.setEditable(false);

        txtBack.setText("<<Back");
        txtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBackActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAddVS.setText("Add Vital Sign");
        btnAddVS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVSActionPerformed(evt);
            }
        });

        btnHealth.setText("Health Trend");
        btnHealth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHealthActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtBloodPressure)
                                            .addComponent(txtRespiratoryRate)
                                            .addComponent(txtWeight)
                                            .addComponent(txtHeartRate)
                                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel12))
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtName)
                                            .addComponent(txtID)
                                            .addComponent(txtAge)
                                            .addComponent(txtDocName)
                                            .addComponent(txtPhaName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(btnAddVS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(txtBack)
                .addGap(125, 125, 125)
                .addComponent(btnUpdate)
                .addGap(60, 60, 60)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddVS, btnDelete, btnView});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSave, btnUpdate, txtBack});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddVS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHealth)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBloodPressure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRespiratoryRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtWeight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHeartRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDocName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPhaName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnSave)
                            .addComponent(txtBack))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSave, btnUpdate, txtBack});

    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblVitalSignHistory.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a vital sign from the table");
            return;
        }
        
        vitalSign = (VitalSign) tblVitalSignHistory.getValueAt(selectedRow, 0);
        
        txtBloodPressure.setText(String.valueOf(vitalSign.getBloodPressure()));
        txtRespiratoryRate.setText(String.valueOf(vitalSign.getRespiratoryRate()));
        txtWeight.setText(String.valueOf(vitalSign.getWeight()));
        txtHeartRate.setText(String.valueOf(vitalSign.getHeartRate()));
        txtDate.setText(vitalSign.getDate());
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblVitalSignHistory.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a vital sign from the table to delete.");
            return;
        }
        
        VitalSign vs = (VitalSign) tblVitalSignHistory.getValueAt(selectedRow, 0);
        account.getPif().getVsh().deleteVitalSign(vs);
        populateTable();
        JOptionPane.showMessageDialog(null, "Vital Sign deleted successfully");
    }//GEN-LAST:event_btnDeleteActionPerformed
    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblVitalSignHistory.getModel();
        dtm.setRowCount(0);
        
        for (VitalSign vs : account.getPif().getVsh().getVitalSignHistory()) {
            Object[] row = new Object[2];
            row[0] = vs;
            if ((account.getPif().getAge() >= 1 && account.getPif().getAge() <= 3)) {
                if ((vs.getBloodPressure() >= 80 && vs.getBloodPressure() <= 110)
                        && (vs.getHeartRate() >= 80 && vs.getHeartRate() <= 130)
                        && (vs.getWeight() >= 22 && vs.getWeight() <= 31)
                        && (vs.getRespiratoryRate() >= 20 && vs.getRespiratoryRate() <= 30)) {
                    row[1] = "normal";
                } else {
                    row[1] = "abnormal";
                }
            }
            
            if (account.getPif().getAge() >= 4 && account.getPif().getAge() <= 5) {
                
                if ((vs.getBloodPressure() >= 80 && vs.getBloodPressure() <= 110)
                        && (vs.getHeartRate() >= 80 && vs.getHeartRate() <= 120)
                        && (vs.getWeight() >= 31 && vs.getWeight() <= 40)
                        && (vs.getRespiratoryRate() >= 20 && vs.getRespiratoryRate() <= 30)) {
                    row[1] = "normal";
                } else {
                    row[1] = "abnormal";
                }
            }
            if (account.getPif().getAge() >= 6 && account.getPif().getAge() <= 12) {
                
                if ((vs.getBloodPressure() >= 80 && vs.getBloodPressure() <= 120)
                        && (vs.getHeartRate() >= 70 && vs.getHeartRate() <= 110)
                        && (vs.getWeight() >= 41 && vs.getWeight() <= 92)
                        && (vs.getRespiratoryRate() >= 20 && vs.getRespiratoryRate() <= 30)) {
                    row[1] = "normal";
                } else {
                    row[1] = "abnormal";
                }
            }
            if (account.getPif().getAge() > 13) {
                
                if ((vs.getBloodPressure() >= 110 && vs.getBloodPressure() <= 120)
                        && (vs.getHeartRate() >= 55 && vs.getHeartRate() <= 105)
                        && (vs.getWeight() >= 110)
                        && (vs.getRespiratoryRate() >= 12 && vs.getRespiratoryRate() <= 20)) {
                    row[1] = "normal";
                } else {
                    row[1] = "abnormal";
                }
            }
            
            dtm.addRow(row);            
        }
    }
    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);      // TODO add your handling code here:
    }//GEN-LAST:event_txtBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            
            String bloodpressure = txtBloodPressure.getText();
            String heartrate = txtHeartRate.getText();
            String respiratoryrate = txtRespiratoryRate.getText();
            String weight = txtWeight.getText();
            
           
            
            vitalSign.setBloodPressure(Integer.parseInt(bloodpressure));
            vitalSign.setHeartRate(Integer.parseInt(heartrate));
            vitalSign.setRespiratoryRate(Integer.parseInt(respiratoryrate));
            vitalSign.setWeight(Double.parseDouble(weight));
            
            JOptionPane.showMessageDialog(null, "Account successfully updated.", "Information", JOptionPane.INFORMATION_MESSAGE);
            btnSave.setEnabled(false);
            btnUpdate.setEnabled(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Correct format required.", "Information", JOptionPane.ERROR_MESSAGE);
            btnSave.setEnabled(false);
            btnUpdate.setEnabled(true);
        }
        refreshTable();
// TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        txtBloodPressure.setEnabled(true);
        txtHeartRate.setEnabled(true);
        txtRespiratoryRate.setEnabled(true);
        txtWeight.setEnabled(true);
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddVSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVSActionPerformed
        CreateVitalSignJPanel panel = new CreateVitalSignJPanel(account.getPif().getVsh(), userProcessContainer);
        userProcessContainer.add("CreateVitalSignJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);// TODO add your handling code here:
    }//GEN-LAST:event_btnAddVSActionPerformed

    private void btnHealthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHealthActionPerformed
        
        VitalSignHistory vitalSignHistory = account.getPif().getVsh();
        JFrame healthTrend = new JFrame("Trend");
        healthTrend.setLayout(new GridLayout(0, 1));
        
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        for(VitalSign vitalSign: vitalSignHistory.getVitalSignHistory()){
            dataset1.addValue(vitalSign.getBloodPressure(), "BloodPressure", vitalSign.getDate());
         }
        JFreeChart bloodPressureChart = ChartFactory.createLineChart("BloodPressure", "Time", "Prssure", dataset1,PlotOrientation.VERTICAL,true,true,false);
        CategoryPlot plot = bloodPressureChart.getCategoryPlot();
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseSeriesVisible(true);
        ChartPanel bloodPressurePanel = new ChartPanel(bloodPressureChart);
        bloodPressurePanel.setSize(640,200);
        healthTrend.add(bloodPressurePanel);
        
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        for(VitalSign vitalSign: vitalSignHistory.getVitalSignHistory()){
            dataset2.addValue(vitalSign.getHeartRate(), "HeartRate", vitalSign.getDate());
         }
        JFreeChart heartRateChart = ChartFactory.createLineChart("HeartRate", "Time", "Heart", dataset2,PlotOrientation.VERTICAL,true,true,false);
        CategoryPlot plot1 = heartRateChart.getCategoryPlot();
        LineAndShapeRenderer renderer1 = (LineAndShapeRenderer) plot1.getRenderer();
        renderer.setBaseSeriesVisible(true);
        ChartPanel HeartRatePanel = new ChartPanel(heartRateChart);
        HeartRatePanel.setSize(640,200);
        healthTrend.add(HeartRatePanel);
        
        DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
        for(VitalSign vitalSign: vitalSignHistory.getVitalSignHistory()){
            dataset3.addValue(vitalSign.getRespiratoryRate(), "RespirationRate", vitalSign.getDate());
         }
        JFreeChart respirationRateChart = ChartFactory.createLineChart("RespirationRate", "Time", "Respiration", dataset3,PlotOrientation.VERTICAL,true,true,false);
        CategoryPlot plot2 = respirationRateChart.getCategoryPlot();
        LineAndShapeRenderer renderer2 = (LineAndShapeRenderer) plot2.getRenderer();
        renderer.setBaseSeriesVisible(true);
        ChartPanel respirationRatePanel = new ChartPanel(respirationRateChart);
       respirationRatePanel.setSize(640,200);
        healthTrend.add(respirationRatePanel);
        
        DefaultCategoryDataset dataset4 = new DefaultCategoryDataset();
        for(VitalSign vitalSign: vitalSignHistory.getVitalSignHistory()){
            dataset4.addValue(vitalSign.getWeight(), "Weight", vitalSign.getDate());
         }
        JFreeChart weightChart = ChartFactory.createLineChart("Weight", "Time", "Weight", dataset4,PlotOrientation.VERTICAL,true,true,false);
        CategoryPlot plot3 = respirationRateChart.getCategoryPlot();
        LineAndShapeRenderer renderer3 = (LineAndShapeRenderer) plot3.getRenderer();
        renderer.setBaseSeriesVisible(true);
        ChartPanel weightPanel = new ChartPanel(weightChart);
        weightPanel.setSize(640,200);
        healthTrend.add( weightPanel);
        
        
        
        
        healthTrend.setSize(640,800);
        healthTrend.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_btnHealthActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddVS;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHealth;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVitalSignHistory;
    private javax.swing.JTextField txtAge;
    private javax.swing.JButton txtBack;
    private javax.swing.JTextField txtBloodPressure;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDocName;
    private javax.swing.JTextField txtHeartRate;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhaName;
    private javax.swing.JTextField txtRespiratoryRate;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}
