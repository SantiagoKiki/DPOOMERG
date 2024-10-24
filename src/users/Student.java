package users;

import learningpath.LearningPath;
import learningpath.activity.Activity;
import tracker.ActivityTracker;
import tracker.ProgressTracker;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Student extends User {
    private LinkedList<String> interests;
    private LinkedList<ProgressTracker> progressTrackers;
    private LearningPath learningPathStudent;
    public final static String ROLE = "student";
    private HashMap<LearningPath, String> reseñas = new HashMap();
    
    public Student(String username, String password) {
        super(username, password);
        this.interests = new LinkedList<>();
        this.progressTrackers = new LinkedList<>();
    }

    public LinkedList<String> getInterests() {
        return interests;
    }

    public LinkedList<ProgressTracker> getProgressTrackers() {
        return progressTrackers;
    }

    public ProgressTracker getProgressTrackerByIndex(int index) {
        return progressTrackers.get(index);
    }

    public List<ActivityTracker> getActivityTrackers(ProgressTracker progressTracker) {
        return progressTracker.getActivityTrackers();
    }

    public ActivityTracker getActivityTrackerByIndex(ProgressTracker progressTracker, int index) {
        return progressTracker.getActivityTrackerByIndex(index);
    }

    @Override
    public String getRole() {
        return ROLE;
    }
    
    public void addInterest(String interest) {
        interests.add(interest);
    }
    
    public void removeInterest(int index) {
        if (index >= 0 && index < interests.size()) {
            interests.remove(index);
        }
    }
    
    public void addReseña() {
        	Scanner teclado=new Scanner(System.in);
    		String rese = teclado.next();
    		System.out.println("Ingrese la reseña:");
    		reseñas.put(learningPathStudent, rese);
    }
    
    public void enrollInLearningPath(LearningPath learningPath) {
        ProgressTracker progressTracker = new ProgressTracker(this.username, learningPath);
        progressTrackers.add(progressTracker);
        learningPath.addProgressTracker(progressTracker);
    }
    
    public void completeActivity(Activity activity) {
        
    }
    
    public float getProgress(ProgressTracker tracker) {
        return tracker.getProgress();
    }
}
	
