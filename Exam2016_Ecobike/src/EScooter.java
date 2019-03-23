import java.util.Scanner;

public class EScooter extends Bike {
	private String maximumSpeed;
	private String batteryCapacity;

	public EScooter(String bikeType, String brandName, String maximumSpeed, String bikeWeigth, String lightAvailibility, String batteryCapacity, String color,
			String price) {
		super(bikeType, brandName, bikeWeigth, lightAvailibility, color, price);
		this.setMaximumSpeed(maximumSpeed);
		this.setBatteryCapacity(batteryCapacity);
	}

	public String getMaximumSpeed() {
		return maximumSpeed;
	}

	public void setMaximumSpeed(String maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}

	public String getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
	public static EScooter read(Scanner sc) {
		String line = sc.nextLine();
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter("; ");
		
		String bikeTypeAndBrandName = lineScanner.next();
		String[] array = bikeTypeAndBrandName.split(" ");
		String bikeType = array[0];
		String brandName = array[1];
		String maximumSpeed = lineScanner.next();
		String bikeWeigth = lineScanner.next();
		String lightAvailibility = lineScanner.next();
		String batteryCapacity = lineScanner.next();
		String color = lineScanner.next();
		String price = lineScanner.next();
		
		lineScanner.close();
		return new EScooter(bikeType, brandName, maximumSpeed, bikeWeigth, lightAvailibility, batteryCapacity, color, price);
	}
	
	@Override
	public String toString() {
		if(lightAvailibility.contains("FALSE"))
			return "E-SCOOTER" + bikeType + " " + brandName + " with " + batteryCapacity + " mAh battery and no head/tail light.\n\t" +
					"Price: " + price + "euros.";
			else {
				return "E-SCOOTER" + bikeType + " " + brandName + " with " + batteryCapacity + " mAh battery and head/tail light.\n\t" +
						"Price: " + price + "euros.";
			}
	}
	
	public String writeToString() {
		return "E-SCOOTER" + bikeType + " " + brandName + "; " + maximumSpeed + "; " + bikeWeigth + "; " +
				lightAvailibility + "; " + batteryCapacity + "; " + color + "; " + price;
	}

	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EScooter)) {
			return false;
		}
		EScooter other = (EScooter) obj;
		if (batteryCapacity == null) {
			if (other.batteryCapacity != null) {
				return false;
			}
		} else if (!batteryCapacity.equals(other.batteryCapacity)) {
			return false;
		}
		if (maximumSpeed == null) {
			if (other.maximumSpeed != null) {
				return false;
			}
		} else if (!maximumSpeed.equals(other.maximumSpeed)) {
			return false;
		}
		return true;
	}

}
