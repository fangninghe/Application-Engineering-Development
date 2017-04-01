/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Activity;

import Business.UserAcount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alex
 */
public class Activity {

    private String name;
    private String time;
    //private SimpleDateFormat time;
    private String status;
   
    
    private UserAccount userAccount;
    
    

    public Activity() {
        SimpleDateFormat time1 = new SimpleDateFormat("yyyy-MM-dd' T 'HH:mm:ssz");
        time = time1.format(new Date());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    
    
    @Override
    public String toString() {
        return name;
    }

}
