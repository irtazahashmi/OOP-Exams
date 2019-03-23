
public abstract class Device {
	String modelName;
	String screenSize;
	String processor;
	String color;
	String memory;
	String price;
	
	
	public Device(String modelName, String screenSize, String processor, String color,
			String memory, String price) {
		super();
		this.modelName = modelName;
		this.screenSize = screenSize;
		this.processor = processor;
		this.color = color;
		this.memory = memory;
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
		if (!(obj instanceof Device)) {
			return false;
		}
		Device other = (Device) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (memory == null) {
			if (other.memory != null) {
				return false;
			}
		} else if (!memory.equals(other.memory)) {
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
		if (processor == null) {
			if (other.processor != null) {
				return false;
			}
		} else if (!processor.equals(other.processor)) {
			return false;
		}
		if (screenSize == null) {
			if (other.screenSize != null) {
				return false;
			}
		} else if (!screenSize.equals(other.screenSize)) {
			return false;
		}
		return true;
	}

	
	
	
	
	
	
	
	
}
