import java.util.Scanner;

public class Client {
	
	/*
	 * This program allows users to generator random binary trees
	 * and traverse their contents in prefix, infix and postfix order
	 * in an iterable fashion. See README for more details.
	 */

	public static void main(String[] args) {
		
		BinaryIterator i;
		BinaryIterator p;
		BinaryIterator o;
		
		BinaryNode binaryTree;
		
		TreeBuilder treeBuilder;
		
		final Scanner sc;
		String input;
		final String help;
		final String iteratorError;
		final String iteratorException;
		
		i = null;
		p = null;
		o = null;
		
		binaryTree = null;
		
		treeBuilder = new TreeBuilder();
		
		sc = new Scanner(System.in);
		help = "G <n>\tGenerates a random binary tree with n levels\n"
				+ "I\tCreates an inorder iterator if it does not exist, and print the next item\n"
				+ "P\tCreates a preorder iterator if it does not exist, and print the next item\n"
				+ "O\tCreates a postorder iterator if it does not exist, and print the next item\n"
				+ "Q\tQuits the program";
		iteratorError = "Unable to create iterator. Please first generate a random binary tree";
		iteratorException = "Reached end of iterator";
		
		System.out.println(help);
		
		do {
			
			input = sc.next();
			
			if(input.equals("G")) {
				
				try {
					
					binaryTree = treeBuilder.buildTree(Integer.parseInt(sc.next()), 0, 1024);
					i = null;
					p = null;
					o = null;
					
				} catch (Exception e) {
					
					System.out.println("Invalid number format");
					
				}
				
			} else if(input.equals("I")) {
				
				if(i == null) {
					
					if(binaryTree == null) {
						
						System.out.println(iteratorError);
						
					} else {
						
						i = new InfixBinaryIterator(binaryTree);
						
					}
					
				}
				
				if(i != null) {
					
					try {
						
						System.out.println(i.next());
						
					} catch (IteratorException e) {
						
						System.out.println(iteratorException);
						
					}
					
				}
				
			} else if(input.equals("P")) {
				
				if(p == null) {
					
					if(binaryTree == null) {
						
						System.out.println(iteratorError);
						
					} else {
						
						p = new PrefixBinaryIterator(binaryTree);
						
					}
					
				}
				
				if(i != null) {
					
					try {
						
						System.out.println(p.next());
						
					} catch (IteratorException e) {
						
						System.out.println(iteratorException);
						
					}
					
				}
				
			} else if(input.equals("O")) {
				
				if(o == null) {
					
					if(binaryTree == null) {
						
						System.out.println(iteratorError);
						
					} else {
						
						o = new PostfixBinaryIterator(binaryTree);
						
					}
					
				}
				
				if(i != null) {
					
					try {
						
						System.out.println(o.next());
						
					} catch (IteratorException e) {
						
						System.out.println(iteratorException);
						
					}
					
				}
				
			} else if(!input.equals("Q")) {
				
				/*
				 * This case is an incorrect output
				 */
				System.out.println(help);
				
			}
			
		} while(!input.equals("Q"));
		
		sc.close();
		
	}
}