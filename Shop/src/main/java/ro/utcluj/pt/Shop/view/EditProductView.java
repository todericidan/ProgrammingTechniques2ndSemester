package ro.utcluj.pt.Shop.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ro.utcluj.pt.Shop.model.Product;

public class EditProductView extends JFrame {


	private JLabel nameLabel,priceLabel,quantityLabel;
	private JTextField nameField,priceField,quantityField;
	private JButton doneButton,editButton;

	public EditProductView(ActionListener actionListener,Product product,int quantity)
	{
		super("Product Details");
		setBackground(Color.lightGray);
		setLayout(null);
		setSize (400,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		initFields(product,quantity,actionListener);

		setVisible(true);
	}

	private void initFields(Product product, int quantity, ActionListener actionListener) {

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
		nameField.setText(product.getProductName());
		nameField.setBounds(122, 27, 200, 30);
		nameField.setFont(nameField.getFont().deriveFont(12.0f));
		add(nameField);

		priceField = new JTextField();
		priceField.setText(""+product.getPrice());
		priceField.setBounds(122, 77, 200, 30);
		priceField.setFont(priceField.getFont().deriveFont(12.0f));
		add(priceField);

		quantityField = new JTextField();
		quantityField.setText(""+quantity);
		quantityField.setBounds(122, 127, 200, 30);
		quantityField.setFont(quantityField.getFont().deriveFont(12.0f));
		add(quantityField);


		setEditableForAllTextField(false);

		doneButton = new JButton("Done");
		doneButton.setActionCommand("details");
		doneButton.setBounds(122,160, 110, 30);
		doneButton.addActionListener(actionListener);
		add(doneButton);

		editButton = new JButton("Edit");
		editButton.setActionCommand("details");
		editButton.setBounds(240,160,80,30);
		editButton.addActionListener(actionListener);
		add(editButton);


	}

	public void setEditableForAllTextField(boolean b) {
		nameField.setEditable(b);
		priceField.setEditable(b);
		quantityField.setEditable(b);
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

}
