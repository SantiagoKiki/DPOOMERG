package controller;

import learningpath.LearningPath;

import java.util.HashMap;
import java.util.LinkedList;

public class StudentController<User, Student, ProgressTracker, ActivityTracker> extends Controller {

    Student student;

    public StudentController(HashMap<String, User> userHashMap, HashMap<Integer, LearningPath> learningPathHashMap, HashMap<Integer, Activity> activityHashMap, User currentUser) {
        super(userHashMap, learningPathHashMap, activityHashMap, currentUser);
        student = (Student) currentUser;
    }

    // Student management methods

    /**
     * Enrolls a student in a learning path.
     *
     * @param student The student to be enrolled.
     * @param learningPath The learning path in which the student is to be enrolled.
     */
    public void enrollInLearningPath(Student student, LearningPath learningPath) {
        ProgressTracker progressTracker = new ProgressTracker(learningPath);
        student.addProgressTracker(progressTracker);
        LearningPath.addProgressTracker(progressTracker);
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
     * @param student The student whose progress tracker is to be retrieved.
     * @return A linked list of progress trackers associated with the student.
     */
    public LinkedList<ProgressTracker> getStudentProgressTrackerByIndex(Student student) {
        return student.getProgressTrackerByIndex();
    }

    /**
     * Retrieves the activity trackers associated with a progress tracker.
     *
     * @param progressTracker The progress tracker whose activity trackers are to be retrieved.
     * @return A linked list of activity trackers associated with the progress tracker.
     */
    public void getActivityTrackers(ProgressTracker progressTracker) {
        return progressTracker.getActivityTrackers();
    }

    /**
     * Retrieves an activity tracker by its index from a progress tracker's activity trackers.
     *
     * @param progressTracker The progress tracker whose activity tracker is to be retrieved.
     * @param index The index of the activity tracker.
     * @return The activity tracker at the specified index.
     */
    public void getActivityTrackerByIndex(ProgressTracker progressTracker, int index) {
        return progressTracker.getActivityTrackerByIndex(index);
    }

    // Activity tracker management methods

    /**
     * Retrieves the activity associated with an activity tracker.
     *
     * @param activityTracker The activity tracker whose activity is to be retrieved.
     * @return The activity associated with the activity tracker.
     */
    public void getActivity(ActivityTracker activityTracker) {
        return activityTracker.getActivity();
    }

    /**
     * Retrieves the status of an activity tracker.
     *
     * @param activityTracker The activity tracker whose status is to be retrieved.
     * @return The status of the activity tracker.
     */
    public void getActivityStatus(ActivityTracker activityTracker) {
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


