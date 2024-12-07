package logic.learningpath.question;

import java.io.Serializable;

public class OpenQuestion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private String answer;

	public OpenQuestion(String text) {
		this.text = text;
		this.answer = "";
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		if (text == null) {
			throw new NullPointerException("El texto no puede ser nulo");
		}
		this.text = text;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		if (answer == null) {
			throw new NullPointerException("La respuesta no puede ser nula");
		}
		this.answer = answer;
	}
}
