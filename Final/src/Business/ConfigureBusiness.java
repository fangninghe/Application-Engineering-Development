/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Customer.Customer;
import Business.Employee.Admin;
import Business.Employee.Employee;
import Business.Employee.Sale;
import Business.Employee.Security;
import Business.Organization.AdminOrganization;
import Business.Organization.CustomerOrganization;
import Business.Organization.Organization;
import Business.Organization.SaleOrganization;
import Business.Organization.SecurityOrganization;
import Business.Product.Product;
import Business.Role.AdminRole;
import Business.Role.CustomerRole;
import Business.Role.SaleRole;
import Business.Role.SecurityRole;
import Business.UserAcount.UserAccount;

/**
 *
 * @author Alex
 */
public class ConfigureBusiness {

    public static Business configure() {

        Business business = Business.getInstance();

        AdminOrganization adminOrganization = new AdminOrganization();
        business.getOrganizationDirectory().getOrganizationList().add(adminOrganization);
        
        SaleOrganization saleOrganization = (SaleOrganization) business.getOrganizationDirectory().createOrganization(Organization.Type.Sale);
        SecurityOrganization securityOrganization = (SecurityOrganization) business.getOrganizationDirectory().createOrganization(Organization.Type.Security);
        CustomerOrganization customerOrganization = (CustomerOrganization)business.getOrganizationDirectory().createOrganization(Organization.Type.Customer);
        

        Admin admin = (Admin) adminOrganization.getEmployeeDirectory().createEmployee(Employee.Type.Admin, "Raunak Agarwal", "111,MainStreet",
                "111@gmail.comm", "123456789", "12345678");
        UserAccount ua = adminOrganization.getUserAccountDirectory().createAdminUserAccount("admin", "admin", admin, new AdminRole());
        
        Sale sale = (Sale) saleOrganization.getEmployeeDirectory().createEmployee(Employee.Type.Sale, "a", "a",
                "a", "1", "1");
        UserAccount ua1 = saleOrganization.getUserAccountDirectory().createSaleUserAccount("a", "a", sale, new SaleRole());
        
        Security security = (Security) securityOrganization.getEmployeeDirectory().createEmployee(Employee.Type.Security, "s", "s",
                "s", "123", "123");
        UserAccount ua2 = securityOrganization.getUserAccountDirectory().createSecurityUserAccount("s", "s", security, new SecurityRole());
        
        Customer customer = (Customer) customerOrganization.getCustomerDirectory().createCustomer("aa", "aa", "aa", "11");
        UserAccount ua3 = customerOrganization.getUserAccountDirectory().createCustomerUserAccount("aa", "aa", customer, new CustomerRole());
        
        Product p = business.getInventory().addProduct("aaa","aaa",50,30,40,1000);

        return business;
    }
}
