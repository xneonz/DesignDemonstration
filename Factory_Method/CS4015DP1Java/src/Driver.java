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
public class Driver {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static long startTime;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static int timestampType;
	private static final int HHMMSS = 1;
	private static final int MS = 2;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void main(String[] args) {
		Scanner sc;
		boolean properType;
		String timestampTypeAsString;
		String inputCommand;
		resetTime();
		sc = new Scanner(System.in);
		properType = false;
		System.out.println("Choose a display type...\nEnter:\t'HH:MM:SS'\nOr:\t'ms'");
		while(!properType) {
			timestampTypeAsString = sc.nextLine();
			if(timestampTypeAsString.equals("HH:MM:SS")) {
				timestampType = HHMMSS;
				properType = true;
			} else if(timestampTypeAsString.equals("ms")) {
				timestampType = MS;
				properType = true;
			} else {
				System.out.println("Invalid input!\nTry again...");
			}
		}
		System.out.println("To display elapsed time, enter: 'd'\nTo reset time, enter: 'r'\nTo quit, enter 'q'");
		while(true) {
			inputCommand = sc.nextLine();
			if(inputCommand.equals("d")) {
				displayTime();
			} else if(inputCommand.equals("r")) {
				resetTime();
			} else if(inputCommand.equals("q")) {
				sc.close();
				return;
			} else {
				System.out.println("Invalid input!\nTry again...");
			}
		}
	}
	
	public static void displayTime() {
		// begin-user-code
		// TODO Auto-generated method stub
		Timestamp timestamp;
		long elapsedTime = System.currentTimeMillis()-startTime;
		switch(timestampType) {
		case HHMMSS:
			timestamp = new ConcreteTimestamp1(elapsedTime);
			timestamp.displayTime();
			break;
		case MS:
			timestamp = new ConcreteTimestamp2(elapsedTime);
			timestamp.displayTime();
			break;
		}
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void resetTime() {
		// begin-user-code
		// TODO Auto-generated method stub
		startTime = System.currentTimeMillis();
		// end-user-code
	}
}