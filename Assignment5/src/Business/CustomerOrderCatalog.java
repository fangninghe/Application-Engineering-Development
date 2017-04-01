/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 * NUID:001664202
 *
 * @author Fangning He
 */
public class CustomerOrderCatalog {

    private ArrayList<Order> customerOrderList;

    public CustomerOrderCatalog() {
        customerOrderList = new ArrayList<>();
    }

    public ArrayList<Order> getCustomerOrderCatalog() {
        return customerOrderList;
    }

    public Order addCustomerOrder(Order o) {
        customerOrderList.add(o);
        return o;
    }

    public void deleteCustomerOrder(Order o) {
        customerOrderList.remove(o);
    }

}
