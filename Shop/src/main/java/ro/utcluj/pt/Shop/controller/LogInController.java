package ro.utcluj.pt.Shop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JButton;

import ro.utcluj.pt.Shop.model.User;
import ro.utcluj.pt.Shop.persistence.UserPersistence;
import ro.utcluj.pt.Shop.view.LogInView;



public class LogInController implements ActionListener{

	private LogInView userInterface;
	private User currentUser;
	private boolean newUserRequest;

	public LogInController() 
	{
		userInterface = new LogInView(this);
		currentUser = new User("nem", null, -1, false);
		newUserRequest = false;
	}
	
	public void setVisibilityOfView(boolean choice)
	{
		userInterface.setVisibility(choice);
	}


	public void actionPerformed(ActionEvent e) 
	{
		JButton buttonSource = (JButton) e.getSource();

		if(buttonSource.getText().equals("SignUp"))
		{
			newUserRequest = true;
			//userInterface.setVisibility(false);
		}

		if(buttonSource.getText().equals("LogIn"))
		{


			UserPersistence persistence = new UserPersistence();
			LinkedList<User> users = null;
			try {
				users=(LinkedList<User>) persistence.getAll();
			} catch (SQLException e1) {
				System.out.println(e1);
				e1.printStackTrace();
			}

			int flag =0;
			for(User user:users)
			{
				if(user.getUsername().equals(userInterface.getUsermame()))
				{
					flag = 1;
					if(user.getUserPassword().equals(userInterface.getPassword()))
					{
						currentUser = user;
						
						//userInterface.displayMessage("Welcome, "+currentUser.getUsername()+"!");
					}
					else
					{
						userInterface.setPassword("");
						userInterface.displayMessage("Invalid Password");
					}
				}

			}
			
			if(flag==0)
			{
				System.out.println("intra "+userInterface.getUsermame());
				userInterface.setUsername("");
				userInterface.setPassword("");
				userInterface.displayMessage("Invalid User");
			}
		}
	}
	
	public User getCurrentUser()
	{
		return currentUser;
	}
	
	public boolean getIsNewUserRequested()
	{
		return newUserRequest;
	}



}
