/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author jbaird2
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
import java.util.Scanner;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author jbaird2
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Client {
	
	private static final String DISPLAY_CURRENT_TIME = "t";
	private static final String RESET_TIME = "r";
	private static final String CHANGE_TO_1_ELAPSEDTIME = "1";
	private static final String CHANGE_TO_1_USERDEFINED = "2";
	private static final String CHANGE_TO_2_ELAPSEDTIME = "3";
	private static final String CHANGE_TO_2_USERDEFINED = "4";
	private static final String QUIT = "q";
	
	private static long startTime;
	private static long userTime;
	
	private static ElapsedTimeObject elapsedTimeObject;
	private static UserDefinedTimeObject userDefinedTimeObject;
	
	private static ElapsedTimeObject etof1;
	private static ElapsedTimeObject etof2;
	private static UserDefinedTimeObject udtof1;
	private static UserDefinedTimeObject udtof2;
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param args
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void main(String... args) {
		// begin-user-code
		// TODO Auto-generated method stub
		
		etof1 = new ElapsedTimeObjectF1();
		etof2 = new ElapsedTimeObjectF2();
		udtof1 = new UserDefinedTimeObjectF1();
		udtof2 = new UserDefinedTimeObjectF2();
		
		Scanner sc = new Scanner(System.in);
		String input = "";
		
		startTime = System.currentTimeMillis();
		userTime = startTime;
		
		System.out.println("Choose your display format...");
		
		do {
			
			System.out.println("'1':\t\"HH:MM:SS\"\n'2':\t\"MS\"");
			input = sc.nextLine();
			
		} while (!input.equals(CHANGE_TO_1_ELAPSEDTIME) && !input.equals(CHANGE_TO_1_USERDEFINED));
		
		if(input.equals(CHANGE_TO_1_ELAPSEDTIME)) {
			
			elapsedTimeObject = new ElapsedTimeObjectF1();
			userDefinedTimeObject = new UserDefinedTimeObjectF1();
			
		} else {
			
			elapsedTimeObject = new ElapsedTimeObjectF2();
			userDefinedTimeObject = new UserDefinedTimeObjectF2();
			
		}
		
		System.out.println("'t':\tdisplay current time");
		System.out.println("'r':\treset elapsed time to 0");
		System.out.println("'1':\tchange elapsed time to display format 'HH:MM:SS'");
		System.out.println("'2':\tchange user-defined time to display format 'MS'");
		System.out.println("'3':\tchange elapsed time to display format 'MS'");
		System.out.println("'4':\tchange user-defined time to display format 'MS'");
		System.out.println("'q':\tquit program");
		
		while(true) {
			
			input = sc.nextLine();
			
			if(input.equals(DISPLAY_CURRENT_TIME)) {
				
				printTime();
				
			} else if(input.equals(RESET_TIME)) {
				
				resetTime();
				
			} else if(input.equals(CHANGE_TO_1_ELAPSEDTIME)) {
				
				elapsedTimeObject = etof1.clone();
				
			} else if(input.equals(CHANGE_TO_1_USERDEFINED)) {
				
				userDefinedTimeObject = udtof1.clone();
				
			} else if(input.equals(CHANGE_TO_2_ELAPSEDTIME)) {
				
				elapsedTimeObject = etof2.clone();
				
			} else if(input.equals(CHANGE_TO_2_USERDEFINED)) {
				
				userDefinedTimeObject = udtof2.clone();
				
			} else if(input.equals(QUIT)) {
				
				return;
				
			}
			
		}
		// end-user-code
	}
	
	private static void printTime() {
		
		long time = System.currentTimeMillis();
		
		elapsedTimeObject.displayTime(time-startTime);
		userDefinedTimeObject.displayTime(time-userTime);
		
	}
	
	private static void resetTime() {
		
		userTime = System.currentTimeMillis();
		
	}
	
}