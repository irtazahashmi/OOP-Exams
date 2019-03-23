import java.util.Comparator;

public class TypeComparator implements Comparator<Car> {

	@Override
	public int compare(Car c1, Car c2) {
		return c1.getClass().getName().compareTo(c2.getClass().getName());
	}

}


