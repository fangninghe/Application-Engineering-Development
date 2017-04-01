/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class CustomerDirectory {
    private ArrayList<Customer> customerList;

    public CustomerDirectory() {
        customerList = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    
    public Customer createCustomer(String name, String adress, String email, String phone){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(adress);
        customer.setEmail(email);
        customer.setPhone(phone);
        
        customerList.add(customer);
        return customer;
    }
    
    
}
