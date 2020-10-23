
public abstract class ArithmeticNode {
	
	private ArithmeticNode left;
	private ArithmeticNode right;
	
	/*
	 * Simply returns true if operator, false if number
	 */
	public abstract boolean isOperator();

	public ArithmeticNode getLeft() {
		return left;
	}

	public ArithmeticNode getRight() {
		return right;
	}

	public void setLeft(ArithmeticNode left) {
		this.left = left;
	}

	public void setRight(ArithmeticNode right) {
		this.right = right;
	}

	public abstract String toString();

	public abstract int evaluate() throws InvalidExpressionException;

	public void removeLeft() {
		left = null;
	}

	public void removeRight() {
		right = null;
	}
}