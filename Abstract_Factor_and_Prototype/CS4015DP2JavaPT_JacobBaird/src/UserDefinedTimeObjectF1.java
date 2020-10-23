/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author jbaird2
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class UserDefinedTimeObjectF1 extends UserDefinedTimeObject {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public UserDefinedTimeObject clone() {
		// begin-user-code
		// TODO Auto-generated method stub
		return new UserDefinedTimeObjectF1();
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void displayTime(long time) {
		// begin-user-code
		// TODO Auto-generated method stub
		long hours = time / (3600*1000);
		time %= (3600*1000);
		long minutes = time / (60*1000);
		time %= (60*1000);
		long seconds = time / 1000;
		String output = ""+hours;
		output += (minutes >= 10L) ? (":"+minutes) : (":0"+minutes);
		output += (seconds >= 10L) ? (":"+seconds) : (":0"+seconds);
		System.out.println(output);
		// end-user-code
	}
}