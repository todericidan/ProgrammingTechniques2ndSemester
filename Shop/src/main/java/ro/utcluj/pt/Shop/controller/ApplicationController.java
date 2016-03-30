package ro.utcluj.pt.Shop.controller;



import ro.utcluj.pt.Shop.model.Person;
import ro.utcluj.pt.Shop.model.User;

public class ApplicationController  {

	LogInController logInController;
	InsertNewUserController ins;
	UserController userController;
	AdminController adminController;
	
	User currentUser;
	Person currentPerson;



	public ApplicationController()
	{
		logIn();
		if(logInController.getIsNewUserRequested())
		{
			createUser();
		}

		System.out.println(currentUser.getUsername()+ " "+currentUser.getIsAdmin());
		if(!currentUser.getIsAdmin())
		{
			initUserController();
		}
		else
		{
			initAdminController();
		}

	}





	private void logIn() {
		logInController = new LogInController();
		while(logInController.getCurrentUser().getUsername().equals("nem") &&(!logInController.getIsNewUserRequested()))
		{
			logInController.setVisibilityOfView(true);
		}
		logInController.setVisibilityOfView(false);

		currentUser = logInController.getCurrentUser();

	}

	private void createUser() 
	{
		ins = new InsertNewUserController();
		while((!ins.getHasCancelBeenPressed()) &&(!ins.getHasUserBeenInserted()))
		{
			ins.setVisibilityOfView(true);
		}
		ins.setVisibilityOfView(false);
		currentUser = ins.getUser();
	}


	private void initUserController() {
		userController = new UserController(currentUser);
	}
	


	private void initAdminController() {
		adminController = new AdminController();
		
	}



	
}
