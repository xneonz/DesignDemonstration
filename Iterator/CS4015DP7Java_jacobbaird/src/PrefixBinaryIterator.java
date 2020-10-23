import java.util.ArrayList;

public class PrefixBinaryIterator extends BinaryIterator {
	
	public PrefixBinaryIterator (BinaryNode binaryNode) {
		
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
			
			result.add(new Integer(binaryNode.getValue()));
			result.addAll(traverse(binaryNode.getLeft()));
			result.addAll(traverse(binaryNode.getRight()));
			
		}
		
		return result;
		
	}
	
}