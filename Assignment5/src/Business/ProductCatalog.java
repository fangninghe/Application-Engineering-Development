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
public class ProductCatalog {

    ArrayList<Product> productList;

    public ProductCatalog() {
        productList = new ArrayList<>();
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public Product addProduct() {
        Product p = new Product();
        productList.add(p);
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
