import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Random;

public class SeismographDecoder implements Runnable {
	
	private SeismographStream seismographStream;
	private AbstractSeismographState lastSeismographState;
	private SocketWrapper socketWrapper;
	private Thread t;
	private SMSClient smsClient;
	
	public SeismographDecoder(SMSClient smsClient) {
		
		this.smsClient = smsClient;
		
	}
	
	private void decode(Socket socket) {
		
		BufferedReader input;
		AbstractSeismographState state;
		int length;
		char[] lenChars;
		char[] name;
		char[] lonChars;
		char[] latChars;
		char[] reaChars;
		double longitude;
		double latitude;
		double reading;
		
		smsClient.displaySocketInfo("", "");
		
		try {
			
			lenChars = new char[4];
			
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				
				input.read(lenChars, 0, 4);
				
				length = ByteBuffer.wrap(new byte[] {(byte)lenChars[0], (byte)lenChars[1],
						(byte)lenChars[2], (byte)lenChars[3]}).getInt();
				
				if(lastSeismographState == null) {
					
					name = new char[length];
					lonChars = new char[8];
					latChars = new char[8];
					reaChars = new char[8];
					
					input.read(name, 0, length);
					input.read(lonChars, 0, 8);
					input.read(latChars, 0, 8);
					input.read(reaChars, 0, 8);
					
					longitude = ByteBuffer.wrap(new byte[] {(byte)lonChars[0], (byte)lonChars[1],
							(byte)lonChars[2], (byte)lonChars[3],
							(byte)lonChars[4], (byte)lonChars[5],
							(byte)lonChars[6], (byte)lonChars[7]}).getDouble();
					latitude = ByteBuffer.wrap(new byte[] {(byte)latChars[0], (byte)latChars[1],
							(byte)latChars[2], (byte)latChars[3],
							(byte)latChars[4], (byte)latChars[5],
							(byte)latChars[6], (byte)latChars[7]}).getDouble();
					reading = ByteBuffer.wrap(new byte[] {(byte)reaChars[0], (byte)reaChars[1],
							(byte)reaChars[2], (byte)reaChars[3],
							(byte)reaChars[4], (byte)reaChars[5],
							(byte)reaChars[6], (byte)reaChars[7]}).getDouble();
					
					state = new SeismographState(new Coordinates(longitude, latitude));
					state.setReading(reading);
					lastSeismographState = state;
					
					seismographStream.append(state);
					
					seismographStream.setName(name.toString());
					smsClient.displaySeismographStreams();
					
				} else {

					reaChars = new char[8];

					input.read(reaChars, 0, 8);
					
					reading = ByteBuffer.wrap(new byte[] {(byte)reaChars[0], (byte)reaChars[1],
							(byte)reaChars[2], (byte)reaChars[3],
							(byte)reaChars[4], (byte)reaChars[5],
							(byte)reaChars[6], (byte)reaChars[7]}).getDouble();
					
					state = lastSeismographState.clone();
					state.setReading(reading);
					
					seismographStream.append(state);
					
				}
				
			}
			
		} catch (IOException e) {
			
		}
		
	}
	
	public void setSeismographStream(SeismographStream seismographStream) {
		
		this.seismographStream = seismographStream;
		
	}

	public void run() {
		
		AbstractSocketBuilder socketBuilder;
		ServerSocket serverSocket;
		
		socketBuilder = SocketBuilder.getSocketBuilder();
		socketBuilder.buildSocket();
		socketWrapper = ((SocketBuilder) socketBuilder).getSocket();
		serverSocket = socketWrapper.getSocket();
		
		smsClient.displaySocketInfo(serverSocket.getInetAddress().toString(), Integer.toString(serverSocket.getLocalPort()));
		
		while(true) {
			
			try {
				
				decode(serverSocket.accept());
				
			} catch (IOException e) {
				
				
				
			}
			
		}
		
	}
	
	public void start() {
		
		Random rn;
		rn = new Random();
		
		if(t == null) {
			
			t = new Thread(this, "Thread#" + rn.nextLong());
			t.start();
			
		}
		
	}
	
}