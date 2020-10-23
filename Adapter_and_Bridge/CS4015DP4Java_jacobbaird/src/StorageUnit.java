/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author jbaird2
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class StorageUnit {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private FileSystem fileSystem;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setFileSystemType(String type) {
		
		if(type.equals("A")) {
			if(fileSystem == null) {
				fileSystem = new ArrayFileSystemImpl();
			} else {
				fileSystem = new ArrayFileSystemImpl(fileSystem.toString());
			}
		} else {
			if(fileSystem == null) {
				fileSystem = new ListFileSystemImpl();
			} else {
				fileSystem = new ListFileSystemImpl(fileSystem.toString());
			}
		}
		
	}
	
	public void createFile(String fileName) {
		// begin-user-code
		// TODO Auto-generated method stub
		if(fileSystem.add(fileName)==1) {
			System.out.println("File created successfully!");
		} else {
			System.out.println("File already exists!");
		}
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void deleteFile(String fileName) {
		// begin-user-code
		// TODO Auto-generated method stub
		if(fileSystem.remove(fileName)==1) {
			System.out.println("File deleted successfully!");
		} else {
			System.out.println("File doesn't exist!");
		}
		// e
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void readFile(String fileName) {
		// begin-user-code
		// TODO Auto-generated method stub
		if(fileSystem.get(fileName)==null) {
			System.out.println("File doesn't exist!");
		} else {
			System.out.println(fileSystem.get(fileName));
		}
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void writeFile(String fileName, String fileContents) {
		// begin-user-code
		// TODO Auto-generated method stub
		if(fileSystem.set(fileName,fileContents)==1) {
			System.out.println("File written successfully!");
		} else {
			System.out.println("File doesn't exist!");
		}
		// end-user-code
	}
	
	public void printAll() {
		System.out.println(fileSystem.toString());
	}
}