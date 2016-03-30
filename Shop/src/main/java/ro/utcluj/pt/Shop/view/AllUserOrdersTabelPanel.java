package ro.utcluj.pt.Shop.view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import ro.utcluj.pt.Shop.model.AllUserOrdersTableModels;
import ro.utcluj.pt.Shop.model.Order;




public class AllUserOrdersTabelPanel extends JPanel {
	
	private JTable table;
	private AllUserOrdersTableModels model;
	
	
	public AllUserOrdersTabelPanel()
	{
		model = new AllUserOrdersTableModels();
		table = new JTable(model);
		setLayout(new BorderLayout());

		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	public void setData(List<Order> data)
	{
		model.setData(data);
	}

	public void refresh() 
	
	{
		model.fireTableDataChanged();
	}

	

}
