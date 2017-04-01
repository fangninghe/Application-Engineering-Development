/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Order.CustomerOrderCatalog;
import Business.Order.CustomerWishOrder;
import Business.Person;

/**
 *
 * @author Alex
 */
public class Customer extends Person {

    private int id;
    private static int count = 10000;
    
    private String status;

    private CustomerOrderCatalog orderCatalog;
    private CustomerWishOrder customerWishOrder;
    private double consume;

    public Customer() {
        orderCatalog = new CustomerOrderCatalog();
        customerWishOrder = new CustomerWishOrder();
        status = "common";
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public CustomerOrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public CustomerWishOrder getCustomerWishOrder() {
        return customerWishOrder;
    }

    public double Consume(double c) {
        consume += c;
        return consume;
    }

    public double getConsume() {
        return consume;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

}
