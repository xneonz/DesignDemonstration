public class OperatorBinaryTreeNode extends BinaryTreeNode {

	/*
	 * OperatorBinaryTreeNode represents a non-leaf node
	 * containing left and right children nodes
	 */
	private BinaryTreeNode left;

	private BinaryTreeNode right;

	public OperatorBinaryTreeNode(BinaryTreeNodeType type) {
		
		super(type);
		
	}
	
	public BinaryTreeNode getLeft() {
		
		return left;
		
	}

	public BinaryTreeNode getRight() {
		
		return right;
		
	}
	
	public void setLeft(BinaryTreeNode left) {
		
		this.left = left;
		
	}

	public void setRight(BinaryTreeNode right) {
		
		this.right = right;
		
	}
	
	public String toString() {
		
		if(getType() == BinaryTreeNodeType.ADD) {
			
			return "+";
			
		} else if(getType() == BinaryTreeNodeType.DIVIDE) {
			
			return "/";
			
		} else if(getType() == BinaryTreeNodeType.MULTIPLY) {
			
			return "*";
			
		} else {
			
			return "-";
			
		}
		
	}
	
	public void acceptVisitor(BinaryTreeVisitor visitor) {
		
		visitor.visitOperator(this);
		
	}
}