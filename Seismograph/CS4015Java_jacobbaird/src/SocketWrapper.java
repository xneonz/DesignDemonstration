import java.net.ServerSocket;
import java.net.Socket;

public class SocketWrapper {
	
	private ServerSocket socket;
	
	public SocketWrapper(ServerSocket socket) {
		
		this.socket = socket;
		
	}
	
	public ServerSocket getSocket() {
		
		return socket;
		
	}
}