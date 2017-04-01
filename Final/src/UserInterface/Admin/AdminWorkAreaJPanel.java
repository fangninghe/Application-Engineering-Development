/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Admin;

import Business.Business;
import Business.DB40Util.DB4OUtil;
import Business.UserAcount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Alex
 */
public class AdminWorkAreaJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private Business business;
    private DB4OUtil dB4OUtil;
    
    private UserAccount userAccount;

    /**
     * Creates new form AdminAreaJPanel
     */
    public AdminWorkAreaJPanel(JPanel userProcessContainer,Business business,UserAccount userAccount,DB4OUtil dB4OUtil) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.userAccount = userAccount;
        this.dB4OUtil = dB4OUtil;
        
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
        btnManageOrganization = new javax.swing.JButton();
        btnManageEmployee = new javax.swing.JButton();
        btnManageInventory = new javax.swing.JButton();
        btnManageOrder = new javax.swing.JButton();
        btnManageCustomer = new javax.swing.JButton();
        btnManageUser = new javax.swing.JButton();
        btnManageThreat = new javax.swing.JButton();
        btnManageSession = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel1.setText("Admin WorkArea");

        btnManageOrganization.setText("Manage Organization");
        btnManageOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageOrganizationActionPerformed(evt);
            }
        });

        btnManageEmployee.setText("Manage Employee");
        btnManageEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEmployeeActionPerformed(evt);
            }
        });

        btnManageInventory.setText("Manage Inventory");
        btnManageInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageInventoryActionPerformed(evt);
            }
        });

        btnManageOrder.setText("Manage Order");
        btnManageOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageOrderActionPerformed(evt);
            }
        });

        btnManageCustomer.setText("Manage Customer");
        btnManageCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCustomerActionPerformed(evt);
            }
        });

        btnManageUser.setText("Manage UserAccount");
        btnManageUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUserActionPerformed(evt);
            }
        });

        btnManageThreat.setText("Manage Threat");
        btnManageThreat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageThreatActionPerformed(evt);
            }
        });

        btnManageSession.setText("Manage Session");
        btnManageSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageSessionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 328, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnManageUser)
                    .addComponent(btnManageEmployee)
                    .addComponent(btnManageOrganization)
                    .addComponent(btnManageThreat))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnManageCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageSession, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnManageCustomer, btnManageEmployee, btnManageInventory, btnManageOrder, btnManageOrganization, btnManageThreat, btnManageUser});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnManageOrganization)
                        .addGap(18, 18, 18)
                        .addComponent(btnManageEmployee)
                        .addGap(18, 18, 18)
                        .addComponent(btnManageUser))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnManageInventory)
                        .addGap(18, 18, 18)
                        .addComponent(btnManageOrder)
                        .addGap(18, 18, 18)
                        .addComponent(btnManageCustomer)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnManageThreat)
                    .addComponent(btnManageSession))
                .addContainerGap(140, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageOrganizationActionPerformed
        ManageOrganizationJPanel panel = new ManageOrganizationJPanel(userProcessContainer, business,userAccount,dB4OUtil);
        userProcessContainer.add("Manage Organization",panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageOrganizationActionPerformed

    private void btnManageEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEmployeeActionPerformed
       ManageEmployeeJPanel panel = new ManageEmployeeJPanel(userProcessContainer,business.getOrganizationDirectory());
       userProcessContainer.add("Manage Employee",panel);
       CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
       cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageEmployeeActionPerformed

    private void btnManageUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUserActionPerformed
        ManageUserJPanel panel = new ManageUserJPanel(userProcessContainer, business,userAccount,dB4OUtil);
        userProcessContainer.add("Manage User Account",panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageUserActionPerformed

    private void btnManageCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCustomerActionPerformed
        ManageCustomerJPanel panel = new ManageCustomerJPanel(userProcessContainer,business.getOrganizationDirectory());
        userProcessContainer.add("Manage User Account",panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageCustomerActionPerformed

    private void btnManageInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageInventoryActionPerformed
        ManageProductJPanel panel = new ManageProductJPanel(userProcessContainer, business.getInventory());
        userProcessContainer.add("Manage User Account",panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageInventoryActionPerformed

    private void btnManageThreatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageThreatActionPerformed
        ManageThreatJPanel panel = new ManageThreatJPanel(userProcessContainer, userAccount);
        userProcessContainer.add("Manage Threat",panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageThreatActionPerformed

    private void btnManageOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageOrderActionPerformed
        ManageOrderJPanel panel = new ManageOrderJPanel(userProcessContainer, business.getOrderCatalog());
        userProcessContainer.add("Manage Order",panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageOrderActionPerformed

    private void btnManageSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageSessionActionPerformed
        ManageSessionJPanel panel = new ManageSessionJPanel(userProcessContainer, business);
        userProcessContainer.add("Manage Session",panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageSessionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageCustomer;
    private javax.swing.JButton btnManageEmployee;
    private javax.swing.JButton btnManageInventory;
    private javax.swing.JButton btnManageOrder;
    private javax.swing.JButton btnManageOrganization;
    private javax.swing.JButton btnManageSession;
    private javax.swing.JButton btnManageThreat;
    private javax.swing.JButton btnManageUser;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
