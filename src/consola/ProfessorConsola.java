package consola;

import controller.ProfessorController;
import learningpath.LearningPath;
import learningpath.activity.Activity;
import learningpath.question.MultipleOptionQuestion;
import learningpath.question.OpenQuestion;

import java.util.LinkedList;
import java.util.Scanner;

public class ProfessorConsola {

    private final ProfessorController professorController;
    private final Scanner scanner;

    public ProfessorConsola(ProfessorController professorController) {
        this.professorController = professorController;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. View Professor Learning Paths");
            System.out.println("2. View Global Learning Paths");
            System.out.println("3. Create Learning Path");
            System.out.println("4. Edit Learning Path");
            System.out.println("5. View Professor Activities");
            System.out.println("6. View Global Activities");
            System.out.println("7. Create Activity");
            System.out.println("8. Edit Activity");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = getIntInput();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewProfessorLearningPaths();
                    break;
                case 2:
                    viewGlobalLearningPaths();
                    break;
                case 3:
                    createLearningPath();
                    break;
                case 4:
                    editLearningPath();
                    break;
                case 5:
                    viewProfessorActivities();
                    break;
                case 6:
                    viewGlobalActivities();
                    break;
                case 7:
                    createActivity();
                    break;
                case 8:
                    editActivity();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewProfessorLearningPaths() {
        LinkedList<LearningPath> learningPaths = professorController.getProfessorLearningPaths(professorController.getProfessor());
        for (LearningPath lp : learningPaths) {
            System.out.println(lp.getTitle() + ": " + lp.getDescription());
        }
    }

    private void viewGlobalLearningPaths() {
        for (LearningPath lp : professorController.getGlobalLearningPaths()) {
            System.out.println(lp.getTitle() + ": " + lp.getDescription());
        }
    }

    private void createLearningPath() {
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();
        LinkedList<String> objectives = new LinkedList<>();
        System.out.print("Enter Objectives (comma separated): ");
        for (String obj : scanner.nextLine().split(",")) {
            objectives.add(obj.trim());
        }
        System.out.print("Enter Difficulty Level: ");
        int difficultyLevel = getIntInput();
        scanner.nextLine(); // Consume newline
        LinkedList<String> tags = new LinkedList<>();
        System.out.print("Enter Tags (comma separated): ");
        for (String tag : scanner.nextLine().split(",")) {
            tags.add(tag.trim());
        }
        professorController.createLearningPath(title, description, objectives, difficultyLevel, tags, professorController.getProfessor());
        System.out.println("Learning Path created successfully.");
    }

    private void editLearningPath() {
        chooseCurrentLearningPath();

        System.out.println("Choose an option to edit:");
        System.out.println("1. Edit Title");
        System.out.println("2. Edit Description");
        System.out.println("3. Edit Objectives");
        System.out.println("4. Edit Difficulty Level");
        System.out.println("5. Edit Tags");
        System.out.println("6. Manage Activities");
        System.out.print("Choose an option: ");
        int editChoice = getIntInput();
        scanner.nextLine(); // Consume newline

        switch (editChoice) {
            case 1:
                System.out.print("Enter new title: ");
                String newTitle = scanner.nextLine();
                professorController.editCurrentLearningPathTitle(newTitle);
                break;
            case 2:
                System.out.print("Enter new description: ");
                String newDescription = scanner.nextLine();
                professorController.editCurrentLearningPathDescription(newDescription);
                break;
            case 3:
                LinkedList<String> newObjectives = new LinkedList<>();
                System.out.print("Enter new objectives (comma separated): ");
                for (String obj : scanner.nextLine().split(",")) {
                    newObjectives.add(obj.trim());
                }
                professorController.editCurrentLearningPathObjectives(newObjectives);
                break;
            case 4:
                System.out.print("Enter new difficulty level: ");
                int newDifficultyLevel = getIntInput();
                scanner.nextLine(); // Consume newline
                professorController.editCurrentLearningPathDifficultyLevel(newDifficultyLevel);
                break;
            case 5:
                LinkedList<String> newTags = new LinkedList<>();
                System.out.print("Enter new tags (comma separated): ");
                for (String tag : scanner.nextLine().split(",")) {
                    newTags.add(tag.trim());
                }
                professorController.editCurrentLearningPathTags(newTags);
                break;
            case 6:
                manageActivitiesInCurrentLearningPath();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

        System.out.println("Learning Path edited successfully.");
    }

    private void manageActivitiesInCurrentLearningPath() {
        System.out.println("Choose an option:");
        System.out.println("1. Add Activity");
        System.out.println("2. Add Activity at Specific Index");
        System.out.println("3. Move Activity");
        System.out.println("4. Remove Activity");
        System.out.print("Choose an option: ");
        int choice = getIntInput();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addActivityToCurrentLearningPath();
                break;
            case 2:
                addActivityToCurrentLearningPathByIndex();
                break;
            case 3:
                moveActivityInCurrentLearningPath();
                break;
            case 4:
                removeActivityFromCurrentLearningPath();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void addActivityToCurrentLearningPath() {
        chooseCurrentActivity();
        professorController.addCurrentActivityToCurrentLearningPath();
    }

    private void addActivityToCurrentLearningPathByIndex() {
        chooseCurrentActivity();
        System.out.print("Enter the index to add the activity at: ");
        int index = getIntInput();
        scanner.nextLine(); // Consume newline
        professorController.addCurrentActivityToCurrentLearningPathByIndex(index);
        System.out.println("Activity added to Learning Path at index " + index + " successfully.");
    }

    private void moveActivityInCurrentLearningPath() {
        System.out.print("Enter the index of the activity to move: ");
        int fromIndex = getIntInput();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the new index for the activity: ");
        int toIndex = getIntInput();
        scanner.nextLine(); // Consume newline
        professorController.moveActivityInCurrentLearningPath(fromIndex, toIndex);
        System.out.println("Activity moved successfully.");
    }

    private void removeActivityFromCurrentLearningPath() {
        System.out.print("Enter the index of the activity to remove: ");
        int index = getIntInput();
        scanner.nextLine(); // Consume newline
        professorController.removeActivityByIndexFromCurrentLearningPath(index);
        System.out.println("Activity removed successfully.");
    }

    private void viewProfessorActivities() {
        LinkedList<Activity> activities = professorController.getProfessorActivities();
        for (Activity activity : activities) {
            System.out.println(activity.getTitle() + ": " + activity.getDescription());
        }
    }

    private void viewGlobalActivities() {
        for (Activity activity : professorController.getGlobalActivities()) {
            System.out.println(activity.getTitle() + ": " + activity.getDescription());
        }
    }

    private void createActivity() {
        System.out.println("Choose Activity Type:");
        System.out.println("1. Exam Activity");
        System.out.println("2. Form Activity");
        System.out.println("3. Resource Activity");
        System.out.println("4. Quiz Activity");
        System.out.println("5. Task Activity");
        System.out.print("Choose an option: ");
        int activityType = getIntInput();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Objective: ");
        String objective = scanner.nextLine();
        System.out.print("Enter Expected Duration: ");
        int expectedDuration = getIntInput();
        scanner.nextLine(); // Consume newline
        System.out.print("Is it Mandatory? (true/false): ");
        boolean mandatory = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        switch (activityType) {
            case 1:
                createExamActivity(title, description, objective, expectedDuration, mandatory);
                break;
            case 2:
                createFormActivity(title, description, objective, expectedDuration, mandatory);
                break;
            case 3:
                createResourceActivity(title, description, objective, expectedDuration, mandatory);
                break;
            case 4:
                createQuizActivity(title, description, objective, expectedDuration, mandatory);
                break;
            case 5:
                createTaskActivity(title, description, objective, expectedDuration, mandatory);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void createExamActivity(String title, String description, String objective, int expectedDuration, boolean mandatory) {
        LinkedList<OpenQuestion> oquestions = new LinkedList<>();
        LinkedList<MultipleOptionQuestion> moquestions = new LinkedList<>();
        // Add logic to populate oquestions and moquestions
        professorController.createExamActivity(title, description, objective, expectedDuration, mandatory, oquestions, moquestions);
        System.out.println("Exam Activity created successfully.");
    }

    private void createFormActivity(String title, String description, String objective, int expectedDuration, boolean mandatory) {
        LinkedList<OpenQuestion> questions = new LinkedList<>();
        // Add logic to populate questions
        professorController.createFormActivity(title, description, objective, expectedDuration, mandatory, questions);
        System.out.println("Form Activity created successfully.");
    }

    private void createResourceActivity(String title, String description, String objective, int expectedDuration, boolean mandatory) {
        System.out.print("Enter URL: ");
        String url = scanner.nextLine();
        professorController.createResourceActivity(title, description, objective, expectedDuration, mandatory, url);
        System.out.println("Resource Activity created successfully.");
    }

    private void createQuizActivity(String title, String description, String objective, int expectedDuration, boolean mandatory) {
        LinkedList<MultipleOptionQuestion> questions = new LinkedList<>();
        System.out.print("Enter Minimum Score: ");
        double minscore = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        // Add logic to populate questions
        professorController.createQuizActivity(title, description, objective, expectedDuration, mandatory, questions, minscore);
        System.out.println("Quiz Activity created successfully.");
    }

    private void createTaskActivity(String title, String description, String objective, int expectedDuration, boolean mandatory) {
        System.out.print("Enter To-Do: ");
        String toDo = scanner.nextLine();
        professorController.createTaskActivity(title, description, objective, expectedDuration, mandatory, toDo);
        System.out.println("Task Activity created successfully.");
    }

    private void editActivity() {
        chooseCurrentActivity();

        System.out.println("Choose an option to edit:");
        System.out.println("1. Edit Title");
        System.out.println("2. Edit Description");
        System.out.println("3. Edit Objective");
        System.out.println("4. Edit Expected Duration");
        System.out.println("5. Add Prerequisite Activity");
        System.out.println("6. Remove Prerequisite Activity");
        System.out.println("7. Add Follow-Up Activity");
        System.out.println("8. Remove Follow-Up Activity");
        System.out.print("Choose an option: ");
        int editChoice = getIntInput();
        scanner.nextLine(); // Consume newline

        switch (editChoice) {
            case 1:
                System.out.print("Enter new title: ");
                String newTitle = scanner.nextLine();
                professorController.editCurrentActivityTitle(newTitle);
                break;
            case 2:
                System.out.print("Enter new description: ");
                String newDescription = scanner.nextLine();
                professorController.editCurrentActivityDescription(newDescription);
                break;
            case 3:
                System.out.print("Enter new objective: ");
                String newObjective = scanner.nextLine();
                professorController.editCurrentActivityObjective(newObjective);
                break;
            case 4:
                System.out.print("Enter new expected duration: ");
                int newDuration = getIntInput();
                scanner.nextLine(); // Consume newline
                professorController.editCurrentActivityExpectedDuration(newDuration);
                break;
            case 5:
                addPrerequisiteActivity();
                break;
            case 6:
                removePrerequisiteActivity();
                break;
            case 7:
                addFollowUpActivity();
                break;
            case 8:
                removeFollowUpActivity();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

        System.out.println("Activity edited successfully.");
    }

    private void addPrerequisiteActivity() {
        chooseCurrentActivity();
        System.out.print("Enter the index of the prerequisite activity: ");
        int index = getIntInput();
        scanner.nextLine(); // Consume newline
        professorController.addCurrentActivityPrerequisiteByIndex(index);
        System.out.println("Prerequisite activity added successfully.");
    }

    private void removePrerequisiteActivity() {
        System.out.print("Enter the index of the prerequisite activity to remove: ");
        int index = getIntInput();
        scanner.nextLine(); // Consume newline
        professorController.removeCurrentActivityPrerequisiteByIndex(index);
        System.out.println("Prerequisite activity removed successfully.");
    }

    private void addFollowUpActivity() {
        chooseCurrentActivity();
        System.out.print("Enter the index of the follow-up activity: ");
        int index = getIntInput();
        scanner.nextLine(); // Consume newline
        professorController.addCurrentActivityFollowUpActivityByIndex(index);
        System.out.println("Follow-up activity added successfully.");
    }

    private void removeFollowUpActivity() {
        System.out.print("Enter the index of the follow-up activity to remove: ");
        int index = getIntInput();
        scanner.nextLine(); // Consume newline
        professorController.removeCurrentActivityFollowUpActivityByIndex(index);
        System.out.println("Follow-up activity removed successfully.");
    }

    private void chooseCurrentLearningPath() {
        System.out.println("Choose Learning Path Type:");
        System.out.println("1. Professor Learning Paths");
        System.out.println("2. Global Learning Paths");
        System.out.print("Choose an option: ");
        int typeChoice = getIntInput();
        scanner.nextLine(); // Consume newline

        if (typeChoice == 1) {
            chooseProfessorLearningPath();
        } else if (typeChoice == 2) {
            chooseGlobalLearningPath();
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private void chooseProfessorLearningPath() {
        LinkedList<LearningPath> learningPaths = professorController.getProfessorLearningPaths(professorController.getProfessor());

        if (learningPaths.isEmpty()) {
            System.out.println("No learning paths available.");
            return;
        }

        System.out.println("Choose a Learning Path:");
        for (int i = 0; i < learningPaths.size(); i++) {
            System.out.println((i + 1) + ". " + learningPaths.get(i).getTitle());
        }
        System.out.print("Enter the number of the Learning Path: ");
        int pathChoice = getIntInput();
        scanner.nextLine(); // Consume newline

        if (pathChoice < 1 || pathChoice > learningPaths.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        LearningPath chosenPath = learningPaths.get(pathChoice - 1);
        professorController.setCurrentLearningPath(chosenPath);
        System.out.println("Current Learning Path set successfully.");
    }

    private void chooseGlobalLearningPath() {
        LinkedList<LearningPath> learningPaths = (LinkedList<LearningPath>) professorController.getGlobalLearningPaths();

        if (learningPaths.isEmpty()) {
            System.out.println("No learning paths available.");
            return;
        }

        System.out.println("Choose a Learning Path:");
        for (int i = 0; i < learningPaths.size(); i++) {
            System.out.println((i + 1) + ". " + learningPaths.get(i).getTitle());
        }
        System.out.print("Enter the number of the Learning Path: ");
        int pathChoice = getIntInput();
        scanner.nextLine(); // Consume newline

        if (pathChoice < 1 || pathChoice > learningPaths.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        LearningPath chosenPath = learningPaths.get(pathChoice - 1);
        professorController.setCurrentLearningPath(chosenPath);
        System.out.println("Current Learning Path set successfully.");
    }

    private void chooseCurrentActivity() {
        System.out.println("Choose Activity Type:");
        System.out.println("1. Professor Activities");
        System.out.println("2. Global Activities");
        System.out.print("Choose an option: ");
        int typeChoice = getIntInput();
        scanner.nextLine(); // Consume newline

        if (typeChoice == 1) {
            chooseProfessorActivity();
        } else if (typeChoice == 2) {
            chooseGlobalActivity();
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private void chooseProfessorActivity() {
        LinkedList<Activity> activities = professorController.getProfessorActivities();

        if (activities.isEmpty()) {
            System.out.println("No activities available.");
            return;
        }

        System.out.println("Choose an Activity:");
        for (int i = 0; i < activities.size(); i++) {
            System.out.println((i + 1) + ". " + activities.get(i).getTitle());
        }
        System.out.print("Enter the number of the Activity: ");
        int activityChoice = getIntInput();
        scanner.nextLine(); // Consume newline

        if (activityChoice < 1 || activityChoice > activities.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Activity chosenActivity = activities.get(activityChoice - 1);
        professorController.setCurrentActivity(chosenActivity);
        professorController.addCurrentActivityToCurrentLearningPath();
        System.out.println("Activity added to Learning Path successfully.");
    }

    private void chooseGlobalActivity() {
        LinkedList<Activity> activities = (LinkedList<Activity>) professorController.getGlobalActivities();

        if (activities.isEmpty()) {
            System.out.println("No activities available.");
            return;
        }

        System.out.println("Choose an Activity:");
        for (int i = 0; i < activities.size(); i++) {
            System.out.println((i + 1) + ". " + activities.get(i).getTitle());
        }
        System.out.print("Enter the number of the Activity: ");
        int activityChoice = getIntInput();
        scanner.nextLine(); // Consume newline

        if (activityChoice < 1 || activityChoice > activities.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Activity chosenActivity = activities.get(activityChoice - 1);
        professorController.setCurrentActivity(chosenActivity);
        professorController.addCurrentActivityToCurrentLearningPath();
        System.out.println("Activity added to Learning Path successfully.");
    }

    private int getIntInput() {
        int input;
        while (true) {
            if (scanner.hasNextInt()) {
                input = getIntInput();
                scanner.nextLine(); // Consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume invalid input
            }
        }
        return input;
    }
}