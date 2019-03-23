import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class iPhoneTest {

	@Test
	void getModemTypetest() {
		iPhone i = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "TRUE", "700");
		assertEquals("GSM", i.getModemType());
	}
	
	@Test
	void setModemTypetest() {
		iPhone i = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "TRUE", "700");
		i.setModemType("CDMA");
		assertEquals("CDMA", i.getModemType());
	}
	@Test
	void get3DTechtest() {
	iPhone i = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "TRUE", "700");
	assertEquals("TRUE", i.getThreeDTechnology());
	}
	
	@Test
	void set3DTechtest() {
	iPhone i = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "TRUE", "700");
	i.setThreeDTechnology("FALSE");
	assertEquals("FALSE", i.getThreeDTechnology());
	}
	
	@Test
	void readTest() {
		String readLine = "IPHONE 7, 4.7, A10, GSM, JET BLACK, 32GB, TRUE, 700";
		Scanner sc = new Scanner(readLine);
		iPhone i = iPhone.read(sc);
		iPhone i2 = new iPhone("7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "TRUE", "700");
		assertEquals(i, i2);
	}
	
	@Test 
	void toStringWith3DTech() {
		iPhone i = new iPhone("7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "TRUE", "700");
		String expected = "Apple iPhone 7 with 32GB of memory\n\twith an A10 processor and 4.7 inch screen\n\thaving GSM and "
				+ "3D Touch Technology\n\t700 euros";
		assertEquals(i.toString(), expected);
	}
	
	@Test 
	void toStringWithout3DTech() {
		iPhone i = new iPhone("7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "FALSE", "700");
		String expected = "Apple iPhone 7 with 32GB of memory\n\twith an A10 processor and 4.7 inch screen\n\thaving GSM\n\t700 euros";
		assertEquals(i.toString(), expected);
	}
	
	@Test
	void writeToString() {
		iPhone i = new iPhone("7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "FALSE", "700");
		String expected = "IPHONE 7, 4.7, A10, GSM, JET BLACK, 32GB, FALSE, 700";
		assertEquals(i.writeToString(), expected);
	}
	
	@Test 
	void equalsMethod_SameObjectTest() {
		iPhone i = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "FALSE", "700");
		iPhone i2 = i;
		assertEquals(i, i2);
	}
	
	@Test 
	void equalsMethod_DifferentObjectTest() {
		iPhone i = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "FALSE", "700");
		iPhone i2 = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "FALSE", "700");
		assertEquals(i, i2);
	}
	
	@Test 
	void equalsMethod_DifferentModelNameTest() {
		iPhone i = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "FALSE", "700");
		iPhone i2 = new iPhone("IPHONE 8", "4.7", "A10", "GSM", "JET BLACK", "32GB", "FALSE", "700");
		assertNotEquals(i, i2);
	}
	
	@Test 
	void equalsMethod_DifferentProcessorTest() {
		iPhone i = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "FALSE", "700");
		iPhone i2 = new iPhone("IPHONE 7", "4.7", "A20", "GSM", "JET BLACK", "32GB", "FALSE", "700");
		assertNotEquals(i, i2);
	}
	
	@Test 
	void equalsMethod_DifferentModemTypeTest() {
		iPhone i = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "FALSE", "700");
		iPhone i2 = new iPhone("IPHONE 7", "4.7", "A10", "CDM", "JET BLACK", "32GB", "FALSE", "700");
		assertNotEquals(i, i2);
	}
	
	@Test 
	void equalsMethod_DifferentColorTest() {
		iPhone i = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "FALSE", "700");
		iPhone i2 = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "BLUE", "32GB", "FALSE", "700");
		assertNotEquals(i, i2);
	}
	
	@Test 
	void equalsMethod_DifferentMemoryTest() {
		iPhone i = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "FALSE", "700");
		iPhone i2 = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "64GB", "FALSE", "700");
		assertNotEquals(i, i2);
	}
	
	@Test 
	void equalsMethod_DifferentTechTest() {
		iPhone i = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "FALSE", "700");
		iPhone i2 = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "TRUE", "700");
		assertNotEquals(i, i2);
	}
	
	@Test 
	void equalsMethod_DifferentPriceTest() {
		iPhone i = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "FALSE", "700");
		iPhone i2 = new iPhone("IPHONE 7", "4.7", "A10", "GSM", "JET BLACK", "32GB", "FALSE", "800");
		assertNotEquals(i, i2);
	}
	

	
	
	
	
	
	
	
	
	
	

	
	

	
	
	
	

}
