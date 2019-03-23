
public abstract class Car {
	
	String carType;
	String brandName;
	String modelName;
	String enginePower;
	String price;
	
	
	public Car(String carType, String brandName, String modelName, String enginePower, String price) {
		this.carType = carType;
		this.brandName = brandName;
		this.modelName = modelName;
		this.enginePower = enginePower;
		this.price = price;
	}
	
	public abstract String toString();

	
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Car)) {
			return false;
		}
		Car other = (Car) obj;
		if (brandName == null) {
			if (other.brandName != null) {
				return false;
			}
		} else if (!brandName.equals(other.brandName)) {
			return false;
		}
		if (carType == null) {
			if (other.carType != null) {
				return false;
			}
		} else if (!carType.equals(other.carType)) {
			return false;
		}
		if (enginePower == null) {
			if (other.enginePower != null) {
				return false;
			}
		} else if (!enginePower.equals(other.enginePower)) {
			return false;
		}
		if (modelName == null) {
			if (other.modelName != null) {
				return false;
			}
		} else if (!modelName.equals(other.modelName)) {
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
