package objects.math.sums;

import objects.math.expression.SubExpression;
import objects.math.var.Variable;

public class Integral<T1 extends SubExpression, T2 extends SubExpression, T3 extends SubExpression>
		extends SubExpression {

	private int order;

	private T1 integrand;

	private T2 lowerBound;
	private T3 upperBound;

	private Variable differential;

	public Integral(int order, T1 integrand, Variable differential, T2 lowerBound, T3 upperBound) {
		this(integrand, differential, lowerBound, upperBound);
		this.order = order;
	}

	public Integral(T1 integrand, Variable differential, T2 lowerBound, T3 upperBound) {
		this.order = 1;
		this.integrand = integrand;

		this.differential = differential;

		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	@Override
	public String getEquationText() {
		String is = "";

		for (int i = 0; i < order; i++) {
			is += "i";
		}

		return "\\" + is + "nt_{" + this.lowerBound.getEquationText() + "}^{" + this.upperBound.getEquationText() + "}"
				+ integrand.getEquationText() + "d" + differential.getEquationText();
	}

}
