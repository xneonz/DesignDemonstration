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
public class ArrayFileSystemImpl extends FileSystemImpl {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private SFile[] files;

	public ArrayFileSystemImpl() {
		files = new SFile[0];
	}

	public ArrayFileSystemImpl(String fs) {
		files = new SFile[0];
		Scanner a = new Scanner(fs);
		a.useDelimiter(",");
		while(a.hasNext()) {
			Scanner b = new Scanner(a.next());
			b.useDelimiter(";");
			SFile s = new SFile(b.next());
			s.setContents(b.next());
			add(s.getName());
			set(s.getName(),s.getContents());
		}
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param fileName
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int add(String fileName) {
		// begin-user-code
		// TODO Auto-generated method stub
		SFile[] temp = new SFile[files.length + 1];
		for(int i = 0; i < files.length; i++) {
			
			if(files[i].getName().equals(fileName)) {
				
				return 0;
				
			}
			
			temp[i] = files[i];
			
		}
		
		temp[files.length] = new SFile(fileName);
		files = temp;
		
		return 1;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param fileName
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int remove(String fileName) {
		// begin-user-code
		// TODO Auto-generated method stub
		if(files.length==0) {
			return 0;
		}

		int foundIndex = -1;

		for(int i = 0; i < files.length; i++) {
			if(files[i].getName().equals(fileName)) {
				foundIndex = i;
			}
		}

		if(foundIndex==-1) {
			return 0;
		}

		SFile[] temp = new SFile[files.length-1];

		for(int i = 0; i < temp.length; i++) {
			if(i >= foundIndex) {
				temp[i] = files[i+1];
			} else {
				temp[i] = files[i];
			}
		}

		files = temp;

		return 1;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param fileName
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String get(String fileName) {
		// begin-user-code
		// TODO Auto-generated method stub
		for(int i = 0; i < files.length; i++) {
			if(files[i].getName().equals(fileName)) {
				return files[i].getContents();
			}
		}
		return null;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param fileName
	 * @param fileContents
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int set(String fileName, String fileContents) {
		// begin-user-code
		// TODO Auto-generated method stub
		for(int i = 0; i < files.length; i++) {
			if(files[i].getName().equals(fileName)) {
				files[i].setContents(fileContents);
				return 1;
			}
		}
		return 0;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String toString() {
		// begin-user-code
		// TODO Auto-generated method stub
		if(files.length==0) {return "";}
		String result = "";
		for(int i = 0; i < files.length; i++) {
			result+=";"+files[i].toString();
		}
		result = result.substring(1);
		return result;
		// end-user-code
	}

}
