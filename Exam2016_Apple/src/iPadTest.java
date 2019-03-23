import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class iPadTest {

	@Test
	void with4GTechtoStringTest() {
		iPad i = new iPad("AIR 2", "9.7", "A8", "TRUE", "SILVER", "64GB", "400");
		String expected = "Apple iPad AIR 2 with 64GB of memory\n\twith an A8 processor and 9.7 "
				+ "inch screen\n\thaving WiFi and 4G technology\n\t400 euros";
		assertEquals(i.toString(), expected);
	}
	
	@Test
	void without4GTechtoStringTest() {
		iPad i = new iPad("AIR 2", "9.7", "A8", "FALSE", "SILVER", "64GB", "400");
		String expected = "Apple iPad AIR 2 with 64GB of memory\n\twith an A8 processor and 9.7 "
				+ "inch screen\n\thaving WiFi\n\t400 euros";
		assertEquals(i.toString(), expected);
	}
	
	@Test
	void readTest() {
		String readLine = " AIR 2, 9.7, A8, TRUE, SILVER, 64GB, 400";
		Scanner sc = new Scanner(readLine);
		iPad i = iPad.read(sc);
		iPad i2 = new iPad("AIR 2", "9.7", "A8", "TRUE", "SILVER", "64GB", "400");
		assertEquals(i, i2);
	}
	
	@Test
	void writeToStringTest() {
		iPad i = new iPad("AIR 2", "9.7", "A8", "TRUE", "SILVER", "64GB", "400");
		String expected = "IPAD AIR 2, 9.7, A8, TRUE, SILVER, 64GB, 400";
		assertEquals(i.writeToString(), expected);
	}
	
	

}
