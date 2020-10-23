/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author jbaird2
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ConcreteTimestamp1 extends Timestamp {
	public ConcreteTimestamp1(long elapsedTime) {
		super(elapsedTime);
	}
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void displayTime() {
		// begin-user-code
		// TODO Auto-generated method stub
		long hours;
		long minutes;
		long seconds;
		String hh;
		String mm;
		String ss;
		hours = elapsedTime / 3600000;
		elapsedTime %= 3600000;
		minutes = elapsedTime / 60000;
		elapsedTime %= 60000;
		seconds = elapsedTime / 1000;
		if (hours < 10) {
			hh = "0"+hours;
		} else {
			hh = ""+hours;
		}
		if (minutes < 10) {
			mm = "0"+minutes;
		} else {
			mm = ""+minutes;
		}
		if (seconds < 10) {
			ss = "0"+seconds;
		} else {
			ss = ""+seconds;
		}
		System.out.println(hh+":"+mm+":"+ss);
		// end-user-code
	}
}