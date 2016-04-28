package model;


import java.util.List;
import model.Account;
import model.Person;

import javax.swing.table.AbstractTableModel;


public class AllAccountsTabelModel extends AbstractTableModel {

	private static final long serialVersionUID = 4125932100886172238L;

	private String[] colNames = {"ID","Name","AccountType","AccountID","SumAvailable"};
	private List<Person> persons;
	private List<Account> accounts;

	public AllAccountsTabelModel() 
	{
		
	}

	public void setData(List<Person> peronsList,List<Account> accountsList){
		this.persons =  peronsList;
		this.accounts = accountsList;
	}
	
	
	@Override
	public int getRowCount() {
		return persons.size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int column) {
		return colNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Person p = persons.get(rowIndex);
		Account a = accounts.get(rowIndex);
		
		switch(columnIndex)
		{		

		case 0:
			return p.getId();	
		case 1:
			return p.getName();
		case 2: 
			if (a instanceof SavingAccounts) 
			{
				return "SavingAccount";
			}
			else
			{
				return "SpendingAccount";
			}
		case 3:
			return a.getAccID();
		case 4:
			return a.getMoney();
		}
		return null;
	}
	

}
