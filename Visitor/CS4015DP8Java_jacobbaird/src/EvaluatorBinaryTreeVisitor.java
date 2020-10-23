public class EvaluatorBinaryTreeVisitor extends BinaryTreeVisitor {

	/*
	 * EvaluatorBinaryTreeVisitor recursively evaluates the
	 * tree using inorder traversal
	 */
	double value = 0.0d;
	
	public void visitOperator(OperatorBinaryTreeNode operator) {

		double left;
		double right;
		
		EvaluatorBinaryTreeVisitor leftVisitor = new EvaluatorBinaryTreeVisitor();
		EvaluatorBinaryTreeVisitor rightVisitor = new EvaluatorBinaryTreeVisitor();;
		
		operator.getLeft().acceptVisitor(leftVisitor);
		operator.getRight().acceptVisitor(rightVisitor);
		
		left = leftVisitor.getValue();
		right = rightVisitor.getValue();
		
		if(operator.getType() == BinaryTreeNodeType.ADD) {
			
			this.value = left + right;
			
		} else if(operator.getType() == BinaryTreeNodeType.MULTIPLY) {
			
			this.value = left * right;
			
		} else if(operator.getType() == BinaryTreeNodeType.SUBTRACT) {
			
			this.value = left - right;
			
		} else if(operator.getType() == BinaryTreeNodeType.DIVIDE) {
			
			this.value = left / right;
			
		}
		
	}

	public void visitNumber(NumberBinaryTreeNode number) {
		
		this.value = (double) number.getValue();
		
	}
	
	public double getValue() {
		
		return value;
		
	}
}