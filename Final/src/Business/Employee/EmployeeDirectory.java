/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class EmployeeDirectory {

    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee createEmployee(Employee.Type type, String name, String adress, String email, String phone, String ssn) {
       
        Employee employee = null;
        if (type.getValue().equals(Employee.Type.Sale.getValue())) {
            employee = new Sale();
        }else if(type.getValue().equals(Employee.Type.Admin.getValue())){
            employee = new Admin();
        }else if(type.getValue().equals(Employee.Type.Security.getValue())){
            employee = new Security();
        }
        employee.setName(name);
        employee.setAddress(adress);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setSsn(ssn);
        employeeList.add(employee);
        return employee;
    }

    public void deleteEmployee(Employee e) {
        employeeList.remove(e);
    }
}
