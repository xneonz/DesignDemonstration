import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

//This class represents a wall

public class MazeWall extends MazeTile {

	public MazeWall() {
		
		BufferedImage icon;
		
		try {
			
			icon = ImageIO.read(new File("wall.png"));
			
		} catch (Exception e) {

			System.out.println("Working Directory = " +
		              System.getProperty("user.dir"));
			icon = null;
			
		}
		
		this.key = 1;
		this.icon = icon;
		this.asciiChar = '#';
		
	}

}