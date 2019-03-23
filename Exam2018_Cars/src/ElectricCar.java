import java.util.Scanner;

public class ElectricCar extends Car {
	private String batteryCapacity;
	
	
	public ElectricCar(String carType, String brandName, String modelName, String enginePower, String batteryCapacity, String price) {
		super(carType, brandName, modelName, enginePower, price);
		this.batteryCapacity = batteryCapacity;
	}

	public String getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	
	public static ElectricCar read(Scanner input) {
		
		String line = input.nextLine();
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter(", ");
		
		String carTypeAndBrand = lineScanner.next();
		String split[] = carTypeAndBrand.split(" ");
		String carType = split[0];
		String brandName = split[1];
		String modelName = lineScanner.next();
		String enginePower = lineScanner.next();
		String batteryCapacity = lineScanner.next();
		String price = lineScanner.next();
		
		lineScanner.close();
		return new ElectricCar (carType, brandName, modelName, enginePower, batteryCapacity, price);
	}
	
	
	@Override
	public String toString() {
		return "ELECTRIC_CAR" + carType + " " + brandName + ", "  + modelName + ", "  + enginePower + ", "  + batteryCapacity + ", " + price;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof ElectricCar)) {
			return false;
		}
		ElectricCar other = (ElectricCar) obj;
		if (batteryCapacity == null) {
			if (other.batteryCapacity != null) {
				return false;
			}
		} else if (!batteryCapacity.equals(other.batteryCapacity)) {
			return false;
		}
		return true;
	}

}
