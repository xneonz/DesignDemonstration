import java.util.Scanner;

public class Client {
	/*
	 * See README for program details
	 */
	
	public static void main(String[] args) {
		
		EvaluatorBinaryTreeVisitor evaluator = new EvaluatorBinaryTreeVisitor();
		PrinterBinaryTreeVisitor printer = new PrinterBinaryTreeVisitor();
		Scanner sc = new Scanner(System.in);
		BinaryTreeNode tree = null;
		String input;
		String help = "G <n>\tGenerates a random expression (binary tree) with n levels\n"
				+ "E\tEvaluates the expression and prints the value\n"
				+ "V\tVisualizes the tree\n"
				+ "Q\tQuits the program";
		String nullExn = "Please first instantiate tree";
		String inExn = "Unrecognized command";
		String numExn = "Depth must be a non-negative integer";
		
		int n;
		BinaryTreeBuilder builder = new BinaryTreeBuilder();
		
		System.out.println(help);
		
		while(true) {
			
			input = sc.next();
			
			if(input.equals("G")) {
				
				try {
					
					n = Integer.parseInt(sc.next());
					
					if(n < 0) {
					
						System.out.println(numExn);
						System.out.println(help);
						
					} else {
						
						tree = builder.buildTree(n);
						
					}
					
				} catch (Exception e) {
					
					System.out.println(numExn);
					System.out.println(help);
					
				}
				
			} else if(input.equals("E")) {
				
				if(tree == null) {
					
					System.out.println(nullExn);
					
				} else {
					
					try {
						
						tree.acceptVisitor(evaluator);
						System.out.println(Double.toString(evaluator.getValue()));
						
					} catch (Exception e) {
						
						System.out.println("Undefined!");
						
					}
				}
				
			} else if(input.equals("V")) {
				
				if(tree == null) {
					
					System.out.println(nullExn);
					
				} else {
					
					tree.acceptVisitor(printer);
					System.out.println();
					
				}
				
			} else if(input.equals("Q")) {
				
				sc.close();
				return;
				
			} else {
				
				System.out.println(inExn);
				System.out.println(help);
				
			}
			
		}
		
	}
	
}