import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
	static int userChoice;
	static Scanner input;
	static Scanner userInput;
	static AppleCatalog catalog;
	static String filename;

	
	public static void main(String[] args) throws FileNotFoundException {						
		
		System.out.println("Made by Irtaza. Apple.");
		userInput = new Scanner(System.in);
		System.out.println("Enter filename:");
		String filename = userInput.next();
		
		input = new Scanner (new File (filename));
		catalog = AppleCatalog.read(input);
		
		do {
			myInterface();
			userChoice = userInput.nextInt();
			
			switch(userChoice) {
			
			case 1: System.out.println(catalog.toString()); break;
			case 2: addANewiPhone(); break;
			case 3: addNewiPad(); break;
			case 4: new Sort(catalog, new ProductComparator()).start(); break;
			case 5: new Sort(catalog, new PriceComparator()).start(); break;
			case 6: catalog.writeToFile(filename); break;
			case 7: exit(); break;
			default: System.out.println("Wrong choice. Please enter a choice from 1-7."); 
			}
		} while(userChoice != 7);
	}

	public static void myInterface() {
		System.out.println("Please make your choice:\n "
				+ "\t1 - Show the entire Mobility4You catalogue\n"
				+ "\t2 – Add a new iPhone\n"
				+ "\t3 – Add a new iPad\n"
				+ "\t4 - Show the entire Mobility4You catalogue sorted by PRODUCT-type\n"
				+ "\t5 - Show the entire Mobility4You catalogue sorted by price (low -> high)\n"
				+ "\t6 – Write to file\n"
				+ "\t7 – Stop the program");
	}
	
	public static void addANewiPhone() {
		System.out.println("Let's add a new iPhone!");
		userInput.nextLine();
		System.out.println("Model name? (Dont type iPhone, just the model name.)");
		String modelName = userInput.nextLine();
		System.out.println("Screensize?");
		String screenSize = userInput.nextLine();
		System.out.println("Processor?");
		String processor = userInput.nextLine();
		System.out.println("Modem type? (either GSM or CDMA)");
		String modemType = userInput.nextLine();
		System.out.println("Color?");
		String color = userInput.nextLine();
		System.out.println("Memory? (e.g 32GB)");
		String memory = userInput.nextLine();
		System.out.println("3DTechnology? (either TRUE/FALSE)");
		String threeDTechnology = userInput.nextLine();
		System.out.println("Price? (Without units)");
		String price = userInput.nextLine();
		
		iPhone i = new iPhone(modelName, screenSize, processor, modemType, color, memory, threeDTechnology, price);
		catalog.addProduct(i);
	}
	
	public static void addNewiPad() {
		System.out.println("Let's add a new iPad!");
		userInput.nextLine();
		System.out.println("Model name? (Dont type iPad, just the model name.)");
		String modelName = userInput.nextLine();
		System.out.println("Screensize?");
		String screenSize = userInput.nextLine();
		System.out.println("Processor?");
		String processor = userInput.nextLine();
		System.out.println("Color?");
		String color = userInput.nextLine();
		System.out.println("Memory? (e.g 32GB)");
		String memory = userInput.nextLine();
		System.out.println("4G Technology? (either TRUE/FALSE)");
		String fourGTechnology = userInput.nextLine();
		System.out.println("Price? (Without units)");
		String price = userInput.nextLine();
		
		iPad i = new iPad(modelName, screenSize, processor, fourGTechnology, color, memory, price);
		catalog.addProduct(i);
	}
	
	public static void exit() {
		System.out.println("Thank you for using the application! Goodbye!");
		System.exit(0);
	}
	
	
	

}
