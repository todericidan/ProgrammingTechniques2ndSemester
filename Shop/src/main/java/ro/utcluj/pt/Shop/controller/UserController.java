package ro.utcluj.pt.Shop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ro.utcluj.pt.Shop.model.Person;
import ro.utcluj.pt.Shop.model.User;
import ro.utcluj.pt.Shop.persistence.PersonPersistence;
import ro.utcluj.pt.Shop.persistence.UserPersistence;
import ro.utcluj.pt.Shop.view.AllProductsView;
import ro.utcluj.pt.Shop.view.AllUserOrdersView;
import ro.utcluj.pt.Shop.view.UserMainView;

public class UserController implements ActionListener{
	
	
	OrderViewController orderController;
	InsertNewUserController ins;
	UserMainView userMainView;
	User currentUser;
	Person currentPerson;
	AccountDetailController accountDetailsController;

	LinkedList<Person> personsList ;
	LinkedList<User> usersList;
	PersonPersistence personPersistence = new PersonPersistence();
	UserPersistence  userPersistence = new UserPersistence();
	
	
	public UserController( User u)
	{
		currentUser = u;
		
		try {
			personsList = (LinkedList<Person>) personPersistence.getAll();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		findCurrentPerson();

		userMainView = new UserMainView(this, currentPerson.getFirstName()+" "+currentPerson.getLastName());
	}
	
	private void findCurrentPerson()
	{
		try {
			personsList =(LinkedList<Person>) personPersistence.getAll();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		for(Person person:personsList)
		{
			if(person.getIdPerson()==currentUser.getIdPerson())
			{
				currentPerson = person;				
			}
		}
	}

	private void findCurrentUser()
	{
		try {
			usersList =(LinkedList<User>) userPersistence.getAll();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		for(User user:usersList)
		{
			if(user.getIdPerson()==currentUser.getIdPerson())
			{
				currentUser = user;				
			}
		}

	}
	public void actionPerformed(ActionEvent e) 
	{
		findCurrentUser();
		findCurrentPerson();
		
		System.out.println("Welcome,"+currentPerson.getFirstName()+" "+currentPerson.getLastName()+"!");

		userMainView.setTextFiled("Welcome,"+currentPerson.getFirstName()+" "+currentPerson.getLastName()+"!");

		
		JButton buttonSource = (JButton) e.getSource();

		if(buttonSource.getText().equals("SignOut") &&(buttonSource.getActionCommand().equals("user")))
		{
			userMainView.setVisibility(false);
			currentUser=null;

		}

		if(buttonSource.getText().equals("DeleteAccount")&&(buttonSource.getActionCommand().equals("user")))
		{
			Object[] options = {"YES","NO"};
			int choice = JOptionPane.showOptionDialog(userMainView, 
					"Delete Account",
					"Are you sure you want to delete it?", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.INFORMATION_MESSAGE,
					null, 
					options,
					options[1]);

			if(choice==0)
			{
				try {
					userPersistence.delete(currentUser);
				} catch (SQLException e1) {
					System.out.println(e1);
					e1.printStackTrace();
				}
				userMainView.setVisibility(false);
				currentUser = null;
			}

		}

		if(buttonSource.getText().equals("AccountDetails")&&(buttonSource.getActionCommand().equals("user")))
		{	
			accountDetailsController = new AccountDetailController(currentPerson, currentUser);
	
		}
		
		if(buttonSource.getText().equals("Order")&&(buttonSource.getActionCommand().equals("user")))
		{
			fetchingOrders();
		}
		
		
		if(buttonSource.getText().equals("ListOrders")&&(buttonSource.getActionCommand().equals("user")))
		{
			listingOrders();
			
		}
		if(buttonSource.getText().equals("ListProducts")&&(buttonSource.getActionCommand().equals("user")))
		{
			listingProducts();
			
		}
		

	}
	


	private void listingProducts() {
		new AllProductsView();
		
	}



	private void listingOrders() {
		new AllUserOrdersView(currentUser.getIdPerson());
	}



	void fetchingOrders()
	{
		
		orderController = new OrderViewController(currentPerson.getIdPerson());
	}
	
	
}
