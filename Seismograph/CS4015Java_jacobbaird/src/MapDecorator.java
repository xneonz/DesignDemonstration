import java.util.ArrayList;

public abstract class MapDecorator extends MapVisualizer {
	
	private ArrayList<MapVisualizer> children;
	
	public void display() {
		
		for(MapVisualizer mapVisualizer : children) {
			
			mapVisualizer.display();
			
		}
		
	}
	
	public void addChild(MapVisualizer mapVisualizer) {
		
		if(children == null) {
			
			children = new ArrayList<MapVisualizer>();
			
		}
		
		children.add(mapVisualizer);
		mapVisualizer.setImage(getImage());
		
	}
	
	public ArrayList<MapVisualizer> getChildren() {
		
		return children;
		
	}
	
}