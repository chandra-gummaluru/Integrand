package objects.math.fraction;

import objects.math.expression.SubExpression;

public class Fraction<T1 extends SubExpression, T2 extends SubExpression> extends SubExpression {
	private T1 numerator;
	private T2 denominator;

	public Fraction(T1 numerator, T2 denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	@Override
	public String getEquationText() {
		return "\\frac{" + numerator.getEquationText() + "}{" + denominator.getEquationText() + "}";
	}
}
