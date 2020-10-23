import java.awt.image.BufferedImage;

public abstract class MazeTile {
	
	protected int key;
	protected BufferedImage icon;
	protected char asciiChar;
	
	//Used to query tile objects in tile factory
	public int getKey() {
		
		return key;
		
	}
	
	//Used to render maze in JFrame
	public BufferedImage getIcon() {
		
		return icon;
		
	}

	//Used to render maze in ASCII
	public char getASCII() {
		
		return asciiChar;
		
	}
	
}