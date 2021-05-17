
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 
 * @author Tala - 1191068 , Create the following Driver
 *
 */
public class Driver {
	/**
	 * Define a public static value to know the status of the air condition to
	 * decide the changes on the fuel consumption .The default value is false , if
	 * the user turned on the condition it will be set to true and will subtract the
	 * increasing from the fuel consumption value , when he turned it off , the
	 * subtracted value will be added to the fuel consumption so it backs to it's
	 * original one and the airCondationStatus will set to false
	 */
	public static boolean airCondationStatus = false;

	public static void main(String[] args) throws FileNotFoundException {
		/**
		 * Define the array list that vehicles will be stored in it
		 */
		ArrayList<Vehicles> vehicles = new ArrayList<>();
		System.out.println("-----------------------------Palestinian Vehicle Agency-----------------------------");
		System.out.println(
				"Welcome to our agency\nPlease be sure to enter the vehicles' data first, so you can choose any number from the below menu\n");
		/**
		 * call the menu method and send the array list to it
		 */
		System.out.println(
				"_________________________________________________________________________________________________________________\n");

		menu(vehicles);

	}

	/**
	 * A static void method that will display for the user the options he has and
	 * ask him to chose one
	 * 
	 * @param vehicles
	 * @throws FileNotFoundException
	 */
	public static void menu(ArrayList<Vehicles> vehicles) throws FileNotFoundException {
		System.out.println("1. Read the data from the file 'input.txt' and store them in Arraylist.");
		System.out.println("2. Set prices of petroleum.");
		System.out.println("3. Print sorted order Vehicles in an ascending order based on costFor100Km.");
		System.out.println("4. Print sorted order Vehicles in an ascending order based on owner name .");
		System.out.println("5. Print sorted order Vehicles in an descending order based on vehicle brand.");
		System.out.println("6. Clone Vehicle without owner.");
		System.out.println("7. Turn air-condition on");
		System.out.println("8. Write Output on the “output.txt” file after sort them.");
		System.out.println(
				"9. Print sorted order Vehicles in an ascending order based on model name .(Additional method)");
		System.out.println("10. Print vehicle having the greatest tunk size. (Additional method) ");
		System.out.println("11. Print the number of every engine type. (Additional method) ");
		System.out.println("12. Exit from System");
		Scanner in = new Scanner(System.in);

		int choice = in.nextInt();
		/**
		 * send the array list and the user choice to the cases method
		 */
		cases(choice, vehicles);
		in.close();
	}

	/**
	 * the cases method that will decide what to do when the user choose a number
	 * 
	 * @param choice
	 * @param vehicles
	 * @throws FileNotFoundException
	 */
	public static void cases(int choice, ArrayList<Vehicles> vehicles) throws FileNotFoundException {
		switch (choice) {
		case 1:
			readFromFile(vehicles);
			menu(vehicles);
			break;

		case 2:
			price();
			menu(vehicles);
			break;

		case 3:
			/**
			 * it the user didn't insert any data yet nothing will happen
			 */
			if (vehicles.size() == 0) {
				System.out.println("There is no vehicles stored in our agency, Please enter the vehicles first\n");
				menu(vehicles);
			} else {
				sortCost(vehicles);
				System.out.println(
						"_________________________________________________________________________________________________________________\n");
				menu(vehicles);
			}
			break;

		case 4:
			if (vehicles.size() == 0) {
				System.out.println("There is no vehicles stored in our agency, Please enter the vehicles first\n");
				menu(vehicles);
			} else {
				ownerNameSort(vehicles);
				menu(vehicles);
			}
			break;

		case 5:
			if (vehicles.size() == 0) {
				System.out.println("There is no vehicles stored in our agency, Please enter the vehicles first\n");
				menu(vehicles);
			} else {
				brandNameSort(vehicles);
				menu(vehicles);
			}
			break;

		case 6:
			if (vehicles.size() == 0) {
				System.out.println("There is no vehicles stored in our agency, Please enter the vehicles first\n");
				menu(vehicles);
			} else {
				clonning(vehicles);
				menu(vehicles);
			}
			break;

		case 7:
			if (vehicles.size() == 0) {
				System.out.println("There is no vehicles stored in our agency, Please enter the vehicles first\n");
				menu(vehicles);
			} else {
				turnOn(vehicles);
				menu(vehicles);
			}
			break;

		case 8:
			if (vehicles.size() == 0) {
				System.out.println("There is no vehicles stored in our agency, Please enter the vehicles first\n");
				menu(vehicles);
			} else {
				sortCost(vehicles);
				System.out.println("Output written successfully on the “output.txt” file \n");
				System.out.println(
						"_________________________________________________________________________________________________________________\n");
				menu(vehicles);
			}
			break;

		case 9:
			if (vehicles.size() == 0) {
				System.out.println("There is no vehicles stored in our agency, Please enter the vehicles first\n");
				menu(vehicles);
			} else {
				modelNameSort(vehicles);
				menu(vehicles);
			}
			break;

		case 10:
			if (vehicles.size() == 0) {
				System.out.println("There is no vehicles stored in our agency, Please enter the vehicles first\n");
				menu(vehicles);
			} else {
				greatestTunkSize(vehicles);
				menu(vehicles);
			}
			break;

		case 11:
			if (vehicles.size() == 0) {
				System.out.println("There is no vehicles stored in our agency, Please enter the vehicles first\n");
				menu(vehicles);
			} else {
				engineTypesCnt(vehicles);
				menu(vehicles);
			}
			break;
		case 12: {
			System.out.println("THANK YOU FOR USING OUR PROGRAM! HAVE A GOOD DAY");
			System.exit(1);
		}

		default:
			System.out.println("The number you chose is not valid , please Enter a number from 1 to 12\n");
			System.out.println(
					"_________________________________________________________________________________________________________________\n");
			menu(vehicles);

		}

	}

