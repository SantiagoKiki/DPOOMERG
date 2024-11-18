package consola;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ProfessorController;
import controller.StudentController;
import users.Professor;
import users.Student;

public class ViewRegister {
	protected Scanner scanner; 
	private StudentController studentController;
	private ProfessorController professorController;
	/**
	 * Constructor
	 */
	public ViewRegister(StudentController studentController, ProfessorController professorController) {

		this.studentController = studentController;
		this.professorController = professorController;
	}
	
	/**
	 * Menús
	 */
	public void mostrarMenuUsuario(String tipoUsuario) {
		if (studentController.getStudent().getRole().equals(tipoUsuario)) {
			mostrarMenuStudent();
		} 
	}
	

	/**
	 * Mostrar el menú de registro para un usuario de tipo "Administrador"
	 */
	public void mostrarMenuStudent() {
		 System.out.println("\n===========================================");
		 System.out.println("Configuración inicial");
         System.out.println("No hay ningún administrador configurado en el sistema.\n");
         System.out.println("Como primer paso, debes crear una cuenta de estudiante.");
         registrarNuevoUsuario("student");
	}
	
	/**
	 * Método para registrar un nuevo usuario.
	 * @param tipoUsuario El tipo de usuario a registrar.
	 */
	public String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
	
	public void registrarNuevoUsuario(String tipoUsuario) {
		
		String nombre = capitalize(getInput("\nNombre: ").trim());
		String apellido = capitalize(getInput("\nApellido: ").trim());
		String cedula = String.valueOf(getInputInt("\nCédula: "));
		
		switch(tipoUsuario) {
		
		case "student":
			String login = validarLogin();
			String password = validarPassword();
			Student student = new Student(nombre, password);
			
			System.out.println("\nUsuario creado con éxito.");
			StudentConsola viewStudent = new StudentConsola(student);
			student.setViewStudent(viewStudent);
			viewStudent.mostrarMenu();
			break;
			
		}
		;
	}
	
	
	/**
	 * Método para validar el nombre de usuario.
	 * @return El nombre de usuario validado.
	 */
	public String validarLogin() {
		while (true) {
			String login = getInput("\nNombre de usuario: ").trim();
			
	        try {
	        	if (login.equals("")) {
					throw new IllegalArgumentException("No has ingresado información.\n");
	        	}
	        	if (studentController.arrayStudents.contains(login)) {
					throw new IllegalArgumentException("El usuario " + login + "ya se encuentra registrado. Intenta con uno diferente.\n");
	        	}
	        	return login;
	        } catch (IllegalArgumentException e) {
	        	System.out.println(e.getMessage());	
	        }	
		}
	}
	
	public String getInput(String prompt) {
		System.out.println(prompt);
        String input = scanner.nextLine();
        return input;
    }
	public int getInputInt(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            try {
                int numero = scanner.nextInt();
                scanner.nextLine();
                return numero; // Return the successfully parsed integer
            } catch (InputMismatchException e) {
            	System.out.println("La información ingresada no es un número.");
                scanner.nextLine();
            }
        }
    }
	
	
	/**
	 * Método para validar la contraseña.
	 * @return La contraseña validada.
	 */
	public String validarPassword() {
		while (true) {
			String password = getInput("\nContraseña: \nDebe tener al menos una mayúscula, un número y un símbolo especial [!@#$%^&()*]").trim();
	        try {
	        	String mayusculaRegex = ".*[A-Z].*";
	            String simboloRegex = ".*[!@#$%^&*()].*";
	            String numeroRegex = ".*\\d.*";
	            
	            if (password.equals("")) {
					throw new IllegalArgumentException("No has ingresado información.\n");
	        	}
	        	if (!(password.matches(mayusculaRegex))) {
					throw new IllegalArgumentException("La contraseña debe contener al menos una mayúscula.\n");
				} 
				if (!(password.matches(simboloRegex))) {
					throw new IllegalArgumentException("La contraseña debe contener al menos un símbolo especial.\n");
				}
				if (!(password.matches(numeroRegex))) {
					throw new IllegalArgumentException("La contraseña debe contener al menos un número.\n");		
				}
				return password;
	        } catch (IllegalArgumentException e) {
	        	System.out.println("Contraseña inválida: " + e.getMessage() + "\nIntenta de nuevo");	
	        }
		}
	}
	
	public void close() {
        scanner.close();

	}	
}
