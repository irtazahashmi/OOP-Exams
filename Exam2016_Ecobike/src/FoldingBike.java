import java.util.Scanner;

public class FoldingBike extends Bike {
	private String wheelSize;
	private String numberOfGears;
	
	
	
	
	public FoldingBike(String bikeType, String brandName, String wheelSize, String numberOfGears, String bikeWeigth, String lightAvailibility, String color,
			String price) {
		super(bikeType, brandName, bikeWeigth, lightAvailibility, color, price);
		this.wheelSize = wheelSize;
		this.numberOfGears = numberOfGears;
	}

	public String getWheelSize() {
		return wheelSize;
	}

	public void setWheelSize(String wheelSize) {
		this.wheelSize = wheelSize;
	}

	public String getNumberOfGears() {
		return numberOfGears;
	}

	public void setNumberOfGears(String numberOfGears) {
		this.numberOfGears = numberOfGears;
	}
	
	public static FoldingBike read(Scanner sc) {
		String line = sc.nextLine();
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter("; ");
		
		String bikeTypeAndBrandName = lineScanner.next();
		String[] array = bikeTypeAndBrandName.split(" ");
		String bikeType = array[0] + " " + array[1];
		String brandName = array[2];
		String wheelSize = lineScanner.next();
		String numberOfGears = lineScanner.next();
		String bikeWeigth = lineScanner.next();
		String lightAvailibility = lineScanner.next();
		String color = lineScanner.next();
		String price = lineScanner.next();
		
		lineScanner.close();
		return new FoldingBike(bikeType, brandName, wheelSize, numberOfGears, bikeWeigth, lightAvailibility, color, price);
	}
	
	@Override
	public String toString() {
		if(lightAvailibility.contains("FALSE"))
		return "FOLDING" + bikeType + " " + brandName + " with " + numberOfGears + " gear(s) and no head/tail light.\n\t" +
				"Price: " + price + " euros.";
		else {
			return "FOLDING" + bikeType + " " + brandName + " with " + numberOfGears + " gear(s) and head/tail light.\n\t" +
					"Price: " + price + " euros.";
		}
	}
		
	public String writeToString() {
		return "FOLDING" + bikeType + " " + brandName + "; " + wheelSize + "; " + numberOfGears + "; " + bikeWeigth + "; " +
				lightAvailibility + "; " + color + "; " + price;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof FoldingBike)) {
			return false;
		}
		FoldingBike other = (FoldingBike) obj;
		if (numberOfGears == null) {
			if (other.numberOfGears != null) {
				return false;
			}
		} else if (!numberOfGears.equals(other.numberOfGears)) {
			return false;
		}
		if (wheelSize == null) {
			if (other.wheelSize != null) {
				return false;
			}
		} else if (!wheelSize.equals(other.wheelSize)) {
			return false;
		}
		return true;
	}
	
	
	
		
	

}
