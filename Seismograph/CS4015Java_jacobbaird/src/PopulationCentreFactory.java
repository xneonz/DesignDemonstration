import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PopulationCentreFactory {
	private ArrayList<PopulationCentre> populationCentres;
	private ArrayList<String> keys;
	
	public PopulationCentreFactory() throws IOException {
		
		File file = new File("./src/populationcentres.txt");
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		Scanner sc;
		PopulationCentre pc;
		String code;
		String name;
		String population;
		String latitude;
		String longitude;
		String parent;
		
		populationCentres = new ArrayList<PopulationCentre>();
		keys = new ArrayList<String>();
		
		while(fileReader.ready()) {
			
			sc = new Scanner(fileReader.readLine());
			sc.useDelimiter(";");
			
			code = sc.next();
			name = sc.next();
			
			population = sc.next();
			latitude = sc.next();
			longitude = sc.next();
			parent = sc.next();
			
			if(code.equals("co")) {
				
				pc = new Country();
				
			} else if(code.equals("re")) {
				
				pc = new Region();
				
			} else if(code.equals("st")) {
				
				pc = new State();
				
			} else if(code.equals("ct")) {
				
				pc = new County();
				
			} else if(code.equals("ci")) {
				
				pc = new City();
				
			} else if(code.equals("ne")) {
				
				pc = new Neighbourhood();
				
			} else {
				
				pc = null;
				
			}
			
			pc.setKey(name);
			keys.add(name);
			
			if(!latitude.equals(".") && !longitude.equals(".")) {
				
				pc.setCoordinates(new Coordinates(Double.parseDouble(longitude), Double.parseDouble(latitude)));
				
			}
			
			if(!population.equals(".")) {
				
				pc.setPopulation(Long.parseLong(population));
				
			}
			
			if(!parent.equals(".")) {
				
				pc.setParent(getPopulationCentre(parent));
				
			}
			
			sc.close();
			
			populationCentres.add(pc);
			
		}
		
		fileReader.close();
		
	}
	
	public ArrayList<String> getKeys() {
		
		return keys;
		
	}
	
	public PopulationCentre getPopulationCentre(String key) {
		
		for(PopulationCentre populationCentre : populationCentres) {
			
			if(populationCentre.getKey().equals(key)) {
				
				return populationCentre;
				
			}
			
		}
		
		return null;
		
	}
	
}