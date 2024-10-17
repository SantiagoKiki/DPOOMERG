package programa;

import java.util.List;

public class ResourceActivity extends Activity {
	
	private String url;

	public ResourceActivity(String title, String description, String objective, int expectedDuration,
			String url, List<Activity> prerequisites, List<Activity> followUpActivities) {
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
