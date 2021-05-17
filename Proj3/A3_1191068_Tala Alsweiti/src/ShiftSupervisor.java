
import java.util.Date;

/**
 * 
 * @author Tala - 119068 Create the following ShiftSupervisor class that
 *         inherits from the Employee class
 *
 */
public class ShiftSupervisor extends Employee {
	private double monthlySalary;
	private double monthlyProductionBonus;
	private int numberOfProductsProducedByTeam;
	private int numberOfProductsMustProduced;

	/**
	 * A non-argument constructor to set a default values
	 */
	public ShiftSupervisor() {
		super();
		monthlySalary = 1000;
		monthlyProductionBonus = 20;
		numberOfProductsProducedByTeam = 100;
		numberOfProductsMustProduced = 90;
	}

	/**
	 * A constructor with arguments using the 8 following attributes
	 * 
	 * @param monthlySalary                  to assign monthly salary value to the
	 *                                       monthlySalary at the time of object
	 *                                       creation
	 * @param monthlyProductionBonus         to assign monthly production bonus
	 *                                       value to the monthlyProductionBonus at
	 *                                       the time of object creation
	 * @param numberOfProductsProducedByTeam to assign number of products by team
	 *                                       value to the
	 *                                       numberOfProductsProducedByTeam at the
	 *                                       time of object creation
	 * @param numberOfProductsMustProduced   to assign number of products must
	 *                                       produce value to the
	 *                                       numberOfProductsMustProduced at the
	 *                                       time of object creation
	 * @param employeeName                   to assign employeeName value to the
	 *                                       employeeName at the time of object
	 *                                       creation using super() to send it to
	 *                                       the super class constructor
	 * @param employeeNumber                 to assign employeeNumber value to the
	 *                                       employeeNumber at the time of object
	 *                                       creation using super() to send it to
	 *                                       the super class constructor
	 * @param hireDate                       to assign hireDate value to the
	 *                                       hireDate at the time of object creation
	 *                                       using super() to send it to the super
	 *                                       class constructor
	 * @param address                        to assign address value to the address
	 *                                       at the time of object creation using
	 *                                       super() to send it to the super class
	 *                                       constructor
	 */
	public ShiftSupervisor(double monthlySalary, double monthlyProductionBonus, int numberOfProductsProducedByTeam,
			int numberOfProductsMustProduced, String employeeName, String employeeNumber, Date hireDate,
			Address address) {
		super(employeeName, employeeNumber, hireDate, address);
		setMonthlySalary(monthlySalary);
		setMonthlyProductionBonus(monthlyProductionBonus);
		setNumberOfProductsProducedByTeam(numberOfProductsProducedByTeam);
		setNumberOfProductsProducedMustProduced(numberOfProductsMustProduced);

	}

	/**
	 * A method to get the monthly salary
	 * 
	 * @return the monthly salary
	 */
	public double getMonthlySalary() {
		return monthlySalary;
	}

	/**
	 * A method to set the monthly salary , if it's less than zero the program won't
	 * work and will show an error message
	 * 
	 * @param monthlySalary
	 */
	public void setMonthlySalary(double monthlySalary) {
		if (monthlySalary >= 0)
			this.monthlySalary = monthlySalary;
		else
			/**
			 * I took this piece of code from Mr.Nabeel Khalaf
			 */

			throw new IllegalArgumentException("The monthly salary value is negative , Please enter an allowed one");

	}

	/**
	 * A method to get the monthly production bonus
	 * 
	 * @return monthly production bonus
	 */
	public double getMonthlyProductionBonus() {
		return monthlyProductionBonus;
	}

	/**
	 * A method to set the monthly production bonus , if it's less than zero the
	 * program won't work and will show an error message
	 * 
	 * @param monthlyProductionBonus
	 */
	public void setMonthlyProductionBonus(double monthlyProductionBonus) {
		if (monthlyProductionBonus >= 0)
			this.monthlyProductionBonus = monthlyProductionBonus;
		else
			/**
			 * I took this piece of code from Mr.Nabeel Khalaf
			 */
			throw new IllegalArgumentException(
					"The monthly production bonus value is negative , Please enter an allowed one");

	}

	/**
	 * A method to get the number of products produced by team
	 * 
	 * @return number of products produced by team
	 */
	public int getNumberOfProductsProducedByTeam() {
		return numberOfProductsProducedByTeam;
	}

	/**
	 * A method to set the number of products produced by team , if it's less than
	 * zero the program won't work and will show an error message
	 * 
	 * @param numberOfProductsProducedByTeam
	 */
	public void setNumberOfProductsProducedByTeam(int numberOfProductsProducedByTeam) {
		if (numberOfProductsProducedByTeam >= 0)
			this.numberOfProductsProducedByTeam = numberOfProductsProducedByTeam;
		else
			/**
			 * I took this piece of code from Mr.Nabeel Khalaf
			 */
			throw new IllegalArgumentException(
					"The number of products produced by the team value is negative , Please enter an allowed one");
	}

	/**
	 * A method to get the number of products must produced
	 * 
	 * @return number of products must produced
	 */
	public int getNumberOfProductsProducedMustProduced() {
		return numberOfProductsMustProduced;
	}

	/**
	 * A method to set the number of products must produced , if it's less than zero
	 * the program won't work and will show an error message
	 * 
	 * @param numberOfProductsMustProduced
	 */
	public void setNumberOfProductsProducedMustProduced(int numberOfProductsMustProduced) {
		if (numberOfProductsMustProduced >= 0)
			this.numberOfProductsMustProduced = numberOfProductsMustProduced;
		else
			/**
			 * I took this piece of code from Mr.Nabeel Khalaf
			 */
			throw new IllegalArgumentException(
					"The number of products must produced value is negative , Please enter an allowed one");
	}

	/**
	 * A method that will calculate the salary for the shift supervisor ,if his team
	 * produced number of products equal or greater to the number of products must
	 * produced , he will get the monthly bonus
	 * 
	 * @return monthlySalary
	 */
	public double getTotalSalary() {
		if (numberOfProductsProducedByTeam >= numberOfProductsMustProduced) {
			monthlySalary += monthlyProductionBonus;

		}
		return monthlySalary;
	}

	/**
	 * A method that will concatenate the employee information from the employee
	 * class with his position ,monthly bonus , number of products produced by team
	 * and must produced and salary in one string
	 * 
	 * @override
	 */
	public String toString() {
		String result = super.toString();
		result += "\nEmployee position is a shift supervisor";
		result += "\nEmployee monthly production bonus is : " + monthlyProductionBonus;
		result += "\nNumber of products must produced is : " + numberOfProductsMustProduced;
		result += "\nNumber of products produced by the team is : " + numberOfProductsProducedByTeam;
		result += "\nEmployee Salary is : " + getTotalSalary();
		return result;

	}
}
