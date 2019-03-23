import java.util.Comparator;

public class Sort extends Thread{
	private BikeCatalog catalog;
	private Comparator<Bike> comparator;
	
	public Sort(BikeCatalog catalog, Comparator<Bike> comparator) {
		this.catalog = catalog;
		this.comparator = comparator;
	}
	
	public void run() {
		BikeCatalog.sort(catalog, comparator);
		System.out.println("Sorting is being implemented...\n");
		System.out.println(catalog);	
	}
}
