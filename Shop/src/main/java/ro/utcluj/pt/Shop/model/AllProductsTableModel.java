package ro.utcluj.pt.Shop.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AllProductsTableModel extends AbstractTableModel {

	private String[] colNames = {"ID","Name","Price"};
	private List<Product> products;

	public AllProductsTableModel()
	{

	}

	public void setData(List<Product> listOfProducts){
		this.products= listOfProducts;
	}

	public int getRowCount() {
		return products.size();

	}

	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int column) {
		return colNames[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) 
	{	
		Product prod = products.get(rowIndex);

		switch(columnIndex)
		{		

		case 0:
			return prod.getIdProduct();	
		case 1:
			return prod.getProductName();
		case 2: 
			return prod.getPrice();
		}

		return null;
	}


}
