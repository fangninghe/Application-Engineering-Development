/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Role.Role;
import Business.Role.SecurityRole;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Security extends Employee{
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SecurityRole());
        return roles;
    }
    
}
