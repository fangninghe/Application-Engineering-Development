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
public class SupplierDirectory {
     private ArrayList<Supplier> supplierDirectory;
    
    public SupplierDirectory(){
        supplierDirectory = new ArrayList<Supplier>();
    }

    public ArrayList<Supplier> getSupplierDirectory() {
        return supplierDirectory;
    }

    public void setSupplierDirectory(ArrayList<Supplier> supplierDirectory) {
        this.supplierDirectory = supplierDirectory;
    }
    
    public Supplier addSupplier(){
        Supplier s = new Supplier();
        supplierDirectory.add(s);
        return s;
    }
    
    public void deleteSupplier(Supplier s){
        supplierDirectory.remove(s);
    }
    
    public Supplier searchSupplier(String keyWord){
        for(Supplier s : supplierDirectory){
            if(s.getSupplierName().equalsIgnoreCase(keyWord)){
                return s;
            }
        }
        return null;
    }
}
