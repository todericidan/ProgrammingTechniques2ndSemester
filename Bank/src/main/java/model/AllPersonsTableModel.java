package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;




public class AllPersonsTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 4823549065776843577L;
	
	private String[] colNames = {"ID","Name"};
	private List<Person> persons;
	
	public AllPersonsTableModel()
	{
		
	}

	public void setData(List<Person> listOfPersons){
		this.persons= listOfPersons;
	}

	@Override
	public int getRowCount() {
		return persons.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}
	
	public String getColumnName(int column) {
		return colNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		Person p = persons.get(rowIndex);
		switch(columnIndex)
		{		

		case 0:
			return p.getId();
		case 1:
			return p.getName();
		}
		return null;
	}

}
