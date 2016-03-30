package ro.utcluj.pt.Shop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JButton;

import ro.utcluj.pt.Shop.model.Person;
import ro.utcluj.pt.Shop.model.User;
import ro.utcluj.pt.Shop.persistence.PersonPersistence;
import ro.utcluj.pt.Shop.persistence.UserPersistence;
import ro.utcluj.pt.Shop.view.InsertNewUserView;

public class InsertNewUserController implements ActionListener {

	private InsertNewUserView userInterface;
	boolean hasUserBeenInserted,hasCancelBeenPressed;
	private User userCreated;

	public InsertNewUserController()
	{
		userInterface = new InsertNewUserView(this);
		hasUserBeenInserted = false;
		hasCancelBeenPressed = false;
	}

	public void setVisibilityOfView(boolean choice)
	{
		userInterface.setVisibility(choice);
	}


	public void actionPerformed(ActionEvent e) 
	{
		JButton buttonSource = (JButton) e.getSource();

		if(buttonSource.getText().equals("Cancel"))
		{
			hasCancelBeenPressed=true;
		}

		if(buttonSource.getText().equals("CreateUser"))
		{
			int messagedDisplayed =0;
			String firstName = userInterface.getFirstName();
			String lastName = userInterface.getLastName();
			String address = userInterface.getAddress();
			String email = userInterface.getEmail();
			String username = userInterface.getUsername();
			String password = userInterface.getPassword();

			UserPersistence userPersis = new UserPersistence();
			LinkedList<User> users = null;
			try {
				users=(LinkedList<User>) userPersis.getAll();
			} catch (SQLException e1) {
				System.out.println(e1);
				e1.printStackTrace();
			}

			int flag =0;
			for(User user:users)
			{
				if(user.getUsername().equals(username))
				{
					flag =1;
				}
			}
			if(flag==1)
			{
				userInterface.displayMessage("Username already exists!");
				userInterface.setUsernameFieldText("");
				messagedDisplayed++;
			}

			if(password.equals(""))
			{
				if(messagedDisplayed==0)
				{
					userInterface.displayMessage("Insert password!");
					messagedDisplayed++;
				}
			}

			if(firstName.equals(""))
			{
				if(messagedDisplayed==0)
				{
					userInterface.displayMessage("Insert first name!");
					messagedDisplayed++;
				}
			}

			if(lastName.equals(""))
			{
				if(messagedDisplayed==0)
				{
					userInterface.displayMessage("Insert last name!");
					messagedDisplayed++;
				}
			}

			if(address.equals(""))
			{
				if(messagedDisplayed==0)
				{
					userInterface.displayMessage("Insert address!");
					messagedDisplayed++;
				}
			}

			if(email.equals(""))
			{
				if(messagedDisplayed==0)
				{
					userInterface.displayMessage("Insert email!");
					messagedDisplayed++;
				}
			}

			if((flag==0)&& (!firstName.equals("")) && (!password.equals("")) && (!lastName.equals("")) && (!address.equals("")) &&(!email.equals("")))
			{
				PersonPersistence personPersis = new PersonPersistence();
				LinkedList<Person> persons = null;
				try {
					persons=(LinkedList<Person>) personPersis.getAll();
				} catch (SQLException e2) {
					System.out.println(e2);
					e2.printStackTrace();
				}

				int maxId=-1;
				for(Person person:persons)
				{
					if(person.getIdPerson()>maxId)
					{
						maxId = person.getIdPerson();
					}
				}
				maxId++;

				Person person = new Person(maxId, firstName, lastName, address, email);
				User user = new User(username, password, maxId, false);
				userCreated =user;

				try {
					personPersis.insert(person);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					userPersis.insert(user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				hasUserBeenInserted=true;
			}

		}
	}

	public User getUser()
	{
		return userCreated;
	}

	public boolean getHasUserBeenInserted()
	{
		return hasUserBeenInserted;
	}

	public boolean getHasCancelBeenPressed()
	{
		return hasCancelBeenPressed;
	}

}
