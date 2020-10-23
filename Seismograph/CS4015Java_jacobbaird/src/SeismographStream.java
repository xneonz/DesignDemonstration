import java.util.ArrayList;
public class SeismographStream {
	
	private ArrayList<AbstractSeismographState> seismographStates;
	private int index;
	private String name;
	
	public SeismographStream(SMSClient smsClient) {
		
		seismographStates = new ArrayList<AbstractSeismographState>();
		
		SeismographDecoder seismographDecoder = new SeismographDecoder(smsClient);
		seismographDecoder.setSeismographStream(this);
		seismographDecoder.start();
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void append(AbstractSeismographState state) {
		
		seismographStates.add(state);
		
	}
	
	public AbstractSeismographState getNextState() {
		
		AbstractSeismographState state;
		
		if(index >= seismographStates.size()) {
			
			return null;
			
		} else {
			
			state = getState(index);
			index++;
			return state;
			
		}
	}
	
	public AbstractSeismographState getFinalState() {
		
		if(seismographStates.size() == 0) {
			
			return null;
			
		} else {
			
			return seismographStates.get(seismographStates.size() - 1);
			
		}
		
	}
	
	public AbstractSeismographState getState(int i) {
		
		if (i < 0) {
		
			return null;
		
		} else if(i >= seismographStates.size()) {
			
			return null;
			
		} else {
			
			return seismographStates.get(i);
			
		}
		
	}
	
	public AbstractSeismographState getFirstState() {
		
		if(seismographStates.size() > 0) {
			
			return seismographStates.get(0);
			
		} else {
			
			return null;
			
		}
		
	}
}