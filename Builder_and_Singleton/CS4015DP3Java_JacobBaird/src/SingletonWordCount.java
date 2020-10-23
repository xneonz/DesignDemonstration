/**
 * 
 */

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.Scanner;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author jbaird2
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SingletonWordCount extends ServiceBuilder {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static ServiceBuilder singletonBuilder;
	
	private SingletonWordCount() {}
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static ServiceBuilder getSingleton() {
		// begin-user-code
		// TODO Auto-generated method stub
		if(singletonBuilder == null) {
			
			singletonBuilder = new SingletonWordCount();
			
		}
		
		return singletonBuilder;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param textFile
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void countWords(String textFile) {
		// begin-user-code
		// TODO Auto-generated method stub
		int wordCount = 0;
		
		try {
		
			BufferedReader br = new BufferedReader(new FileReader(new File(textFile)));
			String line;
			
			while((line = br.readLine()) != null) {
				
				Scanner sc = new Scanner(line);
				
				while(sc.hasNext()) {
					
					wordCount++;
					sc.next();
					
				}
				
			}
			
			FileWriter fw = new FileWriter(new File(textFile.substring(0,textFile.length()-4)+"Z1.txt"));
			
			fw.write(""+wordCount);
			
			System.out.println("Results saved in: " + textFile.substring(0,textFile.length()-4)+"Z1.txt");
			
			fw.close();
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// end-user-code
	}

	@Override
	public void getWordTable(String textFile) {}

	@Override
	public void encryptFile(String textFile) {}
}