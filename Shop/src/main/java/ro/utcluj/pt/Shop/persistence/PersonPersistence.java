package ro.utcluj.pt.Shop.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ro.utcluj.pt.Shop.model.Person;
import ro.utcluj.pt.Shop.persistence.DBHelper;


public class PersonPersistence implements Persistence<Person>{



	public void update(Person element) throws SQLException 
	{
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("update shop.persons set firstName = '" + element.getFirstName() + 
				"', lastName='" + element.getLastName()+"', address='"+ element.getAddress()
				  + "', email='" + element.getEmail() + "' where idPerson = " + element.getIdPerson());
		
	}

	public void delete(Person element) throws SQLException 
	{
		Connection connection= DBHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("delete from shop.persons where idPerson = " + element.getIdPerson());
		
	}

	public int insert(Person element) throws SQLException 
	{	
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("insert into shop.persons(idPerson, firstName, lastName, address, email)" +
				" values ('" + element.getIdPerson() + "','" +element.getFirstName()+ "','" +
				element.getLastName() + "','" +element.getAddress()+ "','" +
				element.getEmail() + "')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet result = statement.getGeneratedKeys();
		
		if (result.next())
		{
			return result.getInt(1);
		}
		
		return -1;
	}

	public List<Person> getAll() throws SQLException 
	{
		
		LinkedList<Person> persons = new LinkedList<Person>();
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from shop.persons");
		
		while(resultSet.next())
		{
			int id = resultSet.getInt(1);
			String firstName = resultSet.getString(2);
			String lastName = resultSet.getString(3);
			String address = resultSet.getString(4);
			String email = resultSet.getString(5);
			
			Person p = new Person(id,firstName,lastName,address,email);
			persons.add(p);
			
		}
		
		return persons;
	}
}
