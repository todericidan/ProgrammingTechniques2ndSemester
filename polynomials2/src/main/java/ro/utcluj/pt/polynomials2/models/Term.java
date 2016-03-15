package ro.utcluj.pt.polynomials2.models;

public class Term {
	
	private int coefficient;
	private int power;
	
	public Term(int coef, int power)
	{
		setCoefficient(coef);
		setPower(power);
	}
	

	
	public int getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public boolean equals(Object a)
	{
		
		if(a==null)
		{
			return false;
		}
		
		if(!(a instanceof Term))
		{
			return false;
		}
		
		Term aux = (Term) a;
		
		//System.out.println(this.getCoefficient()+"^"+this.getPower()+" "+aux.getCoefficient()+"^"+aux.getPower());
		
		if(aux.getCoefficient()!= this.getCoefficient())
		{
			return false;
		}
		if(aux.getPower()!= this.getPower())
		{
			return false;
		}
		
		return true;
		
		
	}
}
