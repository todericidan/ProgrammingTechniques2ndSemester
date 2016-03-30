package ro.utcluj.pt.Shop.view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import ro.utcluj.pt.Shop.model.*;
import ro.utcluj.pt.Shop.persistence.PersonPersistence;
import ro.utcluj.pt.Shop.persistence.ProductPersistence;
import ro.utcluj.pt.Shop.persistence.UserPersistence;

public class AllUsersView extends JFrame {
	
	private AllUsersTablePanel tablePanel;
	private LinkedList<Person> persons ;
	private LinkedList<User> users;
	
	public AllUsersView(LinkedList<Person> pList,LinkedList<User> uList)
	{
		persons = pList;
		users = uList;
		
		for(Person p :persons)
		{
			System.out.println(p.getFirstName());
		}
		tablePanel = new AllUsersTablePanel();
		tablePanel.setData(persons,users);
		add(tablePanel,BorderLayout.CENTER);

		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	
	

}
