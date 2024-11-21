package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import learningpath.activity.ExamActivity;
import learningpath.question.MultipleOptionQuestion;
import learningpath.question.OpenQuestion;
import learningpath.question.Option;

public class ExamActivityTest {
    private ExamActivity examActivity;

    @BeforeEach
    void setUp() throws Exception {
        examActivity = new ExamActivity(
                "Parcial 2 DPOO",
                "Contiene preguntas relacionadas a los temas del segundo corte",
                "Tener una buena comprensión de los temas vistos en clase",
                80, true, null, null
        );
    }

    @AfterEach
    void tearDown() throws Exception {
        examActivity = null;
    }

    @Test
    @DisplayName("Constructor con entradas nulas")
    void constructorConEntradasNulas() {
        ExamActivity e1 = new ExamActivity(
                "Sample Exam",
                "Test Description",
                "Objective",
                60,
                true,
                null,
                null
        );

        assertNotNull(e1.getOpenQuestions());
        assertNotNull(e1.getMOQuestions());
        assertEquals(0, e1.getOpenQuestions().size());
        assertEquals(0, e1.getMOQuestions().size());
    }

    @Test
    @DisplayName("Agregar pregunta abierta")
    void agregarPreguntaAbierta() {
        OpenQuestion question = new OpenQuestion("Qué es un diagrama de clases y para qué se usa?");
        examActivity.addOpenQuestion(question);

        assertEquals(1, examActivity.getOpenQuestions().size());
    }

    @Test
    @DisplayName("Verifica que exista la pregunta de opción múltiple")
    void containsMOQuestion() {
        MultipleOptionQuestion question = getMultipleOptionQuestion();
        examActivity.addMOQuestion(question);

        assertTrue(examActivity.containsMOQuestion(question));
    }

    @Test
    @DisplayName("Verifica que exista la pregunta abierta")
    void containsOpenQuestion() {
        OpenQuestion question = new OpenQuestion("What is encapsulation?");
        examActivity.addOpenQuestion(question);

        assertTrue(examActivity.containsOpenQuestion(question));
    }

    @Test
    @DisplayName("Agregar pregunta abierta nula")
    void agregarPreguntaAbiertaNula() {
        OpenQuestion question = null;
        assertThrows(NullPointerException.class, () -> examActivity.addOpenQuestion(question));

        assertEquals(0, examActivity.getOpenQuestions().size());
    }

    @Test
    @DisplayName("Agregar pregunta abierta duplicada")
    void agregarPreguntaAbiertaDuplicada() {
        OpenQuestion question = new OpenQuestion("Qué es un diagrama de clases y para qué se usa?");
        examActivity.addOpenQuestion(question);
        assertThrows(IllegalArgumentException.class, () -> examActivity.addOpenQuestion(question));

        assertEquals(1, examActivity.getOpenQuestions().size());
    }

    @Test
    @DisplayName("Eliminar pregunta abierta")
    void eliminarPreguntaAbierta() {
        OpenQuestion question = new OpenQuestion("Qué es un diagrama de clases y para qué se usa?");
        examActivity.addOpenQuestion(question);
        assertEquals(1, examActivity.getOpenQuestions().size());
        examActivity.removeOpenQuestion(question);

        assertEquals(0, examActivity.getOpenQuestions().size());
    }

    @Test
    @DisplayName("Eliminar pregunta abierta nula")
    void eliminarPreguntaAbiertaNula() {
        OpenQuestion question = null;
        assertThrows(NullPointerException.class, () -> examActivity.removeOpenQuestion(question));

        assertEquals(0, examActivity.getOpenQuestions().size());
    }

    @Test
    @DisplayName("Eliminar pregunta abierta inexistente")
    void eliminarPreguntaAbiertaInexistente() {
        OpenQuestion question = new OpenQuestion("Qué es un diagrama de clases y para qué se usa?");
        examActivity.addOpenQuestion(question);
        assertEquals(1, examActivity.getOpenQuestions().size());
        assertThrows(IllegalArgumentException.class, () -> examActivity.removeOpenQuestion(
                new OpenQuestion("Qué es un diagrama de secuencia y para qué se usa?")));
        assertEquals(1, examActivity.getOpenQuestions().size());
    }

