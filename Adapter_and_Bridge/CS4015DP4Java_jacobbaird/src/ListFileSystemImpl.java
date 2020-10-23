/**
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author jbaird2
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ListFileSystemImpl extends FileSystemImpl {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ArrayList<SFile> files;

	public ListFileSystemImpl() {
		files = new ArrayList<SFile>();
	}

	public ListFileSystemImpl(String fs) {
		files = new ArrayList<SFile>();
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
	 * @param success
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int add(String fileName) {
		// begin-user-code
		// TODO Auto-generated method stub
		for(SFile f : files) {

			if(f.getName().equals(fileName)) {return 0;}

		}

		SFile newFile = new SFile(fileName);
		files.add(newFile);
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
		for(SFile f : files) {

			if(f.getName().equals(fileName)) {files.remove(f);return 1;}

		}

		return 0;
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
		for(SFile f : files) {

			if(f.getName().equals(fileName)) {return f.getContents();}

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
		for(SFile f : files) {

			if(f.getName().equals(fileName)) {f.setContents(fileContents); return 1;}

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
		if(files.size() == 0) {return "";}
		String output = "";
		for(SFile s : files) {output+=";"+s.toString();}
		return output.substring(1);
		// end-user-code
	}
}
