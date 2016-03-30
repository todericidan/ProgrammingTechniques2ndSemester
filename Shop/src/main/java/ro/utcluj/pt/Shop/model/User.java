package ro.utcluj.pt.Shop.model;

public class User {
	
	private String username;
	private String userPassword;
	private int idPerson;
	private boolean isAdmin;
	
	public User(String username, String password, int idPerson, boolean admin)
	{
		this.idPerson = idPerson;
		this.username = username;
		this.userPassword = password;
		this.isAdmin = admin;

	}	
	
	public String getUsername() {
		return username;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public int getIdPerson() {
		return idPerson;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}
	
	public void setPassword(String password)
	{
		this.userPassword = password;
	}
	
	

}
