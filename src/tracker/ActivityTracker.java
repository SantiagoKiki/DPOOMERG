package tracker;

import java.util.Date;
import learningpath.activity.Activity;

public class ActivityTracker {
	
	
	private Activity activity;
	private int dedicatedTime;
	private String completionStatus;
	protected Date startDate;
	protected Date completionDate;
	
	
	public ActivityTracker(Activity activity) {
		this.activity = activity;
		this.dedicatedTime = 0;
		this.completionStatus = "Not started";
		this.startDate = null;
		this.completionDate = null;
		activity.addActivityTracker(this);
	}
	
	
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public int getDedicatedTime() {
		return dedicatedTime;
	}

	public void setDedicatedTime(int dedicatedTime) {
		this.dedicatedTime = dedicatedTime;
	}

	public String getCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(String status) {
		this.completionStatus = status;
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

	public void recordActivityStart() {
		this.completionStatus = "In Progress";
		this.startDate = new Date();
	}
	
	public void recordActivityCompletion() {
		this.completionStatus = "Completed";
		this.completionDate = new Date();
	}
	
	

}
