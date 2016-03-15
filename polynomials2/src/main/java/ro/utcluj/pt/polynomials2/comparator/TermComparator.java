package ro.utcluj.pt.polynomials2.comparator;

import java.util.Comparator;

import ro.utcluj.pt.polynomials2.models.Term;

public class TermComparator implements Comparator<Term>{
	
	public int compare(Term firstTerm,Term secondTerm) {
		
		return Integer.valueOf(firstTerm.getPower()).compareTo(Integer.valueOf(secondTerm.getPower()));
		
	}

}
