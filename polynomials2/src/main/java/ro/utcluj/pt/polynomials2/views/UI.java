package ro.utcluj.pt.polynomials2.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class UI extends JFrame{
	
	private JLabel pol1Label,pol2Label,resultLabel,options;
	private JTextField pol1Field,pol2Field,resultField;
	private JButton submitPol1,submitPol2,addition,subtract,multiply,divide,derive,integrate;
	
	
	public UI(ActionListener actionListener) 
	{
		super("Polynomials Operations");
		
		setLocationRelativeTo(null);

		setBackground(Color.lightGray);
		setLayout(null);
		setSize (500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pol1Label = new JLabel("Polinomial #1:");
		pol1Label.setForeground(Color.blue);
		pol1Label.setBounds(20, 15, 100, 50);
		pol1Label.setFont(pol1Label.getFont().deriveFont(14.0f));
		add(pol1Label);
		
		pol2Label = new JLabel("Polinomial #2:");
		pol2Label.setForeground(Color.blue);
		pol2Label.setBounds(20, 65, 100, 50);
		pol2Label.setFont(pol1Label.getFont().deriveFont(14.0f));
		add(pol2Label);
		
		resultLabel = new JLabel("Result:");
		resultLabel.setForeground(Color.BLACK);
		resultLabel.setBounds(40, 115, 100, 50);
		resultLabel.setFont(resultLabel.getFont().deriveFont(14.0f));
		add(resultLabel);
		
		pol1Field = new JTextField();
		pol1Field.setBounds(122, 25, 200, 30);
		pol1Field.setFont(pol1Field.getFont().deriveFont(12.0f));
		add(pol1Field);
		
		pol2Field = new JTextField();
		pol2Field.setBounds(122, 75, 200, 30);
		pol2Field.setFont(pol2Field.getFont().deriveFont(12.0f));
		add(pol2Field);
		
		resultField = new JTextField();
		resultField.setBounds(122,125, 200, 30);
		resultField.setFont(resultField.getFont().deriveFont(12.0f));
		resultField.setText("Unknown");
		resultField.setEditable(false);
		add(resultField);
		
		options = new JLabel("Options:");
		options.setBounds(122,155, 200, 30);
		options.setForeground(Color.red);
		options.setFont(new Font("Special", 2, 14));
		add(options);
		
		submitPol1 = new JButton("Submit");
		submitPol1.setActionCommand("Pol1");
		submitPol1.setBounds(322,25, 80, 29);
		submitPol1.addActionListener(actionListener);
		add(submitPol1);
		
		submitPol2 = new JButton("Submit");
		submitPol2.setActionCommand("Pol2");
		submitPol2.setBounds(322,76, 80, 29);
		submitPol2.addActionListener(actionListener);
		add(submitPol2);
		
		addition = new JButton("ADD");
		addition.setBounds(120,190, 80, 30);
		addition.addActionListener(actionListener);
		add(addition);
		
		subtract = new JButton("SUBTRACT");
		subtract.setBounds(205,190, 120, 30);
		subtract.addActionListener(actionListener);
		add(subtract);
		
		
		derive = new JButton("DERIVE");
		derive.setBounds(120,230, 80, 30);
		derive.addActionListener(actionListener);
		add(derive);
		
		integrate = new JButton("INTEGRATE");
		integrate.setBounds(205,230, 120, 30);
		integrate.addActionListener(actionListener);
		add(integrate);
		
		divide = new JButton("DIVIDE");
		divide.setBounds(120,270, 80, 30);
		divide.addActionListener(actionListener);
		add(divide);
		
		multiply = new JButton("MULTIPLY");
		multiply.setBounds(205,270, 120, 30);
		multiply.addActionListener(actionListener);
		add(multiply);
		
		
		setVisible(true);
	}


	public String getPol1() {
		return pol1Field.getText();
	}


	public void setPol1Field(String pol1) {
		this.pol1Field.setText(pol1);;
	}


	public String getPol2() {
		return pol2Field.getText();
	}


	public void setPol2Field(String pol2) {
		this.pol2Field.setText(pol2);
	}


	public String getResult() {
		return resultField.getText();
	}


	public void setResultField(String result) {
		this.resultField.setText(result);
	}


	public String getSubmitPol1ButtonText() {
		return submitPol1.getText();
	}


	public void setSubmitPol1ButtonText(String buttonText) {
		this.submitPol1.setText(buttonText);
	}


	public String getSubmitPol2ButtonText() 
	{
		return submitPol2.getText();
	}


	public void setSubmitPol2ButtonText(String buttonText)
	{
		this.submitPol2.setText(buttonText);
	}
	
	public void setPol1FieldEditability(boolean editable)
	{
		pol1Field.setEditable(editable);
	}
	
	public void setPol2FieldEditability(boolean editable)
	{
		pol2Field.setEditable(editable);
	}

	

}
