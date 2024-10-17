package programa;

import java.util.List;
import java.util.ArrayList;

import programa.question.MultipleOptionQuestion;
import programa.question.OpenQuestion;

public class FormActivity extends Activity {
	
	private List<OpenQuestion> questions;
	private boolean completed;

	public FormActivity(String title, String description, String objective, int expectedDuration,
			boolean completed, List<Activity> prerequisites, List<Activity> followUpActivities, List<OpenQuestion> questions) {
		super(title, description, objective, expectedDuration, prerequisites, followUpActivities);
		this.questions = questions != null ? questions : new ArrayList<>();
		this.completed = completed;
	}

	public List<OpenQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<OpenQuestion> questions) {
		this.questions = questions;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public boolean addQuestion(OpenQuestion question) {
		if (this.questions.contains(question)) {
			System.out.println("Question already added.");
			return false;
		}
		this.questions.add(question);
		return true;
	}
	
	public boolean removeQuestion(OpenQuestion question) {
		if (this.questions.contains(question)) {
			this.questions.remove(question);
			return true;
		}
		System.out.println("There's no question like that.");
		return false;
	}
	
	public boolean containsQuestion(OpenQuestion question) {
		return this.questions.contains(question);
	}

}
