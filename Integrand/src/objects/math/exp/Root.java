package objects.math.exp;

import objects.math.expression.SubExpression;

public class Root<T1 extends SubExpression, T2 extends SubExpression> extends SubExpression {

	private T1 radicand;
	private T2 order;

	public Root(T1 radicand, T2 order) {
		this.radicand = radicand;
		this.order = order;
	}

	@Override
	public String getEquationText() {
		return "\\sqrt[" + order.getEquationText() + "]{" + radicand.getEquationText() + "}";
	}

}
