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

    //Student management methods

    public LinkedList<ProgressTracker> getStudentProgressTrackers(Student student) {
        return student.getProgressTrackers();
    }

    public LinkedList<ProgressTracker> getStudentProgressTrackerByIndex(Student student) {
        return student.getProgressTrackerByIndex();
    }

    public void enrollInLearningPath(Student student, LearningPath learningPath) {
        ProgressTracker progressTracker = new ProgressTracker(learningPath);
        student.addProgressTracker(progressTracker);
        LearningPath.addProgressTracker(progressTracker);
    }

    //Progress tracker management methods
    //TODO: Update ProgressTracker methods to match the ProgressTracker class
    public void getActivityTrackers(ProgressTracker progressTracker) {
        return progressTracker.getActivityTrackers();
    }

    public void getActivityTrackerByIndex(ProgressTracker progressTracker, int index) {
        return progressTracker.getActivityTrackerByIndex(index);
    }

    //Activity tracker management methods
    //TODO: Update ActivityTracker methods to match the ActivityTracker class
    public void getActivity(ActivityTracker activityTracker) {
        return activityTracker.getActivity();
    }

    public void getActivityStatus(ActivityTracker activityTracker) {
        return activityTracker.getStatus();
    }

    public void recordActivityCompletion(ActivityTracker activityTracker) {
        activityTracker.setStatus("Completed");
    }

}


