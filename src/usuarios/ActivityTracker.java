package usuarios;

import java.util.Date;
import programa.Activity;

public class ActivityTracker {
	
	
	private Activity activity;
	private int dedicatedTime;
	private String status;
	protected Date startDate;
	protected Date completionDate;
	
	
	public ActivityTracker(Activity activity, int dedicatedTime, String status, Date startDate, Date completionDate) {
		this.activity = activity;
		this.dedicatedTime = dedicatedTime;
		this.status = status;
		this.startDate = startDate;
		this.completionDate = completionDate;
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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
		if (this.status.equals("Completed")) {
			return 100.0f;
		}
		float expectedDuration = activity.getExpectedDuration();
		return (float)dedicatedTime /expectedDuration * 100;
	}
	
	public void recordActivityCompletion() {
		this.status = "Completed";
		this.completionDate = new Date();
	}
	
	

}
