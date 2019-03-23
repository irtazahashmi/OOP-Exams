import java.util.Scanner;

public class GasCar extends Car {
	private String engineDisplacement;
	
	
	public GasCar(String carType, String brandName, String modelName, String engineDisplacement, String enginePower, String price) {
		super(carType, brandName, modelName, enginePower, price);
		this.setEngineDisplacement(engineDisplacement);
	}

	public String getEngineDisplacement() {
		return engineDisplacement;
	}

	public void setEngineDisplacement(String engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
	}
	
	
	public static GasCar read(Scanner input) {
		
		String line = input.nextLine();
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter(", ");
		
		String carTypeAndBrand = lineScanner.next();
		String split[] = carTypeAndBrand.split(" ");
		String carType = split[0];
		String brandName = split[1];
		String modelName = lineScanner.next();
		String engineDisplacement = lineScanner.next();
		String enginePower = lineScanner.next();
		String price = lineScanner.next();
		
		lineScanner.close();
		return new GasCar (carType, brandName, modelName, engineDisplacement, enginePower, price);
	}
	
	
	
	@Override
	public String toString() {
		return "GAS_CAR" + carType + " " + brandName + ", "  + modelName + ", " + engineDisplacement + ", " + enginePower + ", " + price;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof GasCar)) {
			return false;
		}
		GasCar other = (GasCar) obj;
		if (engineDisplacement == null) {
			if (other.engineDisplacement != null) {
				return false;
			}
		} else if (!engineDisplacement.equals(other.engineDisplacement)) {
			return false;
		}
		return true;
	}

}
