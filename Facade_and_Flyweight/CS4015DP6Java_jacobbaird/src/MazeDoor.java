import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

//This class represents a door

public class MazeDoor extends MazeTile {
	
	public MazeDoor() {
		
		BufferedImage icon;
		
		try {
			
			icon = ImageIO.read(new File("door.png"));
			
		} catch (Exception e) {
			
			System.out.println("Working Directory = " +
		              System.getProperty("user.dir"));
			icon = null;
			
		}
			
		this.key = 2;
		this.icon = icon;
		this.asciiChar = 'E';
		
	}
	
}