package ro.utcluj.pt.Shop.functionality;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class BillMaker {

	private int quantity;
	private int idPerson;
	private float price;
	private String productName,personFirstName,personLastName,submissionDate,deliveryDate;
	private String filePathString;


	public BillMaker(int id,String prod,String first,String last,String sdate,String ddate,float price,int quant)
	{
		this.idPerson = id;
		this.quantity = quant;
		this.price = price;
		this.personFirstName = first;
		this.personLastName = last;
		this.productName = prod;
		this.submissionDate =  sdate;
		this.deliveryDate = ddate;
		
		filePathString = personFirstName+personLastName+idPerson+".txt";

		

	}
	
	public void makeBill()
	{
		File f = new File(filePathString);
		if(f.exists() && !f.isDirectory()) 
		{ 
			writeInFile();
		}
		else
		{
			writeInFile();
		}
	}
	
	private void writeInFile()
	{
		FileWriter writer =null;
		try {
			writer = new FileWriter(filePathString,true);
			writer.write("User "+personFirstName+" "+
					personLastName+" has bought "+quantity+" of "+productName +" spending "
					+this.price +" in date"+submissionDate+". The goods will be delivered on "+deliveryDate +"!");
			//appends the string to the file
			
			BufferedWriter b = new BufferedWriter(writer);
			b.newLine();
			b.close();
			
			writer.close();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
	


}
