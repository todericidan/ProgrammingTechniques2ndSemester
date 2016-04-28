package view;

import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.AllPersonsTableModel;
import model.Person;


public class AllPersonsTablePanel extends JPanel {

	private JTable table;
	private AllPersonsTableModel model;

	public AllPersonsTablePanel()
	{
		model = new AllPersonsTableModel();
		table = new JTable(model);
		setLayout(new BorderLayout());

		add(new JScrollPane(table),BorderLayout.CENTER);

	}

	public void setData(List<Person> data)
	{
		LinkedList<Person> aux = new LinkedList<Person>();
		for(Person p:data)
		{
			aux.add(p);
		}
		model.setData(aux);
	}

	public void refresh() 	
	{
		model.fireTableDataChanged();
	}
}
