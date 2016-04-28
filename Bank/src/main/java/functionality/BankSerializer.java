package functionality;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Bank;

public class BankSerializer {

	public void serialiazeBank(Bank bank)
	{
		try(FileOutputStream fileOut = new FileOutputStream("C:\\Users\\T\\Desktop\\workspace\\Bank\\bank.ser"))
		{	
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(bank);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data has been saved");
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}

	}

	public Bank restoreBank()
	{
		Bank bank = null;
		try(FileInputStream fileIn = new FileInputStream("C:\\Users\\T\\Desktop\\workspace\\Bank\\bank.ser"))
		{
			
			ObjectInputStream in = new ObjectInputStream(fileIn);
			bank= (Bank) in.readObject();
			in.close();
			fileIn.close();
			
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}
		catch(ClassNotFoundException c)
		{
			System.out.println("Bank class not found");
			c.printStackTrace();
		}

		return bank;
	}
}
