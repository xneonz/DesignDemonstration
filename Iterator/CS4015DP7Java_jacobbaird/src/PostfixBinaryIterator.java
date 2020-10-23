import java.util.ArrayList;

public class PostfixBinaryIterator extends BinaryIterator {

	public PostfixBinaryIterator(BinaryNode binaryNode) {
		
		super(binaryNode);
		
	}

	/*
	 * traverse() traverses the nodes of binaryNode in infix order
	 */
	protected ArrayList<Integer> traverse(BinaryNode binaryNode) {
		
		ArrayList<Integer> result;
		
		if(binaryNode == null) {
			
			result = new ArrayList<Integer>();
			
		} else {
			
			result = new ArrayList<Integer>();
			
			result.addAll(traverse(binaryNode.getLeft()));
			result.addAll(traverse(binaryNode.getRight()));
			result.add(new Integer(binaryNode.getValue()));
			
		}
		
		return result;
		
	}
	
}