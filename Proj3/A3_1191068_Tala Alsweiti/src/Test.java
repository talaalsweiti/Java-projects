
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author Tala - 1191068 , create the Test class to put the employees
 *         informations in it
 *
 */
public class Test {

	public static void main(String[] args) {

		/**
		 * create the budget object that have the monthly sales and monthly expenses
		 * values to use it for the unique method
		 */
		Employee budget = new Employee(3000000, 2000);

		/**
		 * create an array list of of Employee that have two types of every sub class
		 */
		ArrayList<Employee> employees = new ArrayList<>();

		Address firstAddress = new Address("Main", "Palestine", "Hebron", 345);
		ProductionWorker firstEmployee = new ProductionWorker(1, 10, 100, "Tala", "123-A", new Date(120, 11, 18),
				firstAddress);
		employees.add(0, firstEmployee);

//		ProductionWorker secEmployee = new ProductionWorker();
//		employees.add(1, secEmployee);

		Address thirdAddress = new Address("Rukab", "Palestine", "Ramallah", 45);
		ShiftSupervisor thirdEmployee = new ShiftSupervisor(1000, 50, 100, 50, "Zeina", "343-B", new Date(119, 4, 2),
				thirdAddress);
		employees.add(1, thirdEmployee);

//		Address fourthAddress = new Address("ALsalam", "Palestine", "Ramallah", 35);
//		ShiftSupervisor fourthEmployee = new ShiftSupervisor(1000, 10, 40, 50, "Sami", "133-C", new Date(119, 2, 3),
//				fourthAddress);
//		employees.add(3, fourthEmployee);

		Address fifthAddress = new Address("Main", "Palestine", "Ramallah", 245);
		TeamLeader fifthEmployee = new TeamLeader(1, 10, 300, 100, 50, 55, "Shahd", "343-F", new Date(120, 3, 2),
				fifthAddress);
		employees.add(2, fifthEmployee);

//		Address sixthAddress = new Address("Main", "Palestine", "Rammallah", 1);
//		TeamLeader sixthEmployee = new TeamLeader(2, 10, 300, 100, 50, 45, "Tarek", "125-H", new Date(120, 6, 7),
//				sixthAddress);
//		employees.add(5, sixthEmployee);

		System.out.println(
				"---------------------------------WELCOME TO the Palestinian Dairy Factory---------------------------------\n");
		System.out.println("Please enter the employees information");
		System.out.println(
				"\n**Note that if you enterd an invalid employee number , invalid shift value, hire date that is after the current date or\nnegative values..THE PROGRAM WON'T WORK and will show an error message**");

		System.out.println(
				"\n**********************************************************************************************************");

		System.out.println("Number of employees is : " + employees.size() + "\n");
		netProfit(budget, employees);

		System.out.println(
				"_____________________________________________________________________________________________");
		System.out.println("The employees are : ");
		for (int i = 0; i < employees.size(); i++) {

			System.out.println("\n" + employees.get(i).toString());
			System.out.println(
					"_____________________________________________________________________________________________");

		}
		System.out.println(
				"*********************************************************************************************");
		ListGreaterThanAverage(employees);

	}

	/**
	 * A method that takes the array list of employees and print all employees who
	 * their salary is greater than the average salary
	 * 
	 * @param list
	 */
	public static void ListGreaterThanAverage(ArrayList<Employee> list) {
		double average, sum = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof ProductionWorker)
				sum += ((ProductionWorker) list.get(i)).getTotalSalary();
			else if (list.get(i) instanceof ShiftSupervisor)
				sum += ((ShiftSupervisor) list.get(i)).getTotalSalary();
			else
				sum += ((TeamLeader) list.get(i)).getTotalSalary();
		}
		average = sum / list.size();
		System.out.println("The average is : " + average
				+ "\nEmployees who their salary is greater than average of all employees are :");
		System.out.println(
				"\n*********************************************************************************************");
		System.out.println(" ");
		for (int i = 0; i < list.size(); i++) {
			/*
			 * check the object is from any sub class (using instanceof) and make casting
			 * for it
			 */
			if (list.get(i) instanceof ProductionWorker)
				if (((ProductionWorker) list.get(i)).getTotalSalary() > average) {
					System.out.println(list.get(i).toString());
					System.out.println(
							"_____________________________________________________________________________________________");

				} else if (list.get(i) instanceof ShiftSupervisor)
					if (((ShiftSupervisor) list.get(i)).getTotalSalary() > average) {
						System.out.println(list.get(i).toString());
						System.out.println(
								"_____________________________________________________________________________________________");

					} else if (list.get(i) instanceof TeamLeader)
						if (((TeamLeader) list.get(i)).getTotalSalary() > average) {
							System.out.println(list.get(i).toString());
							System.out.println(
									"_____________________________________________________________________________________________");

						}

		}
	}

	/*
	 * My unique method , that calculate the net profit for the factory by subtract
	 * the monthly expenses and total salary from the monthly sales
	 */
	public static void netProfit(Employee budget, ArrayList<Employee> list) {
		double profit = budget.getMonthlySales();
		double totalSalary = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof ProductionWorker)
				totalSalary += ((ProductionWorker) list.get(i)).getTotalSalary();
			else if (list.get(i) instanceof ShiftSupervisor)
				totalSalary += ((ShiftSupervisor) list.get(i)).getTotalSalary();
			else
				totalSalary += ((TeamLeader) list.get(i)).getTotalSalary();
		}
		profit -= (totalSalary + budget.getMonthlyExpenses());
		System.out.println("The factory monthly sales = " + budget.getMonthlySales()
				+ " and The factory monthly expenses = " + budget.getMonthlyExpenses());
		System.out.println("The total salaries for all employees = " + totalSalary);
		System.out.println("The factory net profit is = " + profit);
	}

}
