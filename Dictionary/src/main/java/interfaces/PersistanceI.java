package interfaces;

import model.WordDaoImplementation;

public interface PersistanceI {
	
	public void saveDictionary(WordDaoImplementation dictionary);
	
	public WordDaoImplementation restoreDictionary();

}
