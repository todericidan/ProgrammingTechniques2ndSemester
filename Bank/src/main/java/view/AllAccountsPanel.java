package view;

import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Account;
import model.AllAccountsTabelModel;
import model.Person;


public class AllAccountsPanel extends JPanel{
	private static final long serialVersionUID = -5576907502890196961L;
	
	private JTable table;
	private AllAccountsTabelModel model;

	public AllAccountsPanel()
	{
		model = new AllAccountsTabelModel();
		table = new JTable(model);
		setLayout(new BorderLayout());

		add(new JScrollPane(table),BorderLayout.CENTER);
	}

	public void setData(List<Person> data1,List<Account> data2)
	{
		model.setData(data1,data2);
	}

	public void refresh() 

	{
		model.fireTableDataChanged();
	}

}
