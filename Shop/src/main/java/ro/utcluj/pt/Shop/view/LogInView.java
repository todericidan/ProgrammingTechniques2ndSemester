package ro.utcluj.pt.Shop.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LogInView extends JFrame{
	
	private static final long serialVersionUID = 111L;
	
	private JLabel usernameLabel, passwordLabel;
	private JTextField usernameField, passwordField;
	private JButton logInButton, signUpButton;
	
	public LogInView(ActionListener actionListener) 
	{
		super("LogIn View");
		setBackground(Color.lightGray);
		setLayout(null);
		setSize (400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		usernameLabel = new JLabel("Username :");
		usernameLabel.setForeground(Color.blue);
	    usernameLabel.setBounds(20, 15, 100, 50);
		usernameLabel.setFont(usernameLabel.getFont().deriveFont(14.0f));
		add(usernameLabel);
		
		passwordLabel = new JLabel("Password :");
		passwordLabel.setForeground(Color.blue);
		passwordLabel.setBounds(20, 65, 100, 50);
		passwordLabel.setFont(passwordLabel.getFont().deriveFont(14.0f));
		add(passwordLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(122, 27, 200, 30);
		usernameField.setFont(usernameField.getFont().deriveFont(12.0f));
		add(usernameField);
		
		passwordField = new JTextField();
		passwordField.setBounds(122, 77, 200, 30);
		passwordField.setFont(passwordField.getFont().deriveFont(12.0f));
		add(passwordField);
		
		logInButton = new JButton("LogIn");
		logInButton.setBounds(122,122, 80, 30);
		logInButton.addActionListener(actionListener);
		add(logInButton);
		
		signUpButton = new JButton("SignUp");
		signUpButton.setBounds(220,122, 80, 30);
		signUpButton.addActionListener(actionListener);
		add(signUpButton);
		
		setVisible(true);
			
	}
	
	
	public void setVisibility(boolean choice)
	{
		setVisible(choice);
	}
	
	public String getUsermame()
	{
		return this.usernameField.getText();
	}
	
	public String getPassword()
	{
		return this.passwordField.getText();
	}
	
	public void setPassword(String s)
	{
		this.passwordField.setText(s);
	}
	
	public void setUsername(String s)
	{
		this.usernameField.setText(s);
	}
	
	
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(this, message);
	}
	
	
}
