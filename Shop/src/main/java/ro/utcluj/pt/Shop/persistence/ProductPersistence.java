package ro.utcluj.pt.Shop.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ro.utcluj.pt.Shop.model.Product;

public class ProductPersistence implements Persistence<Product> {

	public List<Product> getAll() throws SQLException {
		LinkedList<Product> products = new LinkedList<Product>();
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from shop.products");
		
		while(resultSet.next())
		{
			int idProduct = resultSet.getInt(1);
			String productName = resultSet.getString(2);
			float price = resultSet.getFloat(3);
			
			Product p = new Product(idProduct,productName,price);
			products.add(p);
			
		}
		
		return products;
	}

	public void update(Product element) throws SQLException {
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("update shop.products set productName = '" + element.getProductName() + 
				"', price='" + element.getPrice()+"' where idProduct = " + element.getIdProduct());
		
		
	}

	public void delete(Product element) throws SQLException {
		Connection connection= DBHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("delete from shop.products where idProduct= " + element.getIdProduct());
		
	}

	public int insert(Product element) throws SQLException {
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("insert into shop.products(idProduct, productName, price)" +
				" values ('" + element.getIdProduct() + "','" +element.getProductName()+ "','" +
				element.getPrice()+ "')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet result = statement.getGeneratedKeys();
		
		if (result.next())
		{
			return result.getInt(1);
		}
		
		return -1;
	}
	
}
