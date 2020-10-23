public abstract class AbstractEarthquakeAlert {
	
	private double severity;

	public String encode() {
		
		return Integer.toString(getCodeLength()) + ";" + Integer.toString(getAlertType()) + ";" + Double.toString(getSeverity());

	}

	public abstract int getCodeLength();

	public abstract int getAlertType();

	public double getSeverity() {
		return severity;
	}

	public void setSeverity(double severity) {
		this.severity = severity;
	}
}