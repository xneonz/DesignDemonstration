public class SeismographState extends AbstractSeismographState {
	
	public SeismographState(Coordinates coordinates) {
		
		super(coordinates);
		
	}
	
	public AbstractSeismographState clone() {
		return new SeismographState(this.getCoordinates());
	}
}