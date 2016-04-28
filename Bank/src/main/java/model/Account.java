package model;
import java.io.Serializable;
import java.util.Observable;

public abstract class Account extends Observable implements Serializable{
	
	private static final long serialVersionUID = -8797340946979705436L;
	
	private int accID;
	private double money;
	
	public Account(int accID,double money){
		this.accID = accID;
		this.money = money;
	}
	
	public abstract  void addMoney(double money);
	public abstract void withdrawMoney(double money);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accID;
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
		Account other = (Account) obj;
		if (accID != other.accID)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "\nAccount [accID=" + accID + ", money=" + money + "]";
	}

	public int getAccID() {
		return accID;
	}

	public void setMoney(double money){
		this.money = money;
		
	}

	public double getMoney() {
		return money;
	}


	

}
