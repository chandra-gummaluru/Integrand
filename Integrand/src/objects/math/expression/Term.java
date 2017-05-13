package objects.math.expression;

public class Term extends SubExpression {

	private SubExpression[] subexpressions;

	public Term(SubExpression subexpression) {
		this.subexpressions = new SubExpression[] { subexpression };
	}

	public Term(SubExpression[] subexpressions) {
		this.subexpressions = subexpressions;
	}

	@Override
	public String getEquationText() {
		String s = "";

		if (subexpressions.length > 1) {
			for (int i = 0; i < subexpressions.length; i++) {
				s += "(" + subexpressions[i].getEquationText() + ")";
			}
		} else {
			s = subexpressions[0].getEquationText();
		}

		return s;
	}

}
