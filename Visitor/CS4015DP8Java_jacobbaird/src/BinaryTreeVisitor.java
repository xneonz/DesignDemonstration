public abstract class BinaryTreeVisitor {

	/*
	 * Visitors perform separate tasks on operators and nodes.
	 */
	public abstract void visitOperator(OperatorBinaryTreeNode operator);
	public abstract void visitNumber(NumberBinaryTreeNode number);

}