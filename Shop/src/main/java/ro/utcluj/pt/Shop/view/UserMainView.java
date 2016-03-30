package ro.utcluj.pt.Shop.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserMainView extends JFrame {

	private static final long serialVersionUID = 2L;
	
	private JLabel textLabel;
	private JButton signOutButton,viewDetailsButton,seeProductsButton,deleteAccountButton,orderButton,seeOrdersButtons;
	
	public UserMainView(ActionListener actionListener,String userName)
	{
		super("Main View");
		setBackground(Color.lightGray);
		setLayout(null);
		setSize (400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		textLabel = new JLabel("Welcome,"+userName+"!");
		textLabel.setForeground(Color.black);
		textLabel.setBounds(20, 15, 200, 50);
		textLabel.setFont(textLabel.getFont().deriveFont(14.0f));
		add(textLabel);
		
		signOutButton = new JButton("SignOut");
		signOutButton.setActionCommand("user");
	    signOutButton.setBounds(20,60,80,30);
		signOutButton.addActionListener(actionListener);
		add(signOutButton);
		
		deleteAccountButton = new JButton("DeleteAccount");
		deleteAccountButton.setActionCommand("user");
		deleteAccountButton.setBounds(110,60,120,30);
		deleteAccountButton.addActionListener(actionListener);
		add(deleteAccountButton);
		
		orderButton = new JButton("Order");
		orderButton.setActionCommand("user");
		orderButton.setBounds(20,95,80,30);
		orderButton.addActionListener(actionListener);
		add(orderButton);
		
		viewDetailsButton = new JButton("AccountDetails");
		viewDetailsButton.setActionCommand("user");
		viewDetailsButton.setBounds(110,95,120,30);
		viewDetailsButton.addActionListener(actionListener);
		add(viewDetailsButton);
		
		seeProductsButton = new JButton("ListProducts");
		seeProductsButton.setActionCommand("user");
		seeProductsButton.setBounds(50,130,120,30);
		seeProductsButton.addActionListener(actionListener);
		add(seeProductsButton);
		
	    seeOrdersButtons = new JButton("ListOrders");
	    seeOrdersButtons.setActionCommand("user");
		seeOrdersButtons.setBounds(50,165,120,30);
		seeOrdersButtons.addActionListener(actionListener);
		add(seeOrdersButtons);
		
		setVisible(true);

		
	}
	public void setTextFiled(String text)
	{
		this.textLabel.setText(text);
	}
	
	public void setVisibility(boolean choice)
	{
		setVisible(choice);
	}

	
}
