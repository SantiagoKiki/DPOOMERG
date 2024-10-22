package learningpath.activity;

import java.util.LinkedList;

public class TaskActivity extends Activity {

	public TaskActivity(String title, String description, String objective, int expectedDuration,
			LinkedList<Activity> prerequisites, LinkedList<Activity> followUpActivities ) {
		super(title, description, objective, expectedDuration, prerequisites, followUpActivities);
	}

}
