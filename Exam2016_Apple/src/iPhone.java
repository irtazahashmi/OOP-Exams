import java.util.Scanner;

public class iPhone extends Device {
	private String modemType;
	private String threeDTechnology;
	
	public iPhone(String modelName, String screenSize, String processor, String modemType, String color, String memory, String threeDTechnology,
			String price) {
		super(modelName, screenSize, processor, color, memory, price);
		this.modemType = modemType;
		this.threeDTechnology = threeDTechnology;
	}
	
	public String getModemType() {
		return modemType;
	}
	public void setModemType(String modemType) {
		this.modemType = modemType;
	}
	public String getThreeDTechnology() {
		return threeDTechnology;
	}
	public void setThreeDTechnology(String threeDTechnology) {
		this.threeDTechnology = threeDTechnology;
	}
	
	public static iPhone read(Scanner sc) {
		String line = sc.nextLine();
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter(", ");
		
		String modelExtra = lineScanner.next();
		String[] extra = modelExtra.split(" ");
		String modelName = extra[1];
		String screenSize = lineScanner.next();
		String processor = lineScanner.next();
		String modemType = lineScanner.next();
		String color = lineScanner.next();
		String memory = lineScanner.next();
		String threeDTechnology = lineScanner.next();
		String price = lineScanner.next();
		
		lineScanner.close();
		return new iPhone(modelName, screenSize, processor, modemType, color, memory, threeDTechnology, price);
	}

	@Override
	public String toString() {
		if(threeDTechnology.contains("TRUE")) {
			return "Apple iPhone " + modelName + " with " + memory + " of memory\n\twith an " + processor +
				" processor and " + screenSize + " inch screen\n\thaving " + modemType + " and 3D Touch Technology\n\t"
						+ price + " euros";
		}
		else {
			return "Apple iPhone " + modelName + " with " + memory + " of memory\n\twith an " + processor +
			" processor and " + screenSize + " inch screen\n\thaving " + modemType + "\n\t" + price + " euros" ;
		}
	}
	
	@Override
	public String writeToString() {
		return "IPHONE " + modelName + ", " + screenSize + ", " + processor + ", " + modemType + ", " + color + ", " + 
				memory + ", " + threeDTechnology + ", " + price;
  	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof iPhone)) {
			return false;
		}
		iPhone other = (iPhone) obj;
		if (modemType == null) {
			if (other.modemType != null) {
				return false;
			}
		} else if (!modemType.equals(other.modemType)) {
			return false;
		}
		if (threeDTechnology == null) {
			if (other.threeDTechnology != null) {
				return false;
			}
		} else if (!threeDTechnology.equals(other.threeDTechnology)) {
			return false;
		}
		return true;
	}
	
}
