import java.util.ArrayList;

public abstract class BinaryIterator {

	private ArrayList<Integer> binaryNodeValues;
	
	public BinaryIterator(BinaryNode binaryNode) {
		
		this.binaryNodeValues = traverse(binaryNode);
		
	}

	/*
	 * next() returns the first element of the binaryNodeValues
	 * list and then removes that element from the list. Once every
	 * element has been removed from the list, an IteratorException
	 * is thrown.
	 */
	public int next() throws IteratorException {
		
		int value;
		
		if(binaryNodeValues.size() == 0) {
			
			throw new IteratorException();
			
		}
		
		value = binaryNodeValues.get(0).intValue();
		
		binaryNodeValues.remove(0);
		
		return value;
		
	}
	
	/*
	 * This method traverses the contents of a BinaryNode object
	 * in one of prefix, infix or postfix order, as determined by
	 * the subclass, and stores the result in an ArrayList object.
	 */
	protected abstract ArrayList<Integer> traverse(BinaryNode binaryNode);

}