package objects.math.expression;

public class Expression extends SubExpression {

	private Term[] terms;
	private ArithmeticOperation[] operations;

	public Expression(Term term) {
		this.terms = new Term[] { term };
	}

	public Expression(Term[] terms, ArithmeticOperation[] operations) {
		this.terms = terms;
		this.operations = operations;
	}

	@Override
	public String getEquationText() {
		String s = "";

		for (int i = 0; i < terms.length - 1; i++) {
			s += terms[i].getEquationText() + operations[i].getOperator();
		}

		s += terms[terms.length - 1].getEquationText();

		return s;
	}

}
