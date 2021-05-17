
/**
 * 
 * * @author Tala - 1191068 , Create the following Minivan class with the
 * following fields
 *
 */
public class Minivan extends Vehicles {
	/**
	 * Integer number of seats in a vehicle.
	 */
	private int numberOfSeats;
	/**
	 * Boolean status of air-condition's working: ON/OFF
	 */
	private boolean airConditionON;
	/**
	 * Boolean status of a vehicle's having auto door
	 */
	private boolean hasAutoDoors;

	/**
	 * A no-argument constructor to set a default values
	 */
	public Minivan() {
		super();
		numberOfSeats = 2;
		airConditionON = false;
		hasAutoDoors = false;
	}

	/**
	 * A constructor with arguments using the 3 following attributes,to assign the
	 * values when the object is created
	 * 
	 * @param numberOfSeats
	 * @param airConditionON
	 * @param hasAutoDoors
	 */
	public Minivan(String classType, String modelName, String modelNo, String brand, Owner owner, String engineType,
			double tunkSize, double fuelConsumption, int numberOfSeats, boolean airConditionON, boolean hasAutoDoors) {
		super(classType, modelName, modelNo, brand, owner, engineType, tunkSize, fuelConsumption);
		setAirConditionON(airConditionON);
		setHasAutoDoors(hasAutoDoors);
		/**
		 * we used try/catch because setNumberOfSeats may throw Illegal Argument
		 * Exception
		 */
		try {
			setNumberOfSeats(numberOfSeats);
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
			throw new IllegalArgumentException("Invaild entary for the number of seats the value will be set to 5");
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
	 * A method to return if the car has auto doors
	 * 
	 * @return true if the car has auto doors otherwise false
	 */
	public boolean isHasAutoDoors() {
		return hasAutoDoors;
	}

	/**
	 * A method to set the car auto doors status
	 * 
	 * @param hasAutoDoors
	 */
	public void setHasAutoDoors(boolean hasAutoDoors) {
		this.hasAutoDoors = hasAutoDoors;
	}

	@Override
	/**
	 * A method to calculate the cost for 100km ,by divide the fuel consumption from
	 * 100 then multiply it with the liter price .
	 */
	public double costFor100Km(PetroleumType petroleumType) {
		double literPrice = PetroleumType.getGasolinePrice();

		double fuelConsumption = super.getFuelConsumption();
		if (super.getEngineType().equalsIgnoreCase("Diesel")) {
			literPrice = PetroleumType.getDieselPrice();
		}
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
	 * an override method displaying all the information for the minivan
	 */
	public String toString() {
		return "ModelName: " + getModelName() + ", Brand: " + getBrand() + ", Owner: " + super.owner.toString()
				+ ", EngineType: " + getEngineType() + ", TankSize: " + getTunkSize() + " liter, " + "FuelConsumption: "
				+ getFuelConsumption() + " km/liter, " + "NumberOfSeat: " + getNumberOfSeats() + ", Movable distance: "
				+ super.movableDistance() + " Km, " + "Cost for 100 Km: " + costFor100Km(new PetroleumType()) + " NIS,"
				+ " Auto doors :" + isHasAutoDoors() + "\n";

	}

}
