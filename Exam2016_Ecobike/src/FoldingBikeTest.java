import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class FoldingBikeTest {

	@Test
	void defaultConstructorTest() {
		FoldingBike f = new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		assertEquals("FOLDING BIKE", f.bikeType);
		assertEquals("Brompton", f.brandName);
		assertEquals("20", f.getWheelSize());
		assertEquals("6", f.getNumberOfGears());
	}
	
	
	@Test
	void getWheelSizeTest() {
		FoldingBike f = new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		assertEquals("20", f.getWheelSize());
	}
	
	@Test
	void setWheelSizeTest() {
		FoldingBike f = new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		f.setWheelSize("30");
		assertEquals("30", f.getWheelSize());
	}
	
	@Test
	void getNumberOfGearsTest() {
		FoldingBike f = new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		assertEquals("6", f.getNumberOfGears());
	}
	
	@Test
	void setNumberOfGearsTest() {
		FoldingBike f = new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		f.setNumberOfGears("10");
		assertEquals("10", f.getNumberOfGears());
	}
	
	@Test
	void readTest() {
		String readLine = "FOLDING BIKE Brompton; 20; 6; 9283; TRUE; black; 1199";
		Scanner sc = new Scanner(readLine);
		FoldingBike f = FoldingBike.read(sc);
		FoldingBike f2 = new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		assertEquals(f, f2);	
	}
	
	@Test
	void toStringTest_LightAvailibilityFalse() {
		FoldingBike f = new FoldingBike(" BIKE", "Brompton", "20", "6", "9283", "FALSE", "black", "1199");
		String expected = "FOLDING BIKE Brompton with 6 gear(s) and no head/tail light.\n" + 
				"	Price: 1199 euros.";
		assertEquals(f.toString(), expected);	
	}
	
	@Test
	void toStringTest_LightAvailibilityTrue() {
		FoldingBike f = new FoldingBike(" BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		String expected = "FOLDING BIKE Brompton with 6 gear(s) and head/tail light.\n\t" + 
				"Price: 1199 euros.";
		assertEquals(f.toString(), expected);		
	}

	@Test
	void writeToStringTest() {
		FoldingBike f = new FoldingBike(" BIKE", "Brompton", "20", "6", "9283", "FALSE", "black", "1199");
		String expected = "FOLDING BIKE Brompton; 20; 6; 9283; FALSE; black; 1199";
		assertEquals(f.writeToString(), expected);	
	}
	
	@Test
	void equalsMethod_SameObject() {
		FoldingBike f = new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		FoldingBike f2 = f;
		assertEquals(f, f2);
	}
	
	@Test
	void equalsMethod_DifferentObject() {
		FoldingBike f = new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		FoldingBike f2 =  new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		assertEquals(f, f2);
	}
	
	@Test
	void equalsMethod_DifferentBikeType() {
		FoldingBike f = new FoldingBike("E-BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		FoldingBike f2 =  new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		assertNotEquals(f, f2);
	}
	
	@Test
	void equalsMethod_DifferentWheelSize() {
		FoldingBike f = new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		FoldingBike f2 =  new FoldingBike("FOLDING BIKE", "Brompton", "40", "6", "9283", "TRUE", "black", "1199");
		assertNotEquals(f, f2);
	}
	
	@Test
	void equalsMethod_DifferentNumberOfGears() {
		FoldingBike f = new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		FoldingBike f2 =  new FoldingBike("FOLDING BIKE", "Brompton", "20", "10", "9283", "TRUE", "black", "1199");
		assertNotEquals(f, f2);
	}
	
	@Test
	void equalsMethod_DifferentBikeWeigth() {
		FoldingBike f = new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		FoldingBike f2 =  new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9280", "TRUE", "black", "1199");
		assertNotEquals(f, f2);
	}
	
	@Test
	void equalsMethod_LightAvailibility() {
		FoldingBike f = new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		FoldingBike f2 =  new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "FALSE", "black", "1199");
		assertNotEquals(f, f2);
	}
	

	@Test
	void equalsMethod_DifferentColor() {
		FoldingBike f = new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		FoldingBike f2 =  new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "blue", "1199");
		assertNotEquals(f, f2);
	}
	
	@Test
	void equalsMethod_DifferentPrice() {
		FoldingBike f = new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		FoldingBike f2 =  new FoldingBike("FOLDING BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "2000");
		assertNotEquals(f, f2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
