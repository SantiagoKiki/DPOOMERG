package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import learningpath.activity.FormActivity;
import learningpath.question.OpenQuestion;

public class FormActivityTest {
	
	private FormActivity formActivity;
	
	@BeforeEach
	void setUp() throws Exception {
		formActivity = new FormActivity("Form Title", "Form Description", "Form Objective", 60, true, null);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		formActivity = null;
	}
	
	@Test
	@DisplayName("Constructor con entradas nulas")
	void constructorWithNullEntries() {
		FormActivity f1 = new FormActivity("Sample Form", "Test Description", "Objective", 60, true, null);
		assertNotNull(f1.getQuestions());
		assertEquals(0, f1.getQuestions().size());
	}
	
	@Test
	@DisplayName("Agregar pregunta abierta")
	void addOpenQuestion() {
		OpenQuestion question = new OpenQuestion("What is a class diagram and what is it used for?");
		formActivity.addQuestion(question);

		assertEquals(1, formActivity.getQuestions().size());
	}
	
	@Test
	@DisplayName("Agregar pregunta abierta nula")
	void addNullOpenQuestion() {
		assertThrows(NullPointerException.class, () -> formActivity.addQuestion(null));
	}
	
	@Test
	@DisplayName("Agregar pregunta abierta duplicada")
	void addDuplicateOpenQuestion() {
        OpenQuestion question = new OpenQuestion("What is a class diagram and what is it used for?");
        formActivity.addQuestion(question);
        assertThrows(IllegalArgumentException.class, () -> formActivity.addQuestion(question));
	}
	
	@Test
	@DisplayName("Eliminar pregunta abierta")
	void removeOpenQuestion() {
		OpenQuestion question = new OpenQuestion("What is a class diagram and what is it used for?");
		formActivity.addQuestion(question);
		assertEquals(1, formActivity.getQuestions().size());
		formActivity.removeQuestion(question);
		assertEquals(0, formActivity.getQuestions().size());
	}
	
	@Test
	@DisplayName("Eliminar pregunta abierta nula")
	void removeNullOpenQuestion() {
		assertThrows(NullPointerException.class, () -> formActivity.removeQuestion(null));
	}
	
	@Test
	@DisplayName("Eliminar pregunta abierta inexistente")
	void removeNonExistentOpenQuestion() {
		OpenQuestion question = new OpenQuestion("What is a class diagram and what is it used for?");
		assertThrows(IllegalArgumentException.class, () -> formActivity.removeQuestion(question));
	}
	
	@Test
	@DisplayName("Verifica que exista la pregunta abierta")
	void containsOpenQuestion() {
        OpenQuestion question = new OpenQuestion("What is a class diagram and what is it used for?");
        formActivity.addQuestion(question);
        assertTrue(formActivity.containsQuestion(question));
	}
	
	@Test
	@DisplayName("Verifica que no exista la pregunta abierta")
	void notContainsOpenQuestion() {
		OpenQuestion question = new OpenQuestion("What is a class diagram and what is it used for?");
		assertFalse(formActivity.containsQuestion(question));
	}
}
