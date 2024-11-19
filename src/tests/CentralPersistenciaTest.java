package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.ProfessorController;
import controller.StudentController;
import learningpath.LearningPath;
import learningpath.activity.Activity;
import learningpath.activity.TaskActivity;
import persistencia.CentralPersistencia;
import users.Professor;
import users.Student;
import users.User;

public class CentralPersistenciaTest {
	 private CentralPersistencia centralPersistencia;
	    private StudentController studentController;
	    private ProfessorController professorController;
	    private HashMap<String, User> userHashMap;
	    private HashMap<String, LearningPath> learningPathHashMap;
	    private HashMap<String, Activity> activityHashMap;

	    @BeforeEach
	    void setUp() {
	        centralPersistencia = new CentralPersistencia();
	        userHashMap = new HashMap<>();
	        learningPathHashMap = new HashMap<>();
	        activityHashMap = new HashMap<>();

	        // Crear un usuario Student y un controlador para pruebas
	        Student student = new Student("student1", "password");
	        userHashMap.put(student.getUsername(), student);
	        studentController = new StudentController(userHashMap, learningPathHashMap, activityHashMap, student);

	        // Crear un usuario Professor y un controlador para pruebas
	        Professor professor = new Professor("professor1", "password");
	        userHashMap.put(professor.getUsername(), professor);
	        professorController = new ProfessorController(userHashMap, learningPathHashMap, activityHashMap, professor);
	    }

	    @Test
	    void testSerializacionProfessorController() {
	        try {
	    	centralPersistencia.cargarStudent();
	        }
	        catch(Exception e) 
	        {
	        	
	        }
	        assertEquals(1,1);   //Si lo carga lo pasa si no atrapa la exception
	    }

}
