import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CarCatalog {
	ArrayList<Car> cars;
	
	
	public CarCatalog() {
		cars = new ArrayList<Car>();
	}
	
	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}


	public void add(Car aCar) {
		cars.add(aCar);
	}
	
	
	public static CarCatalog read(Scanner input) {
		CarCatalog result = new CarCatalog();
		
		while(input.hasNext()) {
			String carType = input.next();
			if (carType.startsWith("E")) {
				result.add(ElectricCar.read(input));
			}
			else if (carType.startsWith("G")) {
				result.add(GasCar.read(input));
			}
			else if (carType.startsWith("H")) {
				result.add(HybridCar.read(input));
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		return result;
	}
	
	
	public String toString() {
		String result = "";
		for (int i = 0; i < cars.size(); i++) {
			result = result + cars.get(i).toString() + "\n";
		}
		return result;
	}
	
	
	public void writeToFile(String filename) throws FileNotFoundException {
		
		File newFile = new File(filename);
		PrintWriter output = new PrintWriter(newFile);
		
		for(int i = 0; i < cars.size(); i++) {
			
			output.println(cars.get(i).toString());
			System.out.println(cars.get(i).toString());
		}
		output.close();		
	}
	
	
	public static synchronized void sort(CarCatalog carMagazine, Comparator<Car> comparator) {
		Collections.sort(carMagazine.cars, comparator);
	}

	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CarCatalog)) {
			return false;
		}
		CarCatalog other = (CarCatalog) obj;
		if (cars == null) {
			if (other.cars != null) {
				return false;
			}
		} else if (!cars.equals(other.cars)) {
			return false;
		}
		return true;
	}	
	
}
