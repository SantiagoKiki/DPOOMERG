package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

import logic.learningpath.LearningPath;
import logic.learningpath.activity.Activity;
import logic.tracker.ProgressTracker;
import logic.users.Professor;

public class LearningPathTest {

    private LearningPath learningPath;
    private Activity activity;
    private ProgressTracker progressTracker;
    private Professor professor;

    @BeforeEach
    public void setUp() {
        professor = new Professor("John Doe", "johndoe@example.com");
        LinkedList<String> objectives = new LinkedList<>();
        objectives.add("Objective 1");
        LinkedList<String> tags = new LinkedList<>();
        tags.add("Tag 1");
        learningPath = new LearningPath("Title", "Description", objectives, 3, tags, professor);
        activity = new Activity("Activity Title", "Activity Description", "Activity Objective", 2, true) {};
        progressTracker = new ProgressTracker("Student1", learningPath);
    }

    @Test
    public void testAddActivity() {
        learningPath.addActivity(activity);
        assertEquals(1, learningPath.getActivities().size());
        assertEquals(activity, learningPath.getActivities().get(0));
    }

    @Test
    public void testAddActivityInPos() {
        learningPath.addActivity(activity);
        Activity newActivity = new Activity("New Activity", "New Description", "New Objective", 3, false) {};
        learningPath.addActivityInPos(newActivity, 0);
        assertEquals(2, learningPath.getActivities().size());
        assertEquals(newActivity, learningPath.getActivities().get(0));
    }

    @Test
    public void testMoveActivity() {
        learningPath.addActivity(activity);
        Activity newActivity = new Activity("New Activity", "New Description", "New Objective", 3, false) {};
        learningPath.addActivity(newActivity);
        learningPath.moveActivity(0, 1);
        assertEquals(newActivity, learningPath.getActivities().get(0));
        assertEquals(activity, learningPath.getActivities().get(1));
    }

    @Test
    public void testRemoveActivityByIndex() {
        learningPath.addActivity(activity);
        learningPath.removeActivityByIndex(0);
        assertEquals(0, learningPath.getActivities().size());
    }

    @Test
    public void testAddProgressTracker() {
        learningPath.addProgressTracker(progressTracker);
        assertEquals(1, learningPath.getProgressTrackers().size());
        assertEquals(progressTracker, learningPath.getProgressTrackers().get(0));
    }

    @Test
    public void testUpdateVersion() {
        int initialVersion = learningPath.getVersion();
        learningPath.updateVersion();
        assertEquals(initialVersion + 1, learningPath.getVersion());
    }
}

