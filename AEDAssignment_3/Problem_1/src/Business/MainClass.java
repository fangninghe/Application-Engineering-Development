/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Alex
 */
public class MainClass {
   
    public static void main(String args[]){ 
        SupplierDirectory supplierDirectory = new SupplierDirectory();; 
        Summary s = new Summary(supplierDirectory);
    }
    
}
