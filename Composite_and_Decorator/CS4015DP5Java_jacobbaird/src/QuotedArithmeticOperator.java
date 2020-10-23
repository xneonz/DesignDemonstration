
public class QuotedArithmeticOperator extends ArithmeticOperatorDecorator {
	public String toString() {
		switch(operatorType) {
			case ADD:
				return "'+'";
			case SUBTRACT:
				return "'-'";
			case MULTIPLY:
				return "'*'";
			case DIVIDE:
				return "'/'";
			case PARENTHESES:
				return "()";
			default:
				return "''";
		}
	}
}