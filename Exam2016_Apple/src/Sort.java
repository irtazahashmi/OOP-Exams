import java.util.Comparator;

public class Sort extends Thread {
	private AppleCatalog catalog;
	private Comparator<Device> comparator;
	
	public Sort(AppleCatalog catalog, Comparator<Device> comparator) {
		this.catalog = catalog;
		this.comparator = comparator;
	}
	
	public void run() {
		AppleCatalog.sort(catalog, comparator);
		System.out.println(catalog);
	}
	
	

}
