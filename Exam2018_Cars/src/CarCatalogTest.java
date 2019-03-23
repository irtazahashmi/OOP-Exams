import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class CarCatalogTest {

	@Test
	void getCarsTest() {
		ElectricCar e = new ElectricCar("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		GasCar g = new GasCar("GAS_CAR", "Toyota", "Civic", "1.5L", "80KW", "17000 euro");
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(e);
		cars.add(g);
		CarCatalog c = new CarCatalog();
		c.add(e);
		c.add(g);
		assertEquals(c.getCars(), cars);
	}
	
	@Test
	void setCarsTest() {
		ElectricCar e = new ElectricCar("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		GasCar g = new GasCar("GAS_CAR", "Toyota", "Civic", "1.5L", "80KW", "17000 euro");
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(e);
		cars.add(g);
		CarCatalog c = new CarCatalog();
		c.setCars(cars);
		assertEquals(c.getCars(), cars);
	}
	
	@Test
	void testToString() {
		ElectricCar e = new ElectricCar("", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		GasCar g = new GasCar("", "Toyota", "Civic", "1.5L", "80KW", "17000 euro");
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(e);
		cars.add(g);
		String expected = "[ELECTRIC_CAR Tesla, Model 2, 2500MH, 150KW, 2000 euro, GAS_CAR Toyota, Civic, 1.5L, 80KW, 17000 euro]";
		assertEquals(cars.toString(), expected);
	}
	
	@Test
	void equalsMethod_SameObject() {
		ElectricCar e = new ElectricCar("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		GasCar g = new GasCar("GAS_CAR", "Toyota", "Civic", "1.5L", "80KW", "17000 euro");
		CarCatalog c = new CarCatalog();
		c.add(e);
		c.add(g);
		CarCatalog c2 = c;
		assertEquals(c, c2);
	}
	
	@Test
	void equalsMethod_DifferentObject() {
		ElectricCar e = new ElectricCar("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		GasCar g = new GasCar("GAS_CAR", "Toyota", "Civic", "1.5L", "80KW", "17000 euro");
		CarCatalog c = new CarCatalog();
		c.add(e);
		c.add(g);
		CarCatalog c2 = new CarCatalog();
		c2.add(e);
		c2.add(g);
		assertEquals(c, c2);
	}
	
	@Test
	void notEqualsDifferentLength() {
		ElectricCar e = new ElectricCar("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		GasCar g = new GasCar("GAS_CAR", "Toyota", "Civic", "1.5L", "80KW", "17000 euro");
		CarCatalog c = new CarCatalog();
		c.add(e);
		c.add(g);
		CarCatalog c2 = new CarCatalog();
		c2.add(e);
		assertNotEquals(c, c2);
	}
	
	@Test
	void notEqualsDifferentOrder() {
		ElectricCar e = new ElectricCar("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		GasCar g = new GasCar("GAS_CAR", "Toyota", "Civic", "1.5L", "80KW", "17000 euro");
		CarCatalog c = new CarCatalog();
		c.add(e);
		c.add(g);
		CarCatalog c2 = new CarCatalog();
		c2.add(g);
		c2.add(e);
		assertNotEquals(c, c2);
	}
	
	@Test
	void notEqualsDifferentName() {
		ElectricCar e = new ElectricCar("ELECTRIC_CAR", "Tesla", "Model 2", "2500MH", "150KW", "2000 euro");
		GasCar g = new GasCar("GAS_CAR", "Toyota", "Civic", "1.5L", "80KW", "17000 euro");
		GasCar g2 = new GasCar("GAS_CAR", "Toyota", "Corolla", "1.5L", "80KW", "17000 euro");
		CarCatalog c = new CarCatalog();
		c.add(e);
		c.add(g);
		CarCatalog c2 = new CarCatalog();
		c2.add(e);
		c2.add(g2);
		assertNotEquals(c, c2);
	}
	

}
