/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class OrderCatalog {
    private ArrayList<Order> OrderList;
    
    public OrderCatalog() {
        OrderList = new ArrayList<>();
    }
    
    public ArrayList<Order> getOrderCatalog() {
        return OrderList;
    }
    
    public Order addOrder(Order o) {
        OrderList.add(o);
        return o;
    }
    
    public void deleteOrder(Order o){
         OrderList.remove(o);
    }
}
