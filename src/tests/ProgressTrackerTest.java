package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import learningpath.LearningPath;
import learningpath.activity.Activity;
import learningpath.activity.QuizActivity;
import tracker.ActivityTracker;
import tracker.ProgressTracker;
import utils.Generator;


public class ProgressTrackerTest {

	private ProgressTracker progressTracker;
	
	@BeforeEach
    void setUp() {
		Generator generator = Generator.getInstance();
		LinkedList<Activity> activities = new LinkedList<>();
		for (int i = 0; i < 5; i++) {
			activities.add(new QuizActivity("Uso de bucles while " + i, "Explorar bucles while " + i, "Uso de bucles while para repetir acciones. " + i, 30, true, new LinkedList<>(), 70.0));
		    }
		String learningPathId = generator.generateId("LearningPath");
		LearningPath learningPath = new LearningPath("Nivel de Python 3", "Descripcion...", new LinkedList<>(), 2, new LinkedList<>(), null);
		learningPath.getActivities().addAll(activities);
		
		progressTracker = new ProgressTracker("Estudiante1", learningPath);
		 LinkedList<ActivityTracker> trackers = progressTracker.getActivityTrackers();
		    for (int i = 0; i < trackers.size(); i++) {
		        trackers.get(i).setCompletionStatus(i < 3 ? "Completed" : "Not started");
		    }
	}
	
	@Test
	@DisplayName("Calcular progreso estado completado")
	public void testCalculateProgress_Completion() {
		for (ActivityTracker tracker : progressTracker.getActivityTrackers()) {
            tracker.setCompletionStatus("Completed");
        }
		progressTracker.calculateProgress();
		assertEquals(100.0f, progressTracker.getProgress(), "El progreso deberia ser 100%");
		assertTrue(progressTracker.getCompletionStatus(), "El estado de finalizacion deberia ser verdadero");
	}
	
	@Test
	@DisplayName("Calcular progreso estado no completado")
    void testCalculateProgress_NoCompletion() {
        for (ActivityTracker tracker : progressTracker.getActivityTrackers()) {
            tracker.setCompletionStatus("Not started");
        }
        progressTracker.calculateProgress();
        assertEquals(0.0f, progressTracker.getProgress(), "El progreso deberia ser 0%.");
        assertFalse(progressTracker.getCompletionStatus(), "El estado de finalizacion deberia ser falso");
    }
	
	@Test
	@DisplayName("Calcular progreso de forma parcial")
	public void testCalculateProgress() {
		progressTracker.calculateProgress();
		assertEquals(60.0f, progressTracker.getProgress(), 0.01, "El progreso debería ser 60%.");
        assertFalse(progressTracker.getCompletionStatus(), "El estado de finalización debería ser falso.");
	}

	
}
