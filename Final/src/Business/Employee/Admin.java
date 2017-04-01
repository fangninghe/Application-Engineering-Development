/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Activity.Activity;
import Business.Role.AdminRole;
import Business.Role.Role;
import Business.UserAcount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Admin extends Employee{
    
    private ArrayList<Activity> activityList;
    private ArrayList<UserAccount>uaRecycelBin;
    
    public Admin(){
        activityList = new ArrayList<>();
        uaRecycelBin = new ArrayList<>();
    }

    public ArrayList<Activity> getActivityList() {
        return activityList;
    }

    public ArrayList<UserAccount> getUaRecycelBin() {
        return uaRecycelBin;
    }
    
    
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AdminRole());
        return roles;
    }
    
}
