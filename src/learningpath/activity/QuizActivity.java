package learningpath.activity;

import java.util.LinkedList;

import learningpath.question.MultipleOptionQuestion;

public class QuizActivity extends Activity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double minScore;
	private LinkedList<MultipleOptionQuestion> questions;

	public QuizActivity(String title, String description, String objective, int expectedDuration, boolean mandatory,
						LinkedList<MultipleOptionQuestion> questions, double minScore) {
		super(title, description, objective, expectedDuration, mandatory);
		this.questions = questions != null ? questions : new LinkedList<>();
		this.minScore = minScore;
	}

	public double getMinScore() {
		return minScore;
	}

	public void setMinScore(double minScore) {
		this.minScore = minScore;
	}

	public LinkedList<MultipleOptionQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(LinkedList<MultipleOptionQuestion> questions) {
		this.questions = questions;
	}

	public boolean addQuestion(MultipleOptionQuestion question) {
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
	
	public boolean removeQuestion(MultipleOptionQuestion question) {
		if (question != null && this.containsQuestion(question)) {
			this.questions.remove(question);
			return true;
		}
		System.out.println("There's no question like that.");
		return false;
	}
	
	public boolean containsQuestion(MultipleOptionQuestion question) {
		return this.questions.contains(question);
	}
}
