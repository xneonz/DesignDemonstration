/*
 * Exception thrown under the following condition:
 * -A number contains a non-null left or right node
 * -An operator contains a null left or right node
 * -Dividing by zero
 */

public class InvalidExpressionException extends Exception {
	private static final long serialVersionUID = 372759265645402580L;

	public String getMessage() {
		return "Invalid expression!";
	}
}