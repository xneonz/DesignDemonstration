public class SocketDirector {
	
	public SocketWrapper constructSocket() {
		
		SocketWrapper socketWrapper;
		
		SocketBuilder.getSocketBuilder().buildSocket();
		socketWrapper = ((SocketBuilder) SocketBuilder.getSocketBuilder()).getSocket();
		
		return socketWrapper;
		
	}
	
}