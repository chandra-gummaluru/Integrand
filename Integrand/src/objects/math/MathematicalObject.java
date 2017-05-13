package objects.math;

import objects.math.expression.Expressable;

public abstract class MathematicalObject implements Expressable {

	public String toString() {
		return this.getEquationText();
	}
}
