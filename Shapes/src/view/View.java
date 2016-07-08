package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame{
	
	private JPanel canvas;
	private JButton moveUpButton,moveDownButton,moveRightButton,moveLeftButton;
	private JButton triangleButton,rectangleButton,circleButton,drawButton;
	private JLabel movingShapeLabel,newShapeLabel;
	private JComboBox comboBox;
	
	
	public View(ActionListener listener,String[]items)
	{	
		super("Ui");
		setBackground(Color.lightGray);
		setLayout(null);
		setSize (600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		movingShapeLabel = new JLabel("Moving shape: ");
		movingShapeLabel.setBounds(430, 190, 100, 20);
		add(movingShapeLabel);
		
		//canvas setup
		canvas = new JPanel();
		canvas.setBounds(10, 5,400, 450);
		canvas.setForeground(Color.red);
		canvas.setBackground(Color.white);
		add(canvas);
		
		//buttons setup
		moveUpButton = new JButton("UP");
		moveUpButton.setBounds(430,30,110,30);
		moveUpButton.addActionListener(listener);
		add(moveUpButton);
		
		moveDownButton = new JButton("DOWN");
		moveDownButton.setBounds(430,70,110,30);
		moveDownButton.addActionListener(listener);
		add(moveDownButton);
		
		moveLeftButton = new JButton("LEFT");
		moveLeftButton.setBounds(430,110,110,30);
		moveLeftButton.addActionListener(listener);
		add(moveLeftButton);
		
		moveRightButton = new JButton("RIGHT");
		moveRightButton.setBounds(430,150,110,30);
		moveRightButton.addActionListener(listener);
		add(moveRightButton);
		
		triangleButton = new JButton("Triangle");
		triangleButton.setBounds(30, 500, 100, 30);
		triangleButton.addActionListener(listener);
		add(triangleButton);
		
		circleButton = new JButton("Circle");
		circleButton.setBounds(140, 500, 100, 30);
		circleButton.addActionListener(listener);
		add(circleButton);
		
		rectangleButton = new JButton("Rectangle");
		rectangleButton.setBounds(250, 500, 100, 30);
		rectangleButton.addActionListener(listener);
		add(rectangleButton);
		
		drawButton= new JButton("Draw");
		drawButton.setBounds(430, 300, 100, 60);
		drawButton.addActionListener(listener);
		add(drawButton);
		
		
		newShapeLabel = new JLabel("New shape: ");
		newShapeLabel.setBounds(430, 250, 100, 20);
		add(newShapeLabel);
		
		
		
		//c.draw(canvas);
		//canvas.paint(new CircleShape(20, 50, 3, Color.black));
		
		
		//System.out.println("banae");
		
		 comboBox = new JComboBox(items);
		 comboBox.setBounds(400, 500, 100, 30);
		  //itemSelectionBox.addActionListener(actionListener);
		add(comboBox);
		
		ViewComponent v = new  ViewComponent();
		v.paintComponent(canvas);
		
		
		setVisible(true);
	}
	
	
	
	
}
