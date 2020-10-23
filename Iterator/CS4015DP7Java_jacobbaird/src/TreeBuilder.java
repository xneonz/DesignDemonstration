import java.util.Random;

public class TreeBuilder {
	
	/*
	 * This method creates a node with random value v, s.t. minimum <= v < maximum
	 * and left and right children created by recursively calling itself, decrementing
	 * depth each time until the base case of depth = 0 is reached, in which case null
	 * is returned. Minimum and maximum are used to ensure the resulting binary tree
	 * is ordered.
	 */
	public BinaryNode buildTree(int depth, int minimum, int maximum) {
		
		Random rn;
		BinaryNode binaryNode;
		int value;
		
		if(depth == 0) {
			
			binaryNode = null;
			
		} else {
			
			rn = new Random();
			binaryNode = new ConcreteBinaryNode();
			value = (maximum > minimum) ? rn.nextInt(maximum - minimum) + minimum : minimum;
			
			binaryNode.setValue(value);
			binaryNode.setLeft(buildTree(depth - 1, minimum, value));
			binaryNode.setRight(buildTree(depth - 1, value, maximum));
			
		}
		
		return binaryNode;
	}
}