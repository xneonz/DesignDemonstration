import java.io.IOException;
import java.util.Random;
public class Seismograph implements Runnable {
	private AbstractSeismographState currentState;
	private SeismographEncoder seismographEncoder;
	private Thread t;
	private String name;
	private SeismometerClient client;
	
	public Seismograph(String name, double longitude, double latitude, SeismometerClient client, String inetAddress, int port) throws IOException {
		
		this.name = name;
		currentState = new SeismographState(new Coordinates(longitude, latitude));
		this.client = client;
		
		seismographEncoder = new SeismographEncoder(inetAddress, port, name);
		
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		
		Random rn = new Random();
		
		while(true) {
			
			try {
				
				t.sleep(5000L);
				currentState.setReading(10.0 * Math.pow(rn.nextDouble(), 4.0));
				client.displaySeismometer();
				
				seismographEncoder.encode(currentState);
				
			} catch (InterruptedException e) {
				
				
				
			}
			
		}
		
	}
	
	public void start() {
		
		if(t == null) {
			
			t = new Thread(this, name);
			t.start();
			
		}
		
	}
	
	public String toString() {
		
		return name + ": " + currentState.toString();
		
	}
	
	public AbstractSeismographState getState() {
		return null;
	}
}