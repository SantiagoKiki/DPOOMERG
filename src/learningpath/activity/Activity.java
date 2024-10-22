package learningpath.activity;

import java.util.HashMap;
import java.util.LinkedList;

import utils.Generator;

public abstract class Activity {

    protected String id;
    protected String title;
    protected String description;
    protected String objective;
    protected int expectedDuration;
    protected LinkedList<Activity> prerequisites;
    protected LinkedList<Activity> followUpActivities;

    public Activity(String title, String description, String objective, int expectedDuration,
                    LinkedList<Activity> prerequisites, LinkedList<Activity> followUpActivities) {
        Generator u = Generator.getInstance();
        this.id = u.generateId("Activity");
        this.title = title;
        this.description = description;
        this.objective = objective;
        this.expectedDuration = expectedDuration;
        this.prerequisites = prerequisites;
        this.followUpActivities = followUpActivities;
        Generator.deleteInstance();
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

    public LinkedList<Activity> getPrerequisites() {
        return this.prerequisites;
    }

    public LinkedList<Activity> getFollowUpActivities() {
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

    public void setPrerequisites(LinkedList<Activity> p) {
        this.prerequisites = p;
    }

    public void setFollowUpActivities(LinkedList<Activity> f) {
        this.followUpActivities = f;
    }

    public void addPrerequisite(Activity activity) {
        this.prerequisites.add(activity);
    }

    public void removePrerequisite(int index) {
        this.prerequisites.remove(index);
    }

    public void addFollowUp(Activity activity) {
        this.followUpActivities.add(activity);
    }

    public void removeFollowUp(int index) {
        this.followUpActivities.remove(index);
    }

}
