package ro.utcluj.pt.polynomials2.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ro.utcluj.pt.polynomials2.models.Polynomial;
import ro.utcluj.pt.polynomials2.models.functionality.Addition;
import ro.utcluj.pt.polynomials2.models.functionality.BiOperation;
import ro.utcluj.pt.polynomials2.models.functionality.Derivation;
import ro.utcluj.pt.polynomials2.models.functionality.Division;
import ro.utcluj.pt.polynomials2.models.functionality.Integration;
import ro.utcluj.pt.polynomials2.models.functionality.Multiplication;
import ro.utcluj.pt.polynomials2.models.functionality.StringParser;
import ro.utcluj.pt.polynomials2.models.functionality.Substraction;
import ro.utcluj.pt.polynomials2.models.functionality.UniOperation;
import ro.utcluj.pt.polynomials2.views.UI;

public class UiViewController implements ActionListener{

	private UI userInterface;
	private Polynomial firstPolynomial,secondPolynomial;

	public UiViewController()
	{
		userInterface = new UI(this);

	}

	public void actionPerformed(ActionEvent e)
	{
		JButton buttonSource = (JButton) e.getSource();
		//System.out.println(buttonSource.getText());

		if(buttonSource.getText().equals("Cancel"))
		{
			if(buttonSource.getActionCommand().equals("Pol1"))
			{
				userInterface.setSubmitPol1ButtonText("Submit");
				userInterface.setPol1FieldEditability(true);
			}
			else
			{
				userInterface.setSubmitPol2ButtonText("Submit");
				userInterface.setPol2FieldEditability(true);
			}
			return;
		}

		if(buttonSource.getText().equals("Submit"))
		{
			if(buttonSource.getActionCommand().equals("Pol1"))
			{
				if(userInterface.getPol1().equals("0x^0")|| userInterface.getPol1().equals("-0x^0"))
				{

				}
				else
				{
					StringParser s = new StringParser(userInterface.getPol1());
					firstPolynomial= new Polynomial(s.getTerms());
					//System.out.println(firstPolynomial.toString());
					userInterface.setPol1Field(firstPolynomial.toString());

					userInterface.setSubmitPol1ButtonText("Cancel");
					userInterface.setPol1FieldEditability(false);
				}
			}
			else
			{
				if(userInterface.getPol2().equals("0x^0")|| userInterface.getPol2().equals("-0x^0"))
				{

				}
				else
				{
					secondPolynomial = new Polynomial((new StringParser(userInterface.getPol2()).getTerms()));		
					userInterface.setPol2Field(secondPolynomial.toString());
					userInterface.setSubmitPol2ButtonText("Cancel");
					userInterface.setPol2FieldEditability(false);
				}
			}
		}




		if(buttonSource.getText().equals("ADD"))
		{
			BiOperation operation = new Addition();
			Polynomial result = operation.executeOperation(firstPolynomial, secondPolynomial);
			userInterface.setResultField(result.toString());
		}

		if(buttonSource.getText().equals("SUBTRACT"))
		{
			BiOperation operation = new Substraction();
			Polynomial result = operation.executeOperation(firstPolynomial, secondPolynomial);
			userInterface.setResultField(result.toString());
		}


		if(buttonSource.getText().equals("DIVIDE"))
		{
			Division operation = new Division();
			Polynomial result = operation.executeOperation(firstPolynomial, secondPolynomial);
			userInterface.setResultField("Quotient:"+operation.getQuotient()+" "+" Remainder: "+operation.getRemainder());

			//operation.division(firstPolynomial, secondPolynomial);

		}

		if(buttonSource.getText().equals("MULTIPLY"))
		{
			BiOperation operation = new Multiplication();
			Polynomial result = operation.executeOperation(firstPolynomial, secondPolynomial);
			userInterface.setResultField(result.toString());
		}

		if(buttonSource.getText().equals("DERIVE"))
		{

			UniOperation operation = new Derivation();

			if(userInterface.getPol1().equals("")||userInterface.getPol2().equals(""))
			{
				if((!(userInterface.getPol1().equals("")))&& userInterface.getPol1().equals(""))
				{

					Polynomial result = operation.executeOperation(firstPolynomial);
					userInterface.setResultField(result.toString());
				}
				if((!(userInterface.getPol2().equals("")))&& userInterface.getPol2().equals(""))
				{
					Polynomial result = operation.executeOperation(secondPolynomial);
					userInterface.setResultField(result.toString());
				}
			}
			else
			{
				Object[] options = {"pol1","pol2"};
				int choice = JOptionPane.showOptionDialog(userInterface, 
						"First of second?",
						"Choose a polynom", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.INFORMATION_MESSAGE,
						null, 
						options,
						options[1]);
				//System.out.println(choice);
				if(choice==0)
				{
					Polynomial result = operation.executeOperation(firstPolynomial);
					userInterface.setResultField(result.toString());
				}
				else
				{
					Polynomial result = operation.executeOperation(secondPolynomial);
					userInterface.setResultField(result.toString());
				}
			}
		}

		if(buttonSource.getText().equals("INTEGRATE"))
		{
			Integration operation = new Integration();

			if(userInterface.getPol1().equals("")||userInterface.getPol2().equals(""))
			{
				//				System.out.println("intra");
				//				
				//				if((!userInterface.getPol1().equals(""))&& userInterface.getPol1().equals(""))
				//				{
				//					userInterface.setResultField(operation.toStringResult(firstPolynomial));
				//				}
				//				if((!userInterface.getPol2().equals(""))&& userInterface.getPol2().equals(""))
				//				{
				//					userInterface.setResultField(operation.toStringResult(secondPolynomial));
				//				}
			}
			else
			{
				Object[] options = {"pol1","pol2"};
				int choice = JOptionPane.showOptionDialog(userInterface, 
						"First of second?",
						"Choose a polynom", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.INFORMATION_MESSAGE,
						null, 
						options,
						options[1]);
				//System.out.println(choice);
				if(choice==0)
				{

					userInterface.setResultField(operation.getStringFormResult(firstPolynomial));
				}
				else
				{

					userInterface.setResultField(operation.getStringFormResult(secondPolynomial));
				}
			}
		}
	}
}


