package learningpath.activity;

import java.util.LinkedList;

import learningpath.question.OpenQuestion;

public class FormActivity extends Activity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public void addQuestion(OpenQuestion question) throws NullPointerException, IllegalArgumentException{
		if (question == null) {
			throw new NullPointerException("Question can not be null.");
		}
		if (this.containsQuestion(question)) {
			throw new IllegalArgumentException("Question already added.");
		}
		
		this.questions.add(question);
	}

	public void removeQuestion(OpenQuestion question) throws NullPointerException, IllegalArgumentException {
		if (question == null) {
			throw new NullPointerException("Question cannot be null.");
		}
		if (!this.containsQuestion(question)) {
			throw new IllegalArgumentException("There's no question like that.");
		}
		this.questions.remove(question);
	}

	public boolean containsQuestion(OpenQuestion question) {
		return this.questions.contains(question);
	}

}