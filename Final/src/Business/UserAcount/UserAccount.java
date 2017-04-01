/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAcount;

import Business.Customer.Customer;
import Business.Employee.Admin;
import Business.Employee.Sale;
import Business.Employee.Security;
import Business.MessageQueue.Message;
import Business.MessageQueue.MessageQueue;
import Business.Role.Role;
import Business.Session.SessionHistory;

/**
 *
 * @author Alex
 */
public class UserAccount {

    private String username;
    private String password;
    
    private Admin admin;
    private Sale sale;
    private Security security;
    private Customer customer;
    
    private Role role;
    private MessageQueue messageQueue;

    private boolean isActive;

    private SessionHistory sessionHistory;

    public UserAccount() {
        sessionHistory = new SessionHistory();
        isActive = true;
        messageQueue = new MessageQueue();
    }
    
     public Message addMessage(String message,UserAccount sender,UserAccount receiver){
        Message m = new Message();
        m.setMessage(message);
        m.setSender(sender);
        m.setReceiver(receiver);
        m.setStatus("Initialization");
        sender.getMessageQueue().getMessageList().add(m);
        receiver.getMessageQueue().getMessageList().add(m);
        return m;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public SessionHistory getSessionHistory() {
        return sessionHistory;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public MessageQueue getMessageQueue() {
        return messageQueue;
    }
    
    

    @Override
    public String toString() {
        return username;
    }
}
