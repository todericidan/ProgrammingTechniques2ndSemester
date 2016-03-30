package ro.utcluj.pt.Shop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import ro.utcluj.pt.Shop.model.Person;
import ro.utcluj.pt.Shop.model.User;
import ro.utcluj.pt.Shop.persistence.PersonPersistence;
import ro.utcluj.pt.Shop.persistence.UserPersistence;
import ro.utcluj.pt.Shop.view.AccountDetailsView;

public class AccountDetailController implements ActionListener{

	private AccountDetailsView userInterface;
	private boolean editingIsDone;
	private int idPerson;
	private String username;
	private Person personToBeUpdated;
	private User userToBeUpdated;

	public AccountDetailController(Person p,User u)
	{
		personToBeUpdated = p;
		userToBeUpdated = u;

		idPerson = p.getIdPerson();
		username = u.getUsername();

		editingIsDone = false;
		userInterface = new AccountDetailsView(p, u,this);

	}

	public void setViewVisibility(boolean choice)
	{
		userInterface.setVisibility(choice);
	}

	public boolean getIsEditingDone()
	{
		return editingIsDone;
	}

	public void actionPerformed(ActionEvent e) 
	{

		JButton buttonSource = (JButton) e.getSource();

		if(buttonSource.getText().equals("Edit"))
		{
			userInterface.setEditableForAllTextField(true);
		}

		if(buttonSource.getText().equals("Done"))
		{
			
			personToBeUpdated = new Person(idPerson,null,null,null,null);

			String firstName = userInterface.getFirstNameField();
			String lastName = userInterface.getLastNameField();
			String address = userInterface.getAddressField();
			String email = userInterface.getEmailField();

			personToBeUpdated.setFirstName(firstName);
			personToBeUpdated.setLastName(lastName);
			personToBeUpdated.setAddress(address);
			personToBeUpdated.setEmail(email);


			userToBeUpdated = new User(username,null, idPerson, false);

			String pass = userInterface.getPasswordField();

			userToBeUpdated.setPassword(pass);
			
			

			if(firstName.equals("")||lastName.equals("")||address.equals("")||email.equals("")||pass.equals(""))
			{
				userInterface.displayMessage("Some fields are empty!");
			}
			else
			{
				System.out.println("intra");
				UserPersistence uP =  new UserPersistence();
				try {
					uP.update(userToBeUpdated);
				} catch (SQLException e1) {
					System.out.println(e1);
					e1.printStackTrace();
				}

				PersonPersistence pP = new PersonPersistence();

				try {
					pP.update(personToBeUpdated);
				} catch (SQLException e1) {
					System.out.println(e1);
					e1.printStackTrace();
				}
				
				editingIsDone = true;
				userInterface.setVisibility(false);
			}

		}

	}
	

}
