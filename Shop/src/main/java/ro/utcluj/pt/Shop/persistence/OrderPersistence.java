package ro.utcluj.pt.Shop.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ro.utcluj.pt.Shop.model.Order;

public class OrderPersistence implements Persistence<Order>{

	public List<Order> getAll() throws SQLException 
	{
		LinkedList<Order> orders = new LinkedList<Order>();
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from shop.orders");
		
		while(resultSet.next())
		{
			int idPerson = resultSet.getInt(1);
			int idProduct = resultSet.getInt(2);
			int quantity = resultSet.getInt(3);
			String dateString = resultSet.getString(4);
			String delivery =resultSet.getString(5);
			
			Order o = new Order(idPerson,idProduct,quantity,dateString,delivery);
			orders.add(o);
			
		}
		
		return orders;
	}

	public void update(Order element) throws SQLException 
	{
		System.out.println("date: "+element.getSubmissionDate()+ " delivery:"+element.getDeliveryDate());
		
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("update shop.orders set quantity = ' " + element.getQuantity() 
		        +"', deliveryDate='"+element.getDeliveryDate()
		        +"' where idProduct = " + element.getIdProduct()
				+" AND idPerson ="+element.getIdPerson()
				+" AND submissionDate like'"+element.getSubmissionDate()+"%'");
			
	}

	public void delete(Order element) throws SQLException 
	{
		System.out.println("for deletion :"+element.getIdPerson()+" "+element.getIdProduct()+" "+element.getSubmissionDate());
		Connection connection= DBHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("delete from shop.orders  "
				+ "where idProduct = " + element.getIdProduct()
				+" AND idPerson = "+element.getIdPerson()
				+" AND submissionDate like'"+element.getSubmissionDate()+"%'");
	}

	public int insert(Order element) throws SQLException 
	{	
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("insert into shop.orders(idPerson, idProduct, quantity, submissionDate, deliveryDate)" +
				" values ('" + element.getIdPerson() + "','" 
				+ element.getIdProduct()+ "','" 
				+ element.getQuantity()+ "','" 
				+ element.getSubmissionDate()+ "','" 
				+ element.getDeliveryDate()+"')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet result = statement.getGeneratedKeys();
		
		if (result.next())
		{
			return result.getInt(1);
		}
		
		return -1;
	}
	
	

}
