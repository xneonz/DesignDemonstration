public class WarningStation {

	private StateReceiver stateReceiver;
	private String populationCentre;
	
	public WarningStation(WarningStationClient client) {
		
		this.populationCentre = client.getSelectedCentre();
		this.stateReceiver = new StateReceiver(client, populationCentre);
		
	}
	
	public String toString() {
		
		return populationCentre;
		
	}
	
}