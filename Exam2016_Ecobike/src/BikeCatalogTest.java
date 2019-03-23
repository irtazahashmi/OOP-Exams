import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class BikeCatalogTest {

	@Test
	void getBikesTest() {
		BikeCatalog c = new BikeCatalog();
		EBike eb = new EBike("E-BIKE", "Peugeot", "45", "5426", "TRUE", "8000", "blue", "875");
		c.add(eb);
		List<Bike> list = new ArrayList<Bike>();
		list.add(eb);
		assertEquals(list, c.getBikes());
	}
	
	@Test
	void setBikesTest() {
		BikeCatalog c = new BikeCatalog();
		EBike eb = new EBike("E-BIKE", "Peugeot", "45", "5426", "TRUE", "8000", "blue", "875");
		c.add(eb);
		List<Bike> list = new ArrayList<Bike>();
		c.setBikes(list);
		assertEquals(list, c.getBikes());
	}
	
	@Test
	void addCarTest() {
		BikeCatalog c = new BikeCatalog();
		EBike eb = new EBike("E-BIKE", "Peugeot", "45", "5426", "TRUE", "8000", "blue", "875");
		c.add(eb);
		String expected = "E-BIKEE-BIKE Peugeot with 8000 mAh battery and head/tail light.\n" + 
				"	Price: 875 euros.\n";
		assertEquals(expected, c.toString());
	}
	
	@Test 
	void toStringTest() {
		BikeCatalog c = new BikeCatalog();
		EScooter es = new EScooter("", "Pugeot", "20", "9283", "TRUE", "5426", "black", "2000");
		FoldingBike fb = new FoldingBike(" BIKE", "Brompton", "20", "6", "9283", "TRUE", "black", "1199");
		c.add(fb);
		c.add(es);
		String expected = "FOLDING BIKE Brompton with 6 gear(s) and head/tail light.\n" + 
				"	Price: 1199 euros.\n" + 
				"E-SCOOTER Pugeot with 5426 mAh battery and head/tail light.\n" + 
				"	Price: 2000 euros.\n";
		assertEquals(expected, c.toString());
	}
	

	

}
