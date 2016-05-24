package model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Description extends AbstractDefinition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3335619082777153142L;

	public Description(int descriptId,String description, float accuracy)
	{
		super();
		this.descriptId = descriptId;
		this.descript = description;
		this.accuracy = accuracy;
	}

	public Description()
	{
		super();
	}

	@Override
	public boolean isNil() {
		return false;
	}

	@Override
	public String getDescription() {
		return this.descript;
	}





}
