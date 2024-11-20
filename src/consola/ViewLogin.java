package consola;

import java.util.Scanner;

import controller.ProfessorController;
import controller.StudentController;
import users.Professor;
import users.Student;
import users.User;

public class ViewLogin {
	protected Scanner scanner; 
	
	public ViewLogin(StudentConsola studentConsola) {
		this.scanner = new Scanner(System.in);
	}
	
	private StudentController studentController;
	
	public ViewLogin( StudentController studentController) {
		this.studentController = studentController;
		this.scanner = new Scanner(System.in);

	}

	public void mostrarMenu() {
		 System.out.println("\n===========================================");
		 System.out.println("Bienvenido al sistema");
		 System.out.println("===========================================\n");
		if (studentController != null) {
			
			System.out.println("Iniciar sesión ");
			String login = getInput("\nUsuario: ");
			if (StudentController.arrayStudents.contains(login) || ProfessorController.arrayProfes.contains(login))  {
				if(StudentController.arrayStudents.contains(login)) 
				{validarPasswordStudent(login);
				User usuario = studentController.getStudent();
				iniciarSesion(usuario);
				}
				if(ProfessorController.arrayProfes.contains(login)) 
				{validarPasswordProfessor(login);
				User usuario = studentController.getStudent();
				iniciarSesion(usuario);
				
				}
				System.out.println("\nInicio de sesión exitoso.");
			}
			else {
				usuarioNoRegistrado();
			}
		}
	}
	
	
	
	public String getInput(String prompt) {
		System.out.println(prompt);
        String input = scanner.nextLine();
        return input;
    }
    

	
	public void usuarioNoRegistrado() {
		boolean opcion = getInputY_N("\nEl usuario no se encuentra registrado. ¿Deseas registrarte?");
		if(opcion) {				
			ViewRegister viewRegistro = new ViewRegister(studentController);
			viewRegistro.mostrarMenuUsuario("Usuario");
		
		} else {
			mostrarMenu();
		}
	}
	
	private void validarPasswordStudent(String login) {
		while (true) {
			String password = getInput("\nContraseña: ").trim();
			for(Student elements : StudentController.arrayStudents) 
			{ if (elements.getUsername() == login){
				Student usuario = elements;
				try {
					if (password.equals(usuario.getPassword())) {
						break;
					} else {
						throw new IllegalArgumentException("La contraseña no es correcta");
					}
				} catch (IllegalArgumentException e ) {
					System.out.println(e.getMessage());
					boolean opcion = getInputY_N("\n¿Volver?");
					if(opcion) {				
						mostrarMenu();
						break;
					} 
				}
			}
			}
			
		}
	}
	private void validarPasswordProfessor(String login) {
		while (true) {
			String password = getInput("\nContraseña: ").trim();
			for(Professor elements : ProfessorController.arrayProfes) 
			{ if (elements.getUsername() == login){
				Professor usuario = elements;
				try {
					if (password.equals(usuario.getPassword())) {
						break;
					} else {
						throw new IllegalArgumentException("La contraseña no es correcta");
					}
				} catch (IllegalArgumentException e ) {
					System.out.println(e.getMessage());
					boolean opcion = getInputY_N("\n¿Volver?");
					if(opcion) {				
						mostrarMenu();
						break;
					} 
				}
			}
			}
			
		}
	}

	
	public String validarLogin() {
		while (true) {
			String login = getInput("\nNombre de usuario: ");
	        try {
	        	if (login.equals("")) {
					throw new IllegalArgumentException("No has ingresado información.\n");
	        	}
	        	return login;
	        } catch (IllegalArgumentException e) {
	        	System.out.println(e.getMessage());	
	        }	
		}
	}
	
	public boolean getInputY_N(String mensaje) {
        System.out.println(mensaje + " [Y/N]");
        while (true) {
            String action = getInput("Ingresa una opción:").trim();
            if (action.equalsIgnoreCase("Y")) {
                return true;
            } else if (action.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Opción inválida. Ingresa 'Y' para sí o 'N' para no.");
            }
        }
    }

	
	public void iniciarSesion(User usuario) {
		String tipoUsuario = usuario.getRole();
		switch(tipoUsuario) {
		case "professor":
			Professor profesor = (Professor) usuario;
			ProfessorConsola viewProfessor = new ProfessorConsola(profesor);
			viewProfessor.mostrarMenu();
			break;
		case "student":
			Student empleado = (Student) usuario;
			StudentConsola viewEmpleado = new StudentConsola(empleado);
			viewEmpleado.mostrarMenu();
			break;

		}
		
	}
	public void close() {
        scanner.close();
	
}
	}
