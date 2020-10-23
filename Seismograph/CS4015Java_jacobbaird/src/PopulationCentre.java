import java.util.ArrayList;

public abstract class PopulationCentre {
	
	private ArrayList<PopulationCentre> children = new ArrayList<PopulationCentre>();
	private PopulationCentre parent;
	private String key;
	private long population = 0;
	private Coordinates coordinates;
	
	public String toString() {
		
		return key + ((parent != null) ? ", " + parent.getKey() : "") + ": " + Coordinates.centre(this).toString() + " - " + Double.toString(population);
		
	}
	
	public String getKey() {
		return key;
	}
	
	public void acceptVisitor(AbstractPopulationCentreVisitor visitor) {
	}
	
	public long getPopulation() {
		
		return population;

	}
	
	public void setPopulation(long population) {
		
		this.population = population;
		
	}
	
	public void setCoordinates(Coordinates coordinates) {
		
		this.coordinates = coordinates;
		
	}
	
	public Coordinates getCoordinates() {
		
		return coordinates;
		
	}
	
	public void setKey(String key) {
		
		this.key = key;
		
	}
	
	public void setParent(PopulationCentre parent) {
		
		this.parent = parent;
		parent.addChild(this);
		
	}
	
	public PopulationCentre getParent() {
		
		return parent;
		
	}
	
	public void addChild(PopulationCentre child) {
		
		children.add(child);
		
	}
	
	public ArrayList<PopulationCentre> getChildren() {
		
		return children;
		
	}
	
}