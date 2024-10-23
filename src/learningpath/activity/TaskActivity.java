package learningpath.activity;

public class TaskActivity extends Activity {

	private String toDo;

	public TaskActivity(String title, String description, String objective, int expectedDuration, boolean mandatory,
			String toDo) {
		super(title, description, objective, expectedDuration, mandatory);
		this.toDo = toDo;
	}

	public String getToDo() {
		return toDo;
	}

	public void setToDo(String toDo) {
		this.toDo = toDo;
	}

}
