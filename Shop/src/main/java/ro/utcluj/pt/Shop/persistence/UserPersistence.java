package ro.utcluj.pt.Shop.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ro.utcluj.pt.Shop.model.User;

public class UserPersistence implements Persistence<User>{

	public List<User> getAll() throws SQLException 
	{
		LinkedList<User> users = new LinkedList<User>();
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from shop.users");
		
		while(resultSet.next())
		{
			String username = resultSet.getString(1);
			String userPassword = resultSet.getString(2);
			int idPerson = resultSet.getInt(3);
			boolean isAdmin = resultSet.getBoolean(4);
			
			User u = new User(username,userPassword,idPerson,isAdmin);
			users.add(u);
			
		}
		
		return users;
	}

	public void update(User element) throws SQLException 
	{
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("update shop.users set userPassword = '" + element.getUserPassword() + 
				"' where username = '" + element.getUsername()+"'");
		
	}

	public void delete(User element) throws SQLException 
	{
		//System.out.println("delete "+element.getUsername());
		Connection connection= DBHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("delete from shop.users where username = '" + element.getUsername()+"'");
		
	}

	public int insert(User element) throws SQLException 
	{
		int a =0;
		if(element.getIsAdmin())
		{
			System.out.println("is admin:"+element.getIsAdmin());
			a=1;
		}
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("insert into shop.users(username, userPassword, idPerson, isAdmin)" +
				" values ('" + element.getUsername() + "','" +element.getUserPassword()+ "','" +
				element.getIdPerson() + "','" +a+ "')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet result = statement.getGeneratedKeys();
		
		if (result.next())
		{
			return result.getInt(3);
		}
		
		return -1;
	}

}
