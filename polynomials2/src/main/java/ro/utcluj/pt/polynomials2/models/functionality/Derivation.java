package ro.utcluj.pt.polynomials2.models.functionality;

import ro.utcluj.pt.polynomials2.models.Polynomial;
import ro.utcluj.pt.polynomials2.models.Term;

public class Derivation extends UniOperation {

	@Override
	public Polynomial executeOperation(Polynomial a) 
	{
		Polynomial result = new Polynomial();
		for(Term t:a.getTerms())
		{
			if(t.getPower()!=0)
			{
				int coef =t.getCoefficient()*t.getPower();
				int pow = t.getPower()-1;

				result.addTerm(new Term(coef,pow)); 
			}
		}
		return result;
	}

}
