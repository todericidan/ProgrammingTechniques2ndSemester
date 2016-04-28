package model;


public class SavingAccounts extends Account{

	private static final long serialVersionUID = -1264584545265554661L;

	public SavingAccounts(int accID, double money) {
		super(accID, money);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addMoney(double money) {
		
		//System.out.println(getAccID()+" "+"SavingAccount "+money);
		setMoney(getMoney()+(money*(98)/100));
		//System.out.println(getAccID()+" "+"SavingAccount "+getMoney());
		setChanged();
		notifyObservers(money);
		
	}

	@Override
	public void withdrawMoney(double money) {
		double perc = money/getMoney() *100;
		
		if(perc <10)
		{	
			setMoney(getMoney()-(money*(100+2)/100));
		}
		else
		{
			setMoney(getMoney()-(money*(100+5)/100));
		}
		setChanged();
		notifyObservers(money);
		
	}

	@Override
	public String toString() {
		return "\n SavingAccount [accID=" + getAccID() + ", money=" + getMoney() + "]";
	}
	

}
