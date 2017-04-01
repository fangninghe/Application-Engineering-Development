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
public class SaleDirectory {
    ArrayList<Sale>saleList;
    
    public SaleDirectory(){
        saleList = new ArrayList<>();
    }

    public ArrayList<Sale> getSaleList() {
        return saleList;
    }

    public void setSaleList(ArrayList<Sale> saleList) {
        this.saleList = saleList;
    }
    
     public Sale addSale() {
        Sale s = new Sale();
        saleList.add(s);
        return s;
    }

    public void deleteSale(Sale s) {
        saleList.remove(s);
    }

    public Sale searchSale(String i) {
        for (Sale s : saleList) {
            if (s.getID().equals(i) ) {
                return s;
            }
        }
        return null;
    }
}
