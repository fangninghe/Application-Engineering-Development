/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author fangninghe
 */
public class Account {
    
    private String Name;
    private String SSN;
    private String PhoneNumber;
    private String Address;
    private PatientInfo pif;
    
    
    
    public Account() {
        
        //this.pif = new PatientInfo();
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

   
   

    public PatientInfo getPif() {
        return pif;
    }

    public void setPif(PatientInfo pif) {
        this.pif = pif;
    }
    
    public PatientInfo setItAsPatient(){
        pif = new PatientInfo();
        return pif;
    }
    
    @Override
    public String toString() {
        return Name;
    }
    
  // public class Pationtinfo extends Account() {
    

    
    

}
