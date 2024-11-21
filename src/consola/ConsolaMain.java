package consola;

import controller.Controller;
import controller.ProfessorController;
import controller.StudentController;
import java.util.Scanner;


/**
 * The main class for the console application.
 */
public class ConsolaMain {

    /**
     * The main method that runs the console application.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createUser(controller, scanner);
                    break;
                case 2:
                    Controller newController = logIn(controller, scanner);
                    if (newController != null) {
                        controller = newController;
                        if (controller instanceof ProfessorController) {
                            ProfessorConsola consola = new ProfessorConsola((ProfessorController) controller);
                            consola.start();
                            controller = new Controller(controller.getUserHashMap(), controller.getLearningPathHashMap(), controller.getActivityHashMap(), null);
                        } else if (controller instanceof StudentController) {
                            StudentConsola consola = new StudentConsola((StudentController) controller);
                            consola.start();
                            controller = new Controller(controller.getUserHashMap(), controller.getLearningPathHashMap(), controller.getActivityHashMap(), null);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Creates a new user.
     *
     * @param controller The controller to handle user creation
     * @param scanner The scanner to read user input
     */
    private static void createUser(Controller controller, Scanner scanner) {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String name = scanner.nextLine();
        System.out.print("Enter User Type (1 for Professor, 2 for Student): ");
        int userType = scanner.nextInt();
        String userRole;
        scanner.nextLine(); // Consume newline

        if (userType == 1) {
            userRole = "PROFESSOR";
        } else {
            userRole = "STUDENT";
        }

        controller.registerUser(username, name, userRole);

        System.out.println("User created successfully.");
    }

    /**
     * Logs in a user.
     *
     * @param controller The controller to handle user login
     * @param scanner The scanner to read user input
     * @return A new controller if login is successful, null otherwise
     */
    private static Controller logIn(Controller controller, Scanner scanner) {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        Controller newController = controller.login(username, password);
        if (newController != null) {
            return newController;
        } else {
            System.out.println("User not found. Please try again.");
        }
        return null;
    }
}