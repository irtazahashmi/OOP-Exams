import java.util.Comparator;

public class Sort extends Thread {
	private CarCatalog carMagazine;
	private Comparator<Car> comparator;

	public Sort(CarCatalog carMagazine, Comparator<Car> comparator) {
		this.carMagazine = carMagazine;
		this.comparator = comparator;
	}

	public void run() {
		CarCatalog.sort(carMagazine, comparator);
		System.out.println(carMagazine);
	}

}
