package ro.utcluj.pt.polynomials2.models;

import java.util.ArrayList;
import java.util.Collections;

import ro.utcluj.pt.polynomials2.comparator.TermComparator;
import ro.utcluj.pt.polynomials2.comparator.TermInverseComparator;

public class Polynomial {

	private ArrayList<Term> terms = new ArrayList<Term>() ;
	private boolean isSortedAscending = false;

	public Polynomial(ArrayList<Term> list)
	{
		setTerms(list);
	}

	public Polynomial() {

	}

	private void sortElements()
	{
		Collections.sort(terms,new TermComparator());
		isSortedAscending = true;
	}

	public void sortInverseElements()
	{

		Collections.sort(terms,new TermInverseComparator());
		isSortedAscending = false;
	}



	public void addTerm(Term term)
	{


		if(!checkifExistingPower(term.getPower()))
		{
			this.terms.add(term);

		}
		else
		{
			setCoefficientAtGivenPower(term.getPower(),term.getCoefficient()+getCoefficientAtGivenPower(term.getPower()));
		}
		sortElements();

	}

	private boolean checkifExistingPower(int pow) 
	{

		if(getCoefficientAtGivenPower(pow)!=0)
		{
			return true;
		}
		return false;
	}

	public int getCoefficientAtGivenPower(int power)
	{
		for(Term term:terms )
		{

			if(term.getPower()==power)
			{
				return term.getCoefficient();
			}
		}
		return 0;
	}

	public void setCoefficientAtGivenPower(int power,int coef)
	{
		for(Term term:terms )
		{

			if(term.getPower()==power)
			{
				term.setCoefficient(coef);
			}
		}

	}

	public int getDegree() 
	{
		if(isSortedAscending)
		{
			return terms.get(terms.size()-1).getPower();
		}
		else
		{
			return terms.get(0).getPower();
		}

	}






	public ArrayList<Term> getTerms() {
		return terms;
	}

	public void setTerms(ArrayList<Term> terms) 
	{
		for(Term t:terms)
		{
			addTerm(t);

		}
	}
	
	
	@Override
	public String toString()
	{
		
		StringBuilder result = new StringBuilder();


		for(Term t : terms)
		{


			int coef = t.getCoefficient();
			//System.out.println(t.getCoefficient()+" @ "+t.getPower());

			if(t.getPower()!=0)
			{				
				if(coef !=0)
				{

					if((coef > 0))
					{
						result.append("+");
					}
					result.append(coef+"x");

					if(t.getPower()!=0)
					{
						result.append("^"+t.getPower());
					}
				}
			}
			else
			{
				result.append(getCoefficientAtGivenPower(t.getPower()));
			}
		}



		if(result.equals(""))
		{
			//System.out.println("ai");
			return "0";
		}


		return result.toString();

	}

	@Override
	public boolean equals(Object a)
	{
		if(a==null)
		{
			return false;
		}
		if(!(a instanceof Polynomial))
		{
			return false;
		}

		Polynomial aux = (Polynomial) a;

		if(aux.getDegree() != this.getDegree())
		{
			return false;
		}

		if(!(aux.getTerms().equals(this.getTerms())))
		{

			return false;
		}


		return true;
	}
	
	


}
