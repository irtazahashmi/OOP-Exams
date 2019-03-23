import java.util.Scanner;

public class HybridCar extends Car {
	private String engineDisplacement;
	private String batteryCapacity;

	public HybridCar(String carType, String brandName, String modelName, String engineDisplacement, String enginePower, String batteryCapacity, String price) {
		super(carType, brandName, modelName, enginePower, price);
		this.engineDisplacement = engineDisplacement;
		this.batteryCapacity = batteryCapacity;
	}
	
	public String getEngineDisplacement() {
		return engineDisplacement;
	}

	public void setEngineDisplacement(String engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
	}

	public String getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
	public static HybridCar read(Scanner input) {
		
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
		String batteryCapacity = lineScanner.next();
		String price = lineScanner.next();
		
		lineScanner.close();
		return new HybridCar (carType, brandName, modelName, engineDisplacement, enginePower, batteryCapacity, price);
	}


	@Override
	public String toString() {
		return "HYBRID_CAR" + carType + " " + brandName + ", "  + modelName + ", "  + engineDisplacement + ", "  + enginePower + ", " + batteryCapacity + ", " + price;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof HybridCar)) {
			return false;
		}
		HybridCar other = (HybridCar) obj;
		if (batteryCapacity == null) {
			if (other.batteryCapacity != null) {
				return false;
			}
		} else if (!batteryCapacity.equals(other.batteryCapacity)) {
			return false;
		}
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
