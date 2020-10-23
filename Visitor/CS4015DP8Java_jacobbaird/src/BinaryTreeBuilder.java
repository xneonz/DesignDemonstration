import java.util.Random;

public class BinaryTreeBuilder {

	/*
	 * buildTree construct a tree of depth <depth>.
	 * Leafs are numbers, and all other nodes are operators.
	 * An tree of depth > 0 has a 20% chance of containing
	 * one operator child and one number child, otherwise two
	 * operator children. A tree of depth 0 will always be a
	 * number.
	 */
	
	public BinaryTreeNode buildTree(int depth) {
		
		Random rn = new Random();
		int config;
		OperatorBinaryTreeNode tree;
		BinaryTreeNodeType type;

		if(depth == 0) {
			
			return new NumberBinaryTreeNode(rn.nextInt(10));
			
		} else {
			
			config = rn.nextInt(4);
			
			if(config == 0) {
				
				type = BinaryTreeNodeType.ADD;
				
			} else if(config == 1) {

				type = BinaryTreeNodeType.SUBTRACT;
				
			} else if(config == 2) {

				type = BinaryTreeNodeType.MULTIPLY;
				
			} else {

				type = BinaryTreeNodeType.DIVIDE;
				
			}
			
			tree = new OperatorBinaryTreeNode(type);
			config = rn.nextInt(8);
			
			if(config == 0) {
				
				tree.setLeft(new NumberBinaryTreeNode(rn.nextInt(10)));
				tree.setRight(buildTree(depth - 1));
				
			} else if(config == 1) {

				tree.setRight(new NumberBinaryTreeNode(rn.nextInt(10)));
				tree.setLeft(buildTree(depth - 1));
				
			} else {
				
				tree.setLeft(buildTree(depth - 1));
				tree.setRight(buildTree(depth - 1));
				
			}
			
			return tree;
			
		}
		
	}
}