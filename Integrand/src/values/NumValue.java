package values;

/**
 * A numerical value is a value defined by some number.
 *
 */
public class NumValue extends Value<Number> {

	public enum MathConstant {
		PI("\\pi", Math.PI);

		private String formula;
		private Number value;

		MathConstant(String formula, Number value) {
			this.formula = formula;
			this.value = value;
		}

		public String toString() {
			return this.formula;
		}

		public Number getNumericalValue() {
			return this.value;
		}
	}

	public NumValue(Number value) {
		super(value);
	}

	@Override
	public Number getNumericalValue() {
		return this.getValue();
	}
}
