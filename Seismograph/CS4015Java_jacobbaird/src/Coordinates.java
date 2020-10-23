public class Coordinates {
	private double longitude;
	private double latitude;
	
	public Coordinates(double longitude, double latitude) {
		
		this.longitude = longitude;
		this.latitude = latitude;
		
	}
	
	public String toString() {
		
		return Double.toString(longitude) + ", " + Double.toString(latitude);
		
	}
	
	public double getLongitude() {
		
		return longitude;
		
	}
	
	public double getLatitude() {
		
		return latitude;
		
	}
	
	public double distance(Coordinates coordinates) {
		
		double xdist;
		double ydist;
		
		xdist = longitude - coordinates.getLongitude();
		ydist = latitude - coordinates.getLatitude();
		
		xdist = Math.pow(xdist, 2);
		ydist = Math.pow(ydist, 2);
		
		return Math.sqrt(xdist + ydist);
		
	}
	
	public static Coordinates centre(PopulationCentre populationCentre) {
		
		Coordinates coordinates;
		Coordinates temp;
		
		double longitude = 0.0;
		double latitude = 0.0;
		
		if(populationCentre.getCoordinates() != null) {
			
			return populationCentre.getCoordinates();
			
		}
		
		for(PopulationCentre pc : populationCentre.getChildren()) {
			
			temp = Coordinates.centre(pc);
			
			longitude += temp.getLongitude();
			latitude += temp.getLatitude();
			
		}
		
		coordinates = new Coordinates(longitude / (double) populationCentre.getChildren().size(), latitude / (double) populationCentre.getChildren().size());
		populationCentre.setCoordinates(coordinates);
		
		return coordinates;
		
	}
}