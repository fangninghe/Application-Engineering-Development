/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class CustomerWishOrder {
    ArrayList<OrderItem>customerWishList;
    
    public CustomerWishOrder(){
        customerWishList = new ArrayList<>();
    }

    public ArrayList<OrderItem> getCustomerWishList() {
        return customerWishList;
    }

    public void setCustomerWishList(ArrayList<OrderItem> customerWishList) {
        this.customerWishList = customerWishList;
    }
    
    public OrderItem addCustomerWishOrder(Product p,int q ,int price) {
        OrderItem oi = new OrderItem();
        oi.setProduct(p);
        oi.setQuantity(q);
        oi.setSalesPrice(price);
        customerWishList.add(oi);
        return oi;
        
    }
    
    public void deleteCustomerWishOrder(OrderItem oi){
        customerWishList.remove(oi);
    }
    
}
