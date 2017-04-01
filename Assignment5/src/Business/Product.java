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
public class Product {

    private static int count = 1000;

    private int modelNumber;
    private String productName;
    private double floorPrice;
    private double targetPrice;
    private double ceilingPrice;
    private int availablity;
    private String productDescription;
    private String productFrom;

    private double profit;

    public Product() {
        count++;
        modelNumber = count;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(double floorPrice) {
        this.floorPrice = floorPrice;
    }

    public double getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(double targetPrice) {
        this.targetPrice = targetPrice;
    }

    public double getCeilingPrice() {
        return ceilingPrice;
    }

    public void setCeilingPrice(double ceilingPrice) {
        this.ceilingPrice = ceilingPrice;
    }

    public int getAvailablity() {
        return availablity;
    }

    public void setAvailablity(int availablity) {
        this.availablity = availablity;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductFrom() {
        return productFrom;
    }

    public void setProductFrom(String productFrom) {
        this.productFrom = productFrom;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public void addProfit(double number) {
        profit += number;
    }

    @Override
    public String toString() {
        return this.productName;
    }

}
