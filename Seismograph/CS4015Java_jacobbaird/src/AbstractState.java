
import java.util.Set;
public class AbstractState {
	private long duration;
	private Object stateReceiver;
	private AlertType alertType;
	public void receiveState() {
	}
	public void downgrade() {
	}
	public String getSeverity() {
		return null;
	}
	public String getAdvisory() {
		return null;
	}
}