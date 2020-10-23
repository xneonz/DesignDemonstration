import java.util.Date;
public abstract class AbstractSeismographState {
	private Coordinates coordinates;
	private double reading = 0.0;
	private Date time;
	public abstract AbstractSeismographState clone();
	
	public AbstractSeismographState(Coordinates coordinates) {
		
		this.coordinates = coordinates;
		
	}
	
	public String toString() {
		
		String value;
		
		return coordinates.toString() + " - " + (((value = Double.toString(reading)).length() > 4) ? value.substring(0, 4) : value);
		
	}
	
	public void setTime(Date time) {
		
		this.time = time;
		
	}
	
	public void setReading(double reading) {
		
		this.reading = reading;
		
	}
	
	public Coordinates getCoordinates() {
		
		return coordinates;
		
	}
	
	public Date getTime() {
		
		return time;
		
	}
	
	public double getReading() {
		
		return reading;
		
	}
	
}