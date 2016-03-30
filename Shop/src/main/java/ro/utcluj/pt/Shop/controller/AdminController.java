package ro.utcluj.pt.Shop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ro.utcluj.pt.Shop.model.Order;
import ro.utcluj.pt.Shop.model.Person;
import ro.utcluj.pt.Shop.model.Product;
import ro.utcluj.pt.Shop.model.ProductStorage;
import ro.utcluj.pt.Shop.model.User;
import ro.utcluj.pt.Shop.persistence.OrderPersistence;
import ro.utcluj.pt.Shop.persistence.PersonPersistence;
import ro.utcluj.pt.Shop.persistence.ProductPersistence;
import ro.utcluj.pt.Shop.persistence.ProductStoragePersistence;
import ro.utcluj.pt.Shop.persistence.UserPersistence;
import ro.utcluj.pt.Shop.view.AdminMainView;
import ro.utcluj.pt.Shop.view.AllProductsView;
import ro.utcluj.pt.Shop.view.AllUsersView;

public class AdminController implements ActionListener{

	AdminMainView adminMainView;
	EditProductController editProductController;
	AddProductController addProductController;

	public AdminController()
	{
		adminMainView = new AdminMainView(this);
	}

	public void actionPerformed(ActionEvent e) 
	{

		JButton buttonSource = (JButton) e.getSource();

		if(buttonSource.getText().equals("SignOut"))
		{
			adminMainView.setVisibility(false);

		}
		if(buttonSource.getText().equals("EditProduct"))
		{
			String product = JOptionPane.showInputDialog(null, "Insert ProductId", JOptionPane.OK_CANCEL_OPTION);
			System.out.println(product);
			int id = Integer.parseInt(product);

			editProductController = new EditProductController(id);
		}
		if(buttonSource.getText().equals("AddProduct"))
		{
			addProductController = new AddProductController();
		}
		if(buttonSource.getText().equals("DeleteProduct"))
		{
			String productID = JOptionPane.showInputDialog(null, "Insert ProductId", JOptionPane.OK_CANCEL_OPTION);
			System.out.println(productID);
			int id = Integer.parseInt(productID);

			ProductStoragePersistence storagePer = new ProductStoragePersistence();
			OrderPersistence orderPer = new OrderPersistence();
			ProductPersistence prodPer = new ProductPersistence();

			LinkedList<ProductStorage> storages = null;
			LinkedList<Order> orders = null;
			LinkedList<Product> products = null;

			try {
				storages = (LinkedList<ProductStorage>) storagePer.getAll();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				orders = (LinkedList<Order>) orderPer.getAll();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				products = (LinkedList<Product>) prodPer.getAll();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			//				for(Product product2:products)
			//				{
			//					if(product2.getIdProduct()==id)
			//					{
			//						try {
			//							prodPer.delete(product2);
			//						} catch (SQLException e1) {
			//							// TODO Auto-generated catch block
			//							e1.printStackTrace();
			//						}
			//					}
			//				}

			//System.out.println("futs");
			int flag = 0;
			for(Order order:orders)
			{
				if(order.getIdProduct()==id)
				{
					flag=1;
					break;
				}
			}


			for(ProductStorage storage:storages)
			{
				if(storage.getIdProduct()==id)
				{
					try {
						storage = new ProductStorage(id, 0);
						if(flag==1)
						{
							storagePer.update(storage);
						}
						else
						{
							storagePer.delete(storage);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			for(Product product:products)
			{
				if(product.getIdProduct()==id)
				{
					try {
						product = new Product(id, "Deleted", product.getPrice());
						if(flag==1)
						{
							prodPer.update(product);
						}
						else
						{
							prodPer.delete(product);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}

		if(buttonSource.getText().equals("ViewProducts"))
		{
			new AllProductsView();
		}

		if(buttonSource.getText().equals("Users"))
		{
			LinkedList<Person> p=null;
			try {
				p = (LinkedList<Person>) new PersonPersistence().getAll();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			LinkedList<User> u=null;
			try {
				u = (LinkedList<User>) new UserPersistence().getAll();
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}

			new AllUsersView(p,u);
		}
	}

}
