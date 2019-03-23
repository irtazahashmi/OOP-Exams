
public abstract class Bike {
	String bikeType;
	String brandName;
	String bikeWeigth;
	String lightAvailibility;
	String color;
	String price;
	
	public Bike(String bikeType, String brandName, String bikeWeigth, String lightAvailibility, String color,
			String price) {
		this.bikeType = bikeType;
		this.brandName = brandName;
		this.bikeWeigth = bikeWeigth;
		this.lightAvailibility = lightAvailibility;
		this.color = color;
		this.price = price;
	}
	
	public abstract String toString();
	
	public abstract String writeToString();


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Bike)) {
			return false;
		}
		Bike other = (Bike) obj;
		if (bikeType == null) {
			if (other.bikeType != null) {
				return false;
			}
		} else if (!bikeType.equals(other.bikeType)) {
			return false;
		}
		if (bikeWeigth == null) {
			if (other.bikeWeigth != null) {
				return false;
			}
		} else if (!bikeWeigth.equals(other.bikeWeigth)) {
			return false;
		}
		if (brandName == null) {
			if (other.brandName != null) {
				return false;
			}
		} else if (!brandName.equals(other.brandName)) {
			return false;
		}
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (lightAvailibility == null) {
			if (other.lightAvailibility != null) {
				return false;
			}
		} else if (!lightAvailibility.equals(other.lightAvailibility)) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		return true;
	}

	
	
	
}
