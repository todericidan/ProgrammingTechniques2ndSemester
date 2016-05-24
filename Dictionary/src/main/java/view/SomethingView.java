package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SomethingView extends JFrame{
	
	private JTextArea instructionsTextArea;
	

	public SomethingView(String name,String viewed)
	{
		super(name);
		setLocationRelativeTo(null);

		setBackground(Color.lightGray);
		setLayout(null);
		setSize (400,400);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 40, 394, 191);
		add(scrollPane);
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText(viewed);
		scrollPane.setViewportView(textArea_1);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
//		instructionsTextArea = new JTextArea(12,40);
//		instructionsTextArea.setText(viewed);
//
//		instructionsTextArea.setBounds(20,120,350,200);
//		instructionsTextArea.setFont(new Font("Courier New", Font.ITALIC, 12));
//		add(instructionsTextArea);
	}

}
