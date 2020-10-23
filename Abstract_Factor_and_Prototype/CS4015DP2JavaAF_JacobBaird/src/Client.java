/**
 * 
 */

import java.util.Scanner;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author jbaird2
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Client {
	
	private static ElapsedTimeFactory elapsedTimeFactory;
	
	private static final String DISPLAY_CURRENT_TIME = "t";
	private static final String RESET_TIME = "r";
	private static final String CHANGE_TO_1 = "1";
	private static final String CHANGE_TO_2 = "2";
	private static final String QUIT = "q";
	
	private static long startTime;
	private static long userTime;
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param args
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void main(String... args) {
		// begin-user-code
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = "";
		
		startTime = System.currentTimeMillis();
		userTime = startTime;
		
		System.out.println("Choose your display format...");
		
		do {
			
			System.out.println("'1':\t\"HH:MM:SS\"\n'2':\t\"MS\"");
			input = sc.nextLine();
			
		} while (!input.equals(CHANGE_TO_1) && !input.equals(CHANGE_TO_2));
		
		if(input.equals(CHANGE_TO_1)) {
			
			elapsedTimeFactory = new ElapsedTimeFactoryV1();
			
		} else {
			
			elapsedTimeFactory = new ElapsedTimeFactoryV2();
			
		}
		
		System.out.println("'t':\tdisplay current time");
		System.out.println("'r':\treset elapsed time to 0");
		System.out.println("'1':\tchange to display format 'HH:MM:SS'");
		System.out.println("'2':\tchange to display format 'MS'");
		System.out.println("'q':\tquit program");
		
		while(true) {
			
			input = sc.nextLine();
			
			if(input.equals(DISPLAY_CURRENT_TIME)) {
				
				printTime();
				
			} else if(input.equals(RESET_TIME)) {
				
				resetTime();
				
			} else if(input.equals(CHANGE_TO_1)) {
				
				elapsedTimeFactory = new ElapsedTimeFactoryV1();
				
			} else if(input.equals(CHANGE_TO_2)) {
				
				elapsedTimeFactory = new ElapsedTimeFactoryV2();
				
			} else if(input.equals(QUIT)) {
				
				return;
				
			}
			
		}
		// end-user-code
	}
	
	private static void printTime() {
		
		long time = System.currentTimeMillis();
		
		elapsedTimeFactory.CreateElapsedTimer().displayTime(time-startTime);
		elapsedTimeFactory.CreateUserDefinedTimer().displayTime(time-userTime);
		
	}
	
	private static void resetTime() {
		
		userTime = System.currentTimeMillis();
		
	}
	
}