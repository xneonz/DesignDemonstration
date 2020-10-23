import java.util.Random;
import java.util.Scanner;


public class Client {
	
	private static MazeFacade mazeFacade;
	
	//This method generates a n x n maze of random tiles. Each tile is a space, wall or door
	//Each tile is a 'reference' to an existing tile object.
	private static int[][] generateMaze(int n) {
		
		Random rn;
		int[][] maze;
		
		rn = new Random();
		maze = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				
				maze[i][j] = rn.nextInt(3);
				
			}
			
		}
		
		return maze;
	}

	private static void printMaze(int[][] maze) {
		
		mazeFacade.printMaze(maze);
		
	}

	private static void displayMaze(int[][] maze) {
		
		mazeFacade.displayMaze(maze);
		
	}

	public static void main(String[] args) {
		
		/**
		 * 	1. 	Implementing the flyweight pattern would be much easier than implementing the prototype pattern.
		 * 		It would be easier because each pattern requires the instantiation of a base tile, whereas
		 * 		the prototype requires a cloning method as well
		 * 	2.	The flyweight pattern consumes less memory because each object contains a BufferedImage.
		 * 		However, if tiles did not contain BufferedImages and only ascii characters, simply using a n x n
		 * 		char matrix would consume less memory, because object references consume 4-8 bytes, whereas char
		 * 		variables consume only 1 byte
		 */
		
		Scanner scanner;
		
		mazeFacade = new MazeFacade();
		scanner = new Scanner(System.in);
		
		System.out.println("M <n>: Print ASCII maze of n x n spaces\nG <n>: Print image of maze of n x n spaces\nQ: Quit");
		
		while(true) {
			
			String input;
			Scanner inputScanner;
			String command;
			int argument;
			
			input = scanner.nextLine();
			inputScanner = new Scanner(input);
			
			command = inputScanner.next();
			
			if(command.equals("M")) {
				
				int[][] maze;
				
				argument = Integer.parseInt(inputScanner.next());
				maze = generateMaze(argument);
				
				printMaze(maze);
				
			} else if(command.equals("G")) {
				
				int[][] maze;
				
				argument = Integer.parseInt(inputScanner.next());
				maze = generateMaze(argument);
				
				displayMaze(maze);
				
			} else if(command.equals("Q")) {
				
				inputScanner.close();
				
				scanner.close();
				return;
				
			} else {
				
				System.out.println("M <n>: Print ASCII maze of n x n spaces\nG <n>: Print image of maze of n x n spaces\nQ: Quit");
				
			}
			
			inputScanner.close();
			
		}
		
	}
}