package controller;

import learningpath.LearningPath;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class ProfessorController<Activity, User, Student, Professor, ProgressTracker, ActivityTracker> extends Controller {

    /**
     * Constructs a new ProfessorController with the specified hash maps and current user.
     *
     * @param userHashMap A hash map of users.
     * @param learningPathHashMap A hash map of learning paths.
     * @param activityHashMap A hash map of activities.
     * @param currentUser The current user.
     */
    public ProfessorController(HashMap<String, User> userHashMap, HashMap<Integer, LearningPath> learningPathHashMap, HashMap<Integer, Activity> activityHashMap, User currentUser) {
        super(userHashMap, learningPathHashMap, activityHashMap, currentUser);
    }

    // Professor management methods

    /**
     * Retrieves the learning paths associated with a professor.
     *
     * @param professor The professor whose learning paths are to be retrieved.
     * @return A linked list of learning paths associated with the professor.
     */
    public LinkedList<LearningPath> getProfessorLearningPaths(Professor professor) {
        return professor.getLearningPaths();
    }

    /**
     * Retrieves a learning path by its index from a professor's learning paths.
     *
     * @param professor The professor whose learning path is to be retrieved.
     * @param index The index of the learning path.
     * @return The learning path at the specified index.
     */
    public LearningPath getProfessorLearningPathByIndex(Professor professor, int index) {
        return professor.getLearningPathByIndex(index);
    }

    /**
     * Retrieves all global learning paths.
     *
     * @return A collection of all global learning paths.
     */
    public Collection<LearningPath> getGlobalLearningPaths() {
        return learningPathHashMap.values();
    }

    /**
     * Creates a new learning path and adds it to the hash map.
     *
     * @param id The ID of the new learning path.
     * @param title The title of the new learning path.
     * @param description The description of the new learning path.
     * @param objectives The objectives of the new learning path.
     * @param difficultyLevel The difficulty level of the new learning path.
     * @param duration The duration of the new learning path.
     * @param rating The rating of the new learning path.
     * @param tags The tags associated with the new learning path.
     * @param professor The professor creating the new learning path.
     */
    public void createLearningPath(int id, String title, String description, LinkedList<String> objectives, int difficultyLevel, int duration, float rating, LinkedList<String> tags, Professor professor) {
        LearningPath newLearningPath = new LearningPath(id, title, description, objectives, difficultyLevel, tags, currentUser);
        learningPathHashMap.put(newLearningPath.getId(), newLearningPath);
    }

    /**
     * Edits the title of an existing learning path.
     *
     * @param id The ID of the learning path to be edited.
     * @param title The new title of the learning path.
     */
    public void editLearningPathTitle(int id, String title) {
        LearningPath learningPath = (LearningPath) learningPathHashMap.get(id);
        learningPath.setTitle(title);
        learningPath.updateVersion();
        learningPath.updateModificationDate();
    }

    /**
     * Edits the description of an existing learning path.
     *
     * @param id The ID of the learning path to be edited.
     * @param description The new description of the learning path.
     */
    public void editLearningPathDescription(int id, String description) {
        LearningPath learningPath = (LearningPath) learningPathHashMap.get(id);
        learningPath.setDescription(description);
        learningPath.updateVersion();
        learningPath.updateModificationDate();
    }

    /**
     * Edits the objectives of an existing learning path.
     *
     * @param id The ID of the learning path to be edited.
     * @param objectives The new objectives of the learning path.
     */
    public void editLearningPathObjectives(int id, LinkedList<String> objectives) {
        LearningPath learningPath = (LearningPath) learningPathHashMap.get(id);
        learningPath.setObjectives(objectives);
        learningPath.updateVersion();
        learningPath.updateModificationDate();
    }

    /**
     * Edits the difficulty level of an existing learning path.
     *
     * @param id The ID of the learning path to be edited.
     * @param difficultyLevel The new difficulty level of the learning path.
     */
    public void editLearningPathDifficultyLevel(int id, int difficultyLevel) {
        LearningPath learningPath = (LearningPath) learningPathHashMap.get(id);
        learningPath.setDifficultyLevel(difficultyLevel);
        learningPath.updateVersion();
        learningPath.updateModificationDate();
    }

    /**
     * Edits the tags of an existing learning path.
     *
     * @param id The ID of the learning path to be edited.
     * @param tags The new tags of the learning path.
     */
    public void editLearningPathTags(int id, LinkedList<String> tags) {
        LearningPath learningPath = (LearningPath) learningPathHashMap.get(id);
        learningPath.setTags(tags);
        learningPath.updateVersion();
        learningPath.updateModificationDate();
    }

    /**
     * Deletes a learning path by its ID.
     *
     * @param id The ID of the learning path to be deleted.
     */
    public void deleteLearningPath(int id) {
        learningPathHashMap.remove(id);
    }

    /**
     * Adds an activity to a learning path.
     *
     * @param learningPathId The ID of the learning path.
     * @param activityId The ID of the activity to be added.
     */
    public void addActivityToLearningPath(int learningPathId, int activityId) {
        LearningPath learningPath = (LearningPath) learningPathHashMap.get(learningPathId);
        Activity activity = (Activity) activityHashMap.get(activityId);
        learningPath.addActivity(activity);
    }

    /**
     * Adds an activity to a learning path at a specific index.
     *
     * @param learningPathId The ID of the learning path.
     * @param activityId The ID of the activity to be added.
     * @param index The index at which the activity should be added.
     */
    public void addActivityToLearningPathByIndex(int learningPathId, int activityId, int index) {
        LearningPath learningPath = (LearningPath) learningPathHashMap.get(learningPathId);
        Activity activity = (Activity) activityHashMap.get(activityId);
        learningPath.addActivityByIndex(activity, index);
    }

    /**
     * Moves an activity within a learning path from one index to another.
     *
     * @param learningPathId The ID of the learning path.
     * @param currentIndex The current index of the activity.
     * @param finalIndex The final index of the activity.
     */
    public void moveActivityInLearningPath(int learningPathId, int currentIndex, int finalIndex) {
        LearningPath learningPath = (LearningPath) learningPathHashMap.get(learningPathId);
        learningPath.moveActivity(currentIndex, finalIndex);
    }

    /**
     * Removes an activity from a learning path by its index.
     *
     * @param learningPathId The ID of the learning path.
     * @param index The index of the activity to be removed.
     */
    public void removeActivityByIndexFromLearningPath(int learningPathId, int index) {
        LearningPath learningPath = (LearningPath) learningPathHashMap.get(learningPathId);
        learningPath.removeActivityByIndex(index);
    }

    // Activity management methods

    /**
     * Retrieves the activities associated with a professor.
     *
     * @param professor The professor whose activities are to be retrieved.
     * @return A linked list of activities associated with the professor.
     */
    public LinkedList<Activity> getProfessorActivities(Professor professor) {
        return professor.getActivities();
    }

    /**
     * Retrieves all global activities.
     *
     * @return A collection of all global activities.
     */
    public Collection<Activity> getGlobalActivities() {
        return activityHashMap.values();
    }

    /**
     * Creates a new activity and adds it to the hash map.
     */
    public void createActivity() {
        // TODO: Implement createActivity
        Activity newActivity = new Activity();
        activityHashMap.put(newActivity.getId(), newActivity);
    }

    /**
     * Deletes an activity by its ID.
     *
     * @param id The ID of the activity to be deleted.
     */
    public void deleteActivity(int id) {
        activityHashMap.remove(id);
    }

    /**
     * Edits an existing activity.
     */
    public void editActivity() {
        // TODO: Implement editActivity
    }
}