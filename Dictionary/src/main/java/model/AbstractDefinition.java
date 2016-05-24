package model;

import java.io.Serializable;

public abstract class AbstractDefinition implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7244738258702889560L;
	
	public AbstractDefinition() {
		super();

	}
	
	protected int descriptId;
	protected String descript;
	protected float accuracy;

	public float getAccuracy()
	{
		return this.accuracy;
	}
	
	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}

	public int getDescriptId()
	{
		return descriptId;
	}
	
	public abstract boolean isNil();
	public abstract String getDescription();
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Description other = (Description) obj;
		if (Float.floatToIntBits(accuracy) != Float.floatToIntBits(other.getAccuracy()))
			return false;
		if (descript == null) {
			if (other.getDescription() != null)
				return false;
		} else if (!descript.equals(other.getDescription()))
			return false;
		if (descriptId != other.getDescriptId())
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(getAccuracy());
		result = prime * result + ((descript == null) ? 0 : descript.hashCode());
		result = prime * result + descriptId;
		return result;
	}



	@Override
	public String toString() {
		return "Description [descriptId=" + getDescriptId()+ ", descript=" + getDescription() + ", accuracy=" + getAccuracy() + "]";
	}

}
