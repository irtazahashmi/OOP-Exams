import java.util.*;
public class iPad extends Device {
		private String fourGTechnology;
		

	public iPad(String modelName, String screenSize, String processor, String fourGTechnology, String color, String memory, String price) {
		super(modelName, screenSize, processor, color, memory, price);
		this.setFourGTechnology(fourGTechnology);
	}

	public String getFourGTechnology() {
		return fourGTechnology;
	}

	public void setFourGTechnology(String fourGTechnology) {
		this.fourGTechnology = fourGTechnology;
	}
	
	public static iPad read(Scanner sc) {
		String line = sc.nextLine();
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter(", ");
	
		String modelName = lineScanner.next().substring(1);
		String screenSize = lineScanner.next();
		String processor = lineScanner.next();
		String fourGTechnology = lineScanner.next();
		String color = lineScanner.next();
		String memory = lineScanner.next();
		String price = lineScanner.next();
		
		lineScanner.close();
		return new iPad(modelName, screenSize, processor, fourGTechnology, color, memory, price);
		
	}

	@Override
	public String toString() {
		if (fourGTechnology.contains("TRUE")) {
			return	"Apple iPad " + modelName + " with " + memory + " of memory\n\twith an " + processor +
				" processor and " + screenSize + " inch screen\n\thaving WiFi and 4G technology\n\t" 
				+ price + " euros";
		}
		else {
			return	"Apple iPad " + modelName + " with " + memory + " of memory\n\twith an " + processor +
					" processor and " + screenSize + " inch screen\n\thaving WiFi\n\t" 
					+ price + " euros";
		}
	}
	
	@Override
	public String writeToString() {
		return "IPAD " + modelName + ", " + screenSize + ", " + processor + ", " + fourGTechnology + ", " + color + ", " + 
				memory + ", " + price;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof iPad)) {
			return false;
		}
		iPad other = (iPad) obj;
		if (fourGTechnology == null) {
			if (other.fourGTechnology != null) {
				return false;
			}
		} else if (!fourGTechnology.equals(other.fourGTechnology)) {
			return false;
		}
		return true;
	}
	
}
