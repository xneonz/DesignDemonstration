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
		String input;

		System.out.println("Enter name of file, or 'stop' to stop...");
		
		while(!(input=sc.nextLine()).equals("stop")) {
			
			ServiceBuilder singletonWordCount = SingletonWordCount.getSingleton();
			ServiceBuilder singletonWordTable = SingletonWordTable.getSingleton();
			ServiceBuilder singletonEncryption = SingletonEncryption.getSingleton();
			
			System.out.println("Select service type...\n'count' to count words\n'table' to generate word table\n'encrypt' to encrypt file");
			
			String command = sc.nextLine();
			if(command.equals("count")) {
				System.out.println("Counting...");
				singletonWordCount.countWords(input);
			}
			if(command.equals("table")) {
				System.out.println("Tabulating...");
				singletonWordTable.getWordTable(input);
			}
			if(command.equals("encrypt")) {
				System.out.println("Encrypting...");
				singletonEncryption.encryptFile(input);
			}
			System.out.println("Enter name of file, or 'stop' to stop...");
			
		}
		// end-user-code
	}
}