package ro.utcluj.pt.polynomials2.models.functionality;

import ro.utcluj.pt.polynomials2.models.Polynomial;
import ro.utcluj.pt.polynomials2.models.Term;

public class Multiplication extends BiOperation {

	@Override
	public Polynomial executeOperation(Polynomial a, Polynomial b) 
	{
		Polynomial result = new Polynomial();
		
		
		for(Term aTerm:a.getTerms())
		{
			int coef=0;
			int pow=0;
			for(Term bTerm:b.getTerms())
			{
				coef = aTerm.getCoefficient()*bTerm.getCoefficient(); 
			    pow = aTerm.getPower() + bTerm.getPower();
			    result.addTerm(new Term(coef, pow));
			    System.out.println(coef + "-" + pow );
			}
			
			
		}
		
		return result;
	}

}
