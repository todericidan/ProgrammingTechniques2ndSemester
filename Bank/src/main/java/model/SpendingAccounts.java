package model;

public class SpendingAccounts extends Account{
	
	private static final long serialVersionUID = -4807508189544101508L;

	public SpendingAccounts(int accID, double money) {
		super(accID, money);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addMoney(double money) {
		//System.out.println(getAccID()+" "+"SpendingAccount "+money);
		setMoney(getMoney()+money);
		//System.out.println(getAccID()+" "+"SpendingAccount "+getMoney());
		setChanged();
		notifyObservers(money);
		
	}

	@Override
	public void withdrawMoney(double money) {
		setMoney(getMoney()-money);
		setChanged();
		notifyObservers(money);
		
	}

	@Override
	public String toString() {
		return "\n SpendingAccount [accID=" + getAccID() + ", money=" + getMoney() + "]";
	}

}
