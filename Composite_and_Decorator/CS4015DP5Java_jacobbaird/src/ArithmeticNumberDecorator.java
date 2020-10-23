
public abstract class ArithmeticNumberDecorator extends ArithmeticNode {
	protected int value;
	
	public void setValue(int v) {
		
		this.value = v;
		
	}
	
	public boolean isOperator() {
		
		return false;
		
	}

	public abstract String toString();

	public int evaluate() {
		return value;
	}
}