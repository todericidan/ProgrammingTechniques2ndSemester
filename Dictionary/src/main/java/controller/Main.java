package controller;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonFactory;

import interfaces.PersistanceI;
import model.Description;
import model.JsonPersistance;
import model.SerializerPersistance;
import model.Word;
import model.WordDaoImplementation;
import view.SomethingView;

public class Main {

	public static void main(String[] args) {
		//new SomethingView("sadasdaa");
		new AppController();
		
		
		WordDaoImplementation dict = new WordDaoImplementation();
		dict.addDescriptionforWord(new Word("masina", 99.99f, 1), new Description(1,"automobil", 90.0f));
		dict.addDescriptionforWord(new Word("masina", 99.99f, 1), new Description(2,"autovehicul", 100.0f));
		
		dict.addDescriptionforWord(new Word("aaa", 99.99f, 1),new Description(1,"123",22f));
		
		System.out.println(dict);
		
		PersistanceI per = new JsonPersistance();
		per.saveDictionary(dict);
		
		dict= per.restoreDictionary();
		System.out.println(dict);
		
		/*
		List<Word> words = dict.getWordThatMatchPattern("a");
		
		for(Word w :words)
		{
			System.out.println(w.getName());
		}
		
		dict.removeDescription(1,new Word("aq",99.99f,1));
		dict.removeDescription(1, new Word("masina", 99.99f, 1));
		dict.removeDescription(2, new Word("masina", 99.99f, 1));
		System.out.println(dict);
		
	
		
		System.out.println("adding");
		dict.addDescriptionforWord(new Word("aq",99.99f,1), new Description(1,"dsas",22f));
		dict.addDescriptionforWord( new Word("masina", 99.99f, 1), new Description(1,"vehicul cu patru roti",70.0f));
	
		System.out.println(dict);
		
		*/
		
		
		
		/*
		
		
		Set<AbstractDefinition> desc = dict.getDescriptionsforWord(new Word("pula", 99.99f, 1));
		
		for(AbstractDefinition d: desc)
		{
			System.out.println(d);
		}
		
		
		
		
		//System.out.println("sugem pula");
		PersistanceI per = new SerializerPersistance();
		per.saveDictionary(dict);
		
		
		
		File f = new File("C:\\Users\\T\\Desktop\\workspace\\Dictionary\\dictionary.txt");
		if(f.exists())
		{
		    System.out.println("success");
		    System.out.println();
			System.out.println("Restored dicktionary");
			WordDaoImplementation dictionary1 = per.restoreDictionary();
			System.out.println(dictionary1);
		}
		else
		{
		    System.out.println("fail");
		    //per.saveDictionary(dict);
		    
		}
		*/
		
		
		/*
		File f = new File("C:\\Users\\T\\Desktop\\workspace\\Dictionary\\dictionary.ser");
		if(f.exists())
		{
		    System.out.println("success");
		    System.out.println();
			System.out.println("Restored bank");
			WordDaoImplementation dictionary1 = per.restoreDictionary();
			System.out.println(dictionary1);
		}
		else
		{
		    System.out.println("fail");
		    //per.saveDictionary(dict);
		    
		}*/
		//String line = "pizdabu";
		//String pattern = "(pizdab)(.?)";
		
		
		//System.out.println(line.matches(pattern));
		
		
	}

}
