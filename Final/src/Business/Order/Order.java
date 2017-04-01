/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Customer.Customer;
import Business.Employee.Sale;
import Business.Product.Product;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Order {
    private static int count = 10000;
    private ArrayList<OrderItem> orderItemList;
    private int orderNumber;
    private String status;
    private double amount;

    private Sale sale;
    private Customer customer;

    public Order() {
        count++;
        orderNumber = count;
        orderItemList = new ArrayList<>();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void removeOrderItem(OrderItem o) {
        orderItemList.remove(o);
    }

    public OrderItem addOrderItem(Product p, int q, int price) {
        OrderItem o = new OrderItem();
        o.setProduct(p);
        o.setQuantity(q);
        o.setSalesPrice(price);
        orderItemList.add(o);
        return o;
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {

        return amount;
    }

    public void calculateAmount() {
        double number = 0;
        for (OrderItem oi : orderItemList) {
            number += oi.getQuantity() * oi.getSalesPrice();
        }
        amount = number;
    }

    @Override
    public String toString() {
        return String.valueOf(this.orderNumber);
    }
}
