import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AppleCatalog {
	List<Device> devices;
	
	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public AppleCatalog() {
		devices = new ArrayList<Device>();
	}
	
	public void addProduct(Device device) {
		devices.add(device);
	}
	
	public static AppleCatalog read(Scanner sc) {
		AppleCatalog result = new AppleCatalog();
		
		while(sc.hasNext()) {
			String deviceType = sc.next();
			
			if(deviceType.contains("IPHONE")) {
				result.addProduct(iPhone.read(sc));
			}
			else if (deviceType.contains("IPAD")) {
				result.addProduct(iPad.read(sc));
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		return result;
	}
	
	public String toString() {
		String result = "";
		for(int i = 0; i < devices.size(); i++) {
			result += devices.get(i).toString() + "\n";
		}
		return result;
	}
	
	public void writeToFile(String filename) throws FileNotFoundException {
		
		File newFile = new File(filename);
		PrintWriter output = new PrintWriter(newFile);
		
		for(int i = 0; i < devices.size(); i++) {
			output.println(devices.get(i).writeToString());
			System.out.println(devices.get(i).writeToString());
		}
		output.close();
	}

	public static synchronized void sort(AppleCatalog catalog, Comparator<Device> comparator) {
		Collections.sort(catalog.devices, comparator);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AppleCatalog)) {
			return false;
		}
		AppleCatalog other = (AppleCatalog) obj;
		if (devices == null) {
			if (other.devices != null) {
				return false;
			}
		} else if (!devices.equals(other.devices)) {
			return false;
		}
		return true;
	}	

}
