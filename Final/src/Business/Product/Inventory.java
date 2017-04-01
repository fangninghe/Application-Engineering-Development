/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Product;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Inventory {
    ArrayList<Product> productList;

    public Inventory() {
        productList = new ArrayList<>();
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public Product addProduct(String name , String description , double c , double f , double t , int a) {
        Product p = new Product();
        productList.add(p);
        p.setProductName(name);
        p.setProductDescription(description);
        p.setCeilingPrice(c);
        p.setFloorPrice(f);
        p.setTargetPrice(t);
        p.setAvailablity(a);
        return p;
    }

    public void deleteProduct(Product p) {
        productList.remove(p);
    }

    public Product searchProduct(int i) {
        for (Product p : productList) {
            if (p.getModelNumber() == i) {
                return p;
            }
        }
        return null;
    }
}
