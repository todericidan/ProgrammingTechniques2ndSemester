package ro.utcluj.pt.Shop.view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;

import ro.utcluj.pt.Shop.model.Product;
import ro.utcluj.pt.Shop.persistence.ProductPersistence;

public class AllProductsView extends JFrame{

	private AllProductsTablePanel tablePanel;
	private List<Product> products;

	public AllProductsView() 
	{
		products = getProducts();
		tablePanel = new AllProductsTablePanel();
		tablePanel.setData(products);
		add(tablePanel,BorderLayout.CENTER);

		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}


	private List<Product> getProducts() 
	{
		try {
			return new ProductPersistence().getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
