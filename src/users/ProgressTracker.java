package users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProgressTracker {
    private String studentUsername;
    private LearningPath learningPath;
    private Date startDate;
    private Date completionDate;
    private List<ActivityTracker> activitiesTracker;   //// 
    public static ArrayList<LearningPath> allLearninPaths;

    
    public ProgressTracker(String studentUsername, LearningPath learningPath) {
        this.studentUsername = studentUsername;
        this.learningPath = learningPath;
        this.activitiesTracker = new ArrayList<>();
        this.startDate = new Date();
    }
 
    public float calculateProgress() {
        return 0.0f;
    }

    public void completeActivity() {
        this.completionDate = new Date(); 
    }

	public String getStudentUsername() {
		return studentUsername;
	}

	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}

	public LearningPath getLearningPath() {
		return learningPath;
	}

	public void setLearningPath(LearningPath learningPath) {
		this.learningPath = learningPath;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public List<ActivityTracker> getActivitiesTracker() {
		return activitiesTracker;
	}

	public void setActivitiesTracker(List<ActivityTracker> activitiesTracker) {
		this.activitiesTracker = activitiesTracker;
	}

	public static ArrayList<LearningPath> getAllLearninPaths() {
		return allLearninPaths;
	}

	public static void setAllLearninPaths(ArrayList<LearningPath> allLearninPaths) {
		ProgressTracker.allLearninPaths = allLearninPaths;
	}
    
    
    
    
}
