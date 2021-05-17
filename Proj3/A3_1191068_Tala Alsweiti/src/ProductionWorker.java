
import java.util.Date;

/**
 * 
 * @author Tala - 119068 Create the following ProductionWorker class that
 *         inherits from the Employee class
 *
 */
public class ProductionWorker extends Employee {
	/**
	 * the shift attribute that determine which shift the employee is working in one
	 * or two
	 */
	private int shift;
	/**
	 * the hourlyPayRate that determine the payment for every hour the employee
	 * worked
	 */
	private double hourlyPayRate;
	/**
	 * the number of hours the employee worked per month
	 */
	private double numberOfHoursPerMonth;

	/**
	 * A non-argument constructor to set a default values
	 */
	public ProductionWorker() {
		super();
		shift = 1;
		hourlyPayRate = 10;
		numberOfHoursPerMonth = 250;
	}

	/**
	 * A constructor with arguments using the 8 following attributes
	 * 
	 * @param shift                 to assign shift value to the shift at the time
	 *                              of object creation
	 * @param hourlyPayRate         to assign hourlyPayRate value to the
	 *                              hourlyPayRate at the time of object creation
	 * @param numberOfHoursPerMonth to assign hourlyPayRate value to the
	 *                              hourlyPayRate at the time of object creation
	 * @param employeeName          to assign employeeName value to the employeeName
	 *                              at the time of object creation using super() to
	 *                              send it to the super class constructor
	 * @param employeeNumber        to assign employeeNumber value to the
	 *                              employeeNumber at the time of object creation
	 *                              using super() to send it to the super class
	 *                              constructor
	 * @param hireDate              to assign hireDate value to the hireDate at the
	 *                              time of object creation using super() to send it
	 *                              to the super class constructor
	 * @param address               to assign address value to the address at the
	 *                              time of object creation using super() to send it
	 *                              to the super class constructor
	 */
	public ProductionWorker(int shift, double hourlyPayRate, double numberOfHoursPerMonth, String employeeName,
			String employeeNumber, Date hireDate, Address address) {
		super(employeeName, employeeNumber, hireDate, address);
		setShift(shift);
		setHourlyPayRate(hourlyPayRate);
		setNumberOfHoursPerMonth(numberOfHoursPerMonth);
	}

	/**
	 * A method to get the shift
	 * 
	 * @return the shift
	 */
	public int getShift() {
		return shift;
	}

	/**
	 * A method to set the shift , if it's not equal to one or two the program won't
	 * work and will show an error message
	 * 
	 * @param shift
	 */
	public void setShift(int shift) {
		if (shift == 1 || shift == 2) {
			this.shift = shift;
		} else
			/**
			 * I took this piece of code from Mr.Nabeel Khalaf
			 */
			throw new IllegalArgumentException(
					"The only allowed shift values' are day shift (=1) and night shift (=2) , Please enter a valid value ");
	}

	/**
	 * A method to get the hourly pay rate
	 * 
	 * @return the hourly pay rate
	 */
	public double getHourlyPayRate() {
		return hourlyPayRate;
	}

	/**
	 * A method to set the hourly pay rate , if it's less than zero the program
	 * won't work and will show an error message
	 * 
	 * @param hourlyPayRate
	 */
	public void setHourlyPayRate(double hourlyPayRate) {
		if (hourlyPayRate >= 0)
			this.hourlyPayRate = hourlyPayRate;
		else
			/**
			 * I took this piece of code from Mr.Nabeel Khalaf
			 */
			throw new IllegalArgumentException("Hourly pay rate value is negative , Please enter an allowed one");
	}

	/**
	 * A method to get number of hours per month
	 * 
	 * @return number of hours per month
	 */
	public double getNumberOfHoursPerMonth() {
		return numberOfHoursPerMonth;
	}

	/**
	 * A method to set the number of hours per month ,if it's less than zero the
	 * program won't work and will show an error message
	 * 
	 * @param numberOfHoursPerMonth
	 */
	public void setNumberOfHoursPerMonth(double numberOfHoursPerMonth) {
		if (numberOfHoursPerMonth >= 0)
			this.numberOfHoursPerMonth = numberOfHoursPerMonth;
		else
			/**
			 * I took this piece of code from Mr.Nabeel Khalaf
			 */
			throw new IllegalArgumentException("The number of hours is negative , Please enter an allowed one");
	}

	/**
	 * A method that will calculate the salary for every employee depends on the
	 * number of hours per month , the hourly rate , shift and if he worked extra
	 * hours
	 * 
	 * @return salary
	 */
	public double getTotalSalary() {
		double salary;
		salary = numberOfHoursPerMonth * hourlyPayRate;
		if (shift == 1) {
			/**
			 * if the employee worked extra hours the payment will be added to the salary
			 */
			if (numberOfHoursPerMonth > 208) {
				salary += ((numberOfHoursPerMonth - 208) * hourlyPayRate * 1.25);

			}

		}

		if (shift == 2) {
			if (numberOfHoursPerMonth > 182) {
				/**
				 * if the employee worked extra hours the payment will be added to the salary
				 */
				salary += ((numberOfHoursPerMonth - 182) * hourlyPayRate * 1.5);
			}

		}
		return salary;
	}

	/**
	 * A method that will concatenate the employee information from the employee
	 * class with his position , salary , shift , hourly rate and number of hours
	 * per month in one string
	 * 
	 * @override
	 */
	public String toString() {
		String result = super.toString();
		result += "\nEmployee position is a Proudction Worker";
		result += "\nEmployee shift is : " + getShift();
		result += "\nEmployee hourly pay rate : " + getHourlyPayRate();
		result += "\nEmployee worekd " + getHourlyPayRate() + " hours";
		result += "\nEmployee Salary is : " + getTotalSalary();

		return result;

	}

}
