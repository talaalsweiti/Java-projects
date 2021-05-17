import java.util.Date;

/**
 * 
 * @author Tala Alsweiti - 1191068 , Create the following Car class with eight
 *         attributes and two constructors
 */
public class Car {

	private String plateNo; // the car plate number
	private int yearManufacture; // the car manufacturing year
	private int monthManufacture; // the car manufacturing month
	private String color; // the car color
	private double price; // the car price
	private String manufactureBy; // the car manufacturing company
	private int guaranteeDueYear; // the car guarantee due year
	private int guaranteeDueMonth; // the car guarantee due month

	/**
	 * Creating a No-argument constructor: that initialize a car object using the
	 * given values in the example
	 */
	public Car() {
		/**
		 * to get the current year from the system, the getYear method calculate the
		 * difference between the current year and 1900 so so we add 1900 to the value
		 * to get the current year
		 **/
		int currentYear = new Date().getYear() + 1900;
		/**
		 * to get the current month from the system, the getMonth method give us values
		 * from 0 to 11 so we add 1 to get the correct current month
		 **/
		int currentMonth = new Date().getMonth() + 1;
		plateNo = "0123-A"; // the default value of the car plate number
		yearManufacture = currentYear; // the default value of the car manufacturing year
		monthManufacture = currentMonth; // the default value of the car manufacturing month
		color = "red"; // the default value of the car color
		price = 50000.00; // the default value of the car price
		manufactureBy = "Mercedes"; // the default value of the car manufacturing company
		/**
		 * the default value of the car guarantee due year, if the current month is more
		 * than 6 it will add one to the default value of guarantee due year else if the
		 * current month is equal or less to 6 it will add zero
		 **/
		guaranteeDueYear = currentYear + ((currentMonth + 6) / 12);
		/**
		 * the default value for the car guarantee due month, if the current month is
		 * more than 6 it will 6 to the current month but with taking into consideration
		 * that it will be in the next year,else it will add 6 normally
		 */
		guaranteeDueMonth = ((currentMonth + 6) % 12);
	}

	/**
	 * A constructor with arguments using the 8 following attributes
	 * 
	 * @param plateNo           assign plate number value to the class plateNo
	 *                          variable at the time of object creation
	 * @param yearManufacture   assign manufacturing year value to the class
	 *                          yearManufacture variable at the time of object
	 *                          creation
	 * @param monthManufacture  assign manufacturing month value to the class
	 *                          monthManufacture variable at the time of object
	 *                          creation
	 * @param color             assign color value to the class color variable at
	 *                          the time of object creation
	 * @param price             assign price value to the class price variable at
	 *                          the time of object creation
	 * @param manufactureBy     assign manufacturing company value to the class
	 *                          manufactureBy variable at the time of object
	 *                          creation
	 * @param guaranteeDueYear  assign guarantee due year value to the class
	 *                          guaranteeDueYear variable at the time of object
	 *                          creation
	 * @param guaranteeDueMonth assign guarantee due month value to the class
	 *                          guaranteeDueMonth variable at the time of object
	 *                          creation
	 */
	public Car(String plateNo, int yearManufacture, int monthManufacture, String color, double price,
			String manufactureBy, int guaranteeDueYear, int guaranteeDueMonth) {
		this.plateNo = plateNo;
		setYearManufacture(yearManufacture);
		setMonthManufacture(monthManufacture);
		this.color = color;
		this.price = price;
		this.manufactureBy = manufactureBy;
		setGuarantee(guaranteeDueMonth, guaranteeDueYear);

	}

	/**
	 * A method to get the manufacturing company value
	 * 
	 * @return the manufacturing company
	 */
	public String getManufactureBy() {
		return manufactureBy;
	}

	/**
	 * A method to get the manufacturing year
	 * 
	 * @return the manufacturing year
	 */
	public int getYearManufacture() {
		return yearManufacture;
	}

	/**
	 * A method to get the manufacturing month
	 * 
	 * @return the manufacturing month
	 */
	public int getMonthManufacture() {
		return monthManufacture;
	}

	/**
	 * A method to get the color
	 * 
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * A method to get the price
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * A method to set the manufacturing year , if it's greater than the current
	 * year or it's less than zero the program will stop and show an error message
	 * else it will set the manufacturing year value to the year variable
	 * 
	 * @param year the value to compare with the current year
	 */
	public void setYearManufacture(int year) {
		int currentYear = new Date().getYear() + 1900;
		int currentMonth = new Date().getMonth() + 1;
		if (year > currentYear || year < 0)
			/**
			 * I took this piece of code from Mr.Nabeel Khalaf
			 */
			throw new IllegalArgumentException("Error , Invalid manufacture year . Please enter correct year");
		else
			yearManufacture = year;

	}

	/**
	 * A method to set the manufacturing month, if it's less than 1 or greater then
	 * 12 the program will stop and show an error message, else it will set the
	 * manufacturing month value to the month variable
	 * 
	 * @param month the value to compare with the current month
	 */
	public void setMonthManufacture(int month) {
		if (month < 1 || month > 12)
			/**
			 * I took this piece of code from Mr.Nabeel Khalaf
			 */
			throw new IllegalArgumentException("Error , Invalid manufacture month . Please enter correct month");
		else
			monthManufacture = month;
	}

