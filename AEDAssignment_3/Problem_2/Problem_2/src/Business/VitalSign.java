/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author fangninghe
 */
public class VitalSign {
    
    private int respiratoryRate;
    private int heartRate;
    private int bloodPressure;
    private double weight;
    private String date ;

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    
    SimpleDateFormat timeGet = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    public String getDate() {
        return date;
    }
    
    

    public void setDate() {
        date = timeGet.format(new Date());
    }
    
     
    @Override
   public String toString(){
        return this.getDate();
   }
    
}
