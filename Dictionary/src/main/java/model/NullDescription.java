package model;

import java.io.Serializable;

public class NullDescription extends AbstractDefinition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -116748488479839688L;
	

	
	public NullDescription() {
		super();
		this.accuracy=0f;
		this.descript="no description";
		this.descriptId = -1;
	}
	

	@Override
	public boolean isNil() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getDescription() {
		return descript;
	}

}
