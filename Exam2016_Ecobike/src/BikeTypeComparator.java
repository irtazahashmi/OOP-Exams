import java.util.Comparator;

public class BikeTypeComparator implements Comparator<Bike> {


	@Override
	public int compare(Bike b1, Bike b2) {
		return b1.getClass().getName().compareTo(b2.getClass().getName());
	}

}
