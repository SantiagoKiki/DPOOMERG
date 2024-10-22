package users;

import consola.UsersVerifier;

public abstract class User {
	
	protected String username;
	protected String password;
	
	public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	abstract public String getRole();

	public boolean authenticate(String password) {
		if (this.password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	
	

}
