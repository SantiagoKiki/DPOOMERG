package learningpath.activity;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedList;
import learningpath.question.TrueFalseQuestion;

public class TrueFalseActivity extends Activity implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	private LinkedList<TrueFalseQuestion> questions;

	public TrueFalseActivity(String title, String description, String objective, int expectedDuration, boolean mandatory,
			LinkedList<TrueFalseQuestion> questions) {
		super(title, description, objective, expectedDuration, mandatory);
		this.questions = questions != null ? questions : new LinkedList<>();
	}

	public LinkedList<TrueFalseQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(LinkedList<TrueFalseQuestion> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(TrueFalseQuestion question) throws NullPointerException, IllegalArgumentException{
		if (question == null) {
			throw new NullPointerException("La pregunta no puede ser nula");
		}
		
		if (this.containsQuestion(question)) {
			throw new IllegalArgumentException("La pregunta ya existe");
		}
		
		questions.add(question);
	}
	
	public void removeQuestion(TrueFalseQuestion question) throws NullPointerException, IllegalArgumentException {
		if (question == null) {
			throw new NullPointerException("La pregunta no puede ser nula");
		}
		
		if (!this.containsQuestion(question)) {
			throw new IllegalArgumentException("La pregunta no existe");
		}

		questions.remove(question);
	}
	
	public boolean containsQuestion(TrueFalseQuestion question) {
		return questions.contains(question);
	}

}
