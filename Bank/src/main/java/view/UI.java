package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controllers.UIController;

public class UI extends JFrame {

	private static final long serialVersionUID = 9015677189884874104L;
	private JButton seeAccountsForPersonButton,seePersonsButton,depositMoneyButton,withdrawMoneyButton,deleteAccountButton,deletePersonButton,addAccountForPersonButton,addProductButton;


	public UI(ActionListener listener)
	{
		super("UI");
		setBackground(Color.lightGray);
		setLayout(null);
		setSize (400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		seeAccountsForPersonButton = new JButton("SeeAccounts");
		seeAccountsForPersonButton.setBounds(20,30,110,30);
		seeAccountsForPersonButton.addActionListener(listener);
		add(seeAccountsForPersonButton);

		seePersonsButton = new JButton("SeePersons");//
		seePersonsButton.setBounds(143,30,110,30);
		seePersonsButton.addActionListener(listener);
		add(seePersonsButton);
		
		depositMoneyButton = new JButton("Deposit");//
		depositMoneyButton.setBounds(20, 63, 110, 30);
		depositMoneyButton.addActionListener(listener);
		add(depositMoneyButton);
		
		withdrawMoneyButton = new JButton("Withdraw");//
		withdrawMoneyButton.setBounds(143, 63, 110, 30);
		withdrawMoneyButton.addActionListener(listener);
		add(withdrawMoneyButton);
		
		deleteAccountButton= new JButton("DeleteAcct");//
		deleteAccountButton.setBounds(20, 96, 110, 30);
		deleteAccountButton.addActionListener(listener);
		add(deleteAccountButton);
		
		deletePersonButton = new JButton("DelPerson");//
		deletePersonButton.setBounds(143, 96, 110, 30);
		deletePersonButton.addActionListener(listener);
		add(deletePersonButton);
		
		addAccountForPersonButton = new JButton("ADD");//
		addAccountForPersonButton.setBounds(20, 129, 110, 30);
		addAccountForPersonButton.addActionListener(listener);
		add(addAccountForPersonButton);
		
		setVisible(true);
	}


	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(this, message);
	}



	
}
