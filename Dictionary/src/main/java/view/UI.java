package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UI extends JFrame {

	private static final long serialVersionUID = 9015677189884874104L;
	private JButton seeAllWordsButton,searchWordButton,addWordButton,deleteWordButton,deleteDefButton;


	public UI(ActionListener listener)
	{
		super("UI");
		setBackground(Color.lightGray);
		setLayout(null);
		setSize (400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		seeAllWordsButton = new JButton("SeeWords");
		seeAllWordsButton.setBounds(20,30,110,30);
		seeAllWordsButton.addActionListener(listener);
		add(seeAllWordsButton);

		searchWordButton= new JButton("SearchWord");//
		searchWordButton.setBounds(143,30,110,30);
		searchWordButton.addActionListener(listener);
		add(searchWordButton);
		
		addWordButton= new JButton("AddDef");//
		addWordButton.setBounds(20, 63, 110, 30);
		addWordButton.addActionListener(listener);
		add(addWordButton);
		
		deleteWordButton = new JButton("DeleteWord");//
		deleteWordButton.setBounds(143, 63, 110, 30);
		deleteWordButton.addActionListener(listener);
		add(deleteWordButton);
		
		deleteDefButton= new JButton("DeleteDef");//
		deleteDefButton.setBounds(20, 96, 110, 30);
		deleteDefButton.addActionListener(listener);
		add(deleteDefButton);
		
		
		setVisible(true);
	}


	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(this, message);
	}



	
}
