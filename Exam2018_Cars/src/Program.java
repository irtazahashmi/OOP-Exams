import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
	static int userChoice; 
	static Scanner userInput;
	static Scanner input;
	static CarCatalog carMagazine;

	public static void main(String[] args) throws FileNotFoundException {
		
		userInput = new Scanner(System.in);
		System.out.println("Made by Irtaza. Mobility4U.");
		System.out.println("Enter your filename:");
		String filename = userInput.next();
		
		input = new Scanner (new File (filename));
		carMagazine = CarCatalog.read(input);
		
		do {
			myInterface(); 
			userChoice = userInput.nextInt();
			
			switch (userChoice) {
			
			case 1: System.out.println(carMagazine.toString()); break;	
			case 2: addElectricCar(); break;
			case 3: addGasCar(); break;
			case 4: addHybridCar(); break;
			case 5: new Sort(carMagazine, new TypeComparator()).start(); break;
			case 6: new Sort(carMagazine, new BrandComparator()).start(); break;  
			case 7: System.out.println("\nDone! Your file has been written to cars.txt.\n");
					carMagazine.writeToFile("cars.txt"); 
					break;
			case 8: exit(); break;
			default: System.out.println("Wrong choice! Please select an option from 1-8!");
			
			}
		} while (userChoice != 8);	
	}

	public static void myInterface() {
		System.out.println("Please make your choice:\n "
				+ "\t1 - Show the entire Mobility4You catalogue\n"
				+ "\t2 – Add a new electric car\n"
				+ "\t3 – Add a new gas-powered car\n"
				+ "\t4 – Add a new hybrid car\n"
				+ "\t5 - Show the entire Mobility4You catalogue sorted by car-type\n"
				+ "\t6 - Show the entire Mobility4You catalogue sorted by brand (alphabetically)\n"
				+ "\t7 – Write to file\n"
				+ "\t8 – Stop the program");
	}
	
	
	public static void addElectricCar() {
		String carType = "";
		System.out.println("What brand?");
		String brand = userInput.next();
		System.out.println("What model? (One word)");
		String model = userInput.next();
		System.out.println("Power of the engine?");
		String power = userInput.next();
		System.out.println("Capacity of the battery?");
		String battery = userInput.next();
		System.out.println("Price? (only the integer)");	
		String price = userInput.next() + " euro";
		
		ElectricCar newElectricCar = new ElectricCar(carType, brand, model, power, battery, price);
		carMagazine.add(newElectricCar);
	}
	
	public static void addGasCar() {
		String carType = "";
		System.out.println("What brand?");
		String brand = userInput.next();
		System.out.println("What model? (One word)");
		String model = userInput.next();
		System.out.println("Engine displacement?");
		String engineDisplacement = userInput.next();
		System.out.println("Power of the engine?");
		String power = userInput.next();
		System.out.println("Price?(only the integer)");	
		String price = userInput.next() + " euro";
		
		GasCar newGasCar = new GasCar (carType, brand, model, engineDisplacement, power, price);
		carMagazine.add(newGasCar);
	}
	
	public static void addHybridCar() {
		String carType = "";
		System.out.println("What brand?");
		String brand = userInput.next();
		System.out.println("What model? (One word)");
		String model = userInput.next();
		System.out.println("Engine displacement?");
		String engineDisplacement = userInput.next();
		System.out.println("Power of the engine?");
		String power = userInput.next();
		System.out.println("Capacity of the battery?");
		String battery = userInput.next();
		System.out.println("Price? (only the integer)");	
		String price = userInput.next() + " euro";
		
		HybridCar newHybridCar = new HybridCar(carType, brand, model, engineDisplacement, power, battery, price);
		carMagazine.add(newHybridCar);
	}
	
	public static void exit() {
		System.out.println("Thank you for using the application! Good bye!");
		System.exit(0);
	}
		
	

}
