package model;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import interfaces.PersistanceI;

import java.util.Map.Entry;


public class JsonPersistance implements PersistanceI{

	public void saveDictionary(WordDaoImplementation dictionary) 
	{
		Map<Word, Set<AbstractDefinition>> dicttionary = dictionary.getRecord();

		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("C:\\Users\\T\\Desktop\\workspace\\Dictionary\\dictionary.txt"), dicttionary);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
	
	
	public WordDaoImplementation restoreDictionary() {
		ObjectMapper mapper = new ObjectMapper();
		
		WordDaoImplementation wordDAO = new WordDaoImplementation();
		
		File f= new File("C:\\Users\\T\\Desktop\\workspace\\Dictionary\\dictionary.txt");
		Map<Word, Set<AbstractDefinition>> dictionary = new HashMap<Word, Set<AbstractDefinition>>();
		
		try {
		dictionary = mapper.readValue(f, new TypeReference<Map<Word, Set<AbstractDefinition>>>(){});
	
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		
		for (Entry<Word, Set<AbstractDefinition>> entry:dictionary.entrySet()){
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		wordDAO.setRecord(dictionary);
		
		return wordDAO;
	}

}
