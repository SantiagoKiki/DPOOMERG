package tests;

import org.junit.jupiter.api.Test;

import logic.learningpath.question.OpenQuestion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class OpenQuestionTest {
	
	private OpenQuestion openQuestion;
	
	@BeforeEach
	public void setUp() {
		openQuestion = new OpenQuestion("What is the capital of Brazil?");
	}
	
	@AfterEach
	public void tearDown() {
		openQuestion = null;
	}
	
	@Test
	@DisplayName("Agregar respuesta")
	public void agregarRespuesta() {
		openQuestion.setAnswer("Brasília");
		assertEquals("Brasília", openQuestion.getAnswer());
	}
	
	@Test
	@DisplayName("Agregar respuesta nula")
	public void agregarRespuestaNula() {
		assertThrows(NullPointerException.class, () -> {
			openQuestion.setAnswer(null);
		});
	}
	
	@Test
	@DisplayName("Agregar texto de la pregunta")
	public void agregarTexto() {
		openQuestion.setText("What is the capital of Brazil?");
		assertEquals("What is the capital of Brazil?", openQuestion.getText());
	}
	
	@Test
	@DisplayName("Agregar texto nulo")
	public void agregarTextoNulo() {
		assertThrows(NullPointerException.class, () -> {
			openQuestion.setText(null);
		});
	}
	
	@Test
	@DisplayName("Respuesta vacía")
	public void respuestaVacia() {
		assertEquals("", openQuestion.getAnswer());
	}
	

}
