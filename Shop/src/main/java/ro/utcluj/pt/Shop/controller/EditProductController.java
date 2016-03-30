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
import ro.utcluj.pt.Shop.view.EditProductView;

public class EditProductController implements ActionListener{

	int productId;
	EditProductView userInterface;
	private Product productToEdit;
	int quantity;
	private LinkedList<ProductStorage> storages = new LinkedList<ProductStorage>();
	private ProductStoragePersistence storagePersistence = new ProductStoragePersistence();
	private ProductPersistence productPersistence = new ProductPersistence();

	public EditProductController(int id)
	{
		quantity=0;
		productId = id;
		findProduct();
	}

	private void findProduct() {

		LinkedList<Product> products =null;
		try {
			products= (LinkedList<Product>) productPersistence.getAll();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		int flag=0;

		for(Product product:products)
		{
			if(product.getIdProduct()==productId)
			{
				flag=1;
				productToEdit=product;
				break;
			}
		}	

		if(flag==1)
		{
			try {
				storages =(LinkedList<ProductStorage>)storagePersistence.getAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for(ProductStorage s :storages)
			{
				if(s.getIdProduct()==productId)
				{
					quantity =s.getQuantity();
				}
			}

			userInterface = new EditProductView(this, productToEdit, quantity);
		}

	}



	public void actionPerformed(ActionEvent e) {
		JButton buttonSource = (JButton) e.getSource();

		if(buttonSource.getText().equals("Edit"))
		{
			userInterface.setEditableForAllTextField(true);
		}

		if(buttonSource.getText().equals("Done"))
		{
			if((!userInterface.getName().equals("")))
			{
				productToEdit = new Product(productId, userInterface.getProductName(), userInterface.getPrice());

				ProductStorage storageToEdit = new ProductStorage(productId, userInterface.getQuantity());

				//System.out.println(productToEdit.getProductName()+"-"+storageToEdit.getQuantity());
				
				try {
					storagePersistence.update(storageToEdit);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					productPersistence.update(productToEdit);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				userInterface.setVisible(false);
				
			}

		}
	}

}
