import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * @author irtazahashmi
 * @version 1.0
 * @studentNumber 4829360
 */
public class Program {
	static int userChoice;
	static String filename;
	static Scanner userInput;
	static BikeCatalog catalog;
	static Scanner fileReader;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Welcome to Ecobike. Made by Irtaza.");
		System.out.println("Enter your filename:");
		userInput = new Scanner(System.in);
		filename = userInput.next();
		fileReader = new Scanner(new File(filename));
		catalog = BikeCatalog.read(fileReader);

		do {
			myInterface();
			userChoice = userInput.nextInt();
			
			switch (userChoice) {
			case 1: showCatalog(); break;
			case 2: addANewFoldingBike(); break;
			case 3: addANewEScooter(); break;
			case 4: addANewEBike(); break;
			case 5: sortBikeByType(); break;
			case 6: sortByBikePrice(); break;
			case 7: writeToFile(); break;
			case 8: exit(); break;
			default: System.out.println("Wrong choice! Please enter a number from 1 - 7.");
			}
		} while (userChoice != 8);
	}

	/**
	 * A method that displays the textual user-interface.
	 */
	private static void myInterface() {
		System.out.println("Please make your choice:\n"
				+ "\t1 - Show the entire EcoBike catalogue\n"
				+ "\t2 - Add a new folding bike\n"
				+ "\t3 - Add a new e-scooter\n"
				+ "\t4 - Add a new e-bike\n"
				+ "\t5 - Sort by bike type\n"
				+ "\t6 - Sort by price (low => high)\n"
				+ "\t7 - Write to file\n"
				+ "\t8 - Stop the program");
	}
	
	private static void showCatalog() {
		System.out.println(catalog.toString());		
	}
	
	
	private static void addANewFoldingBike() {
		System.out.println("Let's add a new folding bike!");
		userInput.nextLine();
		System.out.println("Brand name?");
		String brand = userInput.nextLine();
		System.out.println("Size of the wheels? (in inches)");
		String wheelSize = userInput.nextLine();
		System.out.println("Number of gears?");
		String numberOfGears = userInput.nextLine();
		System.out.println("Bike weigth? (in grams)");
		String bikeWeigth = userInput.nextLine();
		System.out.println("Does it have lights? (TRUE/FALSE)");
		String lightAvailibility = userInput.nextLine();
		System.out.println("Color?");
		String colorUpperCase = userInput.nextLine();
		String color = colorUpperCase.toLowerCase();
		System.out.println("Price? (only the integer value)");
		String price = userInput.nextLine();
		
		FoldingBike f = new FoldingBike(" BIKE", brand, wheelSize, numberOfGears, bikeWeigth, lightAvailibility, color, price);
		catalog.add(f);
	}
	
	private static void addANewEBike() {
		// Too lazy to do it.
	}


	private static void addANewEScooter() {
		// Too lazy to do it.
	}
	
	private static void sortBikeByType() {
		new Sort(catalog, new BikeTypeComparator()).start();
	}
	
	private static void sortByBikePrice() {
		new Sort(catalog, new PriceComparator()).start();	
	}

	private static void writeToFile() throws FileNotFoundException {
		System.out.println("Writing to ecobike.txt done...\n");
		catalog.writeToFile(filename);
	}
	
	private static void exit() {
		System.out.println("Thank you for using the application. Good bye!");
		System.exit(0);
	}
	
	
	
	
	

}
