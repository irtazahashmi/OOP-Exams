import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class EBikeTest {

	@Test
	void readTest() {
		String readLine = "E-BIKE Peugeot; 45; 5426; TRUE; 8000; blue; 875";
		Scanner sc = new Scanner(readLine);
		EBike eb = EBike.read(sc);
		EBike eb2 = new EBike("E-BIKE", "Peugeot", "45", "5426", "TRUE", "8000", "blue", "875");
		assertEquals(eb, eb2);	
	}
	

	@Test
	void toStringTest_LightAvailibilityFalse() {
		EBike eb = new EBike("", "Peugeot", "45", "5426", "FALSE", "8000", "blue", "875");
		String expected = "E-BIKE Peugeot with 8000 mAh battery and no head/tail light.\n" + 
				"	Price: 875 euros.";
		assertEquals(eb.toString(), expected);	
	}
	
	@Test
	void toStringTest_LightAvailibilityTrue() {
		EBike eb = new EBike("", "Peugeot", "45", "5426", "TRUE", "8000", "blue", "875");
		String expected = "E-BIKE Peugeot with 8000 mAh battery and head/tail light.\n" + 
				"	Price: 875 euros.";
		assertEquals(eb.toString(), expected);	
	}
	
	@Test
	void writeToStringTest() {
		EBike eb = new EBike("", "Peugeot", "45", "5426", "TRUE", "8000", "blue", "875");
		String expected = "E-BIKE Peugeot; 45; 5426; TRUE; 8000; blue; 875";
		assertEquals(eb.writeToString(), expected);	
	}

}