	/**
	 * A static void method that will read the vehicles' data from the file and
	 * store them in the array list and print them in the output file
	 * 
	 * @param vehicles
	 * @throws FileNotFoundException
	 */
	public static void readFromFile(ArrayList<Vehicles> vehicles) throws FileNotFoundException {
		File carsFile = new File("inputdata.txt");
		File outputFile = new File("output.txt");
		PrintWriter out = new PrintWriter(outputFile);
		String modelName, modelNo, brand, ownerName, engineType, strTunkSize, strFuelConsumption, strNumOfSeats,
				strAutoDoors, strPower;
		double tunkSize, fuelConsumption;
		int numOfseats, truckPower;
		boolean airCon, autoDoors;
		String read, classType;
		try {
			Scanner in = new Scanner(carsFile);
			while (in.hasNext()) {
				read = in.nextLine();
				String[] tokens = read.split(",");
				classType = tokens[0].trim().toLowerCase();
				modelName = tokens[1].trim();
				modelNo = tokens[2].trim();
				brand = tokens[3].trim();
				ownerName = tokens[4].trim();
				engineType = tokens[5].trim();
				strTunkSize = tokens[6].trim();
				tunkSize = Double.parseDouble(strTunkSize);
				strFuelConsumption = tokens[7].trim();
				fuelConsumption = Double.parseDouble(strFuelConsumption);
				strNumOfSeats = tokens[8].trim();
				numOfseats = Integer.parseInt(strNumOfSeats);
				if (classType.equals("car")) {
					airCon = false;
					Owner ownerInfo = new Owner(ownerName, "2353", "Hebron", "0599", new GregorianCalendar(2021, 1, 1));
					vehicles.add(new Car(classType, modelName, modelNo, brand, ownerInfo, engineType, tunkSize,
							fuelConsumption, numOfseats, airCon));

				} else if (classType.equals("minivan")) {
					strAutoDoors = tokens[9].trim();
					autoDoors = Boolean.parseBoolean(strAutoDoors);
					airCon = false;
					Owner ownerInfo = new Owner(ownerName, "2353", "Hebron", "0599", new GregorianCalendar(2005, 5, 4));
					vehicles.add(new Minivan(classType, modelName, modelNo, brand, ownerInfo, engineType, tunkSize,
							fuelConsumption, numOfseats, airCon, autoDoors));
				} else if (classType.equals("truck")) {
					strPower = tokens[9].trim();
					airCon = false;
					truckPower = Integer.parseInt(strPower);
					Owner ownerInfo = new Owner(ownerName, "2353", "Hebron", "0599", new GregorianCalendar(2011, 7, 9));

					vehicles.add(new Truck(classType, modelName, modelNo, brand, ownerInfo, engineType, tunkSize,
							fuelConsumption, numOfseats, airCon, truckPower));

				} else {
					throw new IllegalArgumentException("Invaild class type,please try again");

				}

			}
			/**
			 * to print the vehicles in the output file and the console
			 */
			System.out.println("\nThe Vehicles are :\n");
			out.println("The Vehicles are :\n");
			for (int i = 0; i < vehicles.size(); i++) {
				System.out.println(vehicles.get(i).toString());
				out.println(vehicles.get(i).toString());
			}

			System.out.println("\nRead DONE successfuly , Thank you !\n");
			System.out.println(
					"_________________________________________________________________________________________________________________\n");
			/**
			 * close the print writer so the written data can be saved in it
			 */
			out.close();
		}
		/**
		 * if the the file does not exist or has something wrong the program will throw
		 * a FileNotFoundException with a message to the user
		 */
		catch (FileNotFoundException e) {
			System.out.println("\nFile has something wrong, Please check the file name and path and try again\n");
		}
	}

