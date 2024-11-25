package logic.learningpath.question;

import java.io.Serializable;

public class TrueFalseQuestion implements Serializable {

	private static final long serialVersionUID = 1L;
	private String question;
	private String answer;
	private final Option[] options = new Option[2];

	public TrueFalseQuestion(String question, Option trueOption, Option falseOption) {
		this.options[0] = trueOption;
		this.options[1] = falseOption;
		this.question = question;
		this.answer = "";
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

	public Option[] getOptions() {
		return options;
	}

	public void setOptions(Option trueOption, Option falseOption) {
		this.options[0] = trueOption;
		this.options[1] = falseOption;
	}

	public boolean isCorrect(Option option) {
		return option.isCorrect();
	}
	
	public void showOptions() {
		System.out.println("1. " + options[0].getText());
		System.out.println("2. " + options[1].getText());
	}
}
