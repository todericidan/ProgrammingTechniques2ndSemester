package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import interfaces.PersistanceI;

public class SerializerPersistance implements PersistanceI{

	public void saveDictionary(WordDaoImplementation dictionary) {
		try(FileOutputStream fileOut = new FileOutputStream("C:\\Users\\T\\Desktop\\workspace\\Dictionary\\dictionary.ser"))
		{	
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(dictionary);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data has been saved");
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}
		
	}

	public WordDaoImplementation restoreDictionary() 
	{
		WordDaoImplementation dictionary= null;
		try(FileInputStream fileIn = new FileInputStream("C:\\Users\\T\\Desktop\\workspace\\Dictionary\\dictionary.ser"))
		{
			
			ObjectInputStream in = new ObjectInputStream(fileIn);
			dictionary = (WordDaoImplementation) in.readObject();
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

		return dictionary;
	}

}
