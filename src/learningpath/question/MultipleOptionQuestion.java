package learningpath.question;

import java.util.LinkedList;

public class MultipleOptionQuestion {
	private String question;
	private LinkedList<Option> options;

	public MultipleOptionQuestion(String question, LinkedList<Option> options) {
		this.question = question;
		this.options = options != null ? options : new LinkedList<>();
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public LinkedList<Option> getOptions() {
		return options;
	}

	public void setOptions(LinkedList<Option> options) {
		this.options = options;
	}
}
