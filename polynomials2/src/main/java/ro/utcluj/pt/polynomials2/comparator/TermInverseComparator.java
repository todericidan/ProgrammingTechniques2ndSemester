package ro.utcluj.pt.polynomials2.comparator;

import java.util.Comparator;

import ro.utcluj.pt.polynomials2.models.Term;

public class TermInverseComparator implements Comparator<Term>
{

	public int compare(Term firstTerm,Term secondTerm) 
	{
		if(firstTerm.getPower()>secondTerm.getPower())
		{
			return -1;
		}
		if(firstTerm.getPower()<secondTerm.getPower())
		{
			return 1;
		}
		
		return 0;
	}



}
