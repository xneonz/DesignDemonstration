
public abstract class BinaryNode {

	private BinaryNode parent;

	private BinaryNode left;

	private BinaryNode right;

	private int value;

	public void setParent(BinaryNode parent) {

		this.parent = parent;

	}

	public void setLeft(BinaryNode left) {

		this.left = left;

	}

	public void setRight(BinaryNode right) {

		this.right = right;

	}

	public void setValue(int value) {

		this.value = value;

	}

	public BinaryNode getParent() {

		return parent;

	}

	public BinaryNode getLeft() {

		return left;

	}
	
	public BinaryNode getRight() {

		return right;

	}
	
	public int getValue() {

		return value;

	}
}