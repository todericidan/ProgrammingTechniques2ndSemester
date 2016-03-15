package ro.utcluj.pt.polynomials2.models.functionality;

import java.util.ArrayList;

import ro.utcluj.pt.polynomials2.models.Term;

public class StringParser {

	private ArrayList<Term> terms = new ArrayList<Term>();
	private String stringToParse= new String();

	public StringParser(String string)
	{
		if(string.equals(""))
		{
			
		}
		else
		{
			setStringToParse(string);
			parseStringIntoTerms();
		}
	}

	private void parseStringIntoTerms()
	{
		System.out.println(stringToParse);
		
		stringToParse= stringToParse.replaceAll("x","");
		stringToParse= stringToParse.replaceAll(" ","");
		
		stringToParse= stringToParse.replaceAll("\\+"," ");
		stringToParse= stringToParse.replaceAll("\\-"," -");
		stringToParse= stringToParse.substring(0,stringToParse.length());
		
		if(stringToParse.charAt(0)==' ')
		{
			stringToParse= stringToParse.substring(1,stringToParse.length());
		}

		//System.out.println(stringToParse);



		String[] parts = stringToParse.split(" ");

		for(String part:parts)
		{
			//System.out.println(part);
			String[] coefAndPower = part.split("\\^");

			if(!coefAndPower[0].equals("0"))
			{

				int coef = Integer.parseInt(coefAndPower[0]);
				int pow = Integer.parseInt(coefAndPower[1]);

				Term term = new Term(coef, pow);
				terms.add(term);
			}
		}

	}

	public ArrayList<Term> getTerms() {
		return terms;
	}

	public String getStringToParse() {
		return stringToParse;
	}

	public void setStringToParse(String stringToParse) {
		this.stringToParse = stringToParse;
	}

}
