package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import learningpath.LearningPath;
import learningpath.activity.Activity;
import learningpath.question.MultipleOptionQuestion;
import learningpath.question.OpenQuestion;
import users.Professor;

public class ProfessorTest {
	 private Professor professor;
	    private LearningPath learningPath;
	    private Activity activity;

	    @BeforeEach
	    public void setUp() {
	        professor = new Professor("profuser", "password");
	        LinkedList<String> objectives = new LinkedList<>();
	        objectives.add("Understand basic concepts");
	        LinkedList<String> tags = new LinkedList<>();
	        tags.add("Programming");

	        learningPath = professor.createLearningPath("101", "Intro to Programming", "Learn programming basics", objectives, 1, tags);
	    }

	    @Test
	    public void testCreateLearningPath() {
	        assertNotNull(learningPath, "Learning path should be created successfully.");
	        assertEquals("Intro to Programming", learningPath.getTitle(), "Learning path title should be set correctly.");
	        assertEquals("Learn programming basics", learningPath.getDescription(), "Learning path description should be set correctly.");
	        assertTrue(professor.getCreatedLearningPaths().contains(learningPath), "Learning path should be added to professor's created paths.");
	    }

	    @Test
	    public void testEditLearningPathTitle() {
	        professor.editLearningPathTitle(learningPath, "Advanced Programming");
	        assertEquals("Advanced Programming", learningPath.getTitle(), "Learning path title should be updated.");
	    }

	    @Test
	    public void testEditLearningPathDescription() {
	        professor.editCurrentLearningPathDescription(learningPath, "Learn advanced programming topics.");
	        assertEquals("Learn advanced programming topics.", learningPath.getDescription(), "Learning path description should be updated.");
	    }

	    @Test
	    public void testEditLearningPathObjectives() {
	        LinkedList<String> newObjectives = new LinkedList<>();
	        newObjectives.add("Advanced concepts");
	        professor.editLearningPathObjectives(learningPath, newObjectives);

	        assertEquals(newObjectives, learningPath.getObjectives(), "Learning path objectives should be updated.");
	    }

	    @Test
	    public void testAddActivityToLearningPath() {
	        activity = professor.createTaskActivity("Homework 1", "Complete exercises", "Practice basic skills", 60, true, "Complete all questions");

	        professor.addActivityToLearningPath(learningPath, activity);
	        assertTrue(learningPath.getActivities().contains(activity), "Activity should be added to the learning path.");
	    }

	    @Test
	    public void testCreateExamActivity() {
	        LinkedList<OpenQuestion> openQuestions = new LinkedList<>();
	        LinkedList<MultipleOptionQuestion> multipleChoiceQuestions = new LinkedList<>();

	        activity = professor.createExamActivity("Midterm Exam", "Midterm test", "Assess knowledge", 90, true, openQuestions, multipleChoiceQuestions);
	        
	        assertNotNull(activity, "Exam activity should be created successfully.");
	        assertTrue(professor.getCreatedActivities().contains(activity), "Exam activity should be added to professor's created activities.");
	    }

	    @Test
	    public void testEditActivityTitle() {
	        activity = professor.createTaskActivity("Task 1", "Initial Task", "Test Objective", 30, false, "Complete checklist");
	        professor.editActivityTitle(activity, "Updated Task 1");

	        assertEquals("Updated Task 1", activity.getTitle(), "Activity title should be updated.");
	    }

	    @Test
	    public void testAddPrerequisiteToActivity() {
	        Activity prereqActivity = professor.createTaskActivity("Prerequisite Task", "Initial prerequisite task", "Complete this first", 45, true, "Do prerequisite work");
	        professor.addActivityToLearningPath(learningPath, prereqActivity);

	        activity = professor.createTaskActivity("Follow-up Task", "Task after prerequisite", "Build upon skills", 30, false, "Do follow-up work");
	        professor.addActivityToLearningPath(learningPath, activity);
	        professor.addPrerequisiteToActivityByIndex(learningPath, activity, 0);

	        assertTrue(activity.getPrerequisites().contains(prereqActivity), "Activity should have the specified prerequisite.");
	    }
}
