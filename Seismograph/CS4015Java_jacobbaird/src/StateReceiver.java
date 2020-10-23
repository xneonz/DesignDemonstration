import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class StateReceiver implements Runnable {
	
	private AbstractState currentState;
	private Socket socket;
	private Thread t;
	private WarningStationClient client;
	private DataOutputStream output;
	private BufferedReader input;
	private String populationCentre;
	
	public StateReceiver(WarningStationClient client, String populationCentre) {
		
		currentState = new NormalState();
		this.client = client;
		this.populationCentre = populationCentre;
		start();
		
	}
	
	public String toString() {
		
		return null;
		
	}
	
	public void run() {
		
		String warning;
		
		try {
			
			socket = new Socket(client.getInetAddress(), client.getInetPort());
			
			output = new DataOutputStream(socket.getOutputStream());
			output.writeBytes(client.getSelectedCentre()+"\n");
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
			
				warning = input.readLine();
				
				Scanner sc = new Scanner(warning);
				String type;
				String suggestion;
				String severity;
				sc.useDelimiter(";");
				sc.next();
				
				int code = Integer.parseInt(sc.next());
				double reading = Double.parseDouble(sc.next());
				
				if(code % 2 == 0) {
					
					suggestion = "Please evacuate the area:";
					
				} else {
					
					suggestion = "Please be advised:";
					
				}
				
				if(code > 1) {
					
					type = "earthquake";
					
				} else {
					
					type = "tsunami";
					
				}
				
				if(reading > 9) {
					
					severity = "Major";
					
				} else if(reading > 8) {
					
					severity = "Moderate";
					
				} else {
					
					severity = "Minor";
					
				}
				
				client.displayAlert(suggestion + " " + severity + " " + type + " detected near " + populationCentre + ".");
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void start() {
		
		Random rn = new Random();
		
		if(t == null) {
			
			t = new Thread(this, "Thread#" + Long.toString(rn.nextLong()));
			t.start();
			
		}
		
	}
	
}