package programa;

import java.util.LinkedList;

public class TaskActivity extends Activity {

	private boolean state;

	public TaskActivity(String title, String description, String objective, int expectedDuration, boolean state,
			LinkedList<Activity> prerequisites, LinkedList<Activity> followUpActivities) {
		super();
		this.state = state;
	}

	public boolean getState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
