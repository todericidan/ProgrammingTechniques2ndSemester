package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.PersistanceI;
import model.AbstractDefinition;
import model.Description;
import model.JsonPersistance;
import model.SerializerPersistance;
import model.Word;
import model.WordDaoImplementation;
import view.SomethingView;
import view.UI;

public class AppController implements ActionListener{
	
	private UI ui;
	private WordDaoImplementation dictionary;
	private PersistanceI per;

	
	public AppController()
	{
		ui = new UI(this);
		while(!initPersistance())
		{}
		
		File f = new File("C:\\Users\\T\\Desktop\\workspace\\Dictionary\\dictionary.ser");
		if(f.exists())
		{
		    System.out.println("success");
		    System.out.println();
			System.out.println("Restored dicktionary");
			dictionary = per.restoreDictionary();
			System.out.println(dictionary);
		}
		else
		{
		    System.out.println("fail");
		    //per.saveDictionary(dict);
		    
		}
			
			
	}

	private boolean initPersistance()
	{
		String persitanceChoice= JOptionPane.showInputDialog(null, "Insert Persistance Mode:(Json or Ser)", JOptionPane.OK_CANCEL_OPTION);
		if(persitanceChoice.equals("Json"))
		{
			per = new JsonPersistance();
			return true;
		}
		
		if(persitanceChoice.equals("Ser"))
		{
			per = new SerializerPersistance();
			return true;
		}
		return false;
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton buttonSource = (JButton) e.getSource();
		
		
		
		if(buttonSource.getText().equals("SeeWords"))
		{
			StringBuilder text=new StringBuilder("");
			
			for (Entry<Word, Set<AbstractDefinition>> entry:dictionary.getRecord().entrySet())
			{
				text.append(entry.getKey().getName());
				
				Iterator<AbstractDefinition> iterator = dictionary.getRecord().get(entry.getKey()).iterator();
				while (iterator.hasNext()) 
				{
					text.append(" = "+iterator.next().getDescription()+" \n");
					
				}

			}
			
			new SomethingView("All Words",text.toString());
			return ;
		}
		if(buttonSource.getText().equals("AddDef"))
		{
			String wordName= JOptionPane.showInputDialog(null, "Word:", JOptionPane.OK_CANCEL_OPTION);
			
			if(wordName.equals(""))
			{
				ui.displayMessage("Null name!");
				return;
			}
			
			String definition= JOptionPane.showInputDialog(null, "Definition:", JOptionPane.OK_CANCEL_OPTION);
			
			if(definition.equals(""))
			{
				ui.displayMessage("Null definition!");
				return;
			}
			addWord(wordName,definition);
			changesCheck();
			return;
			
		}
		
		if(buttonSource.getText().equals("DeleteWord"))
		{
			String word= JOptionPane.showInputDialog(null, "Insert Word", JOptionPane.OK_CANCEL_OPTION);
			//System.out.println(person);

			if(word.equals(""))
			{
				ui.displayMessage("Null name!");
				return;
			}
			
			deleteWord(word);
			changesCheck();
			return;
		}
		if(buttonSource.getText().equals("DeleteDef"))
		{
			String word= JOptionPane.showInputDialog(null, "Insert Name", JOptionPane.OK_CANCEL_OPTION);
			//System.out.println(word);

			if(word.equals(""))
			{
				ui.displayMessage("Null name!");
				return;
			}

			String defID= JOptionPane.showInputDialog(null, "Insert DefID", JOptionPane.OK_CANCEL_OPTION);
			//System.out.println(accountID);

			if(defID.equals(""))
			{
				ui.displayMessage("Null id!");
				return;
			}
			
			deleteDef(word,Integer.parseInt(defID));
			changesCheck();
			return;
		}
		
		if(buttonSource.getText().equals("SearchWord"))
		{
			String wordPattern= JOptionPane.showInputDialog(null, "Insert Pattern", JOptionPane.OK_CANCEL_OPTION);
			if(wordPattern.equals(""))
			{
				ui.displayMessage("Null pattern!");
				return;
			}
			searchWord(wordPattern);
			
		
		}
	
		
	}

