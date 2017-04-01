/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAcount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public abstract class Organization {

    private String name;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter;

    private ArrayList<String> trustIP;

    public enum Type {
        Admin("Admin Organization"), Sale("Sale Organization"),
        Security("Security Organization"), Customer("Customer Organization");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public Organization(String name) {
        this.name = name;
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();

        trustIP = new ArrayList<>();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTrustIP() {
        return trustIP;
    }

    @Override
    public String toString() {
        return organizationID + " " + name;
    }
}
