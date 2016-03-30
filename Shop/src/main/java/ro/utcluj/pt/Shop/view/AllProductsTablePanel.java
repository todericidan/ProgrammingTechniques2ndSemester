package ro.utcluj.pt.Shop.view;

import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ro.utcluj.pt.Shop.model.AllProductsTableModel;
import ro.utcluj.pt.Shop.model.Product;

public class AllProductsTablePanel extends JPanel{
	private JTable table;
	private AllProductsTableModel model;

	public AllProductsTablePanel()
	{
		model = new AllProductsTableModel();
		table = new JTable(model);
		setLayout(new BorderLayout());

		add(new JScrollPane(table),BorderLayout.CENTER);

	}

	public void setData(List<Product> data)
	{
		LinkedList<Product> aux = new LinkedList<Product>();
		for(Product p:data)
		{
			if(!p.getProductName().equals("Deleted"))
			{
				aux.add(p);
			}
		}
		model.setData(aux);
	}

	public void refresh() 
	
	{
		model.fireTableDataChanged();
	}
}
