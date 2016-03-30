package ro.utcluj.pt.Shop.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OrderView extends JFrame{

//	String[] errorSoon = new String[2];
//	errorSoon[0] = "Hello";
//	errorSoon[1] = "World";
//	
	
	private static final long serialVersionUID = 334L;
	String[] items;
	
	private JLabel textLabel,quantityLabel;
	private JComboBox itemSelectionBox;
	private JTextField quantityField;
	private JButton cancelButton,submitButton;
	
	public OrderView(String[] items,ActionListener actionListener)
	{
		super("LogIn View");
		setBackground(Color.lightGray);
		setLayout(null);
		setSize (400,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		textLabel = new JLabel("Pick an item:");
		textLabel.setForeground(Color.blue);
	    textLabel.setBounds(20, 15, 100, 50);
		textLabel.setFont(textLabel.getFont().deriveFont(14.0f));
		add(textLabel);
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(50,80, 80, 30);
		submitButton.addActionListener(actionListener);
		add(submitButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(220,80,80, 30);
		cancelButton.addActionListener(actionListener);
		add(cancelButton);
		
		
		itemSelectionBox = new JComboBox(items);
		itemSelectionBox.setBounds(115, 28, 100, 30);
		//itemSelectionBox.addActionListener(actionListener);
		add(itemSelectionBox);
		
		quantityLabel = new JLabel("quantity:");
		quantityLabel.setForeground(Color.blue);
		quantityLabel.setBounds(220, 28, 80, 30);
		quantityLabel.setFont(textLabel.getFont().deriveFont(14.0f));
		add(quantityLabel);
		
		quantityField = new JTextField("");
		quantityField.setBounds(280, 28, 50, 30);
		add(quantityField);
		
		setVisible(true);
		
	}
	
	public void setVisibility(boolean choice)
	{
		setVisible(choice);
	}
	
	
	public String getQuantity()
	{
		return quantityField.getText();
	}
	
	public JComboBox getSelectionBox()
	{
		return itemSelectionBox;
	}
	
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(this, message);
	}
	
	
	
}
