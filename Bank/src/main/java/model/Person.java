package model;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class Person implements Observer,Serializable{

	private static final long serialVersionUID = 2729189206284689669L;

	private String name;
	private int personID;
	public Person(String name,int personID){
		this.name = name;
		this.personID = personID;

	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + personID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (personID != other.personID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "\nPerson [name=" + name + ", personID=" + personID + "]";
	}

	public void update(Observable arg0, Object arg1) {
		if (arg0 instanceof Account){
			Account acc = (Account) arg0;
			System.out.println("Notification "+acc.getAccID()+" "+arg1.toString());
		}


	}
	
	public String getName()
	{
		return name;
	}
	public int getId()
	{
		return personID;
	}
	
	

}
