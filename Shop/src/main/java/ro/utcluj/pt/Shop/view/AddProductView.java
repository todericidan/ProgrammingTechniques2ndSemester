package ro.utcluj.pt.Shop.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddProductView extends JFrame{
	
	private JLabel nameLabel,priceLabel,quantityLabel;
	private JTextField nameField,priceField,quantityField;
	private JButton doneButton;
	
	public AddProductView(ActionListener actionListener)
	{
		
		super("Add Product");
		setBackground(Color.lightGray);
		setLayout(null);
		setSize (400,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		nameLabel = new JLabel("ProductName:");
		nameLabel.setForeground(Color.blue);
		nameLabel.setBounds(20, 15, 100, 50);
		nameLabel.setFont(nameLabel.getFont().deriveFont(14.0f));
		add(nameLabel);

		priceLabel = new JLabel("Price :");
		priceLabel.setForeground(Color.blue);
		priceLabel.setBounds(20, 65, 100, 50);
		priceLabel.setFont(priceLabel.getFont().deriveFont(14.0f));
		add(priceLabel);

		quantityLabel = new JLabel("Quantity :");
		quantityLabel.setForeground(Color.blue);
		quantityLabel.setBounds(20, 115, 100, 50);
		quantityLabel.setFont(quantityLabel.getFont().deriveFont(14.0f));
		add(quantityLabel);

		//TextFields

		nameField = new JTextField();
		nameField.setText("");
		nameField.setBounds(122, 27, 200, 30);
		nameField.setFont(nameField.getFont().deriveFont(12.0f));
		add(nameField);

		priceField = new JTextField();
		priceField.setText("");
		priceField.setBounds(122, 77, 200, 30);
		priceField.setFont(priceField.getFont().deriveFont(12.0f));
		add(priceField);

		quantityField = new JTextField();
		quantityField.setText("");
		quantityField.setBounds(122, 127, 200, 30);
		quantityField.setFont(quantityField.getFont().deriveFont(12.0f));
		add(quantityField);


		doneButton = new JButton("Done");
		doneButton.setActionCommand("details");
		doneButton.setBounds(122,160, 110, 30);
		doneButton.addActionListener(actionListener);
		add(doneButton);
		
		setVisible(true);
		
	}
	
	public String getProductName()
	{

		return nameField.getText();
	}

	public float getPrice()
	{
		if(!priceField.getText().equals(""))
		{
			return Float.parseFloat(priceField.getText());
		}
		else
		{
			return 0f;
		}
	}

	public int getQuantity()
	{
		if(!quantityField.getText().equals(""))
		{
			return Integer.parseInt(quantityField.getText());
		}
		else
		{
			return 0;
		}
	}
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(this, message);
	}


	public void setVisibility(boolean choice)
	{
		setVisible(choice);
	}

}
