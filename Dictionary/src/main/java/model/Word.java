package model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Word implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3001795153365436055L;
	
	private int wordId;
	private String name;
	private float searchFrequency;
	
	
	public Word()
	{
		super();
	}
	
	public Word(String name,float searchFreq,int id)
	{
		super();
		this.wordId = id;
		this.name =name;
		this.searchFrequency = searchFreq;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(searchFrequency);
		result = prime * result + wordId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(searchFrequency) != Float.floatToIntBits(other.searchFrequency))
			return false;
		if (wordId != other.wordId)
			return false;
		return true;
	}

	public int getWordId() {
		return wordId;
	}

	public String getName() {
		return name;
	}

	public float getSearchFrequency() {
		return searchFrequency;
	}
	
	public void setSearchFrequency(float freq)
	{
		this.searchFrequency = freq;
	}

	@Override
	public String toString() {
		return "Word [wordId=" + wordId + ", name=" + name + ", searchFrequency=" + searchFrequency + "]";
	}




}
