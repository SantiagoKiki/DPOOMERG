package learningpath.activity;

public class ResourceActivity extends Activity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url;

	public ResourceActivity(String title, String description, String objective, int expectedDuration, boolean mandatory,
			String url) {
		super(title, description, objective, expectedDuration, mandatory);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
