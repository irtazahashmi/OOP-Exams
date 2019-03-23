import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class EScooterTest {

	@Test
	void getMaximumSpeedTest() {
		EScooter es = new EScooter("E-SCOOTER", "Pugeot", "20", "9283", "TRUE", "5426", "black", "2000");
		assertEquals("20", es.getMaximumSpeed());
	}
	
	@Test
	void setMaximumSpeedTest() {
		EScooter es = new EScooter("E-SCOOTER", "Pugeot", "20", "9283", "TRUE", "5426", "black", "2000");
		es.setMaximumSpeed("30");
		assertEquals("30", es.getMaximumSpeed());
	}
	
	@Test
	void getBatteryCapacityTest() {
		EScooter es = new EScooter("E-SCOOTER", "Pugeot", "20", "9283", "TRUE", "5426", "black", "2000");
		assertEquals("5426", es.getBatteryCapacity());
	}
	
	@Test
	void setBatteryCapacityTest() {
		EScooter es = new EScooter("E-SCOOTER", "Pugeot", "20", "9283", "TRUE", "5426", "black", "2000");
		es.setBatteryCapacity("5000");
		assertEquals("5000", es.getBatteryCapacity());
	}
	
	@Test
	void readTest() {
		String readLine = "E-SCOOTER Peugeot; 45; 5426; TRUE; 8000; blue; 875";
		Scanner sc = new Scanner(readLine);
		EScooter es = EScooter.read(sc);
		EScooter es2 = new EScooter("E-SCOOTER", "Peugeot", "45", "5426", "TRUE", "8000", "blue", "875");
		assertEquals(es, es2);	
	}
	

	@Test
	void toStringTest_LightAvailibilityFalse() {
		EScooter es = new EScooter("", "Peugeot", "45", "5426", "FALSE", "8000", "blue", "875");
		String expected = "E-SCOOTER Peugeot with 8000 mAh battery and no head/tail light.\n" + 
				"	Price: 875 euros.";
		assertEquals(es.toString(), expected);	
	}
	
	@Test
	void toStringTest_LightAvailibilityTrue() {
		EScooter es = new EScooter("", "Peugeot", "45", "5426", "TRUE", "8000", "blue", "875");
		String expected = "E-SCOOTER Peugeot with 8000 mAh battery and head/tail light.\n" + 
				"	Price: 875 euros.";
		assertEquals(es.toString(), expected);	
	}
	
	@Test
	void writeToStringTest() {
		EScooter es = new EScooter("", "Peugeot", "45", "5426", "TRUE", "8000", "blue", "875");
		String expected = "E-SCOOTER Peugeot; 45; 5426; TRUE; 8000; blue; 875";
		assertEquals(es.writeToString(), expected);	
	}

}
