
import java.util.Date;

/**
 * 
 * @author Tala - 1191068 , Create the following Employee class
 *
 */
public class Employee {
	private String employeeName;
	private String employeeNumber;
	private Date hireDate;
	private Address address;
	/**
	 * the factory monthly sales
	 */
	private double monthlySales;
	/**
	 * the factory monthly expenses
	 */
	private double monthlyExpenses;

	/**
	 * A non-argument constructor to set a default values
	 */
	public Employee() {
		employeeName = "Ahmad";
		employeeNumber = "123-G";
		hireDate = new Date();
		address = new Address();

	}

	/**
	 * A constructor with arguments using the 4 following attributes
	 * 
	 * @param employeeName   to assign employee name value to the employeeName at
	 *                       the time of object creation
	 * @param employeeNumber to assign employee number value to the employeeNumber
	 *                       at the time of object creation
	 * @param hireDate       to assign the hire date
	 * @param address        to assign the address values from the class Address
	 *                       using Aggregation
	 */
	public Employee(String employeeName, String employeeNumber, Date hireDate, Address address) {
		this.employeeName = employeeName;
		setEmployeeNumber(employeeNumber);
		setHireDate(hireDate);
		this.address = address;

	}

	/**
	 * A constructor with arguments using the 2 following attributes , used for my
	 * unique method
	 * 
	 * @param monthlySales    to assign the monthly sales value to monthlySales at
	 *                        the time of object creation
	 * @param monthlyExpenses to assign the monthly expenses value to
	 *                        monthlyExpenses at the time of object creation
	 */
	public Employee(double monthlySales, double monthlyExpenses) {
		setMonthlySales(monthlySales);
		setMonthlyExpenses(monthlyExpenses);
	}

	/**
	 * A method to get the hire date
	 * 
	 * @return the hire date
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * A method to set the hire date , if it's after the current date the program
	 * won't work , else it will set the value for the hire date
	 * 
	 * @param hireDate
	 */
	public void setHireDate(Date hireDate) {
		Date currentDate = new Date();
		if (hireDate.compareTo(currentDate) < 1) {
			this.hireDate = hireDate;
		}

		else
			/**
			 * I took this piece of code from Mr.Nabeel Khalaf
			 */
			throw new IllegalArgumentException("The hire date is after the cuurent date , Please enter a valid date");

	}

	/**
	 * A method to get the Employee Name
	 * 
	 * @return the Employee Name
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * A method to set the Employee Name
	 * 
	 * @param employeeName
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * A method to get the Employee Number
	 * 
	 * @return the Employee Number
	 */
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * A method to set the Employee Number and checks if the employee number is
	 * valid or not using isEmpNumberValid method,if it's not ,the program will stop
	 * and show an error message to the user
	 * 
	 * @param employeeNumber
	 */
	public void setEmployeeNumber(String employeeNumber) {
		boolean valid = isEmpNumberValid(employeeNumber);
		if (valid == false) {

			throw new IllegalArgumentException(
					"Error , Invalid employee number . Please enter correct employee number");

		} else

			this.employeeNumber = employeeNumber;
	}

	/**
	 * A method to get the address
	 * 
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * A method to set the address
	 * 
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * A method to get the monthly sales
	 * 
	 * @return the monthly sales
	 */
	public double getMonthlySales() {
		return monthlySales;
	}

	/**
	 * A method to set the monthly sales , if it's less than zero , the program
	 * won't work and will show an error message
	 * 
	 * @param monthlySales
	 */
	public void setMonthlySales(double monthlySales) {
		if (monthlySales >= 0)
			this.monthlySales = monthlySales;
		else

			throw new IllegalArgumentException("The monthly sales value is negative , Please enter an allowed one");

	}

	/**
	 * A method to get the monthly expenses
	 * 
	 * @return the monthly expenses
	 */
	public double getMonthlyExpenses() {
		return monthlyExpenses;
	}

	/**
	 * A method to set the monthly expenses , if it's less than zero , the program
	 * won't work and will show an error message
	 * 
	 * @param monthlyExpenses
	 */
	public void setMonthlyExpenses(double monthlyExpenses) {
		if (monthlyExpenses >= 0)
			this.monthlyExpenses = monthlyExpenses;
		else

			throw new IllegalArgumentException("The monthly expenses value is negative , Please enter an allowed one");

	}

	/**
	 * A boolean method to check if the number is valid or not , if the 4th digit of
	 * the number is not between A-M then it's not valid and the method will return
	 * false also if the first three digits should be between 0 and 9
	 * 
	 * @param employeeNumber
	 * @return true/false
	 */
	public boolean isEmpNumberValid(String employeeNumber) {

		if (employeeNumber.charAt(4) > 'M' || employeeNumber.charAt(4) < 'A')
			return false;
		for (int i = 0; i < 3; i++) {
			if (employeeNumber.charAt(i) < '0' || employeeNumber.charAt(i) > '9')
				return false;

		}
		return true;
	}

	/**
	 * A method that will concatenate the employee name , number , hire date and
	 * address in one string
	 */
	public String toString() {

		String result = "Employee name is : " + getEmployeeName();
		result += "\nEmployee number is : " + getEmployeeNumber();
		result += "\nEmployee hire date is : " + hireDate;
		result += "\nEmployee Address is : " + address.toString();

		return result;
	}

}
