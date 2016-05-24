package interfaces;

import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import model.AbstractDefinition;
import model.Word;

public interface WordDaoI {
	/**
	 * 
	 * @preCondition word!= NULL & description!=NULL
	 * @postCondition preSize descriptions = postSize descriptions - 1 
	 */
	public void addDescriptionforWord(Word word, AbstractDefinition descript);
		
	/**
	 * 
	 * @preCondition word!= NULL
	 * @postCondition
	 */
	public Set<AbstractDefinition> getDescriptionsforWord(Word word);
	
	/**
	 *@preCondition pattern!=NULL
	 *@posCondition 
	 * @return
	 */
	public List<Word> getWordThatMatchPattern(String pattern);
	
	/**
	 * @preCondition word!=NULL
	 * @postCondition preSize descriptions = postSize descriptions +1
	 */
	public void removeDescription(int descriptID,Word word);
	
	/**
	 * @preCondition word!=NULL
	 * @postCondition preSize words = postSize words +1
	 */
	public void removeWord(Word word);
	
	/**
	 * @preCondition word!=NUll & descript!=NULL
	 * @postCondition
	 */
	public void updateWordDefinition(Word word,AbstractDefinition descript);
	

}
