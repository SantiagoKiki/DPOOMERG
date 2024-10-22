package controller;

import learningpath.*;
import learningpath.activity.Activity;
import users.*;

import java.util.HashMap;

public class Controller {

    protected HashMap<String, User> userHashMap;
    protected HashMap<Integer, LearningPath> learningPathHashMap;
    protected HashMap<Integer, Activity> activityHashMap;
    protected User currentUser;

    /**
     * Default constructor initializing the hash maps and setting the current user to null.
     */
    public Controller() {
        userHashMap = new HashMap<>();
        learningPathHashMap = new HashMap<>();
        activityHashMap = new HashMap<>();
        currentUser = null;
    }

    /**
     * Constructor initializing the hash maps and setting the current user.
     *
     * @param userHashMap A hash map of users.
     * @param learningPathHashMap A hash map of learning paths.
     * @param activityHashMap A hash map of activities.
     * @param currentUser The current user.
     */
    public Controller(HashMap<String, User> userHashMap, HashMap<Integer, LearningPath> learningPathHashMap, HashMap<Integer, Activity> activityHashMap, User currentUser) {
        this.userHashMap = userHashMap;
        this.learningPathHashMap = learningPathHashMap;
        this.activityHashMap = activityHashMap;
        this.currentUser = currentUser;
    }

    // Query methods

    /**
     * Retrieves a learning path by its ID.
     *
     * @param id The ID of the learning path.
     * @return The learning path with the specified ID.
     */
    public LearningPath getLearningPath(int id) {
        return learningPathHashMap.get(id);
    }

    /**
     * Retrieves an activity by its ID.
     *
     * @param id The ID of the activity.
     * @return The activity with the specified ID.
     */
    public Activity getActivity(int id) {
        return activityHashMap.get(id);
    }

    // User management methods

    /**
     * Registers a user with the specified username, password, and role.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @param role The role of the user (e.g., "Student" or "Professor").
     */
    public void registerUser(String username, String password, String role) {
        if (role.equals("Student")) {
            registerStudent(username, password);
        } else if (role.equals("Professor")) {
            registerProfessor(username, password);
        }
    }

    /**
     * Registers a student with the specified username and password.
     *
     * @param username The username of the student.
     * @param password The password of the student.
     */
    public void registerStudent(String username, String password) {
        if (!userHashMap.containsKey(username)) {
            User newStudent = new Student(username, password);
            userHashMap.put(username, newStudent);
        }
    }

    /**
     * Registers a professor with the specified username and password.
     *
     * @param username The username of the professor.
     * @param password The password of the professor.
     */
    public void registerProfessor(String username, String password) {
        if (!userHashMap.containsKey(username)) {
            User newProfessor = new Professor(username, password);
            userHashMap.put(username, newProfessor);
        }
    }

    /**
     * Logs in a user with the specified username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return A new instance of the appropriate controller (StudentController or ProfessorController) if authentication is successful, otherwise null.
     */
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

    /**
     * Logs out the current user.
     *
     * @return A new instance of the Controller with the current user set to null.
     */
    public Controller logout() {
        Controller newInstance = new Controller(this.userHashMap, this.learningPathHashMap, this.activityHashMap, null);
        return newInstance;
    }
}