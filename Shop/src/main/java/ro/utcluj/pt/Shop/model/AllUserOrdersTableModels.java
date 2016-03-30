package ro.utcluj.pt.Shop.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AllUserOrdersTableModels extends AbstractTableModel{

	private String[] colNames = {"ProductID","Quantity","SubmissionDate","DeliveryDate"};
	private List<Order> orders;

	public AllUserOrdersTableModels()
	{

	}
	
	
	public void setData(List<Order> listOfOrders){
		this.orders= listOfOrders;
	}

	public int getRowCount() {
		return orders.size();

	}

	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int column) {
		return colNames[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) 
	{	
		Order order = orders.get(rowIndex);

		switch(columnIndex)
		{		

		case 0:
			return order.getIdProduct();	
		case 1:
			return order.getQuantity();
		case 2: 
			return order.getSubmissionDate();
		case 3:
			return order.getDeliveryDate();
		}

		return null;
	}
}
