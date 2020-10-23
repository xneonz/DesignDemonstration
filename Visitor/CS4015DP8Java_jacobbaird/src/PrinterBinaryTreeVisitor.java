public class PrinterBinaryTreeVisitor extends BinaryTreeVisitor {

	/*
	 * EvaluatorBinaryTreeVisitor recursively prints the
	 * tree using inorder traversal
	 */
	
	public void visitOperator(OperatorBinaryTreeNode operator) {

		System.out.print("(");
		operator.getLeft().acceptVisitor(this);
		System.out.print(operator.toString());
		operator.getRight().acceptVisitor(this);
		System.out.print(")");
		
	}
	
	public void visitNumber(NumberBinaryTreeNode number) {

		System.out.print(number.toString());
		
	}
}