	/**
	 * A method to set the color value
	 * 
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * method to set the guarantee due month and guarantee due year, if the
	 * guarantee due year is less than the manufacture year OR if it's less than 0
	 * OR the guarantee due month is less than 1 or greater than 12 the program will
	 * stop and show an error message ,else it will set the values
	 * 
	 * @param month the value to compare with the current month
	 * @param year  the value to compare with the current year
	 */
	public void setGuarantee(int month, int year) {
		int currentYear = new Date().getYear() + 1900;
		int currentMonth = new Date().getMonth() + 1;
		if (year < getYearManufacture() || year < 0 || month < 1 || month > 12)
			/**
			 * I took this piece of code from Mr.Nabeel Khalaf
			 */
			throw new IllegalArgumentException(
					"Error , Invalid guarantee year OR month . Please enter correct year/month");
		else {

			guaranteeDueYear = year;
			guaranteeDueMonth = month;
		}

	}

	/**
	 * A method to calculate the car age comparing to the current year
	 * 
	 * @return a string with the car age in years and months
	 */
	public String getCarAge() {
		int currentYear = new Date().getYear() + 1900;
		int currentMonth = new Date().getMonth() + 1;
		int ageYears, ageMonths;

		if (getYearManufacture() == currentYear) {
			/**
			 * if the manufacturing year is equal to the current year and the manufacturing
			 * month is less or equal the current month it will subtract the manufacturing
			 * month from the current month else the hasn't manufactured yet so we can't
			 * calculate the age
			 */
			if (getMonthManufacture() <= currentMonth) {
				ageMonths = currentMonth - getMonthManufacture();
				return "The car's age is : " + ageMonths + " months";
			} else {
				return "The car hasn't manufactured yet";
			}

		} else {
			if (getMonthManufacture() <= currentMonth) {
				/**
				 * else if the manufacturing year is less than the current year and the
				 * manufacturing month is less or equal the current month the age in years age
				 * in months will be a subtraction between the current year/month and the
				 * manufacturing year/month else if manufacturing month is greater than the
				 * current month , the age in years will be current year subtracted one and
				 * manufacturing year from it and the age in months will be 12 subtracted
				 * manufacturing month plus current month
				 */
				ageYears = currentYear - getYearManufacture();
				ageMonths = currentMonth - getMonthManufacture();
				return "The car's age is : " + ageYears + " years and " + ageMonths + " months";
			}

			else {
				ageYears = currentYear - getYearManufacture() - 1;
				ageMonths = 12 - getMonthManufacture() + currentMonth;
				return "The car's age is " + ageYears + " years and " + ageMonths + " months";
			}
		}

	}

	/**
	 * A method to calculate the reaming years and months for guarantee
	 * 
	 * @return A string with number years and months left for the guarantee to
	 *         expire
	 */
	public String getCalculateGuarantee() {
		int currentYear = new Date().getYear() + 1900;
		int currentMonth = new Date().getMonth() + 1;
		int yearsLeft, monthsLeft;
		if (guaranteeDueYear > currentYear) {
			/**
			 * if the guarantee due year is greater than the current year and the guarantee
			 * due month is less than the current month ,the years left will be the
			 * guarantee due year subtracted the current month and one and the months left
			 * will be guarantee due month plus 12 subtracted the current month else it will
			 * be a subtraction between the current year/month and the guarantee due
			 * year/month
			 */
			if (guaranteeDueMonth < currentMonth) {
				yearsLeft = guaranteeDueYear - 1 - currentYear;
				monthsLeft = guaranteeDueMonth + (12 - currentMonth);
				return "Guarantee will expire in " + yearsLeft + " years and " + monthsLeft + " months";
			}

			else {
				yearsLeft = guaranteeDueYear - currentYear;
				monthsLeft = Math.abs(guaranteeDueMonth - currentMonth);
				return "Guarantee will expire in " + yearsLeft + " years and " + monthsLeft + " months";
			}
		}
		/**
		 * else if guarantee due year is equal to the current year and the guarantee due
		 * month is greater than the current month the months left will be guarantee due
		 * month subtracted the current months else the guarantee is expired
		 */
		else if (guaranteeDueYear == currentYear) {
			if (guaranteeDueMonth > currentMonth) {
				monthsLeft = guaranteeDueMonth - currentMonth;
				return "Guarantee will expire in " + monthsLeft + " months";
			} else
				return "Guarantee is expired ";
		}
		/**
		 * if the guarantee due year is less than the current year the guarantee is
		 * expired
		 */
		else {
			return "Guarantee is expired ";
		}
	}

	/**
	 * A method to print all the car information
	 * 
	 * @return a string with all the car information in upper case
	 */
	public String printCarInfo() {
		String result = "\nthe Car Plate No is : " + plateNo;
		result += "\nthe Car color is : " + getColor();
		result += "\nthe Car is Manufacture by : " + getManufactureBy();
		result += "\nthe Car price is : " + getPrice();
		result += "\nthe car Year manufacture : " + getYearManufacture() + " and Month manufacture : " + getMonthManufacture();
		result += "\n" + getCarAge();
		result += "\nGuarantee year Due " + guaranteeDueYear + " and Guarantee month due to " + guaranteeDueMonth;
		result += "\n" + getCalculateGuarantee();
		return result.toUpperCase();
	}

}
