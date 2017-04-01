/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Person;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public abstract class Employee extends Person {

    //private String name;
    private int id;
    private static int count = 10000;

    public Employee() {
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }
    
    public enum Type{
        Admin("Admin") , Sale("Sale"), Security("Security");
        
        private String value;
        
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
       
    }
    
     public abstract ArrayList<Role> getSupportedRole();

}
