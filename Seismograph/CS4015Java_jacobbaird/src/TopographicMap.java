import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TopographicMap extends MapDecorator {
	
	public TopographicMap() {
		
		try {
			
			setImage(ImageIO.read(new File("./src/topographic.png")));
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void drawMap() {
	}
	
	public void draw() {
		
		for(MapVisualizer mapVisualizer : getChildren()) {
			
			mapVisualizer.display();
			
		}
		
	}
}