package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;

import interfaces.WordDaoI;

import java.util.Set;

public class WordDaoImplementation implements WordDaoI,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6432372746767903292L;

	private Map<Word, Set<AbstractDefinition>> record = new HashMap<Word, Set<AbstractDefinition>>();


	public WordDaoImplementation()
	{

	}

	public WordDaoImplementation( Map<Word, Set<AbstractDefinition>> record)
	{
		this.record = record;
	}

	public boolean doesWordHaveNullDescription(Word word)
	{
		if(record.containsKey(word))
		{
			int preSize = record.get(word).size();
			if(preSize==1)
			{
				Iterator<AbstractDefinition> iterator = record.get(word).iterator();
				while (iterator.hasNext()) 
				{
					if (iterator.next().getDescription().equals("no description"))
					{
						return true;
					}

				}
			}
		}

		return false;
	}

	public void addDescriptionforWord(Word word, AbstractDefinition descript) 
	{
		//pre
		assert isWellFormed():"Dictionary is not well formed";
		assert word!=null:"The word must not be null";
		assert descript!=null:"The description must not be null";

		int preSize=0;

		if(record.containsKey(word))
		{
			preSize = record.get(word).size();
			if(this.doesWordHaveNullDescription(word))
			{
				//System.out.println("SIZE "+record.get(word).size());
				
				Iterator<AbstractDefinition> iterator = record.get(word).iterator();
				while (iterator.hasNext()) 
				{
					if (iterator.next().getDescription().equals("no description"))
					{
						System.out.println("sdadas");
						iterator.remove();
					}

				}
				//System.out.println("Size after:"+record.get(word).size());
			} 
			
			
			record.get(word).add(descript);

			
			
			
			
		}
		else
		{

			Set<AbstractDefinition> descriptions = new HashSet<AbstractDefinition>();
			descriptions.add(descript);
			record.put(word,descriptions);

		}

		int postSize =record.get(word).size();
		//post
		assert preSize ==postSize-1: "Description not added";
		assert isWellFormed():"Dictionary is not well formed";
	}

	@Override
	public Set<AbstractDefinition> getDescriptionsforWord(Word word) 
	{
		assert isWellFormed():"Dictionary is not well formed";
		
		System.out.println("word   "+word);
		for (Entry<Word, Set<AbstractDefinition>> entry:record.entrySet())
		{

			if(entry.getKey().equals(word))
			{
				return entry.getValue();
			}
		}
		return null;
	}





	@Override
	public List<Word> getWordThatMatchPattern(String pattern) 
	{
		//pre
		assert pattern!=null :"Pattern must not be null";
		assert isWellFormed():"Dictionary is not well formed";


		List<Word> words = new LinkedList<Word>();
		for (Entry<Word, Set<AbstractDefinition>> entry:record.entrySet()){
			if(entry.getKey().getName().matches(pattern))
			{
				words.add(entry.getKey());
			}

		}

		//post


		assert isWellFormed():"Dictionary is not well formed";

		return words;

	}

	@Override
	public void removeDescription(int descriptID, Word word)
	{
		//pre
		assert isWellFormed():"Dictionary is not well formed";
		assert word!=null:"The word must not be null";
		assert descriptID>0: "The description must not be null";

		System.out.println("received "+word);

		int preSize;

		if (record.containsKey(word))
		{
			preSize = record.get(word).size();
			System.out.println("size "+preSize);

			if(preSize == 1 )
			{

				preSize = 2;
				this.addDescriptionforWord(word, new NullDescription());

			}
			else
			{

			}

			Iterator<AbstractDefinition> iterator = record.get(word).iterator();
			while (iterator.hasNext()) 
			{
				if (iterator.next().getDescriptId() == descriptID) 
				{
					iterator.remove();
				}

			}

		}
		else
		{
			preSize = 0;
		}



		int postSize = record.get(word).size();

		//postCond
		assert preSize == postSize +1 :"Account not deleted";
		assert isWellFormed():"Dictionary is not well formed";

	}

	@Override
	public void removeWord(Word word) {
		//pre
		assert isWellFormed():"Dictionary is not well formed";
		assert word!=null:"The word must not be null";

		int preSize;

		if(record.containsKey(word))
		{
			preSize = record.size();
			Set<AbstractDefinition> desc = record.get(word);
			for (AbstractDefinition d:desc)
			{
				record.get(word).remove(d);
			}

			record.remove(word);


		}
		else
		{
			preSize = 0;
		}

		int postSize = record.size();


		//postCond
		assert preSize == postSize +1 :"Person not deleted";
		assert isWellFormed():"Dictionary is not well formed";

	}

	@Override
	public void updateWordDefinition(Word word, AbstractDefinition descript) {

		//pre
		assert isWellFormed():"Dictionary is not well formed";
		assert word!=null:"The word must not be null";
		assert descript!=null:"The description must not be null";
		int preSize =  record.get(word).size();

		removeDescription(descript.getDescriptId(), word);
		addDescriptionforWord(word, descript);

		int postSize =  record.get(word).size();

		//post
		assert preSize==postSize:"Lost value of description";
		assert isWellFormed():"Dictionary is not well formed";

	}
	
	public List<Word> getAllWords() 
	{
		List<Word> listOfPersons = new ArrayList<Word>();

		for(Entry<Word,Set<AbstractDefinition>> entry: record.entrySet()) 
		{

			listOfPersons.add(entry.getKey());

		}

		return listOfPersons;
	}




	public Map<Word, Set<AbstractDefinition>> getRecord() {
		return record;
	}

	public void setRecord(Map<Word, Set<AbstractDefinition>> records)
	{
		this.record= records;
	}
	public boolean isWellFormed(){
		for (Entry<Word, Set<AbstractDefinition>> entry:record.entrySet()){
			//System.out.println("intra:"+entry.getKey());
			if (entry.getValue() == null || entry.getValue().isEmpty()){
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "Dictionary[record=" + record + "]\n";
	}

}
