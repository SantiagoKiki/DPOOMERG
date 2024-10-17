package programa;

import java.util.ArrayList;
import java.util.List;

public abstract class Activity {
	protected String title;
	protected String description;
	protected String objective;
	protected int expectedDuration;
	protected List<Activity> prerequisites;
	protected List<Activity> followUpActivities;

	protected Activity(String title, String description, String objective, int expectedDuration,
			List<Activity> prerequisites, List<Activity> followUpActivities) {
		this.title = title;
		this.description = description;
		this.objective = objective;
		this.expectedDuration = expectedDuration;
		this.prerequisites = prerequisites != null ? prerequisites : new ArrayList<>();
		this.followUpActivities = followUpActivities != null ? followUpActivities : new ArrayList<>();
	}
}
