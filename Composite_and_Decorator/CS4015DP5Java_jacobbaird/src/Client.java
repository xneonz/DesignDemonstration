import java.util.Scanner;

public class Client {

	private static boolean QUOTED;

	private static ArithmeticNode rootNode;

	
	/*
	 * Prefix notation: <operator> <operand> <operand>
	 */
	private static void printPrefix() {
		printPrefixHelper(rootNode);
	}
	
	private static void printPrefixHelper(ArithmeticNode n) {
		if(n == null) {
			return;
		}
		System.out.print(n.toString()+" ");
		if(n.getLeft()!=null) {
			printPrefixHelper(n.getLeft());
		}
		if(n.getRight()!=null) {
			printPrefixHelper(n.getRight());
		}
	}
	
	/*
	 * Infix notation: <operand> <operator> <operand>
	 */
	private static void printInfix() {
		printInfixHelper(rootNode);
	}

	private static void printInfixHelper(ArithmeticNode n) {
		if(n == null) {
			return;
		}
		if(n.getLeft()!=null) {
			printInfixHelper(n.getLeft());
		}
		System.out.print(n.toString()+" ");
		if(n.getRight()!=null) {
			printInfixHelper(n.getRight());
		}
	}
	
	/*
	 * Postfix notation: <operator> <operand> <operand>
	 */
	private static void printPostfix() {
		printPostfixHelper(rootNode);
	}

	private static void printPostfixHelper(ArithmeticNode n) {
		if(n == null) {
			return;
		}
		if(n.getLeft()!=null) {
			printPostfixHelper(n.getLeft());
		}
		if(n.getRight()!=null) {
			printPostfixHelper(n.getRight());
		}
		System.out.print(n.toString()+" ");
	}

	/*
	 * Evaluate expression and print result if expression is valid
	 */
	private static void evaluate() {
		if(rootNode==null) {
			
			System.out.println("No expression present!");
			return;
			
		}
		
		try {
			
			System.out.print("Evaluating:\t");
			printPrefix();
			System.out.println("= "+rootNode.evaluate());
			
		} catch (InvalidExpressionException e) {
			
			System.out.println(e.getMessage());
			
		}
	}

	/*
	 * Append operand to leftmost available position in tree
	 * An available position is any (left/right) null node of an operator node
	 * If no positions available, append to rightmost position, making the expression invalid
	 * An operand with a free operator is also invalid
	 * If the root is null, set the root to n
	 */
	private static void addNode(ArithmeticNode n) {
		
		if(rootNode == null) {
			
			rootNode = n;
			
		} else if(!addNodeHelper(rootNode, n)) {
			
			ArithmeticNode temp = rootNode;
			
			while(temp.getLeft()!=null) {
				
				temp = temp.getLeft();
				
			}
			
			temp.setLeft(n);
			
		}
		
	}
	
	private static boolean addNodeHelper(ArithmeticNode r, ArithmeticNode n) {
		
		if(!r.isOperator()) {
			
			return false;
			
		} else if(r.getLeft()==null) {
			
			r.setLeft(n);
			return true;
			
		} else if(addNodeHelper(r.getLeft(),n)) {
			
			return true;
			
		} else if(r.getRight()==null) {
			
			r.setRight(n);
			return true;
			
		} else if(addNodeHelper(r.getRight(),n)) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public static void main(String... args) {
		String input;
		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.print("Please select display option...\n\t[(Q)uoted/(U)nquoted]:\t");
			input = sc.nextLine();
			
		} while(!input.equals("Q")&&!input.equals("U"));
		
		QUOTED = input.equals("Q");
		
		System.out.println("Commands...\n\t[insert (o)perator]\n\t[insert (n)umber]\n\t[(p)rint expression]\n\t[print (t)ree]\n\t[(e)valuate expression]\n\t[(q)uit]");
		
		while(true) {
			
			input = sc.nextLine();
			
			if(input.equals("o")) {
				
				do {
					
					System.out.println("Enter operator...\n\t[(+)]\n\t[(-)]\n\t[(*)]\n\t[(/)]\n\t[(())]");
					input = sc.nextLine();

				} while(!input.equals("+")&&!input.equals("-")&&!input.equals("*")&&!input.equals("/")&&!input.equals("()"));
				
				final OperatorType O;
				
				if(input.equals("+")) {
					
					O = OperatorType.ADD;
					
				} else if(input.equals("-")) {
					
					O = OperatorType.SUBTRACT;
					
				} else if(input.equals("*")) {
					
					O = OperatorType.MULTIPLY;
					
				} else if(input.equals("()")){
					
					O = OperatorType.PARENTHESES;
					
				} else {
					
					O = OperatorType.DIVIDE;
					
				}
				
				final ArithmeticOperatorDecorator D;
				
				if(QUOTED) {
					
					D = new QuotedArithmeticOperator();
					
				} else {
					
					D = new UnquotedArithmeticOperator();
					
				}
				
				D.setOperatorType(O);
				D.setLeft(null);
				D.setRight(null);
				
				addNode(D);
				
				System.out.println("Inserted operator!");
					
			} else if(input.equals("n")) {
				
				boolean success;
				int value = 0;
				
				do {
					
					System.out.println("Enter number...");
					
					try {
						
						value = Integer.parseInt(sc.nextLine());
						success = true;
						
					} catch (Exception e) {
						
						success = false;
						
					}
					
				} while(!success);
				
				final ArithmeticNumberDecorator D;
				
				if(QUOTED) {
					
					D = new QuotedArithmeticNumber();
					
				} else {
					
					D = new UnquotedArithmeticNumber();
					
				}
				
				D.setValue(value);
				D.setLeft(null);
				D.setRight(null);
				
				addNode(D);
				
				System.out.println("Inserted number!");
				
			} else if(input.equals("p")) {
				
				do {
					
					System.out.println("Choose a print option...\n\t[p(o)stfix]\n\t[p(r)efix]\n\t[i(n)fix]");
					input = sc.nextLine();
					
				} while(!input.equals("o")&&!input.equals("r")&&!input.equals("n"));
				
				if(input.equals("o")) {
					
					printPostfix();
					
				} else if(input.equals("r")) {
					
					printPrefix();
					
				} else {
					
					printInfix();
					
				}
				
				System.out.println();
					
			} else if(input.equals("t")) {
				
				printTree();
				
			} else if(input.equals("e")) {
				
				evaluate();
				
			} else if(input.equals("q")) {
				
				sc.close();
				return;
				
			} else {
				
				System.out.println("Invalid command!\nCommands...\n\t[insert (o)perator]\n\t[insert (n)umber]\n\t[(p)rint expression]\n\t[print (t)ree]\n\t[(e)valuate expression]\n\t[(q)uit]");
				
			}
			
		}
		
	}

	/*
	 * Print tree starting from root node
	 */
	private static void printTree() {
		printTreeHelper(rootNode,0);
	}
	
	private static void printTreeHelper(ArithmeticNode n, int d) {
		
		 if(n==null) {
			 return;
		 }
		 
		 if(n.getLeft()!=null) {
			 printTreeHelper(n.getLeft(),d+1);
		 }
		 
		 for(int i = 0; i < d; i++) {System.out.print("\t");}
		 
		 System.out.println(n.toString());
		 
		 if(n.getRight()!=null) {
			 printTreeHelper(n.getRight(),d+1);
		 }
		 
	}
}