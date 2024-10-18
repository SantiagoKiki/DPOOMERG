package controller;

import learningpath.LearningPath;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class Controller<Activity,User,Student,Professor,ProgressTracker,ActivityTracker>{

    protected HashMap<String, User> userHashMap;
    protected HashMap<Integer, LearningPath> learningPathHashMap;
    protected HashMap<Integer, Activity> activityHashMap;
    protected User currentUser;

    public Controller() {
        userHashMap = new HashMap<>();
        learningPathHashMap = new HashMap<>();
        activityHashMap = new HashMap<>();
        currentUser = null;
    }

    public Controller(HashMap<String, User> userHashMap, HashMap<Integer, LearningPath> learningPathHashMap, HashMap<Integer, Activity> activityHashMap, User currentUser) {
        this.userHashMap = userHashMap;
        this.learningPathHashMap = learningPathHashMap;
        this.activityHashMap = activityHashMap;
        this.currentUser = currentUser;
    }

    //Query methods

    public LearningPath getLearningPath(int id) {
        return learningPathHashMap.get(id);
    }

    public Activity getActivity(int id) {
        return activityHashMap.get(id);
    }

    //User management methods

    public void registerUser(String username, String password, String role) {
        if (role.equals("Student")) {
            registerStudent(username, password);
        } else if (role.equals("Professor")) {
            registerProfessor(username, password);
        }
    }

    public void registerStudent(String username, String password) {
        if (!userHashMap.containsKey(username)) {
            User newStudent = new Student(username, password);
            userHashMap.put(username, newStudent);
        }
    }

    public void registerProfessor(String username, String password) {
        if (!userHashMap.containsKey(username)) {
            User newProfessor = new Professor(username, password);
            userHashMap.put(username, newProfessor);
        }
    }

    public Controller login(String username, String password) {
        if (userHashMap.containsKey(username)) {
            User user = userHashMap.get(username);
            if (user.authenticate(password)) {
                if (user.getRole().equals("Student")) {
                    StudentController newInstance = new StudentController(this.userHashMap, this.learningPathHashMap, this.activityHashMap, user);
                    return newInstance;
                } else if (user.getRole().equals("Professor")) {
                    ProfessorController newInstance = new ProfessorController(this.userHashMap, this.learningPathHashMap, this.activityHashMap, user);
                    return newInstance;
                }
            }
        }
        return null;
    }

    public Controller logout() {
        Controller newInstance = new Controller(this.userHashMap, this.learningPathHashMap, this.activityHashMap, null);
        return newInstance;
    }

    public void reviewActivity(Activity activity, int rating, String comment) {
        activity.addReview(rating, comment);
    }



