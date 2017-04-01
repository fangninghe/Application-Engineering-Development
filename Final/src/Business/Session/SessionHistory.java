/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Session;

import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class SessionHistory {
    
    private ArrayList<Session> sessionList;
    
    public SessionHistory(){
        sessionList = new ArrayList<>();
    }
    
    public Session addSession() throws UnknownHostException{
        Session session = new Session();
        sessionList.add(session);
        return session;
    }

    public ArrayList<Session> getSessionList() {
        return sessionList;
    }
    
    
    
}
