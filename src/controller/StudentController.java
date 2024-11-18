package controller;

import learningpath.*;
import learningpath.activity.*;
import tracker.ActivityTracker;
import tracker.ProgressTracker;
import users.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class StudentController extends Controller {

    private Student student;
    private LearningPath currentLearningPath;
    private ProgressTracker currentProgressTracker;
    private ActivityTracker currentActivityTracker;
    private LinkedList<LearningPath> learningPathsByInterest;


    public StudentController(HashMap<String, User> userHashMap, HashMap<String, LearningPath> learningPathHashMap, HashMap<String, Activity> activityHashMap, User currentUser) {
        super(userHashMap, learningPathHashMap, activityHashMap, currentUser);
        student = (Student) currentUser;

    }

    // Query methods

    public LinkedList<LearningPath> getLearningPathsByInterest(String interest) {

        LinkedList<LearningPath> learningPaths = new LinkedList<>();

        for(LearningPath learningPath : learningPathHashMap.values()) {

            LinkedList<String> tags = learningPath.getTags();
            if(tags.contains(interest)) {
                learningPaths.add(learningPath);
            }
        }
        learningPathsByInterest = learningPaths;
        return learningPaths;
    }

    public LearningPath getLearningPathByInterest(int index) {
        currentLearningPath = learningPathsByInterest.get(index);
        return currentLearningPath;
    }

    public Collection<LearningPath> getGlobalLearningPaths() {
        return learningPathHashMap.values();
    }

    public LearningPath getLearningPathById(String id) {
        currentLearningPath = learningPathHashMap.get(id);
        return currentLearningPath;
    }

    // Enrolling management method

    /**
     * Enrolls a student in a learning path.
     */
    public void enrollInLearningPath() {
        student.enrollInLearningPath(currentLearningPath);
    }


    // Progress tracker management methods

    /**
     * Retrieves the progress trackers associated with a student.
     *
     * @return A linked list of progress trackers associated with the student.
     */
    public LinkedList<ProgressTracker> getStudentProgressTrackers() {
        return student.getProgressTrackers();
    }

    /**
     * Retrieves a progress tracker by its index from a student's progress trackers.
     *
     * @return A linked list of progress trackers associated with the student.
     */
    public ProgressTracker getStudentProgressTrackerByIndex(int index) {
        currentProgressTracker = student.getProgressTrackerByIndex(index);
        return currentProgressTracker;
    }

    /**
     * Retrieves the activity trackers associated with a progress tracker.
     *
     * @return A linked list of activity trackers associated with the progress tracker.
     */
    public LinkedList<ActivityTracker> getActivityTrackers() {
        return currentProgressTracker.getActivityTrackers();
    }

    /**
     * Retrieves an activity tracker by its index from a progress tracker's activity trackers.
     *
     * @param index The index of the activity tracker.
     * @return The activity tracker at the specified index.
     */
    public ActivityTracker getActivityTrackerByIndex(int index) {
        return currentProgressTracker.getActivityTrackerByIndex(index);
    }

    // Activity tracker management methods

    /**
     * Retrieves the activity associated with an activity tracker.
     *
     * @return The activity associated with the activity tracker.
     */
    public Activity getActivity() {
        return currentActivityTracker.getActivity();
    }

    /**
     * Retrieves the status of an activity tracker.
     *
     * @return The status of the activity tracker.
     */
    public String getActivityStatus() {
        return currentActivityTracker.getCompletionStatus();
    }

    /**
     * Records the completion of an activity.
     */
    public void recordActivityStart() {
        currentProgressTracker.recordActivityStart(currentActivityTracker);
    }

    public void recordActivityCompletion() {
        currentProgressTracker.recordActivityCompletion(currentActivityTracker);
    }
}


