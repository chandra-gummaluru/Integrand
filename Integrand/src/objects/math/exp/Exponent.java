package objects.math.exp;

import objects.math.expression.SubExpression;
import values.Value;

public class Exponent<T1 extends SubExpression, T2 extends SubExpression> extends SubExpression {

	private T1 base;
	private T2 power;
	public Value<?> coefficient;

	public Exponent(T1 base, T2 power) {
		this.base = base;
		this.power = power;
	}

	@Override
	public String getEquationText() {
		return base.getEquationText() + "^{" + power.getEquationText() + "}";
	}
}
