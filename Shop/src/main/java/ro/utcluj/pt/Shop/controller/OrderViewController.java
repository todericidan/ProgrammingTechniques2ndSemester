package ro.utcluj.pt.Shop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JButton;

import ro.utcluj.pt.Shop.functionality.BillMaker;
import ro.utcluj.pt.Shop.model.Order;
import ro.utcluj.pt.Shop.model.Person;
import ro.utcluj.pt.Shop.model.Product;
import ro.utcluj.pt.Shop.model.ProductStorage;
import ro.utcluj.pt.Shop.persistence.OrderPersistence;
import ro.utcluj.pt.Shop.persistence.PersonPersistence;
import ro.utcluj.pt.Shop.persistence.ProductPersistence;
import ro.utcluj.pt.Shop.persistence.ProductStoragePersistence;
import ro.utcluj.pt.Shop.view.OrderView;

public class OrderViewController implements ActionListener{

	private OrderView userInterface;
	private ProductPersistence prodPer;
	private ProductStoragePersistence storagePer;
	private LinkedList<ProductStorage> storageList;
	private LinkedList<Product> itemsList ;
	private int idPerson;


	public OrderViewController(int idPerson)
	{
		this.idPerson =idPerson;
		prodPer = new ProductPersistence();

		try {
			itemsList = (LinkedList<Product>) prodPer.getAll();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		storagePer =new ProductStoragePersistence();

		try {
			storageList = (LinkedList<ProductStorage>) storagePer.getAll();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		int size=0;
		for(Product product:itemsList)
		{
			if(!product.getProductName().equals("Deleted"))
			{
				size++;
			}
		}
		String[] items= new String[size];
		int poz=0;
		for(Product product:itemsList)
		{
			if(!product.getProductName().equals("Deleted"))
			{
				items[poz]=product.getIdProduct()+"."+product.getProductName();
				System.out.println(items[poz]);
				poz++;
			}
		}

		userInterface = new OrderView(items, this);

	}

	public void actionPerformed(ActionEvent e) 
	{
		JButton buttonSource = (JButton) e.getSource();
		if(buttonSource.getText().equals("Cancel"))
		{
			setVisibilityOfView(false);
		}

		if(buttonSource.getText().equals("Submit")&&(!userInterface.getQuantity().equals("")))
		{
			String result = (String)userInterface.getSelectionBox().getSelectedItem();
			result.replace(" ","");
			//System.out.println("Selected:"+result);

			String[] parts = result.split("\\.");
			System.out.println(parts[0]+"-"+parts[1]);

			int id = Integer.parseInt(parts[0]);
			int quantity = Integer.parseInt(userInterface.getQuantity());



			for(ProductStorage p :storageList)
			{
				if(p.getIdProduct()==id)
				{
					if(p.getQuantity()<quantity)
					{
						userInterface.displayMessage("UnderStock");
					}
					else
					{

						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date d = new Date();

						Order order = new Order(idPerson, id, quantity,dateFormat.format(d), "2016-04-06 12:00:00");

						OrderPersistence orderP =new OrderPersistence();

						try {
							orderP.insert(order);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						LinkedList<Order> orders=null;

						try {
							orders = (LinkedList<Order>) orderP.getAll();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}


						System.out.println("Orders after insert:");
						for(Order o:orders)
						{
							System.out.println("IdPerson:"+o.getIdPerson()+" IdProduct:"+o.getIdProduct()
							+" quantiy:"+o.getQuantity()+" SubDate:"+o.getSubmissionDate()+" Delivery"+o.getDeliveryDate());
						}



						ProductStorage storage = new ProductStorage(id,p.getQuantity()-quantity);

						try {
							storagePer.update(storage);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}


						try {
							storageList=(LinkedList<ProductStorage>) storagePer.getAll();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						System.out.println("Storage after update:");
						for(ProductStorage s:storageList)
						{
							System.out.println(s.getIdProduct() +" - "+s.getQuantity());
						}

						String prodName = null;
						float price =0.0f;
						String first =null;
						String last =null;


						for(Product product:itemsList)
						{
							if(product.getIdProduct()==id)
							{
								prodName  = product.getProductName();
								price = product.getPrice();
							}
						}

						PersonPersistence personPer = new PersonPersistence();


						LinkedList<Person> persons=null;
						try {
							persons = (LinkedList<Person>) personPer.getAll();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						for(Person person:persons)
						{
							if(person.getIdPerson()==order.getIdPerson())
							{
								first = person.getFirstName();
								last = person.getLastName();
							}
						}

						price =  price *order.getQuantity();


						BillMaker billConverter = new BillMaker(idPerson,prodName, first, last, order.getSubmissionDate(), order.getDeliveryDate(), price,order.getQuantity());
						billConverter.makeBill();

					}
				}
			}
		}
		else
		{
			userInterface.displayMessage("insert a quantity!");
		}


	}

	public void setVisibilityOfView(boolean choice)
	{
		userInterface.setVisibility(choice);
	}




}
