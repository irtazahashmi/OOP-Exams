import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class AppleCatalogTest {

	@Test
	void getDevicesTest() {
		iPad ipad = new iPad("AIR 2", "9.7", "A8", "TRUE", "SILVER", "64GB", "400");
		iPhone iphone = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "TRUE", "700");
		List<Device> devices = new ArrayList<Device>();
		devices.add(iphone);
		devices.add(ipad);
		AppleCatalog catalog = new AppleCatalog();
		catalog.addProduct(iphone);
		catalog.addProduct(ipad);
		assertEquals(devices, catalog.getDevices());
	}
	
	@Test 
	void setDevicesTest() {
		iPad ipad = new iPad("AIR 2", "9.7", "A8", "TRUE", "SILVER", "64GB", "400");
		iPhone iphone = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "TRUE", "700");
		List<Device> devices = new ArrayList<Device>();
		devices.add(iphone);
		devices.add(ipad);
		AppleCatalog catalog = new AppleCatalog();
		catalog.setDevices(devices);
		assertEquals(catalog.getDevices(), devices);
	}
	
	@Test 
	void addProductTest() {
		iPhone iphone = new iPhone("7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "TRUE", "700");
		AppleCatalog catalog = new AppleCatalog();
		catalog.addProduct(iphone);
		String expected = "Apple iPhone 7 with 32GB of memory\n" + 
				"	with an A10 processor and 4.7 inch screen\n" + 
				"	having GSM and 3D Touch Technology\n" + 
				"	700 euros\n";
		assertEquals(catalog.toString(), expected);
	}
	
	@Test 
	void toStringTest() {
		iPad ipad = new iPad("AIR 2", "9.7", "A8", "TRUE", "SILVER", "64GB", "400");
		iPhone iphone = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "TRUE", "700");
		List<Device> devices = new ArrayList<Device>();
		devices.add(iphone);
		devices.add(ipad);
		String expected = "[Apple iPhone IPHONE 7 with 32GB of memory\n" + 
				"	with an A10 processor and 4.7 inch screen\n" + 
				"	having GSM and 3D Touch Technology\n" + 
				"	700 euros, Apple iPad AIR 2 with 64GB of memory\n" + 
				"	with an A8 processor and 9.7 inch screen\n" + 
				"	having WiFi and 4G technology\n" + 
				"	400 euros]";
		assertEquals(devices.toString(), expected);
	}

}
