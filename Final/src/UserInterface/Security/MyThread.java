/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Security;

import Business.Business;
import Business.DB40Util.DB4OUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Alex
 */
public class MyThread implements Runnable {

    private MonitorLiveJPanel jPanel;
    private DB4OUtil b4OUtil;
    private Business business;

    //= new MonitorLiveJPanel(userProcessContainer, business);
    public MyThread(JPanel jPanel, Business business, DB4OUtil b4OUtil) {

        this.jPanel = (MonitorLiveJPanel) jPanel;
        this.b4OUtil = b4OUtil;
        this.business = business;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            business = b4OUtil.retrieveSystem();
            jPanel.populateActivityTable();

        }

    }

}
