/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Activity;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class ActivityHistory {

    private ArrayList<Activity> activityList;

    public ActivityHistory() {
        activityList = new ArrayList<>();

    }

    public Activity addActivity() {
        Activity activity = new Activity();
        activityList.add(activity);
        return activity;
    }

    public ArrayList<Activity> getActivityList() {
        return activityList;
    }

}
