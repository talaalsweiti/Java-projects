
import java.util.Date;

/**
 * 
 * @author Tala - 119068 Create the following ProductionWorker class that
 *         inherits from the ProductionWorker class
 *
 */
public class TeamLeader extends ProductionWorker {
	private double monthlyBonus;
	private double requiredTrainingHours;
	private double trainingHoursAttended;

	/**
	 * A non-argument constructor to set a default values
	 */
	public TeamLeader() {
		super();
		monthlyBonus = 100;
		requiredTrainingHours = 50;
		trainingHoursAttended = 55;
	}

	/**
	 * @param monthlyBonus          to assign monthly bonus value to the
	 *                              monthlyBonus at the time of object creation
	 * @param requiredTrainingHours to assign required training hours value to the
	 *                              requiredTrainingHours at the time of object
	 *                              creation
	 * @param trainingHoursAttended to assign training hours attended value to the
	 *                              trainingHoursAttended at the time of object
	 *                              creation
	 * 
	 * @param shift                 to assign shift value to the shift at the time
	 *                              of object creation using super() to send it to
	 *                              the super class constructor
	 * @param hourlyPayRate         to assign hourlyPayRate value to the
	 *                              hourlyPayRate at the time of object creation
	 *                              using super() to send it to the super class
	 *                              constructor
	 * @param numberOfHoursPerMonth to assign hourlyPayRate value to the
	 *                              hourlyPayRate at the time of object creation
	 *                              using super() to send it to the super class
	 *                              constructor
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
	public TeamLeader(int shift, double hourlyPayRate, double numberOfHoursPerMonth, double monthlyBonus,
			double requiredTrainingHours, double trainingHoursAttended, String employeeName, String employeeNumber,
			Date hireDate, Address address) {
		super(shift, hourlyPayRate, numberOfHoursPerMonth, employeeName, employeeNumber, hireDate, address);

		setMonthlyBonus(monthlyBonus);
		setRequiredTrainingHours(requiredTrainingHours);
		setTrainingHoursAttended(trainingHoursAttended);

	}

	/**
	 * A method to get the monthly bonus
	 * 
	 * @return monthlyBonus
	 */
	public double getMonthlyBonus() {
		return monthlyBonus;
	}

	/**
	 * A method to set the monthly bonus , if it's less than zero the program won't
	 * work and will show an error message
	 * 
	 * @param monthlyBonus
	 */
	public void setMonthlyBonus(double monthlyBonus) {
		if (monthlyBonus >= 0)
			this.monthlyBonus = monthlyBonus;
		else
			/**
			 * I took this piece of code from Mr.Nabeel Khalaf
			 */
			throw new IllegalArgumentException("The monthly bonus value is negative , Please enter an allowed one");

	}

	/**
	 * A method to get the required training hours
	 * 
	 * @return
	 */
	public double getRequiredTrainingHours() {
		return requiredTrainingHours;
	}

	/**
	 * A method to set the required training hours , if it's less than zero the
	 * program won't work and will show an error message
	 * 
	 * @param requiredTrainingHours
	 */
	public void setRequiredTrainingHours(double requiredTrainingHours) {
		if (requiredTrainingHours >= 0)
			this.requiredTrainingHours = requiredTrainingHours;
		else
			/**
			 * I took this piece of code from Mr.Nabeel Khalaf
			 */
			throw new IllegalArgumentException(
					"The required training hours value is negative , Please enter an allowed one");
	}

	/**
	 * A method to get the training hours attended
	 * 
	 * @return trainingHoursAttended
	 */
	public double getTrainingHoursAttended() {
		return trainingHoursAttended;
	}

	/**
	 * A method to set the training hours attended , if it's less than zero the
	 * program won't work and will show an error message
	 * 
	 * @param trainingHoursAttended
	 */
	public void setTrainingHoursAttended(double trainingHoursAttended) {
		if (trainingHoursAttended >= 0)
			this.trainingHoursAttended = trainingHoursAttended;
		else
			/**
			 * I took this piece of code from Mr.Nabeel Khalaf
			 */
			throw new IllegalArgumentException(
					"The training hours attended value is negative , Please enter an allowed one");

	}

	/**
	 * A method that will calculate the bonus achieved for the team leader and
	 * adding it to his salary from the ProductionWorker class, by multiply the
	 * monthly bonus with the training hours attended and divide it with the
	 * required training hours
	 * 
	 * @return salary
	 */
	public double getTotalSalary() {
		double bonusAchieved;

		bonusAchieved = monthlyBonus * trainingHoursAttended / requiredTrainingHours;

		double salary = super.getTotalSalary() + bonusAchieved;

		return salary;

	}

	/**
	 * A method that will concatenate the employee information from the employee
	 * class with his position , salary , monthly bonus,required training hours and
	 * training hours attended in one string
	 * 
	 * @override
	 */
	public String toString() {
		String result = super.toString();
		result += "\nThe employee is a team leader for the proudction workers";
		result += "\nEmployee monthly bonus is : " + monthlyBonus;
		result += "\nNumber of required training hours is : " + requiredTrainingHours;
		result += "\nNumber of training hours attended is : " + trainingHoursAttended;
		result += "\nEmployee Salary : " + getTotalSalary();
		return result;

	}

}
