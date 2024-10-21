package users;

public abstract class User {
	
	public String username;
	private String password;
	public static UsersVerifier crear;

	
	public User(String username, String password) {
        this.username = username;
        this.password = password;
        crear.usersDataBase.put(username, password);
    }
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
