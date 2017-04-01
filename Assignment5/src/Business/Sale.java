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
public class Sale extends Person {

    private SaleOrderCatalog saleOrderCatalog;
    private String commission;
    private int aboveTarget;
    private int belowTarget;
    private double profit;

    public Sale() {
        saleOrderCatalog = new SaleOrderCatalog();
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public SaleOrderCatalog getSaleOrderCatalog() {
        return saleOrderCatalog;
    }

    public void setSaleOrderCatalog(SaleOrderCatalog saleOrderCatalog) {
        this.saleOrderCatalog = saleOrderCatalog;
    }

    public void aboveTarget(int a) {
        aboveTarget += a;
    }

    public void belowTarget(int b) {
        belowTarget += b;
    }

    public double Profit(double p) {
        profit += p;
        return profit;
    }

    public int getAboveTarget() {
        return aboveTarget;
    }

    public void setAboveTarget(int aboveTarget) {
        this.aboveTarget = aboveTarget;
    }

    public int getBelowTarget() {
        return belowTarget;
    }

    public void setBelowTarget(int belowTarget) {
        this.belowTarget = belowTarget;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

}
