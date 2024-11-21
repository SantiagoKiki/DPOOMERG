package learningpath.question;

import java.io.Serializable;
import java.util.LinkedList;

public class MultipleOptionQuestion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String question;
	private String answer;
	private LinkedList<Option> options;

	public MultipleOptionQuestion(String question, LinkedList<Option> options) {
		this.question = question;
		this.answer = "";
		this.options = options != null ? options : new LinkedList<>();
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public LinkedList<Option> getOptions() {
		return options;
	}

	public void setOptions(LinkedList<Option> options) {
		this.options = options;
	}

	public void addOption(Option option) throws NullPointerException, IllegalArgumentException {
		if (option == null) {
			throw new NullPointerException("Option can not be null.");
		}
		if (this.containsOption(option)) {
			throw new IllegalArgumentException("Option already added.");
		}

		this.options.add(option);
	}

	public void removeOption(Option option) throws NullPointerException, IllegalArgumentException {
		if (option == null) {
			throw new NullPointerException("Option can not be null.");
		}
		if (!this.containsOption(option)) {
			throw new IllegalArgumentException("Option not found.");
		}

		this.options.remove(option);
	}

	public boolean containsOption(Option option) {
		return this.options.contains(option);
	}
	
	public void showOptions() {
        for (Option option : options) {
            System.out.println(option.getText());
        }
	}

	public double rate(int questionRate) {
		double rate = 0;
		if (options.isEmpty()) {
			return rate;
		}
		for (Option option : options) {
			if (option.isCorrect()) {
				rate += questionRate;
			}
		}
		return rate / options.size();
	}
}
