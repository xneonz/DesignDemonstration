import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketBuilder extends AbstractSocketBuilder {
	
	private static AbstractSocketBuilder socketBuilder;
	
	private static List<ServerSocket> sockets;
	
	private SocketWrapper socketWrapper;
	
	public SocketBuilder() {
		
		addSockets(10);
		
	}
	
	private void addSockets(int count) {
		
		if(sockets == null) {
			
			sockets = new ArrayList<ServerSocket>();
			
		}
		
		for(int i = 0; i < count; i++) {
			
			try {
				
				sockets.add(new ServerSocket(0));
				
			} catch (IOException e) {}
			
		}
		
	}
	
	public static AbstractSocketBuilder getSocketBuilder() {
		
		if(socketBuilder == null) {
			
			socketBuilder = new SocketBuilder();
			
		}
		
		return socketBuilder;
		
	}
	
	public void buildSocket() {
		
		ServerSocket socket = sockets.get(0);
		sockets.remove(0);
		
		socketWrapper = new SocketWrapper(socket);
		
	}
	
	public SocketWrapper getSocket() {
		
		return socketWrapper;
		
	}
	
}