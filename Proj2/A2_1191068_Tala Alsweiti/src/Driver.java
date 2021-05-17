
public class Driver {

	public static void main(String[] args) {
		/**
		 * Creates an array of 5 cars and passes it to the printCarsInfo method and the
		 * maxPrice method
		 */
		System.out.println(
				"Please note that if you enterd an invalied year/month the program will stop and show an error message");
		Car[] array = new Car[5];
		array[0] = new Car();
		array[1] = new Car("0123-B", 2020, 9, "RED", 6000.00, "BMW", 2023, 12);
		array[2] = new Car("0123-C", 2000, 2, "green", 3000.00, "KIA", 2019, 9);
		array[3] = new Car("0123-D", 1000, 3, "yellow", 1000.00, "Range rover", 2031, 1);
		array[4] = new Car("0123-E", 2010, 1, "black", 1000000.0, "Ferari", 2020, 3);
		System.out.println("_________________________________________________________");
		System.out.println("*********************************************************");
		printCarsInfo(array);
		System.out.println("*********************************************************");
		System.out.println("Car with highest price have the following inforamtion: " + maxPrice(array).printCarInfo());
	}

	public static void printCarsInfo(Car[] cars) {
		// print all information about cars with ages and guarantee due to.
		for (int i = 0; i < cars.length; i++) {
			System.out.println(cars[i].printCarInfo());
			System.out.println("_________________________________________________________");
		}
	}

	/**
	 * A method to compare the car objects depends on their price
	 * 
	 * @param cars the objects to compare
	 * @return the car object with the maximum price
	 */
	public static Car maxPrice(Car[] cars) {
		Car max = cars[0];
		for (int i = 1; i < cars.length; i++) {
			if (cars[i].getPrice() > max.getPrice())
				max = cars[i];
		}
		return max;

	}
}