    @Test
    @DisplayName("Agregar pregunta de opción múltiple")
    void crearPreguntaDeOpcionMultiple() {
        MultipleOptionQuestion question = getMultipleOptionQuestion();

        examActivity.addMOQuestion(question);
        assertEquals(1, examActivity.getMOQuestions().size());
    }

    @Test
    @DisplayName("Agregar pregunta de opción múltiple nula")
    void agregarPreguntaDeOpcionMultipleNula() {
        MultipleOptionQuestion question = null;
        assertThrows(NullPointerException.class, () -> examActivity.addMOQuestion(question));

        assertEquals(0, examActivity.getMOQuestions().size());
    }

    @Test
    @DisplayName("Agregar pregunta de opción múltiple duplicada")
    void agregarPreguntaDeOpcionMultipleDuplicada() {
        MultipleOptionQuestion question = getMultipleOptionQuestion();

        examActivity.addMOQuestion(question);
        assertEquals(1, examActivity.getMOQuestions().size());
        assertThrows(IllegalArgumentException.class, () -> examActivity.addMOQuestion(question));

        assertEquals(1, examActivity.getMOQuestions().size());
    }

    @Test
    @DisplayName("Eliminar pregunta de opción múltiple")
    void eliminarPreguntaDeOpcionMultiple() {
        MultipleOptionQuestion question = getMultipleOptionQuestion();

        examActivity.addMOQuestion(question);
        assertEquals(1, examActivity.getMOQuestions().size());
        examActivity.removeMOQuestion(question);

        assertEquals(0, examActivity.getMOQuestions().size());
    }

    @Test
    @DisplayName("Eliminar pregunta de opción múltiple nula")
    void eliminarPreguntaDeOpcionMultipleNula() {
        MultipleOptionQuestion question = null;
        assertThrows(NullPointerException.class, () -> examActivity.removeMOQuestion(question));

        assertEquals(0, examActivity.getMOQuestions().size());
    }

    @Test
    @DisplayName("Eliminar pregunta de opción múltiple inexistente")
    void eliminarPreguntaDeOpcionMultipleInexistente() {
        MultipleOptionQuestion question = getMultipleOptionQuestion();

        examActivity.addMOQuestion(question);
        assertEquals(1, examActivity.getMOQuestions().size());
        assertThrows(IllegalArgumentException.class, () -> examActivity.removeMOQuestion(
                new MultipleOptionQuestion("Qué es un diagrama de secuencia y para qué se usa?", null)));
        assertEquals(1, examActivity.getMOQuestions().size());
    }

    @Test
    @DisplayName("Eliminar pregunta de opción múltiple duplicada")
    void eliminarPreguntaDeOpcionMultipleDuplicada() {
        MultipleOptionQuestion question = getMultipleOptionQuestion();

        examActivity.addMOQuestion(question);
        assertEquals(1, examActivity.getMOQuestions().size());
        examActivity.removeMOQuestion(question);
        assertThrows(IllegalArgumentException.class, () -> examActivity.removeMOQuestion(question));

        assertEquals(0, examActivity.getMOQuestions().size());
    }

    @Test
    @DisplayName("Calificar pregunta de opción múltiple")
    void calificarPreguntaDeOpcionMultiple() {
        MultipleOptionQuestion question = getMultipleOptionQuestion();

        Option option4 = new Option("A. Yuji Itadori", true, "Correcto");
        Option option5 = new Option("B. Megumi Fushiguro", false, "Incorrecto");
        Option option6 = new Option("C. Nobara Kugisaki", false, "Incorrecto");
        MultipleOptionQuestion question2 = new MultipleOptionQuestion("¿Quién es el protagonista de Jujutsu Kaisen?", null);
        question2.addOption(option4);
        question2.addOption(option5);
        question2.addOption(option6);
        examActivity.addMOQuestion(question);
        examActivity.addMOQuestion(question2);
        assertEquals(2, examActivity.getMOQuestions().size());
        assertEquals(2.0 / 3, examActivity.rateMultipleOption(2));
    }

    @Test
    @DisplayName("Rate multiple option question with empty list")
    void rateMultipleOptionWithEmptyList() {
        assertEquals(0.0, examActivity.rateMultipleOption(2));
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

