/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Business;
import Business.DB40Util.DB4OUtil;
import Business.Organization.Organization;
import Business.Organization.SecurityOrganization;
import Business.UserAcount.UserAccount;
import UserInterface.Security.SecurityWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Alex
 */
public class SecurityRole extends Role{

   public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business,DB4OUtil dB4OUtil) {
        return new SecurityWorkAreaJPanel(userProcessContainer, account, (SecurityOrganization)organization, business, dB4OUtil);
    }
    
}
