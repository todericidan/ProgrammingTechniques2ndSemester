package ro.utcluj.pt.Shop.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AdminMainView extends JFrame{

	private JLabel textLabel;
	private JButton signOutButton,seeProductsButton,seeUsersButton,deleteProductButton,editProductButton,addProductButton;

	public AdminMainView(ActionListener actionListener)
	{
		super("Main View");
		setBackground(Color.lightGray);
		setLayout(null);
		setSize (400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textLabel = new JLabel("Welcome,Admin!");
		textLabel.setForeground(Color.black);
		textLabel.setBounds(20, 15, 200, 50);
		textLabel.setFont(textLabel.getFont().deriveFont(14.0f));
		add(textLabel);

		signOutButton = new JButton("SignOut");
		signOutButton.setBounds(20,60,80,30);
		signOutButton.addActionListener(actionListener);
		add(signOutButton);


		editProductButton = new JButton("EditProduct");
		editProductButton.setBounds(110,60,120,30);
		editProductButton.addActionListener(actionListener);
		add(editProductButton);

		seeUsersButton = new JButton("Users");
		seeUsersButton.setBounds(20,95,80,30);
		seeUsersButton.addActionListener(actionListener);
		add(seeUsersButton);

		seeProductsButton = new JButton("ViewProducts");
		seeProductsButton.setBounds(110,95,120,30);
		seeProductsButton.addActionListener(actionListener);
		add(seeProductsButton);

		deleteProductButton = new JButton("DeleteProduct");
		deleteProductButton.setBounds(50,130,120,30);
		deleteProductButton.addActionListener(actionListener);
		add(deleteProductButton);

		addProductButton = new JButton("AddProduct");
		addProductButton.setBounds(50,165,120,30);
		addProductButton.addActionListener(actionListener);
		add(addProductButton);

		setVisible(true);
	}

	public void setVisibility(boolean b) {
		setVisible(b);

	}
	

	
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(this, message);
	}
	
}
