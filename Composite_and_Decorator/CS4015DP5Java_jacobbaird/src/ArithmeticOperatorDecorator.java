
public abstract class ArithmeticOperatorDecorator extends ArithmeticNode {
	protected OperatorType operatorType;
	
	public boolean isOperator() {
		
		return true;
		
	}
	
	public void setOperatorType(OperatorType o) {
		
		operatorType = o;
		
	}

	public abstract String toString();

	public int evaluate() throws InvalidExpressionException {
		try {
			switch(operatorType) {
		
				case ADD:
					return getLeft().evaluate() + getRight().evaluate();
				
				case SUBTRACT:
					return getLeft().evaluate() - getRight().evaluate();
					
				case MULTIPLY:
					return getLeft().evaluate() * getRight().evaluate();
					
				case DIVIDE:
					return getLeft().evaluate() / getRight().evaluate();
					
				case PARENTHESES:
					throw new InvalidExpressionException();
					
				default:
					throw new InvalidExpressionException();
				
			}
		} catch (InvalidExpressionException e) {
			
			throw e;
		
		} catch (Exception e) {
			
			/*
			 * Result of dividing by zero
			 */
			throw new InvalidExpressionException();
			
		}
	}
}