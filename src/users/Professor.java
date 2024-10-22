package users;

import learningpath.*;
import learningpath.activity.*;
import learningpath.question.*;

import java.util.LinkedList;

public class Professor extends User {
    private LinkedList<LearningPath> createdLearningPaths;
    private LinkedList<Activity> createdActivities;
    private final static String ROLE = "professor";
    
    public Professor(String username, String password) {
        super(username, password);
        this.createdLearningPaths = new LinkedList<>();
        this.createdActivities = new LinkedList<>();
    }

    @Override
    public String getRole() {
        return ROLE;
    }

    public LearningPath createLearningPath(int id, String title, String description, LinkedList<String> objectives, int difficultyLevel, LinkedList<String> tags, Professor professor) {
        LearningPath path = new LearningPath(id, title, description, objectives, difficultyLevel, tags, professor);
        createdLearningPaths.add(path);
        return path;
    }
    
    public void deleteLearningPath(int index) {
        createdLearningPaths.remove(index);
    }
    
    public Activity createExamActivity(String title, String description, String objective,
                                       int expectedDuration, LinkedList<Activity> prerequisites,
                                       LinkedList<Activity> followUpActivities,
                                       LinkedList<OpenQuestion> question) {

        Activity activity = new ExamActivity(title, description, objective, expectedDuration, prerequisites, followUpActivities, question);
        createdActivities.add(activity);
        return activity;
    }

    public Activity createFormActivity(String title, String description, String objective,
                                       int expectedDuration, LinkedList<Activity> prerequisites,
                                       LinkedList<Activity> followUpActivities,
                                       LinkedList<OpenQuestion> question) {

        Activity activity = new FormActivity(title, description, objective, expectedDuration, prerequisites, followUpActivities, question);
        createdActivities.add(activity);
        return activity;
    }

    public Activity createResourceActivity(String title, String description, String objective,
                                       int expectedDuration, LinkedList<Activity> prerequisites,
                                       LinkedList<Activity> followUpActivities, String url) {

        Activity activity = new ResourceActivity(title, description, objective, expectedDuration, prerequisites, followUpActivities, url);
        createdActivities.add(activity);
        return activity;
    }

    public Activity createTaskActivity(String title, String description, String objective,
                                       int expectedDuration, LinkedList<Activity> prerequisites,
                                       LinkedList<Activity> followUpActivities, boolean state) {

        Activity activity = new TaskActivity(title, description, objective, expectedDuration, prerequisites, followUpActivities);
        createdActivities.add(activity);
        return activity;
    }

    public Activity createQuizActivity(String title, String description, String objective,
                                       int expectedDuration, LinkedList<Activity> prerequisites,
                                       LinkedList<Activity> followUpActivities,
                                       LinkedList<MultipleOptionQuestion> question, double minscore) {

        Activity activity = new QuizActivity(title, description, objective, expectedDuration, prerequisites, followUpActivities, question, minscore);
        createdActivities.add(activity);
        return activity;
    }

    public void editActivity(int index, String title, String description, String objective,
                             int expectedDuration, LinkedList<Activity> prerequisites,
                             LinkedList<Activity> followUpActivities) {

        Activity activity = createdActivities.get(index);
        activity.setTitle(title);
        activity.setDescription(description);
        activity.setObjective(objective);
        activity.setExpectedDuration(expectedDuration);
        activity.setPrerequisites(prerequisites);
        activity.setFollowUpActivities(followUpActivities);
    }
    
    public void deleteActivity(int index) {
        createdActivities.remove(index);
    }
    
    public void addActivityToLearningPath(LearningPath learningPath, Activity activity) {
        learningPath.addActivity(activity);
    }
    
    public void removeActivityFromLearningPath(LearningPath learningPath, int pos) {
        learningPath.removeActivityByIndex(pos);
    }

}
