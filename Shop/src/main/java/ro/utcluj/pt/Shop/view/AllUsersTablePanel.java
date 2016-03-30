package ro.utcluj.pt.Shop.view;

import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ro.utcluj.pt.Shop.model.AllUsersTabelModel;
import ro.utcluj.pt.Shop.model.Person;
import ro.utcluj.pt.Shop.model.Product;
import ro.utcluj.pt.Shop.model.User;

public class AllUsersTablePanel extends JPanel{

	private JTable table;
	private AllUsersTabelModel model;

	public AllUsersTablePanel()
	{
		model = new AllUsersTabelModel();
		table = new JTable(model);
		setLayout(new BorderLayout());

		add(new JScrollPane(table),BorderLayout.CENTER);
	}

	public void setData(List<Person> data1,List<User> data2)
	{
		LinkedList<Person> aux1= new LinkedList<Person>();
		LinkedList<User> aux2 = new LinkedList<User>();
		for(Person p:data1)
		{
			int flag =0;
			User user = null;
			for(User u:data2)
			{
				if(u.getIdPerson()==p.getIdPerson())
				{
					user=u;
					flag=1;
					break;
				}
			}
			if(flag==1)
			{
			   aux1.add(p);
			   aux2.add(user);
			}
		}
		model.setData(aux1,aux2);
	}

	public void refresh() 

	{
		model.fireTableDataChanged();
	}

}
