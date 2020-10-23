import java.util.HashMap;
import java.util.Set;
public class WarnerPopulationCentreVisitor extends AbstractPopulationCentreVisitor {
	private HashMap warnedPopulationCentres;
	private Coordinates coordinates;
	private Set<Coordinates> coordinates2;
	public void visitLeafPopulationCentre(PopulationCentre populationCentre) {
	}
	public void visitNodePopulationCentre(PopulationCentre populationCentre) {
	}
	public HashMap getResult() {
		return null;
	}
}