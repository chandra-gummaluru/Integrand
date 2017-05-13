package objects.math.expression;

public enum ArithmeticOperation {

	ADD("+"), SUBTRACT("-"), MUTLIPLY("*"), DIVIDE("/");

	private String operator;

	ArithmeticOperation(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return this.operator;
	}

	public String toString() {
		return this.getOperator();
	}

}
