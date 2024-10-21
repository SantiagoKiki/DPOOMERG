package users;


import java.util.HashMap;
import java.util.Scanner;

public class UsersVerifier {
    public static HashMap<String, String> usersDataBase = new HashMap<>();
    public static String currentUser = null;
    
    
    
    public static boolean verifyLogin(String username, String password) {
        return usersDataBase.containsKey(username) && usersDataBase.get(username).equals(password);
    }

    public static void logout() {
        System.out.println("Cerrando sesión de " + currentUser + "...");
        currentUser = null;
        }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            if (currentUser == null) {
                System.out.print("Ingresa tu nombre de usuario: ");
                String username = scanner.nextLine();

                System.out.print("Ingresa tu contraseña: ");
                String password = scanner.nextLine();

                if (verifyLogin(username, password)) {
                    currentUser = username;
                    System.out.println("¡Login exitoso! Bienvenido " + username);
                } else {
                    System.out.println("Error: Usuario o contraseña incorrectos.");
                }
            } else {
                System.out.println("\n--- MENÚ ---");
                System.out.println("1. Ver perfil");
                System.out.println("2. Logout");
                System.out.println("3. Salir");

                System.out.print("Elige una opción: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("Estás viendo el perfil de " + currentUser);
                        break;
                    case 2:
                        logout();
                        break;
                    case 3:
                        isRunning = false;
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }

        scanner.close();
    }
    
    
	public static HashMap<String, String> getUsersDataBase() {
		return usersDataBase;
	}
	public static void setUsersDataBase(HashMap<String, String> usersDataBase) {
		UsersVerifier.usersDataBase = usersDataBase;
	}
	public static String getCurrentUser() {
		return currentUser;
	}
	public static void setCurrentUser(String currentUser) {
		UsersVerifier.currentUser = currentUser;
	}

    
	
    
}