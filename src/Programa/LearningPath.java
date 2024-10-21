package Programa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Users.Student;
import learningpath.Activity;

public class LearningPath {
    private String title;
    private String description;
    private int difficultyLevel;
    private int duration;
    private float rating;
    private Date createDate;
    private Date updateDate;
    private String version;
    private List<Activity> activities;
    public ArrayList<String> interest = new ArrayList();
    
    public LearningPath(String title, String description) {
        this.title = title;
        this.description = description;
        this.activities = new ArrayList<>();
    }
    
    public void addActivity(Activity activity, int pos) {
        activities.add(pos, activity);
    }
    
    public void removeActivity(int pos) {
        if (pos >= 0 && pos < activities.size()) {
            activities.remove(pos);
        }
    }
    
    public Activity getRecommendedActivity(Student student) {
        // Lógica para recomendar actividad
        return null;
    }

	
	
	
	
}
