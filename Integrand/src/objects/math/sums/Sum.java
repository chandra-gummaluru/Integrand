package objects.math.sums;

import objects.math.expression.SubExpression;
import objects.math.var.Variable;

public class Sum<T1 extends SubExpression, T2 extends SubExpression, T3 extends SubExpression> extends SubExpression {

	private T1 summand;

	private T2 lowerBound;
	private T3 upperBound;

	private Variable sumVar;

	public Sum(T1 summand, Variable sumVar, T2 lowerBound, T3 upperBound) {
		this.summand = summand;

		this.sumVar = sumVar;

		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	@Override
	public String getEquationText() {
		return "\\sum_{" + this.sumVar.getEquationText() + "=" + this.lowerBound.getEquationText() + "}^{"
				+ this.upperBound.getEquationText() + "}" + summand.getEquationText();
	}

}
