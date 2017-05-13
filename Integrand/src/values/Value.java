package values;

import objects.math.expression.SubExpression;

/**
 * A value is a mathematical object that is either a constant or some variable.
 *
 * @param <T>
 */
public abstract class Value<T> extends SubExpression {

	private T value;

	public Value(T value) {
		setValue(value);
	}

	public T getValue() {
		return this.value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public String getEquationText() {
		return value.toString();
	}
}
