package objects.math.var;

import objects.math.expression.SubExpression;
import values.Value;

public class Variable extends SubExpression {

	/**
	 * The value (either character or numerical) defining {@code this Variable}.
	 */
	private Value<?> val;

	/**
	 * The subscripts associated with {@code this Variable}.
	 */
	private Variable[] subscripts;

	public Variable(Value<?> val) {
		this.val = val;
	}

	public Variable(Value<?> val, Variable[] subscripts) {
		this(val);

		this.subscripts = subscripts;
	}

	@Override
	public String getEquationText() {
		String s = val.getEquationText();

		if (subscripts != null) {
			s += "_{";

			for (int i = 0; i < subscripts.length - 1; i++) {
				s += subscripts[i].getEquationText() + ",";
			}

			s += subscripts[subscripts.length - 1].getEquationText() + "}";
		}

		return s;
	}

}
