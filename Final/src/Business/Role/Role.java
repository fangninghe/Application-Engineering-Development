/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Business;
import Business.DB40Util.DB4OUtil;
import Business.Organization.Organization;
import Business.UserAcount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Alex
 */
public abstract class Role {
    
    
    
    public Role(){
       
    }
    
    public enum RoleType{
        Admin("Admin"),
        Sale("Sale"),
        Security("Security"),
        Customer("Customer");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business,DB4OUtil dB4OUtil);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
