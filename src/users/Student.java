package users;

import java.util.ArrayList;
import java.util.List;

import learningpath.activity.Activity;

public class Student extends User {
    private List<String> interests;
    private List<ProgressTracker> progressTrackers;
    
    public Student(String username, String password) {
        super(username, password);
        this.interests = new ArrayList<>();
        this.progressTrackers = new ArrayList<>();
    }
    
    public void addInterest(String interest) {
        interests.add(interest);
    }
    
    public void removeInterest(int index) {
        if (index >= 0 && index < interests.size()) {
            interests.remove(index);
        }
    }
    
    public List<LearningPath> getLearningPathsByInterest(String interest) {
    	List<LearningPath> arregloReturn = new ArrayList();
    	int num=0; //recorrido :) 1 vez nada mas
    	if(num == 0) {
	    	for(ProgressTracker elemenents : progressTrackers) {
	    		ArrayList<LearningPath> path = elemenents.getAllLearninPaths();
		    	for(LearningPath allPaths : path) {
		    		ArrayList<String> interesesPath = allPaths.interest;
		    		for(String elementosInterest: interesesPath) {
			    		if (elementosInterest.equals(interest) || elementosInterest.contentEquals(interest)) {
			    			arregloReturn.add(allPaths);
			    			}	
		    			}
		    		}
	    		}
	    num++;
    	}
    	return arregloReturn;
    }
    
    public void registerLearningPath(LearningPath path) {
        progressTrackers.add(new ProgressTracker(this.username, path));
    }
    
    public void completeActivity(Activity activity) {
        
    }
    
    public float getProgress(ProgressTracker tracker) {
        return tracker.calculateProgress();
    }
}
	
