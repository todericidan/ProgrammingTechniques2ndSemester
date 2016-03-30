package ro.utcluj.pt.Shop.model;

public class Person {
	
	private int idPerson;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	
	public Person(int id,String firstName,String lastName,String address,String email)
	{
		setIdPerson(id);
		setAddress(address);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		
	}
	

	public int getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
