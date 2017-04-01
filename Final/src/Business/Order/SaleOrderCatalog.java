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
public class SaleOrderCatalog {
    private ArrayList<Order> saleOrderList;
    
    public SaleOrderCatalog() {
        saleOrderList = new ArrayList<>();
    }
    
    public ArrayList<Order> getSaleOrderCatalog() {
        return saleOrderList;
    }
    
    public Order addSaleOrder(Order o) {
        saleOrderList.add(o);
        return o;
    }
}
