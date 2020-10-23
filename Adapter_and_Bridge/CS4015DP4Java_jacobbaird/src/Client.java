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
		String input;
		Scanner sc = new Scanner(System.in);
		StorageUnit su = new StorageUnit();
		System.out.println("Choose your filesystem...\n[A]:\tArray\n[L]:\tList");

		do {
			input = sc.nextLine();
		} while(!input.equals("A")&&!input.equals("L"));

		if(input.equals("A")) {
			su.setFileSystemType("A");
		} else {
			su.setFileSystemType("L");
		}
		
		System.out.println("[C]:\tCreate file\n[D]:\tDelete file\n[P]:\tPrint file\n[E]:\tEdit file\n[U]:\tPrint all files\n[S]:\tSwap file ststen\n[q]:\tQuit");
		
		while(true) {
			
			input = sc.nextLine();
			
			if(input.equals("C")) {
				System.out.print("File name:\t");
				input = sc.nextLine();
				su.createFile(input);
			} else if(input.equals("D")) {
				System.out.print("File name:\t");
				input = sc.nextLine();
				su.deleteFile(input);
			} else if(input.equals("P")) {
				System.out.print("File name:\t");
				input = sc.nextLine();
				su.readFile(input);
			} else if(input.equals("E")) {
				System.out.print("File name:\t");
				input = sc.nextLine();
				System.out.print("File contents:\t");
				su.writeFile(input,sc.nextLine());
			} else if(input.equals("q")) {
				System.out.println("Quitting...");
			} else if(input.equals("S")) {
				System.out.println("Choose your filesystem...\n[A]:\tArray\n[L]:\tList");
				do {
					input = sc.nextLine();
				} while(!input.equals("A")&&!input.equals("L"));

				if(input.equals("A")) {
					su.setFileSystemType("A");
				} else {
					su.setFileSystemType("L");
				}
			} else if(input.equals("U")) {
				su.printAll();
			} else {
				System.out.println("[C]:\tCreate file\n[D]:\tDelete file\n[P]:\tPrint file\n[E]:\tEdit file\n[U]:\tPrint all files\n[S]:\tSwap file ststen\n[q]:\tQuit");
			}
			
		}
		// end-user-code
	}
}
