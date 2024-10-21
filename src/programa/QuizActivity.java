package programa;

import java.util.LinkedList;


import programa.question.MultipleOptionQuestion;

public class QuizActivity extends Activity {

	private double minScore;
	private LinkedList<MultipleOptionQuestion> questions;

	public QuizActivity(String title, String description, String objective, int expectedDuration, double minScore,
			LinkedList<Activity> prerequisites, LinkedList<Activity> followUpActivities, LinkedList<MultipleOptionQuestion> questions) {
		super();
		this.minScore = minScore;
		this.questions = questions != null ? questions : new LinkedList<>();
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
		if (this.questions.contains(question)) {
			System.out.println("Question already added.");
			return false;
		}
		this.questions.add(question);
		return true;
	}
	
	public boolean removeQuestion(MultipleOptionQuestion question) {
		if (this.questions.contains(question)) {
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
