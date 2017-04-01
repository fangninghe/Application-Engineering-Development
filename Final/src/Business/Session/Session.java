/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Session;

import Business.Activity.Activity;
import Business.Activity.ActivityHistory;
import Business.UserAcount.UserAccount;
import java.net.UnknownHostException;

/**
 *
 * @author Alex
 */
public class Session {

    private Activity logIn;
    private Activity logOut;

    private String IP;
    private UserAccount userAccount;

    private ActivityHistory activityHistory;

    ;
    
    public Session() throws UnknownHostException {
        logIn = new Activity();
        logIn.setName("Log In");
        logIn.setStatus("Normal");
        activityHistory = new ActivityHistory();
        activityHistory.getActivityList().add(logIn);
       
    }

    public ActivityHistory getActivityHistory() {
        return activityHistory;
    }

    public Activity getLogIn() {
        return logIn;
    }

    public Activity getLogOut() {
        return logOut;
    }

    public void setLogOut(Activity logOut) {

        this.logOut = logOut;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    

    @Override
    public String toString() {
        return IP;
    }

}
