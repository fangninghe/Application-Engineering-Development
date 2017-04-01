/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 * NUID:001664202
 * @author Fangning He
 */
public class CustomerDirectory {
    ArrayList<Customer>customerList;
    
    public CustomerDirectory(){
        customerList = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
    
     public Customer addCustomer() {
        Customer c = new Customer();
        customerList.add(c);
        return c;
    }

    public void deleteProduct(Product p) {
        customerList.remove(p);
    }

    public Customer searchCustomer(String i) {
        for (Customer c : customerList) {
            if (c.getID().equals(i) ) {
                return c;
            }
        }
        return null;
    }
}
