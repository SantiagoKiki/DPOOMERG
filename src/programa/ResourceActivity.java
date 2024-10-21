package programa;

import java.util.LinkedList;

public class ResourceActivity extends Activity {
	
	private String url;

	public ResourceActivity(String title, String description, String objective, int expectedDuration,
			String url, LinkedList<Activity> prerequisites, LinkedList<Activity> followUpActivities) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
