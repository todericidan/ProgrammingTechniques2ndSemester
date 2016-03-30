package ro.utcluj.pt.Shop.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ro.utcluj.pt.Shop.model.Person;
import ro.utcluj.pt.Shop.model.User;

public class AccountDetailsView extends JFrame{
	private static final long serialVersionUID = 333L;
	
	private JLabel firstNameLabel,lastNameLabel,addressLabel,emailLabel,passwordLabel;
	private JTextField firstNameField,lastNameField,addressField,emailField, passwordField;
	private JButton doneButton,editButton;
	
	public AccountDetailsView(Person person,User user,ActionListener actionListener)
	{
		super("Account Details");
		setBackground(Color.lightGray);
		setLayout(null);
		setSize (400,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		initFields(person,user,actionListener);
		setVisible(true);
	
	}

	private void initFields(Person person, User user, ActionListener actionListener) 
	{
		
		//System.out.println("id:"+person.getIdPerson()+" name:"+person.getFirstName());
		//System.out.println("User:"+user.getUsername());
		//System.out.println("intra");
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

				passwordLabel = new JLabel("Password :");
				passwordLabel.setForeground(Color.blue);
				passwordLabel.setBounds(20, 215, 100, 50);
				passwordLabel.setFont(passwordLabel.getFont().deriveFont(14.0f));
				add(passwordLabel);


				//fields

				firstNameField = new JTextField();
				firstNameField.setText(person.getFirstName());
				firstNameField.setBounds(122, 27, 200, 30);
				firstNameField.setFont(firstNameField.getFont().deriveFont(12.0f));
				add(firstNameField);

				lastNameField = new JTextField();
				lastNameField.setText(person.getLastName());
				lastNameField.setBounds(122, 77, 200, 30);
				lastNameField.setFont(lastNameField.getFont().deriveFont(12.0f));
				add(lastNameField);

				addressField = new JTextField();
				addressField.setText(person.getAddress());
				addressField.setBounds(122, 127, 200, 30);
				addressField.setFont(addressField.getFont().deriveFont(12.0f));
				add(addressField);

				emailField = new JTextField();
				emailField.setText(person.getEmail());
				emailField.setBounds(122, 177, 200, 30);
				emailField.setFont(emailField.getFont().deriveFont(12.0f));
				add(emailField);

				passwordField = new JTextField();
				passwordField.setText(user.getUserPassword());
				passwordField.setBounds(122, 227, 200, 30);
				passwordField.setFont(passwordField.getFont().deriveFont(12.0f));
				add(passwordField);

				//button
				setEditableForAllTextField(false);

				doneButton = new JButton("Done");
				doneButton.setActionCommand("details");
				doneButton.setBounds(122,260, 110, 30);
				doneButton.addActionListener(actionListener);
				add(doneButton);
				
				editButton = new JButton("Edit");
				editButton.setActionCommand("details");
			    editButton.setBounds(240,260,80,30);
				editButton.addActionListener(actionListener);
				add(editButton);
					
		
	}

	public void setEditableForAllTextField(boolean b) {
		firstNameField.setEditable(b);
		lastNameField.setEditable(b);
		addressField.setEditable(b);
		emailField.setEditable(b);
		passwordField.setEditable(b);
		
	}
	
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(this, message);
	}


	public void setVisibility(boolean choice)
	{
		setVisible(choice);
	}

	public String getFirstNameField() {
		return firstNameField.getText();
	}

	public String getLastNameField() {
		return lastNameField.getText();
	}

	public String getAddressField() {
		return addressField.getText();
	}

	public String getEmailField() {
		return emailField.getText();
	}

	public String getPasswordField() {
		return passwordField.getText();
	}

}
