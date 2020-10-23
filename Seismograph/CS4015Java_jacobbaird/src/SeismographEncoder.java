import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SeismographEncoder {
	
	boolean first;
	Socket socket;
	DataOutputStream output;
	String name;
	
	public SeismographEncoder(String inetAddress, int port, String name) throws IOException {
		
		first = true;
		socket = new Socket(inetAddress, port);
		output = new DataOutputStream(socket.getOutputStream());
		this.name = name;
		
	}
	
	public void encode(AbstractSeismographState state) {
		
		double longitude;
		double latitude;
		double reading;
		
		try {
			
			reading = state.getReading();
		
			if(first) {
				
				longitude = state.getCoordinates().getLongitude();
				latitude = state.getCoordinates().getLatitude();
			
				output.writeInt(name.length());
				output.writeBytes(name);
				output.writeDouble(longitude);
				output.writeDouble(latitude);
				output.writeDouble(reading);
			
			} else {

				output.writeInt(0);
				output.writeDouble(reading);
			
			}
			
		} catch (IOException e) {}
		
		first = false;
		
	}
}