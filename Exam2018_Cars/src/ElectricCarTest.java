import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class ElectricCarTest {

	@Test
	void constructorTest() {
		ElectricCar e = new ElectricCar("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		e.setBatteryCapacity("15000MH");
		assertEquals("15000MH", e.getBatteryCapacity());
	}
	
	
	@Test
	void toStringTest() {
		ElectricCar e = new ElectricCar("", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		assertEquals(e.toString(), "ELECTRIC_CAR Tesla, Model 2, 2500MH, 150KW, 2000 euro");
	}
	
	@Test
	void readTest() throws FileNotFoundException {
		String readLine = "ELECTRIC_CAR Tesla, Model 3, 150KW, 50000Ah, 30000 euro";
		Scanner sc = new Scanner(readLine);
		ElectricCar e = ElectricCar.read(sc);
		ElectricCar expected = new ElectricCar("ELECTRIC_CAR", "Tesla", "Model 3", "150KW", "50000Ah", "30000 euro");
		assertEquals(e, expected);
	}
	
	
	@Test 
	void equalsTest_SameObject() {
		ElectricCar e = new ElectricCar("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		ElectricCar e2 = e;
		assertEquals(e, e2);
		
	}
	
	@Test
	void equalsTest_DifferentObject() {
		ElectricCar e = new ElectricCar("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		ElectricCar e2 = new ElectricCar("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		assertEquals(e, e2);
	}
	
	
	@Test 
	void equalsTest_DifferentcarType() {
		ElectricCar e = new ElectricCar ("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		ElectricCar e2 = new ElectricCar ("GAS_CAR", "Toyota", "Model 3", "2500MH", "150KW", "2000 euro");
		assertNotEquals(e, e2);
	}
	
	
	@Test 
	void equalsTest_DifferentBrandName() {
		ElectricCar e = new ElectricCar ("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		ElectricCar e2 = new ElectricCar ("ELECTRIC_CAR", "Toyota", "Model 3", "2500MH", "150KW", "2000 euro");
		assertNotEquals(e, e2);
	}
	

	@Test 
	void equalsTest_DifferentModelName() {
		ElectricCar e = new ElectricCar ("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		ElectricCar e2 = new ElectricCar ("ELECTRIC_CAR", "Tesla", "Civic", "2500MH", "150KW", "2000 euro");
		assertNotEquals(e, e2);
	}
	
	
	@Test 
	void equalsTest_DifferentEnginePower() {
		ElectricCar e = new ElectricCar ("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		ElectricCar e2 = new ElectricCar ("ELECTRIC_CAR", "Tesla", "Model 2", "1500MH", "150KW", "2000 euro");
		assertNotEquals(e, e2);
	}
	
	@Test 
	void equalsTest_DifferentBatteryCapacity() {
		ElectricCar e = new ElectricCar ("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		ElectricCar e2 = new ElectricCar ("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "250KW", "2000 euro");
		assertNotEquals(e, e2);
	}
	
	
	@Test 
	void equalsTest_DifferentPrice() {
		ElectricCar e = new ElectricCar ("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		ElectricCar e2 = new ElectricCar ("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "5000 euro");
		assertNotEquals(e, e2);
	}
	
}