	private void searchWord(String wordPattern) {
		 List<Word> words = dictionary.getWordThatMatchPattern(wordPattern);
		 
		 StringBuilder text = new StringBuilder("");
		 
		 
		 for (Entry<Word, Set<AbstractDefinition>> entry:dictionary.getRecord().entrySet())
		 {
			 if(words.contains(entry.getKey()))
			 {
				text.append(entry.getKey().getName());
				
				Iterator<AbstractDefinition> iterator = dictionary.getRecord().get(entry.getKey()).iterator();
				while (iterator.hasNext()) 
				{
					text.append(" = "+iterator.next().getDescription()+" \n");
					
				}

			}
		 }
		 
		 new SomethingView("Searched", text.toString());
		 
		 
		
	}

	private void deleteDef(String word, int i) 
	{
		List<Word> list = dictionary.getAllWords();
		int id=0;
		int foundWord=0;
		float perc=0f;
		
		for(Word pp: list)
		{
			if(pp.getName().equals(word))
			{
				perc = pp.getSearchFrequency();
				id = pp.getWordId();
				foundWord= 1;
				break;
			}
		}

		if(foundWord==1)
		{
			Word wordToDeleteFrom = new Word(word, perc, id);
			
			int defId=i;
			Set<AbstractDefinition> listOfDefs =dictionary.getDescriptionsforWord(wordToDeleteFrom);
			
			float perc1 = 0;
			int defFound=0;
			for(AbstractDefinition a:listOfDefs)
			{
				if(a.getDescriptId()==defId)
				{
					defFound=1;
					perc1 = a.getAccuracy();
					break;
				}
			}

			if(defFound==1)
			{
				dictionary.removeDescription(i, wordToDeleteFrom);
			}
			else
			{
				ui.displayMessage("No account has that id!");
			}
		}
		else
		{
			ui.displayMessage("No user has that name!");
		}

		
	}


	private void deleteWord(String word) {
		List<Word> list = dictionary.getAllWords();
		int id=0;
		int foundWord=0;
		float perc=0f;
		
		for(Word pp: list)
		{
			if(pp.getName().equals(word))
			{
				perc = pp.getSearchFrequency();
				id = pp.getWordId();
				foundWord= 1;
				break;
			}
		}
		
		if(foundWord==1)
		{
			dictionary.removeWord(new Word(word, perc, id));
		}
		
	}

	private void addWord(String wordName, String definition) {
		List<Word> list = dictionary.getAllWords();
		int id=0;
		int foundWord=0;
		float perc=0;
		
		for(Word pp: list)
		{
			if(pp.getName().equals(wordName))
			{
				id = pp.getWordId();
				foundWord= 1;
				perc = pp.getSearchFrequency();
				break;
			}
			else
			{
				if(pp.getWordId()>id)
				{
					id = pp.getWordId();
				}
			}
		}
		
		Word wordToAdd;
		Random a = new Random();
		

		if(foundWord==1)
		{
			wordToAdd = new Word(wordName,perc, id);
		}
		else
		{
			wordToAdd = new Word(wordName,a.nextFloat()%100f+1f, id+1);
		}
		
		int defId=1;
		Description defToAdd;

		if(foundWord==1)
		{
			Set<AbstractDefinition> listOfDefs = dictionary.getDescriptionsforWord(wordToAdd);

			for(AbstractDefinition c:listOfDefs)
			{
				if(c.getDescriptId()>defId)
				{
					defId=c.getDescriptId();
				}
			}
			defId++;
		}
		
		defToAdd = new Description(defId, definition, a.nextFloat()%100f+1);
		
		dictionary.addDescriptionforWord(wordToAdd, defToAdd);

		
		
	}

	private void changesCheck() {
		System.out.println("After change");
		System.out.println(dictionary);

		String choice= JOptionPane.showInputDialog(null, "Do you want to save changes? Y/N", JOptionPane.OK_CANCEL_OPTION);
		System.out.println(choice);

		if(choice.equals("Y"))
		{
			System.out.println("SALVAM");
			per.saveDictionary(dictionary);
		}
		else
		{
			File f = new File("C:\\Users\\T\\Desktop\\workspace\\Dictionary\\dictionary.ser");
			if(f.exists())
			{
				System.out.println("success");
				System.out.println();
				System.out.println("Restored dictionary");
				dictionary = per.restoreDictionary();
				System.out.println();
			}
			else
			{
				System.out.println("Setting Up Bank");
				dictionary = new WordDaoImplementation();
			}
		}
		
	}
	
}
