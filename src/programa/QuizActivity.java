package programa;

import java.util.List;
import java.util.ArrayList;

import programa.question.MultipleOptionQuestion;

public class QuizActivity extends Activity {

	private double minScore;
	private List<MultipleOptionQuestion> questions;

	public QuizActivity(String title, String description, String objective, int expectedDuration, double minScore,
			List<Activity> prerequisites, List<Activity> followUpActivities, List<MultipleOptionQuestion> questions) {
		super(title, description, objective, expectedDuration, prerequisites, followUpActivities);
		this.minScore = minScore;
		this.questions = questions != null ? questions : new ArrayList<>();
	}

	public double getMinScore() {
		return minScore;
	}

	public void setMinScore(double minScore) {
		this.minScore = minScore;
	}

	public List<MultipleOptionQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<MultipleOptionQuestion> questions) {
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
