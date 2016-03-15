package ro.utcluj.pt.polynomials2.models.functionality;

import ro.utcluj.pt.polynomials2.models.Polynomial;
import ro.utcluj.pt.polynomials2.models.Term;

public class Substraction extends BiOperation {

	@Override
	public Polynomial executeOperation(Polynomial a, Polynomial b) 
	{
		Polynomial result = new Polynomial();
		for(Term t:a.getTerms())
		{
			result.addTerm(new Term(t.getCoefficient(), t.getPower())); 
		}

		for(Term t:b.getTerms())
		{
			if(result.getCoefficientAtGivenPower(t.getPower())!=0)
			{
				
				int coef = result.getCoefficientAtGivenPower(t.getPower())-t.getCoefficient();
				result.setCoefficientAtGivenPower(t.getPower(), coef);
			}
			else
			{

				
				result.addTerm(new Term(-t.getCoefficient(), t.getPower()));
			}

		}

		
		return result;
	}

}