	/**
	 * A static void method that set the petroleum prices as the user want them
	 */
	public static void price() {
		Scanner in = new Scanner(System.in);
		double gasoline, diesel;
		int check;
		System.out.println(
				"Please set the petroleum prices\nIf you want to change the DIESEL price enter 1\nIf you want to change the GASOLINE price enter 2\nIf you want to change BOTH types enter 0 :");
		check = in.nextInt();
		if (check == 0) {
			System.out.println("The GASOLINE price is (NIS/liter): ");
			gasoline = in.nextDouble();
			PetroleumType.setGasolinePrice(gasoline);
			System.out.println("The DIESEL price is (NIS/liter) : ");
			diesel = in.nextDouble();
			PetroleumType.setDieselPrice(diesel);
			System.out.println("GASOLINE and DIESEL prices' set successfully");
		} else if (check == 1) {
			System.out.println("The DIESEL price is (NIS/liter): ");
			diesel = in.nextDouble();
			PetroleumType.setDieselPrice(diesel);
			System.out.println("DIESEL price set successfully");
		} else if (check == 2) {
			System.out.println("The GASOLINE price is (NIS/liter): ");
			gasoline = in.nextDouble();
			PetroleumType.setGasolinePrice(gasoline);
			System.out.println("GASOLINE price set successfully");
		} else {
			System.out.println("Incorrect entry, NOTHING changed\n");
		}
		System.out.println(
				"_________________________________________________________________________________________________________________\n");
	}

	/**
	 * A static void method that will sort the vehicles depends on the cost for
	 * 100km using the override compareTo method in the Vehicles class and
	 * Collection.sort , and print them in the console and the output file
	 * 
	 * @param vehicles
	 * @throws FileNotFoundException
	 */
	public static void sortCost(ArrayList<Vehicles> vehicles) throws FileNotFoundException {

		File outputFile = new File("output.txt");
		PrintWriter out = new PrintWriter(outputFile);
		Collections.sort(vehicles);
		out.println("Vehicles sorted by cost for 100 km : \n");
		System.out.println("Vehicles sorted by cost for 100 km : \n");
		for (int i = 0; i < vehicles.size(); i++) {
			System.out.println(vehicles.get(i).toString());
			out.println(vehicles.get(i).toString());
		}

		out.close();
	}

	/**
	 * A static void method to turn the air condition ON or OFF for all vehicles as
	 * the user wants when the condition is turned on , the fuel consumption will
	 * increase 10% if it's instanceof car otherwise it will increase 20% so we
	 * change the original value of the fuel consumption , when the user turned it
	 * off it will back to it's original value
	 * 
	 * @param vehicles
	 */
	public static void turnOn(ArrayList<Vehicles> vehicles) {
		Scanner in = new Scanner(System.in);
		double increase = 0;
		System.out.println(
				"If you want to turn the air condtion ON ,please enter 1 and if you want to turn it OFF , please enter 0");
		int onF = in.nextInt();
		if (onF == 1) {
			for (int i = 0; i < vehicles.size(); i++) {
				vehicles.get(i).setAirConditionON();
				increase = vehicles.get(i).getFuelConsumption() / 100.0;
				/**
				 * only if it was turned off, we change the value of the fuel consumption
				 */
				if (airCondationStatus == false) {
					if (vehicles.get(i) instanceof Car) {
						vehicles.get(i).setFuelConsumption(vehicles.get(i).getFuelConsumption() - (increase * 10));
					} else {
						vehicles.get(i).setFuelConsumption(vehicles.get(i).getFuelConsumption() - (increase * 20));
					}
				}
			}
			/**
			 * set the static value to true so if the user turned the condition off we can
			 * set the fuel consumption to it's original value
			 */
			airCondationStatus = true;
			System.out.println("Air Condition turned ON\n");
		} else if (onF == 0) {
			for (int i = 0; i < vehicles.size(); i++) {
				vehicles.get(i).setAirConditionOff();
				/**
				 * only if it was turned on, we change the value of the fuel consumption
				 */
				if (airCondationStatus == true) {
					increase = vehicles.get(i).getFuelConsumption() / 100.0;
					if (vehicles.get(i) instanceof Car) {
						vehicles.get(i).setFuelConsumption(vehicles.get(i).getFuelConsumption() + (increase * 10));
					} else {
						vehicles.get(i).setFuelConsumption(vehicles.get(i).getFuelConsumption() + (increase * 20));
					}
				}
			}
			/**
			 * set the static value to false so if the user turned off the condition twice
			 * in a row the values won't change twice
			 */
			airCondationStatus = false;
			System.out.println("Air Condition turned OFF\n");
		} else {
			System.out.println("Incorrect entry, NOTHING changed\n");
		}
		System.out.println(
				"_________________________________________________________________________________________________________________\n");
	}

