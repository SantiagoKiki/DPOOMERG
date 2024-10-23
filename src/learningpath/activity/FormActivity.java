package learningpath.activity;

import java.util.LinkedList;

import learningpath.question.OpenQuestion;

public class FormActivity extends Activity {

	private LinkedList<OpenQuestion> questions;

	public FormActivity(String title, String description, String objective, int expectedDuration, boolean mandatory,
			LinkedList<OpenQuestion> questions) {
		super(title, description, objective, expectedDuration, mandatory);
		this.questions = questions != null ? questions : new LinkedList<>();
	}

	public LinkedList<OpenQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(LinkedList<OpenQuestion> questions) {
		this.questions = questions;
	}

	public boolean addQuestion(OpenQuestion question) {
		if (question == null) {
			System.err.println("Question can not be null.");
		}
		if (this.containsQuestion(question)) {
			System.out.println("Question already added.");
			return false;
		}
		
		this.questions.add(question);
		return true;
	}

	public boolean removeQuestion(OpenQuestion question) {
		if (question == null) {
			System.err.println("Question can not be null.");
		}
		if (!this.containsQuestion(question)) {
			System.err.println("There's no question like that.");
			return false;
		}
		this.questions.remove(question);
		return true;
	}

	public boolean containsQuestion(OpenQuestion question) {
		return this.questions.contains(question);
	}

}
