import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

//This class represents an empty space

public class MazeSpace extends MazeTile {
	
	public MazeSpace() {
		
		BufferedImage icon;
		
		try {
			
			icon = ImageIO.read(new File("space.png"));
			
		} catch (Exception e) {

			System.out.println("Working Directory = " +
		              System.getProperty("user.dir"));
			icon = null;
			
		}
		
		this.key = 0;
		this.icon = icon;
		this.asciiChar = ' ';
		
	}
	
}