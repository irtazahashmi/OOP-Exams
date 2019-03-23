import java.util.Comparator;

public class ProductComparator implements Comparator<Device> {

	@Override
	public int compare(Device d1, Device d2) {
		return d1.getClass().getName().compareTo(d2.getClass().getName());
	}
	

}
