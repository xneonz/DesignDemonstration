
public class NumberBinaryTreeNode extends BinaryTreeNode {

	/*
	 * NumberBinaryTree node represents a lead node storing a numeric value
	 */
	private int value;
	
	public NumberBinaryTreeNode(int value) {
		
		super(BinaryTreeNodeType.NUMERIC);
		this.value = value;
		
	}

	public int getValue() {
		
		return value;

	}
	
	public String toString() {
		
		return Integer.toString(value);
	
	}

	public void acceptVisitor(BinaryTreeVisitor visitor) {
		
		visitor.visitNumber(this);
		
	}
}