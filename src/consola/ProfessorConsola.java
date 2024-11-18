package consola;

import java.util.Scanner;

import learningpath.LearningPath;
import persistencia.CentralPersistencia;
import users.Professor;
import users.Student;

public class ProfessorConsola {
	
	private Professor professorOwn;
	protected Scanner scanner; 

	

	public ProfessorConsola(Professor professorOwn) {
		super();
		professorOwn.setViewProfessor(this);
		this.professorOwn = professorOwn;
	}


	
	public void mostrarMenu() {
		System.out.println("\n===========================================");
		System.out.println("Bienvenido, Professor!");
        System.out.println("===========================================\n");
        System.out.println("0.\n");
        System.out.println("1. Cerrar sesión \n");
        System.out.println("2. \n");
        System.out.println("3. Cerrar sesión \n");
        
        
        String opcion = getInput("\nSelecciona una opción: ").trim();
        seleccionarOpcion(opcion);
	}
	
	public void seleccionarOpcion(String opcion) {
		if (!(opcion.equals("0"))) {
			switch(opcion) {
				case "1":
			 	break;
			} 
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

		System.out.println("Hola usuario porfavor ingresa tus datos");
	}
}
