import java.util.Comparator;

public class PriceComparator implements Comparator<Device> {

	@Override
	public int compare(Device d1, Device d2) {
		return extractInt(d1.price) - extractInt(d2.price);
	}
	
	 int extractInt(String s) {
	        String num = s.replaceAll("\\D", "");
	        return num.isEmpty() ? 0 : Integer.parseInt(num);   // return 0 if no digits found
	    }

}
