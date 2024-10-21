package programa;

import java.util.HashMap;
import utils.Generator;

public abstract class Activity {

    protected String id;
    protected String title;
    protected String description;
    protected String objective;
    protected int expectedDuration;
    protected HashMap<String, Activity> prerequisites;
    protected HashMap<String, Activity> followUpActivities;

    protected Activity() {
        Generator u = new Generator();
        this.id = u.generateId("Activity");
        this.title = "";
        this.description = "";
        this.objective = "";
        this.expectedDuration = 0;
        this.prerequisites = new HashMap<>();
        this.followUpActivities = new HashMap<>();
        u = null;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getObjective() {
        return this.objective;
    }

    public int getExpectedDuration() {
        return this.expectedDuration;
    }

    public HashMap<String, Activity> getPrerequisites() {
        return this.prerequisites;
    }

    public HashMap<String, Activity> getFollowUpActivities() {
        return this.followUpActivities;
    }

    public void setId(String i) {
        this.id = i;
    }

    public void setTitle(String t) {
        this.title = t;
    }

    public void setDescription(String d) {
        this.description = d;
    }

    public void setObjective(String o) {
        this.objective = o;
    }

    public void setExpectedDuration(int i) {
        this.expectedDuration = i;
    }

    public void setPrerequisites(HashMap<String, Activity> p) {
        this.prerequisites = p;
    }

    public void setFollowUpActivities(HashMap<String, Activity> f) {
        this.followUpActivities = f;
    }

    public boolean addPrerequisite(Activity activity) {
        if (activity == null) {
            System.err.println("The activity can not be null");
            return false;
        }
        if (this.prerequisites.containsKey(activity.getId())) {
            System.err.println("The activity is already present in the registry");
            return false;
        }

        this.prerequisites.put(activity.getId(), activity);
        return true;
    }

    public boolean removePrerequisite(String activityId) {
        if (activityId == null) {
            System.err.println("The id can not be null");
            return false;
        }

        if (!this.prerequisites.containsKey(activityId)) {
            System.err.println("The id was not found in the registry");
            return false;
        }

        this.prerequisites.remove(activityId);
        return true;
    }

    public boolean addFollowUp(Activity activity) {
        if (activity == null) {
            System.err.println("The activity can not be null");
            return false;
        }

        if (this.followUpActivities.containsKey(activity.getId())) {
            System.err.println("The activity is already present in the registry");
            return false;
        }

        this.followUpActivities.put(activity.getId(), activity);
        return true;
    }

    public boolean removeFollowUp(String activityId) {

        if (activityId == null) {
            System.err.println("The id can not be null");
            return false;
        }

        if (!this.followUpActivities.containsKey(activityId)) {
            System.err.println("The id was not found in the registry");
            return false;
        }

        this.followUpActivities.remove(activityId);
        return true;
    }

}
