package tests;

import org.junit.jupiter.api.Test;

import logic.learningpath.question.MultipleOptionQuestion;
import logic.learningpath.question.Option;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleOptionQuestionTest {

	private MultipleOptionQuestion multipleOptionQuestion;

	@BeforeEach
	public void setUp() {
		multipleOptionQuestion = new MultipleOptionQuestion("What is the capital of Brazil?", null);
	}

	@AfterEach
	public void tearDown() {
		multipleOptionQuestion = null;
	}

	@Test
	@DisplayName("Agregar opción")
	public void agregarOpcion() {
		Option option1 = new Option("A. Brasília", true, "Correcto");
		multipleOptionQuestion.addOption(option1);
		assertTrue(multipleOptionQuestion.containsOption(option1));
	}

	@Test
	@DisplayName("Eliminar opción")
	public void eliminarOpcion() {
		Option option1 = new Option("A. Brasília", true, "Correcto");
		multipleOptionQuestion.addOption(option1);
		assertTrue(multipleOptionQuestion.containsOption(option1));
		multipleOptionQuestion.removeOption(option1);
		assertFalse(multipleOptionQuestion.containsOption(option1));
	}

	@Test
	@DisplayName("Agregar opción nula")
	public void agregarOpcionNula() {
		assertThrows(NullPointerException.class, () -> {
			multipleOptionQuestion.addOption(null);
		});
	}

	@Test
	@DisplayName("Eliminar opción nula")
	public void eliminarOpcionNula() {
		assertThrows(NullPointerException.class, () -> {
			multipleOptionQuestion.removeOption(null);
		});
	}

	@Test
	@DisplayName("Agregar opción duplicada")
	public void agregarOpcionDuplicada() {
		Option option1 = new Option("A. Brasília", true, "Correcto");
		multipleOptionQuestion.addOption(option1);
		assertTrue(multipleOptionQuestion.containsOption(option1));
		assertThrows(IllegalArgumentException.class, () -> {
			multipleOptionQuestion.addOption(option1);
		});
	}

	@Test
	@DisplayName("Eliminar opción no existente")
	public void eliminarOpcionNoExistente() {
		Option option1 = new Option("A. Brasília", true, "Correcto");
		assertThrows(IllegalArgumentException.class, () -> {
			multipleOptionQuestion.removeOption(option1);
		});
	}

	@Test
	@DisplayName("Calificar pregunta")
	public void calificarPregunta() {
		Option option1 = new Option("A. Brasília", true, "Correcto");
		Option option2 = new Option("B. Sao Paulo", false, "Incorrecto");
		Option option3 = new Option("C. Rio de Janeiro", false, "Incorrecto");
		multipleOptionQuestion.addOption(option1);
		multipleOptionQuestion.addOption(option2);
		multipleOptionQuestion.addOption(option3);
		assertEquals(1, multipleOptionQuestion.rate(1));
	}

	@Test
	@DisplayName("Calificar pregunta sin opciones")
	public void calificarPreguntaSinOpciones() {
		assertEquals(0.0, multipleOptionQuestion.rate(1));
	}

	@Test
	@DisplayName("Agregar más de 4 opciones")
	public void agregarMasDe4Opciones() {
		Option option1 = new Option("A. Brasília", true, "Correcto");
		Option option2 = new Option("B. Sao Paulo", false, "Incorrecto");
		Option option3 = new Option("C. Rio de Janeiro", false, "Incorrecto");
		Option option4 = new Option("D. Recife", false, "Incorrecto");
		Option option5 = new Option("E. Salvador", false, "Incorrecto");
		multipleOptionQuestion.addOption(option1);
		multipleOptionQuestion.addOption(option2);
		multipleOptionQuestion.addOption(option3);
		multipleOptionQuestion.addOption(option4);
		assertThrows(IllegalStateException.class, () -> {
			multipleOptionQuestion.addOption(option5);
		});
	}

	@Test
	@DisplayName("Cambiar arreglo de opciones")
	public void cambiarArregloDeOpciones() {
		Option option1 = new Option("A. Brasília", true, "Correcto");
		Option option2 = new Option("B. Sao Paulo", false, "Incorrecto");
		Option option3 = new Option("C. Rio de Janeiro", false, "Incorrecto");
		Option option4 = new Option("D. Recife", false, "Incorrecto");
		multipleOptionQuestion.addOption(option1);
		multipleOptionQuestion.addOption(option2);
		multipleOptionQuestion.addOption(option3);
		multipleOptionQuestion.addOption(option4);
		Option option5 = new Option("E. Salvador", false, "Incorrecto");
		Option option6 = new Option("F. Manaus", false, "Incorrecto");
		Option option7 = new Option("G. Porto Alegre", false, "Incorrecto");
		Option option8 = new Option("H. Curitiba", false, "Incorrecto");
		Option[] options = new Option[] { option5, option6, option7, option8 };
		multipleOptionQuestion.setOptions(options);
		assertFalse(multipleOptionQuestion.containsOption(option1));
		assertFalse(multipleOptionQuestion.containsOption(option2));
		assertFalse(multipleOptionQuestion.containsOption(option3));
		assertFalse(multipleOptionQuestion.containsOption(option4));
	}
}
