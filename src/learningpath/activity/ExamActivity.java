package learningpath.activity;


import java.util.LinkedList;

import learningpath.question.OpenQuestion;

public class ExamActivity extends Activity {

	private LinkedList<OpenQuestion> questions;

	public ExamActivity(String title, String description, String objective, int expectedDuration, boolean mandatory,
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
