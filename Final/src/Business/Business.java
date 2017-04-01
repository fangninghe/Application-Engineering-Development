/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Order.OrderCatalog;
import Business.Organization.OrganizationDirectory;
import Business.Product.Inventory;
import Business.Session.Session;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Business {
    private static Business business;
    private OrganizationDirectory organizationDirectory;
    private Inventory inventory;
    private OrderCatalog orderCatalog;
    private ArrayList<Session> sessionBackup;
    
    public static Business getInstance(){
        if (business == null){
            business = new Business();
        }
        return business;
    }

    private Business() {
        organizationDirectory = new OrganizationDirectory();
        inventory = new Inventory();
        orderCatalog = new OrderCatalog();
        sessionBackup = new ArrayList<>();
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public ArrayList<Session> getSessionBackup() {
        return sessionBackup;
    }
    
    
}
