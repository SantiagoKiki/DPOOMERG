package learningpath.activity;

import java.util.LinkedList;

import learningpath.question.OpenQuestion;
import learningpath.question.MultipleOptionQuestion;

public class ExamActivity extends Activity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<OpenQuestion> openQuestions;
	private LinkedList<MultipleOptionQuestion> MOQuestions;

	public ExamActivity(String title, String description, String objective, int expectedDuration, boolean mandatory,
			LinkedList<OpenQuestion> openQuestions, LinkedList<MultipleOptionQuestion> MOQuestions) {

		super(title, description, objective, expectedDuration, mandatory);
		this.openQuestions = openQuestions != null ? openQuestions : new LinkedList<>();
		this.MOQuestions = MOQuestions != null ? MOQuestions : new LinkedList<>();
	}

	public LinkedList<OpenQuestion> getOpenQuestions() {
		return openQuestions;
	}

	public LinkedList<MultipleOptionQuestion> getMOQuestion() {
		return MOQuestions;
	}

	public void setMOQuestion(LinkedList<MultipleOptionQuestion> mOQuestion) {
		MOQuestions = mOQuestion;
	}

	public void setOpenQuestions(LinkedList<OpenQuestion> openQuestions) {
		this.openQuestions = openQuestions;
	}

	public boolean addOpenQuestion(OpenQuestion question) {
		if (question == null) {
			System.err.println("Question can not be null.");
		}
		if (this.containsOpenQuestion(question)) {
			System.out.println("Question already added.");
			return false;
		}

		this.openQuestions.add(question);
		return true;
	}

	public boolean addMOQuestion(MultipleOptionQuestion q) {
		if (q == null) {
			System.err.println("Question can not be null.");
		}
		if (this.containsMOQuestion(q)) {
			System.out.println("Question already added.");
			return false;
		}

		
		this.MOQuestions.add(q);
		return true;
	}

	public boolean removeOpenQuestion(OpenQuestion question) {
		if (question != null && this.containsOpenQuestion(question)) {
			this.openQuestions.remove(question);
			return true;
		}
		System.out.println("There's no question like that.");
		return false;
	}

	public boolean removeMOQuestion(MultipleOptionQuestion q) {
		if (q != null && this.containsMOQuestion(q)) {
			this.MOQuestions.remove(q);
			return true;
		}
		System.out.println("There's no question like that.");
		return false;
	}

	public boolean containsOpenQuestion(OpenQuestion question) {
		return this.openQuestions.contains(question);
	}

	public boolean containsMOQuestion(MultipleOptionQuestion q) {
		return this.MOQuestions.contains(q);
	}
}