	/**
	 * A static void method to deep clone a chosen vehicle object by the user and
	 * set the owner to null
	 * 
	 * @param vehicles
	 * @throws FileNotFoundException
	 */
	public static void clonning(ArrayList<Vehicles> vehicles) throws FileNotFoundException {
		File outputFile = new File("output.txt");
		PrintWriter out = new PrintWriter(outputFile);
		Scanner in = new Scanner(System.in);
		int index = 0;
		System.out.println("Please chose the number of the vehicle you want to clone ,from 1 to " + vehicles.size());
		for (int i = 0; i < vehicles.size(); i++) {
			System.out.println((i + 1) + "-" + vehicles.get(i).toString());
		}
		index = in.nextInt();
		index--;
		try {
			Vehicles vehicleCopy = (Vehicles) vehicles.get(index).clone();
			vehicleCopy.owner.address = null;
			vehicleCopy.owner.name = null;
			vehicleCopy.owner.dateOfRegistration = null;
			vehicleCopy.owner.tel = null;
			vehicleCopy.owner.registerionNo = null;
			System.out.println("The cloned object is :");
			System.out.println(vehicleCopy.toString());
			System.out.println(
					"_________________________________________________________________________________________________________________\n");
			out.println("The cloned object is :");
			out.println(vehicleCopy);
			out.close();

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * A static void method that will sort the vehicles in ascending order depends
	 * on the owner name, and print them in the output file and in the console
	 * 
	 * @param vehicles
	 * @throws FileNotFoundException
	 */
	public static void ownerNameSort(ArrayList<Vehicles> vehicles) throws FileNotFoundException {
		File outputFile = new File("output.txt");
		PrintWriter out = new PrintWriter(outputFile);
		ArrayList<Vehicles> temp = new ArrayList<>();
		temp.add(vehicles.get(0));
		for (int i = 0; i < vehicles.size(); i++) {
			for (int j = 0; j < vehicles.size() - 1; j++) {
				String nameOne = vehicles.get(j).owner.getName();
				String nameTwo = vehicles.get(j + 1).owner.getName();
				if (nameOne.compareTo(nameTwo) > 0) {
					temp.add(vehicles.get(j));
					vehicles.set(j, vehicles.get(j + 1));
					vehicles.set(j + 1, temp.get(temp.size() - 1));

				}
			}
		}
		out.println("Vehicles sorted by owner name : \n");
		System.out.println("Vehicles sorted by owner name : \n");
		for (int i = 0; i < vehicles.size(); i++) {
			out.println(vehicles.get(i).toString());
			System.out.println(vehicles.get(i).toString());
		}
		System.out.println(
				"_________________________________________________________________________________________________________________\n");
		out.close();

	}

	/**
	 * * A static void method that will sort the vehicles in descending order
	 * depends on the brand name, and print them in the output file and in the
	 * console
	 * 
	 * @param vehicles
	 * @throws FileNotFoundException
	 */
	public static void brandNameSort(ArrayList<Vehicles> vehicles) throws FileNotFoundException {
		File outputFile = new File("output.txt");
		PrintWriter out = new PrintWriter(outputFile);
		ArrayList<Vehicles> temp = new ArrayList<>();
		temp.add(vehicles.get(0));
		for (int i = 0; i < vehicles.size(); i++) {

			for (int j = 0; j < vehicles.size() - 1; j++) {
				String brandOne = vehicles.get(j).getBrand();
				String brandTwo = vehicles.get(j + 1).getBrand();
				if (brandOne.compareTo(brandTwo) < 0) {
					temp.add(vehicles.get(j));
					vehicles.set(j, vehicles.get(j + 1));
					vehicles.set(j + 1, temp.get(temp.size() - 1));

				}
			}
		}
		out.println("Vehicles sorted by brand name : \n");
		System.out.println("Vehicles sorted by brand name : \n");
		for (int i = 0; i < vehicles.size(); i++) {
			out.println(vehicles.get(i).toString());
			System.out.println(vehicles.get(i).toString());
		}
		System.out.println(
				"_________________________________________________________________________________________________________________\n");
		out.close();

	}

	/**
	 * EXTRA method , A static void method that will sort the vehicles in ascending
	 * order depends on the model name, and print them in the output file and in the
	 * console
	 * 
	 * @param vehicles
	 * @throws FileNotFoundException
	 */
	public static void modelNameSort(ArrayList<Vehicles> vehicles) throws FileNotFoundException {
		File outputFile = new File("output.txt");
		PrintWriter out = new PrintWriter(outputFile);
		ArrayList<Vehicles> temp = new ArrayList<>();
		temp.add(vehicles.get(0));
		for (int i = 0; i < vehicles.size(); i++) {
			for (int j = 0; j < vehicles.size() - 1; j++) {
				String nameOne = vehicles.get(j).getModelName();
				String nameTwo = vehicles.get(j + 1).getModelName();
				if (nameOne.compareTo(nameTwo) > 0) {
					temp.add(vehicles.get(j));
					vehicles.set(j, vehicles.get(j + 1));
					vehicles.set(j + 1, temp.get(temp.size() - 1));

				}
			}
		}
		out.println("Vehicles sorted by model name : \n");
		System.out.println("Vehicles sorted by model name : \n");
		for (int i = 0; i < vehicles.size(); i++) {
			out.println(vehicles.get(i).toString());
			System.out.println(vehicles.get(i).toString());
		}
		System.out.println(
				"_________________________________________________________________________________________________________________\n");
		out.close();

	}

	/**
	 * * A static void method that will print the vehicle having the greatest tunk
	 * size
	 * 
	 * @param vehicles
	 * @throws FileNotFoundException
	 */
	public static void greatestTunkSize(ArrayList<Vehicles> vehicles) throws FileNotFoundException {
		File outputFile = new File("output.txt");
		PrintWriter out = new PrintWriter(outputFile);
		ArrayList<Vehicles> temp = new ArrayList<>();
		temp.add(vehicles.get(0));
		for (int i = 0; i < vehicles.size() - 1; i++) {
			if (vehicles.get(i).getTunkSize() < vehicles.get(i + 1).getTunkSize()) {
				temp.set(0, vehicles.get(i + 1));
			}
		}
		out.println("Vehicles Having greatest tunk size is : \n");
		out.println(temp);
		System.out.println("Vehicles Having greatest tunk size is : \n");
		System.out.println(temp);
		System.out.println(
				"_________________________________________________________________________________________________________________\n");
		out.close();
	}

	/**
	 * Extra method to calculate every type of the engines
	 * 
	 * @param vehicles
	 * @throws FileNotFoundException
	 */
	public static void engineTypesCnt(ArrayList<Vehicles> vehicles) throws FileNotFoundException {
		File outputFile = new File("output.txt");
		PrintWriter out = new PrintWriter(outputFile);
		int cntDiesel = 0, cntGasoline = 0, cntHybrid = 0;
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getEngineType().equalsIgnoreCase("diesel")) {
				cntDiesel++;
			} else if (vehicles.get(i).getEngineType().equalsIgnoreCase("gasoline")) {
				cntGasoline++;
			} else {
				cntHybrid++;
			}
		}
		out.println("Number of vehicles having engine of type Diesel is : " + cntDiesel + "\n");
		out.println("Number of vehicles having engine of type Gasoline is : " + cntGasoline + "\n");
		out.println("Number of vehicles having engine of type Hybrid is : " + cntHybrid + "\n");

		System.out.println("Number of vehicles having engine of type Diesel is : " + cntDiesel + "\n");
		System.out.println("Number of vehicles having engine of type Gasoline is : " + cntGasoline + "\n");
		System.out.println("Number of vehicles having engine of type Hybrid is : " + cntHybrid + "\n");
		System.out.println(
				"_________________________________________________________________________________________________________________\n");
		out.close();
	}
}
