package values;

/**
 * A character value is a value defined by some character.
 * 
 */
public class CharValue extends Value<Character> {

	public CharValue(Character value) {
		super(value);
	}

	@Override
	public Number getNumericalValue() {
		return null;
	}
}
