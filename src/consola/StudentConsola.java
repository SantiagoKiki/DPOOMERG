package consola;

import java.util.Scanner;

import controller.StudentController;
import learningpath.LearningPath;
import persistencia.CentralPersistencia;
import users.Student;

public class StudentConsola {
	
	private static Student studentOwn;
	protected Scanner scanner; 

	

	public StudentConsola(Student studentOwn) {
		super();
		studentOwn.setViewStudent(this);
		this.studentOwn = studentOwn;
	}


	
	public void mostrarMenu() {
		System.out.println("\n===========================================");
		System.out.println("Bienvenido, Estudiante!");
        System.out.println("===========================================\n");
        System.out.println("1. Ver ofertas aceptadas \n");
        System.out.println("0. Cerrar sesión \n");
        System.out.println("1. Ver ofertas aceptadas \n");
        System.out.println("0. Cerrar sesión \n");
        
        
        String opcion = getInput("\nSelecciona una opción: ").trim();
        seleccionarOpcion(opcion);
	}
	
	public void seleccionarOpcion(String opcion) {
		if (!(opcion.equals("0"))) {
			switch(opcion) {
				case "1":
			 	break;
			} 
		} else {
			ViewLogin studentConsole = new ViewLogin(studentOwn.getViewStudent());
			studentConsole.mostrarMenu();
		}
	}
	
	public String getInput(String prompt) {
		System.out.println(prompt);
        String input = scanner.nextLine();
        return input;
    }
    

	public static void main(String[] args) {
		 CentralPersistencia centralPersistencia = new CentralPersistencia();
	     LearningPath learningPath = (LearningPath) centralPersistencia.cargar();
	     StudentController studentPersistir = (StudentController) centralPersistencia.cargar();
	     StudentController studentController;
	     Object data = centralPersistencia.cargar(); 

	        if (studentPersistir == null) {
	            System.out.println("Debes esperar a que se realice la configuración inicial");
	            return; 
	        }
	        
	        if (data instanceof StudentController) {
	        	studentController = (StudentController) data;
	            studentController.setCentralPersistencia(centralPersistencia);
	            System.out.println("Galería cargada con éxito");
	            ViewLogin viewLogin = new ViewLogin( null, studentController);
	            viewLogin.mostrarMenu();
	        } else {
	        	studentController = new StudentController(null, null, null, studentOwn );
	            centralPersistencia.guardarStudent(studentController);
	        }
	        ViewLogin viewLogin = new ViewLogin(null ,studentPersistir); 
	        viewLogin.mostrarMenu();
		System.out.println("Hola usuario porfavor ingresa tus datos");
	}
	
	
	
	
}
