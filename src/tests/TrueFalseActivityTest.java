package tests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import learningpath.activity.TrueFalseActivity;
import learningpath.question.Option;
import learningpath.question.TrueFalseQuestion;

public class TrueFalseActivityTest {
	
	private TrueFalseActivity trueFalseActivity;
	
	@BeforeEach
	void setUp() throws Exception {
		trueFalseActivity = new TrueFalseActivity("Parcial 2 DPOO",
				"Contiene preguntas relacionadas a los temas del segundo corte",
				"Tener una buena comprensión de los temas vistos en clase", 80, true, null);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		trueFalseActivity = null;
	}
	
	@Test
	@DisplayName("Constructor con entradas nulas")
	void constructorConEntradasNulas() {
		TrueFalseActivity t1 = new TrueFalseActivity("Sample Exam", "Test Description", "Objective", 60, true, null);
		assertNotNull(t1.getQuestions());
		assertEquals(0, t1.getQuestions().size());
	}
	
	@Test
	@DisplayName("Agregar pregunta")
	void agregarPreguntaVerdaderoOFalso() {
		TrueFalseQuestion question = createQuestion();
		trueFalseActivity.addQuestion(question);
		assertEquals(1, trueFalseActivity.getQuestions().size());
	}
	
	@Test
	@DisplayName("Agregar pregunta nula")
	void agregarPreguntaNula() {
		assertThrows(NullPointerException.class, () -> trueFalseActivity.addQuestion(null));
	}
	
	@Test
	@DisplayName("Agregar pregunta existente")
	void agregarPreguntaExistente() {
		TrueFalseQuestion question = createQuestion();
		trueFalseActivity.addQuestion(question);
		assertEquals(1, trueFalseActivity.getQuestions().size());
		assertThrows(IllegalArgumentException.class, () -> trueFalseActivity.addQuestion(question));
	}
	
	@Test
	@DisplayName("Eliminar pregunta")
	void eliminarPreguntaVerdaderoOFalso() {
		TrueFalseQuestion question = createQuestion();
		trueFalseActivity.addQuestion(question);
		assertEquals(1, trueFalseActivity.getQuestions().size());
		trueFalseActivity.removeQuestion(question);
		assertEquals(0, trueFalseActivity.getQuestions().size());
	}
	
	@Test
	@DisplayName("Eliminar pregunta nula")
	void eliminarPreguntaNula() {
		assertThrows(NullPointerException.class, () -> trueFalseActivity.removeQuestion(null));
	}
	
	@Test
	@DisplayName("Eliminar pregunta inexistente")
	void eliminarPreguntaInexistente() {
		TrueFalseQuestion question = createQuestion();
		assertThrows(IllegalArgumentException.class, () -> trueFalseActivity.removeQuestion(question));
	}
	
	@Test
	@DisplayName("Verificar que exista la pregunta")
	void verificarExistenciaPregunta() {
		TrueFalseQuestion question = createQuestion();
		trueFalseActivity.addQuestion(question);
		assertTrue(trueFalseActivity.containsQuestion(question));
	}
	
	@Test
	@DisplayName("Verificar que no exista la pregunta")
	void verificarInexistenciaPregunta() {
		TrueFalseQuestion question = createQuestion();
		assertFalse(trueFalseActivity.containsQuestion(question));
	}
	
	private static TrueFalseQuestion createQuestion() {
		Option option1 = new Option("Verdadero", true, "Es correcto");
		Option option2 = new Option("Falso", false, "Es incorrecto");
		return new TrueFalseQuestion("¿Java es un lenguaje de programación orientado a objetos?", option1, option2);
	}
	
}
