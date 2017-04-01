/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 * NUID:001664202
 *
 * @author Fangning He
 */
public class Customer extends Person {

    private CustomerOrderCatalog orderCatalog;
    private CustomerWishOrder customerWishOrder;
    private double consume;

    ;

    public Customer() {
        orderCatalog = new CustomerOrderCatalog();
        customerWishOrder = new CustomerWishOrder();

    }

    public CustomerOrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(CustomerOrderCatalog orderCatalog) {
        this.orderCatalog = orderCatalog;
    }

    public CustomerWishOrder getCustomerWishOrder() {
        return customerWishOrder;
    }

    public void setCustomerWishOrder(CustomerWishOrder customerWishOrder) {
        this.customerWishOrder = customerWishOrder;
    }

    public double Consume(double c) {
        consume += c;
        return consume;
    }

    public double getConsume() {
        return consume;
    }

    public void setConsume(double consume) {
        this.consume = consume;
    }

}
