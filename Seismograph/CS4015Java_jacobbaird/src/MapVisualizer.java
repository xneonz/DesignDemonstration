import java.awt.image.BufferedImage;

public abstract class MapVisualizer {
	
	private BufferedImage image;
	
	public BufferedImage getImage() {
		
		return image;
		
	}
	
	public void setImage(BufferedImage image) {
		
		this.image = image;
		
	}
	
	public abstract void display();
}