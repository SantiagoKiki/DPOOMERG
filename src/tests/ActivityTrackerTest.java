package tests;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import logic.learningpath.activity.QuizActivity;
import logic.learningpath.question.MultipleOptionQuestion;
import logic.tracker.ActivityTracker;

import static org.junit.jupiter.api.Assertions.*;

public class ActivityTrackerTest {
	
	private ActivityTracker activityTracker;
	
	@BeforeEach
	public void setUp() {
		LinkedList<MultipleOptionQuestion> questions = new LinkedList<>();
		QuizActivity quizActivity = new QuizActivity("Uso de los bucles", "Preguntas opcion multiple", ": Evaluar la competencia en la escritura de bucles", 30, true, questions, 60.0);
		activityTracker = new ActivityTracker(quizActivity);
	}
	
	@Test
	@DisplayName("anadir rating valido")
	public void testAddRatingValid() {
		activityTracker.addRating(5);
		assertEquals(5.0, activityTracker.getAverageRating(), "El promedio deberia ser de 5.0");
	}
	
	@Test
	@DisplayName("anadir rating invalido")
    void testAddRating_InvalidRating() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> { activityTracker.addRating(0);});
		assertEquals("La calificacion debe estar entre 1 y 5", e.getMessage());
	}
	
	@Test
	@DisplayName("Promedio rating vacio")
    void testGetAverageRating_EmptyRatings() {
        assertEquals(0, activityTracker.getAverageRating(), "El promedio deberia ser 0.0 si no hay calificaciones");
    }
	
	
	@Test
	@DisplayName("Promedio rating con multiples entradas")
    void testGetAverageRating_MultipleRatings() {
        activityTracker.addRating(3);
        activityTracker.addRating(4);
        activityTracker.addRating(5);
        assertEquals(4.0, activityTracker.getAverageRating(), 0.01, "El promedio deberia ser 4.0");
    }
}
