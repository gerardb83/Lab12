import java.text.DecimalFormat;
import java.util.*;

public class CarApp2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int userInput = 0;
		
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(new Car("Ford", "Palooka", 2018, 29000));
		cars.add(new Car("Chevy", "Tuscoluco", 2019, 38000));
		cars.add(new Car("Chrysler", "Mongoose", 2018, 33000));
		cars.add(new UsedCar("BMW", "Stutgardt", 1978, 13000, 220000));
		cars.add(new UsedCar("Renault", "Pardon", 1989, 56000, 189000));
		cars.add(new UsedCar("Saab", "Lakvaagon", 1995, 22000, 340000));

		System.out.println("Grand Circus Motors\n\nCurrent Inventory:");
		System.out.println("===================================================");
		do {
			printList(cars);
			try {
				userInput = Validation.getDynamicRangeInt(scan, "\nWhich car would you like? ", 1, cars, 7,
						"Please enter a valid selection");
				printCar(userInput, cars);
				String buyCar = Validation.getYNString(scan, "Would you like to buy this car? (y or n)");
				if (buyCar.equals("y")) {
					cars.remove(userInput - 1);
					System.out.println("Excellent! We'll draw up the paperwork.\n");
				}
			} catch (IndexOutOfBoundsException e) {
			}

		} while (userInput != 7);
		System.out.println("Have a great day!");
	}

	public static void printList(ArrayList<Car> cars) {
		for (int i = 0; i < cars.size(); i++) {
			if(cars.get(i) instanceof UsedCar) {
				UsedCar usedCar = (UsedCar) cars.get(i);	
			System.out.printf("%-15s %-15s %-10s %-15s %-15s\n", (i + 1) + ". " + cars.get(i).getMake(), cars.get(i).getModel(), cars.get(i).getYear(), "$" + df2.format(cars.get(i).getPrice()), " (Used) " + df3.format(usedCar.getMileage()) + " miles");
		} else {
			System.out.printf("%-15s %-15s %-10s %-15s\n", (i + 1) + ". " + cars.get(i).getMake(), cars.get(i).getModel(), cars.get(i).getYear(), "$" + df2.format(cars.get(i).getPrice()));
		}
		}
		System.out.println("7. Quit");
	}
	
	public static void printCar(int userInput, ArrayList<Car> cars) {
		int i = userInput - 1;
		if(cars.get(i) instanceof UsedCar) {
			UsedCar usedCar = (UsedCar) cars.get(i);
			System.out.printf("%-15s %-15s %-10s %-15s %-15s\n", cars.get(i).getMake(), cars.get(i).getModel(), cars.get(i).getYear(), "$" + df2.format(cars.get(i).getPrice()), " (Used) " + df3.format(usedCar.getMileage()) + " miles");
		} else {
			System.out.printf("%-15s %-15s %-10s %-15s\n", cars.get(i).getMake(), cars.get(i).getModel(), cars.get(i).getYear(), "$" + df2.format(cars.get(i).getPrice()));
		}
	}
		

	public static DecimalFormat df2 = new DecimalFormat("00,000.00");
	public static DecimalFormat df3 = new DecimalFormat("000,000.00");
}
