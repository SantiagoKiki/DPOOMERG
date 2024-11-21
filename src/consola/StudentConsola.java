package consola;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;
import controller.StudentController;
import learningpath.LearningPath;
import learningpath.activity.Activity;
import learningpath.activity.ResourceActivity;
import learningpath.question.OpenQuestion;
import persistencia.CentralPersistencia;
import tracker.ActivityTracker;
import tracker.ProgressTracker;
import users.Professor;
import users.Student;



public class StudentConsola implements Serializable {

	private final StudentController studentController;
	protected Scanner scanner;
	private static Student studentOwn;
	public LinkedList<String> arrayIntereses = new LinkedList<String>();
	public String interes = "Programacion";
	public LinkedList<String> arrayEtiquetas = new LinkedList<String>(); //Para mostrar que es funcional
	public String tag1 = "TAG";
	public String tag2 = "Tag2";
	public Professor ivan = new Professor( "1234", "contraseña");
	public LinkedList<OpenQuestion> questions = null;
	public ResourceActivity actividad1 = new ResourceActivity("Titulo Ingenioso", "En esta actividad tienes que...", "El objetivo es....", 20, true, "");
	public LearningPath learningPathPrueba = new LearningPath("Sistemas", "Ingeniería en sistemas",  arrayIntereses, 4,  arrayEtiquetas,ivan);
	public CentralPersistencia persistir = new CentralPersistencia();

	public StudentConsola(StudentController studentController) {
		super();
		this.studentController = studentController;
		this.scanner = new Scanner(System.in);

	}


