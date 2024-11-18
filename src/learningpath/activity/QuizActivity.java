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

	public void addQuestion(MultipleOptionQuestion question) throws NullPointerException, IllegalArgumentException {
		if (question == null) {
			throw new NullPointerException("Question can not be null");
		}
		if (this.containsQuestion(question)) {
			throw new IllegalArgumentException("Question already added to the quiz.");
		}
		this.questions.add(question);
	}
	
	public void removeQuestion(MultipleOptionQuestion question) throws NullPointerException, IllegalArgumentException {
		
		if (question == null) {
			throw new NullPointerException("Question can not be null.");
		}
		
		if (!this.containsQuestion(question)) {
			throw new IllegalArgumentException("Question not found.");
		}
		questions.remove(question);
	}
	
	public boolean containsQuestion(MultipleOptionQuestion question) {
		return this.questions.contains(question);
	}
	
	public double calculateScore(int questionRate) {
		double score = 0;
		if (questions.isEmpty()) {
            return 0.0;
		}
		for (MultipleOptionQuestion question : questions) {
			score += question.rate(questionRate);
		}
		return score / questions.size();
	}
}
