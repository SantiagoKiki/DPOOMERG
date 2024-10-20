package Programa;

import java.util.ArrayList;
import java.util.List;

public class Activity {
    private String title;
    private String description;
    private String objective;
    private int expectedDuration;
    private List<Activity> prerequisites;
    private List<Activity> followUpActivities;
    
    public Activity(String title, String description) {
    this.title = title;
    this.description = description;
    this.prerequisites = new ArrayList<>();
    this.followUpActivities = new ArrayList<>();
    }
    
    
    
}