import java.awt.Color;
import java.awt.image.BufferedImage;

public class PopulationCentreComponent extends MapVisualizer {
	
	private String key;
	private PopulationCentreFactory populationCentreFactory;
	
	public PopulationCentreComponent(PopulationCentreFactory populationCentreFactory, String key) {
		
		this.key = key;
		this.populationCentreFactory = populationCentreFactory;
		
	}
	
	public void display() {
		
		PopulationCentre populationCentre = populationCentreFactory.getPopulationCentre(key);
		BufferedImage map = getImage();
		Coordinates.centre(populationCentre);
		double width = map.getWidth();
		double height = map.getHeight();
		double longitude = populationCentre.getCoordinates().getLongitude();
		double latitude = populationCentre.getCoordinates().getLatitude();
		double xpos = 1.25 * (longitude / 180.0) * (width / 2.0) + (width / 2.0);
		double ypos = (latitude / 90.0) * (height / 2.0) + (height / 2.0);
		int size = 5;
		
		for(int i = 0; i < size; i++) {
			
			for(int j = 0; j < size; j++) {
				
				map.setRGB((int) xpos + i - size / 2, (int) height - (int) ypos + j - size / 2, Color.CYAN.getRGB());
				
			}
			
		}
		
	}
	
}