package ro.utcluj.pt.polynomials2.models.functionality;

import ro.utcluj.pt.polynomials2.models.Polynomial;

public abstract class BiOperation extends Operation {
	public abstract Polynomial executeOperation(Polynomial a, Polynomial b);

}
