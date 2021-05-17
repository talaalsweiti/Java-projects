
/**
 * 
 * @author Tala - 1191068 , Create the following Vehicles class with the
 *         following fields
 *
 */
public abstract class Vehicles implements Cloneable, Comparable<Vehicles> {
	/**
	 * Model name of a vehicle
	 */
	protected String modelName;
	/**
	 * Model number of a vehicle
	 */
	protected String modelNo;
	/**
	 * Company to produce the model
	 */
	protected String brand;
	/**
	 * Type of the engine. Classified by fuel type to be used such as
	 * gasoline,diesel or hybrid
	 */
	protected String engineType;
	/**
	 * Size of fuel tank. Unit is liter.
	 */
	protected double tunkSize;
	/**
	 * Fuel consumption. Unit is km/liter.
	 */
	protected double fuelConsumption;
	/**
	 * Owner of the vehicle (as object)
	 */
	public Owner owner;

	/**
	 * A no-argument constructor to set a default values
	 */
	public Vehicles() {
		modelName = "Camley";
		modelNo = "ER500";
		brand = "Toyota";
		engineType = "Hybrid";
		tunkSize = 50;
		fuelConsumption = 2;
	}

	/**
	 * A constructor with arguments using the 7 following attributes,to assign the
	 * values when the object is created
	 * 
	 * @param classType
	 * @param modelName
	 * @param modelNo
	 * @param brand
	 * @param engineType
	 * @param tunkSize
	 * @param fuelConsumption
	 */
	public Vehicles(String classType, String modelName, String modelNo, String brand, Owner owner, String engineType,
			double tunkSize, double fuelConsumption) {
		setModelName(modelName);
		setModelNo(modelNo);
		setBrand(brand);
		setOwner(owner);
		try {
			setTunkSize(tunkSize);
			setFuelConsumption(fuelConsumption);
		} catch (IllegalArgumentException ie) {
			setTunkSize(1);
			System.out.println(ie);
		}
		try {
			setEngineType(engineType, classType);

		} catch (IllegalArgumentException ie) {
			if (classType.equals("truck")) {
				setEngineType("Diesel", classType);
			}

			else {
				setEngineType("Gasoline", classType);
			}
			System.out.println(ie);
		}

	}

	/**
	 * A method to get the model name
	 * 
	 * @return model name
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * A method to set the model name
	 * 
	 * @param modelName
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * A method to get the model number
	 * 
	 * @return model number
	 */
	public String getModelNo() {
		return modelNo;
	}

	/**
	 * A method to set the model number
	 * 
	 * @param modelNo
	 */
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	/**
	 * A method to get the brand
	 * 
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * A method to set the brand
	 * 
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * A method to get the engine type
	 * 
	 * @return engine type
	 */
	public String getEngineType() {
		return engineType;
	}

	/**
	 * A method to set the engine type ,The Car uses only gasoline engine . The
	 * Minivan can use engine of both gasoline and diesel.The Truck uses only diesel
	 * engine. else , the program will throw illegal argument exception and The and
	 * value will Automatically set
	 * 
	 * @param engineType
	 * @param classType
	 */
	public void setEngineType(String engineType, String classType) throws IllegalArgumentException {
		if (classType.equals("car")) {
			if (engineType.equalsIgnoreCase("gasoline") || engineType.equalsIgnoreCase("Hybrid")) {
				this.engineType = engineType;
			} else {
				throw new IllegalArgumentException(
						"The engine type you enterd is not allowed for cars from type Car. The engine type will Automatically set to 'Gasoline'");
			}
		} else if (classType.equals("minivan")) {
			if (engineType.equalsIgnoreCase("gasoline") || engineType.equalsIgnoreCase("Hybrid")
					|| engineType.equalsIgnoreCase("diesel")) {
				this.engineType = engineType;
			} else {
				throw new IllegalArgumentException(
						"The engine type you enterd is not allowed for cars from type Minivan.The engine type will Automatically set to 'Gasoline'");
			}
		} else if (classType.equals("truck")) {
			if (engineType.equalsIgnoreCase("diesel")) {
				this.engineType = engineType;
			} else {
				throw new IllegalArgumentException(
						"The engine type you enterd is not allowed for cars from type Truck.The engine type will Automatically set to 'Diesle'");
			}
		} else {
			throw new IllegalArgumentException("The invalid engine type");
		}

	}

	/**
	 * A method to get the tunk size
	 * 
	 * @return tunk size
	 */
	public double getTunkSize() {
		return tunkSize;
	}

	/**
	 * A method to set the tunk size , the tunk size should be greater than 0 ,if it
	 * is not the program will throw illegal argument exception
	 * 
	 * @param tunkSize
	 */
	public void setTunkSize(double tunkSize) throws IllegalArgumentException {
		if (tunkSize > 0)
			this.tunkSize = tunkSize;
		else
			throw new IllegalArgumentException(
					"Invaild entary, tunk size could not be negative or zero,the value wll be set to 1");
	}

	/**
	 * A method to get the fuel consumption
	 * 
	 * @return
	 */
	public double getFuelConsumption() {
		return fuelConsumption;
	}

	/**
	 * A method to set the fuel consumption,it should not be negative , if it is the
	 * program will throw illegal argument exception
	 * 
	 * @param fuelConsumption
	 */
	public void setFuelConsumption(double fuelConsumption) throws IllegalArgumentException {
		if (fuelConsumption >= 0) {
			this.fuelConsumption = fuelConsumption;
		} else
			throw new IllegalArgumentException(
					"Invaild entary, fuel consumption could not be negative,the value will be set to 0");
	}

	/**
	 * A method to get the owner
	 * 
	 * @return owner
	 */
	public Owner getOwner() {
		return owner;
	}

	/**
	 * A method to set the owner
	 * 
	 * @param owner
	 */
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	/**
	 * abstract method to calculate the cost for 100 km
	 * 
	 * @param petroleunType
	 * @return costFor100Km
	 */
	public abstract double costFor100Km(PetroleumType petroleunType);

	/**
	 * A method to calculate the movable distance , by multiply the fuel consumption
	 * with the tunk size
	 * 
	 * @return movable distance
	 */
	public double movableDistance() {
		double distance = getFuelConsumption() * getTunkSize();
		return distance;
	}

	/**
	 * abstract method to set the air condition on
	 * 
	 * @return true boolean value
	 */
	public abstract boolean setAirConditionON();

	/**
	 * abstract method to set the air condition off
	 * 
	 * @return false boolean value
	 */
	public abstract boolean setAirConditionOff();

	@Override
	/**
	 * An override method to compare between the cars based on the cost for 100Km
	 */
	public int compareTo(Vehicles o) {
		if (costFor100Km(new PetroleumType()) > o.costFor100Km(new PetroleumType()))
			return 1;
		else if (costFor100Km(new PetroleumType()) < o.costFor100Km(new PetroleumType()))
			return -1;

		return 0;
	}

	/**
	 * a method to deep clone any chosen object , return the cloned object
	 */
	public Object clone() throws CloneNotSupportedException {
		Vehicles vehicleCpy = (Vehicles) super.clone();
		vehicleCpy.owner = (Owner) (owner.clone());
		return vehicleCpy;
	}
}