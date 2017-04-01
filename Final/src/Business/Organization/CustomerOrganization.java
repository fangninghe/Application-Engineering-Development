/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Customer.CustomerDirectory;
import Business.Role.CustomerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class CustomerOrganization extends Organization{
    
    private CustomerDirectory customerDirectory;
    
    public CustomerOrganization() {
        super(Organization.Type.Customer.getValue());
        customerDirectory = new CustomerDirectory();
    }
    
     public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CustomerRole());
        return roles;
    }
}
