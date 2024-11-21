package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import learningpath.activity.TaskActivity;

public class TaskActivityTest {
	
	private TaskActivity taskActivity;
	
	@BeforeEach
	void setUp() throws Exception {
        taskActivity = new TaskActivity(
                "Parcial 2 DPOO",
                "Contiene preguntas relacionadas a los temas del segundo corte",
                "Tener una buena comprensión de los temas vistos en clase",
                80, true, null);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		taskActivity = null;
	}
	
	@Test
	@DisplayName("Constructor con entradas nulas")
	void constructorConEntradasNulas() {
		TaskActivity t1 = new TaskActivity("Sample Exam", "Test Description", "Objective", 60, true, null);
		assertNull(t1.getToDo());
	}
	
	@Test
	@DisplayName("Agregar tarea")
	void agregarTarea() {
		taskActivity.setToDo("Hacer el taller 1");
		assertEquals("Hacer el taller 1", taskActivity.getToDo());
	}
	
	@Test
	@DisplayName("Cambiar tarea")
	void cambiarTarea() {
		taskActivity.setToDo("Hacer el taller 1");
		assertEquals("Hacer el taller 1", taskActivity.getToDo());
		taskActivity.setToDo("Hacer el taller 2");
		assertEquals("Hacer el taller 2", taskActivity.getToDo());
	}

}
