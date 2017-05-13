package values;

import values.MathValue.MathConstant;

/**
 * A character value is a value defined by some character.
 * 
 */
public class MathValue extends Value<MathConstant> {

	public enum MathConstant {
		INFINITY("\\infty"), PI("\\pi");

		private String formula;

		MathConstant(String formula) {
			this.formula = formula;
		}

		public String toString() {
			return this.formula;
		}
	}

	public MathValue(MathConstant value) {
		super(value);
	}
}
