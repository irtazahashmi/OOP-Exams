import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BikeCatalog {
	List<Bike> bikes;

	public BikeCatalog() {
		bikes = new ArrayList<Bike>();
	}
	
	public List<Bike> getBikes() {
		return bikes;
	}

	public void setBikes(List<Bike> bikes) {
		this.bikes = bikes;
	}

	public void add(Bike bike) {
		bikes.add(bike);
	}
	
	public static BikeCatalog read(Scanner sc) {
		BikeCatalog result = new BikeCatalog();
		
		while(sc.hasNext()) {
			String bikeType = sc.next();
			if(bikeType.contains("FOLDING")) {
				result.add(FoldingBike.read(sc));
			}
			else if (bikeType.contains("E-SCOOTER")) {
				result.add(EScooter.read(sc));
			}
			else if(bikeType.contains("E-BIKE")) {
				result.add(EBike.read(sc));
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		return result;
	}
	
	
	public String toString() {
		String result = "";
		for (int i = 0; i < bikes.size(); i++) {
			result = result + bikes.get(i).toString() + "\n";
		}
		return result;
	}
	
	
	public void writeToFile(String filename) throws FileNotFoundException {
		
		File newFile = new File (filename);
		PrintWriter output = new PrintWriter(newFile);
		
		for (int i = 0; i < bikes.size(); i++) {
			output.println(bikes.get(i).writeToString());
			System.out.println(bikes.get(i).writeToString());
		}
		output.close();
	}
	
	public static synchronized void sort(BikeCatalog catalog, Comparator<Bike> comparator) {
		Collections.sort(catalog.bikes, comparator);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BikeCatalog)) {
			return false;
		}
		BikeCatalog other = (BikeCatalog) obj;
		if (bikes == null) {
			if (other.bikes != null) {
				return false;
			}
		} else if (!bikes.equals(other.bikes)) {
			return false;
		}
		return true;
	}

	

}
