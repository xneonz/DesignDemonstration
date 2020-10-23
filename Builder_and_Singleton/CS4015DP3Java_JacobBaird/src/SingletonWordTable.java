/**
 * 
 */

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author jbaird2
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SingletonWordTable extends ServiceBuilder {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static ServiceBuilder singletonBuilder;
	
	private SingletonWordTable() {}
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
			
			singletonBuilder = new SingletonWordTable();
			
		}
		
		return singletonBuilder;
		// end-user-code
	}

	@Override
	public void countWords(String textFile) {}

	@Override
	public void getWordTable(String textFile) {
		
		try {
			
			HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
			String line;
			BufferedReader br = new BufferedReader(new FileReader(new File(textFile)));
			
			while((line = br.readLine()) != null) {
				
				Scanner sc = new Scanner(line);
				
				while(sc.hasNext()) {
					
					String word = sc.next().toLowerCase();
					
					if(wordMap.containsKey(word)) {
						wordMap.put(word, wordMap.get(word)+1);
					} else {
						wordMap.put(word, 1);
					}
					
				}
				
			}
			
			FileWriter fw = new FileWriter(new File(textFile.substring(0,textFile.length()-4)+"Z2.txt"));
			
			for(String key : wordMap.keySet()) {
				
				fw.write(key + " : " + wordMap.get(key) + "\n");
				
			}
			
			System.out.println("Results saved in: " + textFile.substring(0,textFile.length()-4)+"Z2.txt");
			
			fw.close();
			br.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void encryptFile(String textFile) {
		// TODO Auto-generated method stub
		
	}
}