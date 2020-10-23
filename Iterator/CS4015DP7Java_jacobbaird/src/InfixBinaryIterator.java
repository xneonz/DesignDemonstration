import java.util.ArrayList;

public class InfixBinaryIterator extends BinaryIterator {
	
	public InfixBinaryIterator(BinaryNode binaryNode) {
		
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
			result.add(new Integer(binaryNode.getValue()));
			result.addAll(traverse(binaryNode.getRight()));
			
		}
		
		return result;
		
	}
}