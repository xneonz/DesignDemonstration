import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author jbaird2
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SingletonEncryption extends ServiceBuilder {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static ServiceBuilder singletonBuilder;

	private SingletonEncryption() {}
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
			
			singletonBuilder = new SingletonEncryption();
			
		}
		
		return singletonBuilder;
		// end-user-code
	}

	@Override
	public void countWords(String textFile) {}

	@Override
	public void getWordTable(String textFile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void encryptFile(String textFile) {
		try {
			
			int[] cypher = {5,2,1,6,3,0,4};
			
			LinkedList<String> wordList = new LinkedList<String>();
			LinkedList<String> fileList = new LinkedList<String>();
			String line;
			BufferedReader br = new BufferedReader(new FileReader(new File(textFile)));
			
			while((line = br.readLine()) != null) {
				
				Scanner sc = new Scanner(line);
				
				while(sc.hasNext()) {
					
					String word = sc.next().toLowerCase();
					
					fileList.add(word);
					
					if(wordList.contains(word)) {
						wordList.add(word);
					} else {
						wordList.add(word);
					}
					
				}
				
			}
			
			while(fileList.size()<7) {
				
				fileList.add("");
				
			}
			
			while(wordList.size()<7) {
				
				wordList.add("");
				
			}
			
			FileWriter fw = new FileWriter(new File(textFile.substring(0,textFile.length()-4)+"Z3.txt"));
			
			for(int i = 0; i < fileList.size(); i++) {
				
				int wordIndex = cypher[(wordList.indexOf(fileList.get(i)) % 7)];
				fw.write(fileList.get(wordIndex) + " ");
				
			}
			
			System.out.println("Results saved in: " + textFile.substring(0,textFile.length()-4)+"Z3.txt");
			
			fw.close();
			br.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
}