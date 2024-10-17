package programa.question;

import java.util.List;
import java.util.ArrayList;

public class MultipleOptionQuestion {
	private String question;
	private List<Option> options;

	public MultipleOptionQuestion(String question, List<Option> options) {
		this.question = question;
		this.options = options != null ? options : new ArrayList<>();
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}
}
