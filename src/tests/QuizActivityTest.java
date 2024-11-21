package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import learningpath.activity.QuizActivity;
import learningpath.question.MultipleOptionQuestion;
import learningpath.question.Option;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class QuizActivityTest {
	private QuizActivity quizActivity;
	
	@BeforeEach
	void setUp() throws Exception {
		quizActivity = new QuizActivity("Quiz 1", "Description", "Objective", 60, true, null, 0);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		quizActivity = null;
	}
	
	@Test
	@DisplayName("Constructor con entradas nulas")
	void constructorConEntradasNulas() {
		QuizActivity q1 = new QuizActivity("Sample Quiz", "Test Description", "Objective", 60, true, null, 0);

		assertNotNull(q1.getQuestions());
		assertEquals(0, q1.getQuestions().size());
	}
	
	@Test
	@DisplayName("Agregar pregunta de opción múltiple")
	void agregarPreguntaDeOpcionMultiple() {
		quizActivity.addQuestion(getMultipleOptionQuestion());
		assertEquals(1, quizActivity.getQuestions().size());
	}
	
	@Test
	@DisplayName("Eliminar pregunta de opción múltiple")
	void eliminarPreguntaDeOpcionMultiple() {
		MultipleOptionQuestion question = getMultipleOptionQuestion();
		quizActivity.addQuestion(question);
		assertEquals(1, quizActivity.getQuestions().size());
		quizActivity.removeQuestion(question);
		assertEquals(0, quizActivity.getQuestions().size());
	}
	
	@Test
	@DisplayName("Agregar pregunta de opción múltiple nula")
	void agregarPreguntaDeOpcionMultipleNula() {
		assertThrows(NullPointerException.class, () -> quizActivity.addQuestion(null));
	}
	
	@Test
	@DisplayName("Eliminar pregunta de opción múltiple nula")
	void eliminarPreguntaDeOpcionMultipleNula() {
		assertThrows(NullPointerException.class, () -> quizActivity.removeQuestion(null));
	}
	
	@Test
	@DisplayName("Agregar pregunta de opción múltiple duplicada")
	void agregarPreguntaDeOpcionMultipleDuplicada() {
		MultipleOptionQuestion question = getMultipleOptionQuestion();
		quizActivity.addQuestion(question);
		assertEquals(1, quizActivity.getQuestions().size());
		assertThrows(IllegalArgumentException.class, () -> quizActivity.addQuestion(question));
	}
	
	@Test
	@DisplayName("Eliminar pregunta de opción múltiple inexistente")
	void eliminarPreguntaDeOpcionMultipleInexistente() {
		assertEquals(0, quizActivity.getQuestions().size());
		assertThrows(IllegalArgumentException.class, () -> quizActivity.removeQuestion(getMultipleOptionQuestion()));
	}
	
	@Test
	@DisplayName("Calificar examen")
	void calificarExamen() {
		MultipleOptionQuestion question = getMultipleOptionQuestion();
		quizActivity.addQuestion(question);
		assertEquals(1, quizActivity.getQuestions().size());
		assertEquals(10.0/3, quizActivity.calculateScore(10));
	}
	
	@Test
	@DisplayName("Calificar examen sin preguntas")
	void calificarExamenSinPreguntas() {
		assertEquals(0.0, quizActivity.calculateScore(10));
	}
	
	@Test
	@DisplayName("Contiene pregunta")
	void contienePregunta() {
		MultipleOptionQuestion question = getMultipleOptionQuestion();
		quizActivity.addQuestion(question);
		assertTrue(quizActivity.containsQuestion(question));
	}
	
	@Test
	@DisplayName("No contiene pregunta")
	void noContienePregunta() {
		assertFalse(quizActivity.containsQuestion(getMultipleOptionQuestion()));
	}
	
	@Test
	@DisplayName("Establecer lista de preguntas nula")
	void establecerPreguntasNula() {
		quizActivity.setQuestions(null);
		assertNull(quizActivity.getQuestions());
	}
	
	
	private static MultipleOptionQuestion getMultipleOptionQuestion() {
        Option option1 = new Option("A. Es un diagrama que representa la estructura de un sistema", true, "Correcto");
        Option option2 = new Option("B. Se usa para modelar la interacción entre los objetos", false, "Incorrecto");
        Option option3 = new Option("C. Se usa para modelar la interacción entre los objetos", false, "Incorrecto");
        MultipleOptionQuestion question = new MultipleOptionQuestion("Qué es un diagrama de clases y para qué se usa?", null);
        question.addOption(option1);
        question.addOption(option2);
        question.addOption(option3);
        return question;
    }
}
