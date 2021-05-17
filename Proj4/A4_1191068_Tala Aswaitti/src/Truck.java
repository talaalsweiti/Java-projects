
/**
 * 
 * * @author Tala - 1191068 , Create the following Truck class with the
 * following fields
 *
 */
public class Truck extends Vehicles {
	/**
	 * Integer number of seats in a vehicle.
	 */
	private int numberOfSeats;
	/**
	 * Boolean status of air-condition's working: ON/OFF
	 */
	private boolean airConditionON;
	/**
	 * Horse Power of a vehicle's engine.
	 */
	private int power;

	/**
	 * A no-argument constructor to set a default values
	 */
	public Truck() {
		super();
		numberOfSeats = 2;
		airConditionON = false;
		power = 300;
	}

	/**
	 * A constructor with arguments using the 3 following attributes,to assign the
	 * values when the object is created
	 * 
	 * @param numberOfSeats
	 * @param airConditionON
	 * @param power
	 */
	public Truck(String classType, String modelName, String modelNo, String brand, Owner owner, String engineType,
			double tunkSize, double fuelConsumption, int numberOfSeats, boolean airConditionON, int power) {
		super(classType, modelName, modelNo, brand, owner, engineType, tunkSize, fuelConsumption);
		setAirConditionON(airConditionON);
		/**
		 * we used try/catch because setNumberOfSeats or setPower may throw Illegal
		 * Argument Exception
		 */
		try {
			setNumberOfSeats(numberOfSeats);
			setPower(power);
		} catch (IllegalArgumentException ie) {
			setNumberOfSeats(5);
			System.out.println(ie);
		}
	}

	/**
	 * A method to get the number of seats
	 * 
	 * @return number of seats
	 */
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	/**
	 * A method to set the number of seats, it should be greater than zero and less
	 * or equal to 10 , else the program will throw an exception and set the value
	 * to 5
	 * 
	 * @param numberOfSeats
	 */
	public void setNumberOfSeats(int numberOfSeats) throws IllegalArgumentException {
		if (numberOfSeats > 0 && numberOfSeats <= 10)
			this.numberOfSeats = numberOfSeats;
		else
			throw new IllegalArgumentException(
					"Invaild entary, number of seats could not be negative or zero for the truck,please try again");
	}

	/**
	 * A method to return the air condition status
	 * 
	 * @return air condition status
	 */
	public boolean isAirConditionON() {
		return airConditionON;
	}

	/**
	 * overloaded method to set the air condition status
	 * 
	 * @param airConditionON
	 */
	public void setAirConditionON(boolean airConditionON) {
		this.airConditionON = airConditionON;
	}

	/**
	 * A method to get the power of the truck
	 * 
	 * @return
	 */
	public int getPower() {
		return power;
	}

	/**
	 * A method to set the power of the truck , it should not be negative
	 * 
	 * @param power
	 */
	public void setPower(int power) throws IllegalArgumentException {
		if (power >= 0)
			this.power = power;
		else
			throw new IllegalArgumentException("Invaild entary, power could not be negative or zero,please try again");
	}

	@Override
	/**
	 * A method to calculate the cost for 100km ,by divide the fuel consumption from
	 * 100 then multiply it with the liter price .
	 */
	public double costFor100Km(PetroleumType petroleumType) {
		double literPrice = PetroleumType.getDieselPrice();

		double fuelConsumption = super.getFuelConsumption();

		double fuelConsumptionFor100 = 100 / fuelConsumption;
		double cost = literPrice * fuelConsumptionFor100;
		return cost;

	}

	@Override
	/**
	 * an override method to set the air condition value to ON
	 */
	public boolean setAirConditionON() {
		// TODO Auto-generated method stub
		setAirConditionON(true);
		return true;
	}

	@Override
	/**
	 * an override method to set the air condition value to Off
	 */
	public boolean setAirConditionOff() {
		// TODO Auto-generated method stub
		setAirConditionON(false);
		return false;
	}

	@Override
	/**
	 * an override method displaying all the information for the truck
	 */
	public String toString() {
		return "ModelName: " + getModelName() + ", Brand: " + getBrand() + ", Owner: " + super.owner.toString()
				+ ", EngineType: " + getEngineType() + ", TankSize: " + getTunkSize() + " liter, " + "FuelConsumption: "
				+ getFuelConsumption() + " km/liter, " + "NumberOfSeat: " + getNumberOfSeats() + ", Movable distance: "
				+ super.movableDistance() + " Km, " + "Cost for 100 Km: " + costFor100Km(new PetroleumType()) + " NIS,"
				+ "Power :" + getPower() + " Horse\n";
	}

}
