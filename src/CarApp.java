import java.text.DecimalFormat;
import java.util.*;

public class CarApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nWelcome to Grand Circus Motors! (Admin Console)\n");
		int sizeArr = Validation.getPosInt(scan, "How many cars are you ordering? ");
		Car cars[] = new Car[sizeArr];

		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car();
			cars[i].setMake(Validation.getString(scan, "\nEnter Car #" + (i + 1) + " Make: "));
			cars[i].setModel(Validation.getString(scan, "\nEnter Car #" + (i + 1) + " Model: "));
			cars[i].setYear(Validation.getRangeInt(scan, "\nEnter Car #" + (i + 1) + " Year: ", 1880, 2099,
					"Please enter a reasonable year."));
			cars[i].setPrice(Validation.getPosDouble(scan, "\nEnter Car #" + (i + 1) + " Price: "));
		}

		System.out.println("\nCurrent Inventory: ");
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].getPrice() < 1000) {
				System.out.printf("%-15s %-15s %-10s %-15s\n", cars[i].getMake(), cars[i].getModel(), cars[i].getYear(),
						"$" + df.format(cars[i].getPrice()));
			} else if (cars[i].getPrice() < 10000) {
				System.out.printf("%-15s %-15s %-10s %-15s\n", cars[i].getMake(), cars[i].getModel(), cars[i].getYear(),
						"$" + df1.format(cars[i].getPrice()));
			} else if (cars[i].getPrice() < 100000) {
				System.out.printf("%-15s %-15s %-10s %-15s\n", cars[i].getMake(), cars[i].getModel(), cars[i].getYear(),
						"$" + df2.format(cars[i].getPrice()));
			} else {
				System.out.printf("%-15s %-15s %-10s %-15s\n", cars[i].getMake(), cars[i].getModel(), cars[i].getYear(),
						"$" + df3.format(cars[i].getPrice()));
			}
		}
	}

	public static DecimalFormat df = new DecimalFormat("00.00");
	public static DecimalFormat df1 = new DecimalFormat("0,000.00");
	public static DecimalFormat df2 = new DecimalFormat("00,000.00");
	public static DecimalFormat df3 = new DecimalFormat("000,000.00");
	
}
