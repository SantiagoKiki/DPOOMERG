package programa;

import java.util.List;

public class TaskActivity extends Activity {

	private boolean state;

	public TaskActivity(String title, String description, String objective, int expectedDuration, boolean state,
			List<Activity> prerequisites, List<Activity> followUpActivities) {
		super(title, description, objective, expectedDuration, prerequisites, followUpActivities);
		this.state = state;
	}

	public boolean getState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
