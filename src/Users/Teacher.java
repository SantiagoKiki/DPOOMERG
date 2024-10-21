package Users;

import java.util.ArrayList;
import java.util.HashMap;

import Programa.Activity;
import Programa.LearningPath;

class Teacher extends User {
    private HashMap<String, LearningPath> createdLearningPaths;
    private ArrayList<Activity> createdActivities;
    
    public Teacher(String username, String password) {
        super(username, password);
        this.createdLearningPaths = new HashMap<>();
        this.createdActivities = new ArrayList<>();
    }
    
    public LearningPath createLearningPath(String title, String description) {
        LearningPath path = new LearningPath(title, description);
        createdLearningPaths.put(title, path);
        return path;
    }
    
    public void deleteLearningPath(String title) {
        createdLearningPaths.remove(title);
    }
    
    public Activity createActivity(String title, String description) {
        Activity activity = new Activity(title, description);
        createdActivities.add(activity);
        return activity;
    }
    
    public void deleteActivity(Activity activity) {
        createdActivities.remove(activity);
    }
    
    public void addActivityToLearningPath(LearningPath path, Activity activity, int pos) {
        path.addActivity(activity, pos);
    }
    
    public void removeActivityFromLearningPath(LearningPath path, int pos) {
        path.removeActivity(pos);
    }
}
