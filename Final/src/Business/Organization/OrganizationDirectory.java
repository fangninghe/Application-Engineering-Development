/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Sale.getValue())){
            organization = new SaleOrganization();
            organizationList.add(organization);
        }else if (type.getValue().equals(Organization.Type.Customer.getValue())){
            organization = new CustomerOrganization();
            organizationList.add(organization);
        }else if (type.getValue().equals(Organization.Type.Security.getValue())){
            organization = new SecurityOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}
