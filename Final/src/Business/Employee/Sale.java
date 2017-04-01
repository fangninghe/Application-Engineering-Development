/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Order.SaleOrderCatalog;
import Business.Role.Role;
import Business.Role.SaleRole;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Sale extends Employee{
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

    public int getBelowTarget() {
        return belowTarget;
    }

    public double getProfit() {
        return profit;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SaleRole());
        return roles;
    }
}
