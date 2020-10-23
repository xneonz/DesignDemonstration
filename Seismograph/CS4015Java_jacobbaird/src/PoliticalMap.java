import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PoliticalMap extends MapDecorator {
	
	public PoliticalMap() {
		
		try {
			
			setImage(ImageIO.read(new File("./src/political.png")));
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void drawMap() {
	}
	public void draw() {
	}
}