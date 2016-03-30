package ro.utcluj.pt.Shop.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InsertNewUserView extends JFrame{
	private static final long serialVersionUID = 112L;
	
	private JLabel firstNameLabel,lastNameLabel,addressLabel,emailLabel,usernameLabel, passwordLabel;
	private JTextField firstNameField,lastNameField,addressField,emailField,usernameField, passwordField;
	private JButton createNewUserButton,cancelButton;

	public InsertNewUserView(ActionListener actionListener)  
	{
		super("SignUp View");
		setBackground(Color.lightGray);
		setLayout(null);
		setSize (450,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//labels
		firstNameLabel = new JLabel("FirstName :");
		firstNameLabel.setForeground(Color.blue);
		firstNameLabel.setBounds(20, 15, 100, 50);
		firstNameLabel.setFont(firstNameLabel.getFont().deriveFont(14.0f));
		add(firstNameLabel);

		lastNameLabel = new JLabel("LastName :");
		lastNameLabel.setForeground(Color.blue);
		lastNameLabel.setBounds(20, 65, 100, 50);
		lastNameLabel.setFont(lastNameLabel.getFont().deriveFont(14.0f));
		add(lastNameLabel);

		addressLabel = new JLabel("Address :");
		addressLabel.setForeground(Color.blue);
		addressLabel.setBounds(20, 115, 100, 50);
		addressLabel.setFont(addressLabel.getFont().deriveFont(14.0f));
		add(addressLabel);

		emailLabel = new JLabel("Email :");
		emailLabel.setForeground(Color.blue);
		emailLabel.setBounds(20, 165, 100, 50);
		emailLabel.setFont(emailLabel.getFont().deriveFont(14.0f));
		add(emailLabel);

		usernameLabel = new JLabel("Username :");
		usernameLabel.setForeground(Color.blue);
		usernameLabel.setBounds(20, 215, 100, 50);
		usernameLabel.setFont(usernameLabel.getFont().deriveFont(14.0f));
		add(usernameLabel);

		passwordLabel = new JLabel("Password :");
		passwordLabel.setForeground(Color.blue);
		passwordLabel.setBounds(20, 268, 100, 50);
		passwordLabel.setFont(passwordLabel.getFont().deriveFont(14.0f));
		add(passwordLabel);


		//fields

		firstNameField = new JTextField();
		firstNameField.setBounds(122, 27, 200, 30);
		firstNameField.setFont(firstNameField.getFont().deriveFont(12.0f));
		add(firstNameField);

		lastNameField = new JTextField();
		lastNameField.setBounds(122, 77, 200, 30);
		lastNameField.setFont(lastNameField.getFont().deriveFont(12.0f));
		add(lastNameField);

		addressField = new JTextField();
		addressField.setBounds(122, 127, 200, 30);
		addressField.setFont(addressField.getFont().deriveFont(12.0f));
		add(addressField);

		emailField = new JTextField();
		emailField.setBounds(122, 177, 200, 30);
		emailField.setFont(emailField.getFont().deriveFont(12.0f));
		add(emailField);

		usernameField = new JTextField();
		usernameField.setBounds(122, 227, 200, 30);
		usernameField.setFont(usernameField.getFont().deriveFont(12.0f));
		add(usernameField);

		passwordField = new JTextField();
		passwordField.setBounds(122, 279, 200, 30);
		passwordField.setFont(passwordField.getFont().deriveFont(12.0f));
		add(passwordField);

		//button

		createNewUserButton = new JButton("CreateUser");
		createNewUserButton.setBounds(122,320, 110, 30);
		createNewUserButton.addActionListener(actionListener);
		add(createNewUserButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(240,320,80,30);
		cancelButton.addActionListener(actionListener);
		add(cancelButton);
		
		setVisible(true);


	}

	public void setVisibility(boolean choice)
	{
		setVisible(choice);
	}

	public String getFirstName() {
		return firstNameField.getText();
	}

	public String getLastName() {
		return lastNameField.getText();
	}

	public String getAddress() {
		return addressField.getText();
	}

	public String getEmail() {
		return emailField.getText();
	}

	public String getUsername() {
		return usernameField.getText();
	}

	public String getPassword() {
		return passwordField.getText();
	}

	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(this, message);
	}


	public void setFirstNameFieldText(String firstName) {
		this.firstNameField.setText(firstName);
	}

	public void setLastNameFieldText(String lastName) {
		this.lastNameField.setText(lastName);
	}

	public void setAddressFieldText(String address) {
		this.addressField.setText(address);
	}

	public void setEmailFieldText(String email) {
		this.emailField.setText(email);
	}

	public void setUsernameFieldText(String username) {
		this.usernameField.setText(username);
	}

	public void setPasswordFieldText(String password) {
		this.passwordField.setText(password);
	}





}
