package controller;

import learningpath.*;
import learningpath.activity.*;
import tracker.ActivityTracker;
import tracker.ProgressTracker;
import users.*;

import java.util.HashMap;
import java.util.LinkedList;

public class StudentController extends Controller {

    Student student;

    public StudentController(HashMap<String, User> userHashMap, HashMap<Integer, LearningPath> learningPathHashMap, HashMap<Integer, Activity> activityHashMap, User currentUser) {
        super(userHashMap, learningPathHashMap, activityHashMap, currentUser);
        student = (Student) currentUser;
    }

    // Student management methods

    /**
     * Enrolls a student in a learning path.
     * @param learningPath The learning path in which the student is to be enrolled.
     */
    public void enrollInLearningPath(LearningPath learningPath) {
        student.enrollInLearningPath(learningPath);
    }

    public LinkedList<LearningPath> getLearningPathsByInterest(String interest) {

        LinkedList<LearningPath> learningPaths = new LinkedList<>();

        for(LearningPath learningPath : learningPathHashMap.values()) {

            LinkedList tags = learningPath.getTags();
            if(tags.contains(interest)) {
                learningPaths.add(learningPath);
            }
        }
        return learningPaths;
    }

    // Progress tracker management methods

    /**
     * Retrieves the progress trackers associated with a student.
     *
     * @param student The student whose progress trackers are to be retrieved.
     * @return A linked list of progress trackers associated with the student.
     */
    public LinkedList<ProgressTracker> getStudentProgressTrackers(Student student) {
        return student.getProgressTrackers();
    }

    /**
     * Retrieves a progress tracker by its index from a student's progress trackers.
     *
     * @return A linked list of progress trackers associated with the student.
     */
    public ProgressTracker getStudentProgressTrackerByIndex(int index) {
        return student.getProgressTrackerByIndex(index);
    }

    /**
     * Retrieves the activity trackers associated with a progress tracker.
     *
     * @param progressTracker The progress tracker whose activity trackers are to be retrieved.
     * @return A linked list of activity trackers associated with the progress tracker.
     */
    public LinkedList<ActivityTracker> getActivityTrackers(ProgressTracker progressTracker) {
        return progressTracker.getActivityTrackers();
    }

    /**
     * Retrieves an activity tracker by its index from a progress tracker's activity trackers.
     *
     * @param progressTracker The progress tracker whose activity tracker is to be retrieved.
     * @param index The index of the activity tracker.
     * @return The activity tracker at the specified index.
     */
    public ActivityTracker getActivityTrackerByIndex(ProgressTracker progressTracker, int index) {
        return progressTracker.getActivityTrackerByIndex(index);
    }

    // Activity tracker management methods

    /**
     * Retrieves the activity associated with an activity tracker.
     *
     * @param activityTracker The activity tracker whose activity is to be retrieved.
     * @return The activity associated with the activity tracker.
     */
    public Activity getActivity(ActivityTracker activityTracker) {
        return activityTracker.getActivity();
    }

    /**
     * Retrieves the status of an activity tracker.
     *
     * @param activityTracker The activity tracker whose status is to be retrieved.
     * @return The status of the activity tracker.
     */
    public String getActivityStatus(ActivityTracker activityTracker) {
        return activityTracker.getStatus();
    }

    /**
     * Records the completion of an activity.
     *
     * @param activityTracker The activity tracker whose activity is to be marked as completed.
     */
    public void recordActivityCompletion(ActivityTracker activityTracker) {
        activityTracker.setStatus("Completed");
    }
}


