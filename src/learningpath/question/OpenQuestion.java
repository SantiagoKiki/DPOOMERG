package learningpath.question;

import java.io.Serializable;

public class OpenQuestion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;

	public OpenQuestion(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
