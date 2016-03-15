package ro.utcluj.pt.polynomials2.test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ro.utcluj.pt.polynomials2.models.Polynomial;
import ro.utcluj.pt.polynomials2.models.Term;
import ro.utcluj.pt.polynomials2.models.functionality.Addition;
import ro.utcluj.pt.polynomials2.models.functionality.BiOperation;
import ro.utcluj.pt.polynomials2.models.functionality.Derivation;
import ro.utcluj.pt.polynomials2.models.functionality.Division;
import ro.utcluj.pt.polynomials2.models.functionality.Integration;
import ro.utcluj.pt.polynomials2.models.functionality.Multiplication;
import ro.utcluj.pt.polynomials2.models.functionality.Substraction;
import ro.utcluj.pt.polynomials2.models.functionality.UniOperation;

public class OperationTest {
	
	private Polynomial a,b;
	
	 public OperationTest() {
		setup();
	}
	
	@Before
	public void setup(){
		 a = new Polynomial();
		a.addTerm(new Term(2, 2));
		a.addTerm(new Term(-5, 5));
		
		 b = new Polynomial();
		b.addTerm(new Term(3, 2));
		b.addTerm(new Term(4, 5));
	}
	
	
	@Test
	public void additionTest()
	{
		
		Polynomial result = new Polynomial();
		
		result.addTerm(new Term(5,2));
		result.addTerm(new Term(-1,5));
		
		BiOperation o = new Addition();
		
		Polynomial r1 = o.executeOperation(a, b);
		//System.out.println(r1.getStringForm()+ " " + result.getStringForm() + " " + r1.equals(result));
		assertEquals("Addition check",result,r1);
		
	}
	
	@Test
	public void subtractionTest()
	{

		Polynomial result = new Polynomial();
		
		result.addTerm(new Term(-1,2));
		result.addTerm(new Term(-9,5));
		
		BiOperation o = new Substraction();
		Polynomial r1 = o.executeOperation(a, b);
		assertEquals("Subtraction check",result,r1);
	}
	
	@Test
	public void deriveTest()
	{

		Polynomial result = new Polynomial();
		
		result.addTerm(new Term(4,1));
		result.addTerm(new Term(-25,4));
		
		UniOperation o = new Derivation();
		Polynomial r1 = o.executeOperation(a);
		assertEquals("1#Derive check",result,r1);
		
		result = new Polynomial();
		result.addTerm(new Term(6,1));
		result.addTerm(new Term(20,4));
		r1 = o.executeOperation(b);
		assertEquals("2#Derive check",result,r1);
		
	}
	
	@Test
	public void integrateTest()
	{	
		String result = new String("+0.67x^3-0.83x^6");
		Integration o = new Integration();
		assertEquals("1#IntegrateStringForm check",result,o.getStringFormResult(a));
		
		result = new String("+1.00x^3+0.67x^6");
		assertEquals("Integrate check",result,o.getStringFormResult(b));
		
	}
	
	@Test
	public void multiplyTest()
	{	
		Polynomial  result = new Polynomial();
		result.addTerm(new Term(6,4));
		result.addTerm(new Term(-7,7));
		result.addTerm(new Term(-20,10));
		BiOperation o = new Multiplication();
		
		assertEquals("Multiplication check",result,o.executeOperation(a, b));
		
	}
	
	@Test
	public void divideTest()
	{
		Polynomial testPol = new Polynomial();
		testPol.addTerm(new Term(5, 6));
		
		Polynomial testPol1= new Polynomial();
		testPol1.addTerm(new Term(2, 2));
		
		Division o = new Division();
		
		o.executeOperation(testPol, testPol1);
		Polynomial q =new Polynomial();
		q.addTerm(new Term(2, 4));
		
		Polynomial r = new Polynomial();
		r.addTerm(new Term(1, 6));
		//System.out.println(o.getQuotientStringForm());
		
		assertEquals("Quotient check",o.getQuotient(),q);
		assertEquals("Remainder check",o.getRemainder(), r);
		
		
	}
	
	
	
	
	public static void main(String[] args) 
	{
		OperationTest o = new OperationTest();
		o.additionTest();
	}
	
	
	
	
	

}
