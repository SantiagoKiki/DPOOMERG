package users;

import java.io.Serializable;

public abstract class User implements Serializable{

	private static final long serialVersionUID = 1L;
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

    public String getPassword() 
    {
    	return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    abstract public String getRole();

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

}