	public void start() {
	    arrayIntereses.add(interes);
	    arrayEtiquetas.add(tag1);
	    arrayEtiquetas.add(tag2);
	    System.out.println("\n===========================================");
	    System.out.println("Bienvenido, Estudiante!");
	    System.out.println("===========================================\n");
	    System.out.println("1. Ver Learning Paths \n");
	    System.out.println("2. Inscribir tu Learning Path \n");
	    System.out.println("3. Ver actividades de los Learnings Paths \n");
	    System.out.println("4. Generar reseña para un Learning Path \n");
	    System.out.println("5. Calificar una actividad \n");
	    System.out.println("6. Consultar progreso en un Learning Path \n");
	    System.out.println("0. Cerrar sesión \n");

	    while (true) {
	        String opcion = getInput("\nSelecciona una opción: ").trim();
	        switch (opcion) {
	            case "1":
	                System.out.println("Los siguientes learning Paths estan disponibles: \n");
	                System.out.println("Si esta interesad@ en alguno de ellos guarde el id ya que a través de el se podrá ingresar: \n");
	                for (LearningPath elements : LearningPath.allLearningPath) {
	                    System.out.println("Titulo: " + elements.getTitle() + " \n");
	                    System.out.println("Descripción: " + elements.getDescription() + " \n");
	                    System.out.println("Rating: " + elements.getRating() + " \n");
	                    System.out.println("Id: " + elements.getId() + " \n");
	                    System.out.println("===========================================\\n");
	                }
	                break;

	            case "2":
	                System.out.println("Por favor ingrese la id del LearningPath a inscribir: \n");
	                String numero = getInput("\nIngrese la id: ").trim();
	                LearningPath learningPath = studentOwn.mapaLearningPaths.get(numero);
	                studentController.setCurrentLearningPath(learningPath);
	                break;

	            case "3":
	                System.out.println("Ingrese la id del LearningPath a consultar: \n");
	                String idLearningPathActividad = getInput("\nIngrese la id: ").trim();
	                LearningPath learningPathIterable = studentOwn.mapaLearningPaths.get(idLearningPathActividad);
	                if (learningPathIterable != null) {
	                    System.out.println("Las siguientes son las actividades del learningPath escogido \n");
	                    for (Activity actividadesLearningPath : learningPathIterable.getActivities()) {
	                        System.out.println("El titulo de la actividad es:" + actividadesLearningPath.getTitle() + " \n");
	                        System.out.println("La descripción de la actividad es:" + actividadesLearningPath.getDescription() + " \n");
	                        System.out.println("El objetivo de la actividad es:" + actividadesLearningPath.getObjective() + " \n");
	                        System.out.println("La id de la actividad es:" + actividadesLearningPath.getId() + " \n");
	                        System.out.println("===========================================\\n");
	                    }
	                }
	                break;

	            case "4":
	                System.out.println("\n Generar Reseña para un Learning Path");
	                if (studentOwn.mapaLearningPaths.isEmpty()) {
	                    System.out.println("No tienes Learning Paths inscritos.");
	                    break;
	                }
	                for (String id : studentOwn.mapaLearningPaths.keySet()) {
	                    LearningPath lp = studentOwn.mapaLearningPaths.get(id);
	                    System.out.println("ID: " + id + ", Título: " + lp.getTitle());
	                }
	                String idLearningPathResena = getInput("Ingrese el ID del Learning Path para el que desea generar una reseña: ").trim();
	                LearningPath selectedPath = studentOwn.mapaLearningPaths.get(idLearningPathResena);
	                if (selectedPath == null) {
	                    System.out.println("El ID ingresado no corresponde a un Learning Path inscrito.");
	                    break;
	                }
	                String resena = getInput("Escriba su reseña: ");
	                studentOwn.addResena(selectedPath, resena);
	                studentController.getCentralPersistencia().guardarStudent(studentController);
	                System.out.println("Reseña añadida exitosamente.");
	                break;

	            case "5":
	                System.out.println("\nCalificar una Actividad");
	                if (studentOwn.getProgressTrackers().isEmpty()) {
	                    System.out.println("No tienes actividades disponibles para calificar. Asegúrate de estar inscrito en un Learning Path.");
	                    break;
	                }
	                System.out.println("Tus Learning Paths inscritos:");
	                for (int i = 0; i < studentOwn.getProgressTrackers().size(); i++) {
	                    System.out.println((i + 1) + ". " + studentOwn.getProgressTrackers().get(i).getLearningpath().getTitle());
	                }

	                int trackerIndex = Integer.parseInt(getInput("\nSelecciona el número del Learning Path que deseas consultar: ").trim()) - 1;

	                if (trackerIndex < 0 || trackerIndex >= studentOwn.getProgressTrackers().size()) {
	                    System.out.println("Índice inválido.");
	                    break;
	                }
	                ProgressTracker progressTracker = studentOwn.getProgressTrackers().get(trackerIndex);
	                LinkedList<ActivityTracker> activityTrackers = progressTracker.getActivityTrackers();
	                if (activityTrackers.isEmpty()) {
	                    System.out.println("No hay actividades disponibles para calificar en este Learning Path.");
	                    break;
	                }
	                System.out.println("\nActividades disponibles:");
	                for (int i = 0; i < activityTrackers.size(); i++) {
	                    System.out.println((i + 1) + ". " + activityTrackers.get(i).getActivity().getTitle());
	                }
	                int activityIndex = Integer.parseInt(getInput("\nSelecciona el número de la actividad que deseas calificar: ").trim()) - 1;
	                if (activityIndex < 0 || activityIndex >= activityTrackers.size()) {
	                    System.out.println("Índice inválido.");
	                    break;
	                }
	                ActivityTracker tracker = activityTrackers.get(activityIndex);
	                int rating = Integer.parseInt(getInput("Ingresa una calificación entre 1 y 5: ").trim());
	                if (rating < 1 || rating > 5) {
	                    System.out.println("La calificación debe estar entre 1 y 5.");
	                    break;
	                }
	                tracker.addRating(rating);
	                System.out.println("Has calificado la actividad " + tracker.getActivity().getTitle() + " con un " + rating);
	                break;

	            case "6":
	                if (studentOwn.mapaLearningPaths.isEmpty()) {
	                    System.out.println("No tienes Learning Paths inscritos.");
	                    break;
	                }
	                for (String id : studentOwn.mapaLearningPaths.keySet()) {
	                    LearningPath lp = studentOwn.mapaLearningPaths.get(id);
	                    System.out.println("ID: " + id + ", Título: " + lp.getTitle());
	                }
	                String idLearningPathProgreso = getInput("Ingrese el ID del Learning Path que desea consultar: ").trim();
	                LearningPath selectedPathProgreso = studentOwn.mapaLearningPaths.get(idLearningPathProgreso);
	                if (selectedPathProgreso == null) {
	                    System.out.println("El ID ingresado no corresponde a un Learning Path inscrito.");
	                    break;
	                }
	                ProgressTracker tracker2 = studentOwn.getProgressTrackerByLearningPath(selectedPathProgreso);
	                if (tracker2 == null) {
	                    System.out.println("No se encontró un progreso asociado a este Learning Path.");
	                    break;
	                }
	                System.out.println("Progreso actual del Learning Path '" + selectedPathProgreso.getTitle() + "': " + tracker2.getProgress() + "%");
	                break;

	            default:
	                System.out.println("Opción inválida. Prueba de nuevo.");
	        }
	    }
	}




