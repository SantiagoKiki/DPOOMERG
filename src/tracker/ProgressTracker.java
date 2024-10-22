package tracker;

import learningpath.LearningPath;

import java.util.Date;
import java.util.LinkedList;

public class ProgressTracker{
	
	private String studentUsername;
	private LearningPath learningpath;
	private LinkedList<ActivityTracker> activityTrackers;
	protected Date startDate;
	protected Date completionDate;
	
	
	public ProgressTracker(String studentUsername, LearningPath learningpath) {
		
		this.studentUsername = studentUsername;
		this.learningpath = learningpath;
		this.activityTrackers = new LinkedList<ActivityTracker>();
		this.startDate = new Date();
		this.completionDate = null;
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


	public LinkedList<ActivityTracker> getActivitiestracker() {
		return activityTrackers;
	}

	public ActivityTracker getActivityTrackerByIndex(int index) {
		return activityTrackers.get(index);
	}


	public void setActivitiestracker(LinkedList<ActivityTracker> activitiestracker) {
		this.activityTrackers = activitiestracker;
	}

	public LinkedList<ActivityTracker> getActivityTrackers() {
		return activityTrackers;
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
		if (this.activityTrackers.isEmpty()) {
			return 0.0f;
		}
		for (ActivityTracker activitytracker: this.activityTrackers) {
			if (activitytracker.getStatus().equals("Completed")) {
				cont++;
			}
		}
		return ((float) cont/this.activityTrackers.size()) * 100;
	}
	
	// No se muy bien como implementar el metodo con respecto al uml
	public void completeActivity() {
		this.completionDate = new Date(); 
	}
	
	
	
	
	
	
}
