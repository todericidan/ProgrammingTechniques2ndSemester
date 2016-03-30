package ro.utcluj.pt.Shop.model;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AllUsersTabelModel extends AbstractTableModel {

	private String[] colNames = {"ID","FirstName","LastName","Address","Email","Username","Password"};
	private LinkedList<Person> persons;
	private LinkedList<User> users;

	public AllUsersTabelModel()
	{

	}

	public void setData(List<Person> peronsList,List<User> usersList){
		this.persons = (LinkedList<Person>) peronsList;
		this.users = (LinkedList<User>) usersList;
	}

	public int getRowCount() {
		return users.size();	
	}

	public int getColumnCount() {
		return 7;
	}
	
	public String getColumnName(int column) {
		return colNames[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Person p = persons.get(rowIndex);
		User u = users.get(rowIndex);
		
		switch(columnIndex)
		{		

		case 0:
			return p.getIdPerson();	
		case 1:
			return p.getFirstName();
		case 2: 
			return p.getLastName();
		case 3:
			return p.getAddress();
		case 4:
			return p.getEmail();
		case 5:
			return u.getUsername();
		case 6:
			return u.getUserPassword();
		}
		return null;
	}

}
