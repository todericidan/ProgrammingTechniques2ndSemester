package ro.utcluj.pt.polynomials2.models.functionality;


import ro.utcluj.pt.polynomials2.models.Polynomial;
import ro.utcluj.pt.polynomials2.models.Term;

public class Division extends BiOperation {

	private Polynomial remainderPol = new Polynomial();
	private Polynomial quotientPol = new Polynomial();

	@Override
	public Polynomial executeOperation(Polynomial p1, Polynomial p2) 
	{

		//Polynomial[] division = new Polynomial[2];
		//division[0] = new Polynomial(p1.getDegree() - p2.getDegree()+1); // Quotient
		//division[1] = new Polynomial(p2.getDegree()-1); // Remainder

		Polynomial divider = p2;
		Polynomial dividend = p1;

		Polynomial auxPol = new Polynomial();
		auxPol.addTerm(new Term(1, 1));
		int dividerDegree = divider.getDegree();
		int copyOfDegree1 = p1.getDegree();
		int copyOfDegree2 = p2.getDegree();

		if(p1.getDegree()>=p2.getDegree()){
			while(dividerDegree>=p2.getDegree()){
				for (int i = 0; i < copyOfDegree1 - copyOfDegree2; i++) {
					divider = new Multiplication().executeOperation(divider, auxPol);
				}
				Term t = new Term(
						dividend.getCoefficientAtGivenPower(dividend.getDegree()) / 
						divider.getCoefficientAtGivenPower(divider.getDegree()),
						dividend.getDegree()- p2.getDegree());
				quotientPol.addTerm(t);
						
				divider = scalarMultiplication(divider, quotientPol.getCoefficientAtGivenPower(dividend.getDegree() - p2.getDegree()));
				dividend = new Substraction().executeOperation(dividend, divider);
				dividerDegree--;
				divider = p2;
				copyOfDegree1--;
			}
			remainderPol = new Substraction().executeOperation(p1, new Multiplication().executeOperation(quotientPol, divider));
		}
		else
		{
			
			quotientPol = p1;
			remainderPol = new Polynomial();
		}
		
		System.out.println("Cat:"+quotientPol.toString());
		System.out.println("Rest:"+remainderPol.toString());
		
		return quotientPol;
	}
	
	private Polynomial scalarMultiplication(Polynomial a, int scalar)
	{
		Polynomial result = a;
		for(Term t: result.getTerms())
		{
			result.setCoefficientAtGivenPower(t.getPower(), result.getCoefficientAtGivenPower(t.getPower()*scalar));
		}
		return result;
	}
	
	public Polynomial getQuotient()
	{
		return quotientPol;
	}
	
	public Polynomial getRemainder()
	{
		return remainderPol;
	}

	
}

