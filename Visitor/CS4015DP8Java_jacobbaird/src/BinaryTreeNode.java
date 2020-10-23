public abstract class BinaryTreeNode {

	/*
	 * type allows the evaluator to determine which binary
	 * operation to perform on the left and right nodes of an operator.
	 */
	private BinaryTreeNodeType type;
	
	public BinaryTreeNode(BinaryTreeNodeType type) {
		
		this.type = type;

	}

	public BinaryTreeNodeType getType() {
		return type;
	}
	
	public abstract String toString();

	public abstract void acceptVisitor(BinaryTreeVisitor visitor);
}