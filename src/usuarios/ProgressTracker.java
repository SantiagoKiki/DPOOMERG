package usuarios;

import java.util.Date;
import java.util.List;

public class ProgressTracker<LearningPath>{
	
	private String studentUsername;
	private LearningPath learningpath;
	private List<ActivityTracker> activitiestracker;
	protected Date startDate;
	protected Date completionDate;
	
	
	public ProgressTracker(String studentUsername, LearningPath learningpath, List<ActivityTracker> activitiestracker,
			Date startDate, Date completionDate) {
		
		this.studentUsername = studentUsername;
		this.learningpath = learningpath;
		this.activitiestracker = activitiestracker;
		this.startDate = startDate;
		this.completionDate = completionDate;
	}


	public String getStudentUsername() {
		return studentUsername;
	}


	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}


	public LearningPath getLearningpath() {
		return learningpath;
	}


	public void setLearningpath(LearningPath learningpath) {
		this.learningpath = learningpath;
	}


	public List<ActivityTracker> getActivitiestracker() {
		return activitiestracker;
	}


	public void setActivitiestracker(List<ActivityTracker> activitiestracker) {
		this.activitiestracker = activitiestracker;
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
	
	public float calculateProgress() {
		int cont = 0;
		if (this.activitiestracker.isEmpty()) {
			return 0.0f;
		}
		for (ActivityTracker activitytracker: this.activitiestracker) {
			if (activitytracker.getStatus().equals("Completed")) {
				cont++;
			}
		}
		return ((float) cont/this.activitiestracker.size()) * 100;
	}
	
	// No se muy bien como implementar el metodo con respecto al uml
	public void completeActivity() {
		this.completionDate = new Date(); 
	}
	
	
	
	
	
	
}