	public String getInput(String prompt) {
		System.out.println(prompt);
        String input = scanner.nextLine();
        return input;
    }
    

/*	public void main() {
		 CentralPersistencia centralPersistencia = new CentralPersistencia();
	     LearningPath learningPath = (LearningPath) centralPersistencia.cargar();
	     StudentController studentPersistir = (StudentController) centralPersistencia.cargar();
	     Object dataStudent = centralPersistencia.cargarStudent();


	     /////aaaa
	     	String interes = "Programacion";
	        LinkedList<String> arrayIntereses = new LinkedList<>();
	        LinkedList<String> arrayEtiquetas = new LinkedList<>();
	        String tag1 = "TAG";
	        String tag2 = "Tag2";
	        arrayIntereses.add("programming");
	        arrayEtiquetas.add(tag1);
	        arrayEtiquetas.add(tag2);

	        Professor ivan = new Professor("1234", "contraseña");
	     	Student currentUser = new Student("Correo", "Password");
	        LinkedList<OpenQuestion> questions = new LinkedList<>();
	        ResourceActivity actividad1 = new ResourceActivity("Titulo Ingenioso", "En esta actividad tienes que...", "El objetivo es....", 20, true, "");
	        LearningPath learningPathPrueba = new LearningPath( "Sistemas", "Ingeniería en sistemas", arrayIntereses, 4, arrayEtiquetas, ivan);
	     	HashMap<String, User> userHashMap = new HashMap<String, User>();
	     	Student estudiante1 = new Student("Correo", "Password");
	     	HashMap<String, LearningPath> learningPathHashMap = new HashMap<String, LearningPath>();
	     	userHashMap.put("1", estudiante1);
	     	userHashMap.put("2", currentUser);
	     	learningPathHashMap.put("1", learningPathPrueba);
	     	HashMap<String, Activity> activityHashMap = new HashMap<String, Activity>();


	     	learningPathHashMap.put("1", learningPath);

	        StudentController studentController1 = new StudentController(userHashMap, learningPathHashMap, activityHashMap, currentUser);

	        if (dataStudent != null) {
	        	studentController = (StudentController) dataStudent;
	            studentController.setCentralPersistencia(centralPersistencia);
	            System.out.println("Cargada con éxito");
	            ViewLogin viewLogin = new ViewLogin(studentController);
	            viewLogin.mostrarMenu();
	        } else {
	        	studentController = new StudentController(null, null, null, studentOwn );
	            centralPersistencia.guardarStudent(studentController);
	        }
	}*/
	
	
	
	
}
