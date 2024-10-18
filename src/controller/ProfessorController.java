package controller;

import learningpath.LearningPath;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class ProfessorController<Activity,User,Student,Professor,ProgressTracker,ActivityTracker> extends Controller {

    public ProfessorController(HashMap<String, User> userHashMap, HashMap<Integer, LearningPath> learningPathHashMap, HashMap<Integer, Activity> activityHashMap, User currentUser) {
        super(userHashMap, learningPathHashMap, activityHashMap, currentUser);
    }

    //Professor management methods
    public LinkedList<LearningPath> getProfessorLearningPaths(Professor professor) {
        return professor.getLearningPaths();
    }

    public LearningPath getProfessorLearningPathByIndex(Professor professor, int index) {
        return professor.getLearningPathByIndex(index);
    }

    public Collection<LearningPath> getGlobalLearningPaths() {
        return learningPathHashMap.values();
    }

    public void createLearningPath(int id, String title, String description, LinkedList<String> objectives, int difficultyLevel, int duration, float rating, LinkedList<String> tags, Professor professor) {
        LearningPath newLearningPath = new LearningPath(id, title, description, objectives, difficultyLevel, tags,  currentUser);
        learningPathHashMap.put(newLearningPath.getId(), newLearningPath);
    }

    public void editLearningPathTitle(int id, String title) {
        LearningPath learningPath = learningPathHashMap.get(id);
        learningPath.setTitle(title);
        learningPath.updateVersion();
        learningPath.updateModificationDate();
    }

    public void editLearningPathDescription(int id, String description) {
        LearningPath learningPath = learningPathHashMap.get(id);
        learningPath.setDescription(description);
        learningPath.updateVersion();
        learningPath.updateModificationDate();
    }

    public void editLearningPathObjectives(int id, LinkedList<String> objectives) {
        LearningPath learningPath = learningPathHashMap.get(id);
        learningPath.setObjectives(objectives);
        learningPath.updateVersion();
        learningPath.updateModificationDate();
    }

    public void editLearningPathDifficultyLevel(int id, int difficultyLevel) {
        LearningPath learningPath = learningPathHashMap.get(id);
        learningPath.setDifficultyLevel(difficultyLevel);
        learningPath.updateVersion();
        learningPath.updateModificationDate();
    }

    public void editLearningPathTags(int id, LinkedList<String> tags) {
        LearningPath learningPath = learningPathHashMap.get(id);
        learningPath.setTags(tags);
        learningPath.updateVersion();
        learningPath.updateModificationDate();
    }

    public void deleteLearningPath(int id) {
        learningPathHashMap.remove(id);
    }

    public void addActivityToLearningPath(int learningPathId, int activityId) {
        LearningPath learningPath = learningPathHashMap.get(learningPathId);
        Activity activity = activityHashMap.get(activityId);
        learningPath.addActivity(activity);
    }

    public void addActivityToLearningPathByIndex(int learningPathId, int activityId, int index) {
        LearningPath learningPath = learningPathHashMap.get(learningPathId);
        Activity activity = activityHashMap.get(activityId);
        learningPath.addActivityByIndex(activity, index);
    }

    public void moveActivityInLearningPath(int learningPathId, int currentIndex, int finalIndex) {
        LearningPath learningPath = learningPathHashMap.get(learningPathId);
        Activity activity = activityHashMap.get(activityId);
        learningPath.moveActivity(currentIndex, finalIndex);
    }

    public void removeActivityByIndexFromLearningPath(int learningPathId, int index) {
        LearningPath learningPath = learningPathHashMap.get(learningPathId);
        learningPath.removeActivityByIndex(index);
    }

    //Activity management methods

    public LinkedList<Activity> getProfessorActivities(Professor professor) {
        return professor.getActivities();
    }

    public Collection<Activity> getGlobalActivities() {
        return activityHashMap.values();
    }

    public void createActivity() {
        //TODO: Implement createActivity
        Activity newActivity = new Activity();
        activityHashMap.put(newActivity.getId(), newActivity);
    }

    public void deleteActivity(int id) {
        activityHashMap.remove(id);
    }

    public void editActivity(){
        //TODO: Implement editActivity
    }

}
