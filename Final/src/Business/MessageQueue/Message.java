/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MessageQueue;

import Business.UserAcount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alex
 */
public class Message {

    private String message;
    private String time;
    private String status;

    private UserAccount sender;
    private UserAccount receiver;

    public Message() {
        SimpleDateFormat time1 = new SimpleDateFormat("yyyy-MM-dd' T 'HH:mm:ssz");
        time = time1.format(new Date());
    }
    
   

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }
    
   @Override
    public String toString() {
        return message;
    }

}
