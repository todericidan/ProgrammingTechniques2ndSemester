package ro.utcluj.pt.polynomials2.models.functionality;

import java.text.NumberFormat;

import ro.utcluj.pt.polynomials2.models.Polynomial;
import ro.utcluj.pt.polynomials2.models.Term;

public class Integration extends UniOperation{

	@Override
	public Polynomial executeOperation(Polynomial a) 
	{
		
		Polynomial result = new Polynomial();
		for(Term t:a.getTerms())
		{
			if(t.getPower()!=0)
			{
				double coeff =(double)t.getCoefficient()/(t.getPower()+1);
				int coef = (int)coeff;
				
 				int pow = t.getPower()+1;
 				
 				//System.out.println(coeff+"x^"+pow+"   "+coef);
 				
 				if(coeff<1 &&coeff>0)
 				{
 					
 					coeff=coeff +  1;
 					coef =(int)coeff;
 				}
 				
 				if(coeff<0 &&coeff>-1)
 				{
 					
 					coeff=coeff -  1;
 					coef =(int)coeff;
 				}
 				//System.out.println(coeff+"x^"+pow+"   "+coef);
 				
				result.addTerm(new Term(coef,pow)); 
			}
		}
		
		
		return result;	
	}
	
	public String getStringFormResult(Polynomial a)
	{
		StringBuilder result = new StringBuilder();
		
		if(a.getDegree()>0)
		{
			for(Term t :a.getTerms())
			{
				double coef =(double) t.getCoefficient();
				
				if(t.getPower()!=0)
				{
					
					if(coef !=0)
					{

						if((coef > 0) && (t.getPower()!= 0))
						{
							result.append("+");
						}
						
						double aux = coef/(t.getPower()+1);

						NumberFormat nf = NumberFormat.getInstance();
				        nf.setMinimumFractionDigits(2);
				        nf.setMaximumFractionDigits(2);
				        String stringConversion = nf.format(aux);
		
						result.append(stringConversion+"x");

						if(t.getPower()!=0)
						{
							result.append("^"+(t.getPower()+1));
						}
					}
				}
				else
				{
					result.append(a.getCoefficientAtGivenPower(t.getPower())+"x^1");
				}
			}
		}

		if(result.equals(null))
		{
			//System.out.println("ai");
			return "0";
		}


		return result.toString();
	}

}
