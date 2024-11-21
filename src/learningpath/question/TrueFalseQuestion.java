package learningpath.question;

import java.io.Serializable;

public class TrueFalseQuestion implements Serializable {

	private static final long serialVersionUID = 1L;
	private String question;
	private final Option[] options = new Option[2];

	public TrueFalseQuestion(String question, Option trueOption, Option falseOption) {
		this.options[0] = trueOption;
		this.options[1] = falseOption;
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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
}
