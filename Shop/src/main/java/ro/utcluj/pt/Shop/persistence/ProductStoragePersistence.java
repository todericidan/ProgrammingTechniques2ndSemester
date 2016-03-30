package ro.utcluj.pt.Shop.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ro.utcluj.pt.Shop.model.ProductStorage;

public class ProductStoragePersistence implements Persistence<ProductStorage>{

	public List<ProductStorage> getAll() throws SQLException 
	{
		LinkedList<ProductStorage> productsStorage = new LinkedList<ProductStorage>();
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from shop.productstorage");
		
		while(resultSet.next())
		{
			int idProduct = resultSet.getInt(1);
			int quantity = resultSet.getInt(2);
			
			ProductStorage p = new ProductStorage(idProduct, quantity);
			productsStorage.add(p);
			
		}
		
		return productsStorage;
	}

	public void update(ProductStorage element) throws SQLException 
	{
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("update shop.productstorage set quantity = ' " + element.getQuantity() + 
				"' where idProduct= " + element.getIdProduct());
		
		
	}

	public void delete(ProductStorage element) throws SQLException 
	{
		Connection connection= DBHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("delete from shop.productstorage  where idProduct = " + element.getIdProduct());
		
	}

	public int insert(ProductStorage element) throws SQLException 
	{
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("insert into shop.productstorage(idProduct, quantity)" +
				" values ('" + element.getIdProduct() + "','" + element.getQuantity() + "')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet result = statement.getGeneratedKeys();
		
		if (result.next())
		{
			return result.getInt(1);
		}
		
		return -1;
	}


}
