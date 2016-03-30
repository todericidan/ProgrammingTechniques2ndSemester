package ro.utcluj.pt.Shop.view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import ro.utcluj.pt.Shop.model.Order;
import ro.utcluj.pt.Shop.persistence.OrderPersistence;


public class AllUserOrdersView extends JFrame{
	private AllUserOrdersTabelPanel tablePanel;
	private List<Order> orders;
	private int id;

	public AllUserOrdersView(int id) 
	{
		this.id = id;
		orders = getProducts();
		tablePanel = new AllUserOrdersTabelPanel();
		tablePanel.setData(orders);
		add(tablePanel,BorderLayout.CENTER);

		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}


	private List<Order> getProducts() 
	{
		 OrderPersistence persistence = new OrderPersistence();
		List<Order> ordersList = null;
		LinkedList<Order> userList = new LinkedList<Order>();
		 try {
			 ordersList = persistence.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		for(Order o:ordersList)
		{
			if(o.getIdPerson()==id)
			{
				userList.add(o);
			}
		}
		
		return userList;
	}
}
