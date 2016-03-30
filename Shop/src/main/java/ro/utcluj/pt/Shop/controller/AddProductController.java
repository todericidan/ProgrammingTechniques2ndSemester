package ro.utcluj.pt.Shop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JButton;

import ro.utcluj.pt.Shop.model.Product;
import ro.utcluj.pt.Shop.model.ProductStorage;
import ro.utcluj.pt.Shop.persistence.ProductPersistence;
import ro.utcluj.pt.Shop.persistence.ProductStoragePersistence;
import ro.utcluj.pt.Shop.view.AddProductView;

public class AddProductController implements ActionListener{

	private AddProductView userInterface;
	private LinkedList<Product> products =new LinkedList<Product>();
	private LinkedList<ProductStorage> storages = new LinkedList<ProductStorage>();
	private ProductStoragePersistence storagePersistence = new ProductStoragePersistence();
	private ProductPersistence productPersistence = new ProductPersistence();
	
	public AddProductController()
	{
		userInterface = new AddProductView(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton buttonSource = (JButton) e.getSource();
		
		if(buttonSource.getText().equals("Done"))
		{
			if(userInterface.getProductName().equals(""))
			{
				userInterface.displayMessage("Insert Product Name!");
			}
			else
			{
				int maxx=-1;
				
				try {
					products = (LinkedList<Product>) productPersistence.getAll();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for(Product product:products)
				{
					if(product.getIdProduct()>maxx)
					{
						maxx=product.getIdProduct();
					}
				}
				maxx++;
				
				Product productToInsert = new Product(maxx, userInterface.getProductName(), userInterface.getPrice());
				
				ProductStorage storageToInsert = new ProductStorage(maxx, userInterface.getQuantity());
				
				try {
					productPersistence.insert(productToInsert);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					storagePersistence.insert(storageToInsert);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				userInterface.setVisibility(false);
			}
		}
		
	}
	
	
}
