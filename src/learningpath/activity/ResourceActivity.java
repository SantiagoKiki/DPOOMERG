package learningpath.activity;

import java.util.LinkedList;

public class ResourceActivity extends Activity {
	
	private String url;

	public ResourceActivity(String title, String description, String objective, int expectedDuration,
			LinkedList<Activity> prerequisites, LinkedList<Activity> followUpActivities, String url) {
		super(title, description, objective, expectedDuration, prerequisites, followUpActivities);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
