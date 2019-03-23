import java.util.Comparator;

public class PriceComparator implements Comparator<Bike> {

	@Override
	public int compare(Bike b1, Bike b2) {
		return extractInt(b1.price) - extractInt(b2.price);
	}
	
	 int extractInt(String s) {
	        String num = s.replaceAll("\\D", "");
	        return num.isEmpty() ? 0 : Integer.parseInt(num);   // return 0 if no digits found
	    }
}
