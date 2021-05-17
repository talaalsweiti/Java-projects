
/**
 * 
 * @author Tala - 119068 Create the following Address class that contain the
 *         employee address
 *
 *
 */
public class Address {
	private String street;
	private String state;
	private String city;
	private int zipCode;

	/**
	 * A non-argument constructor to set a default values
	 */
	public Address() {
		street = "Main";
		state = "Palestine";
		city = "Hebron";
		zipCode = 12;
	}

	/**
	 * 
	 * @param street  assign the street string value to street
	 * @param state   assign the state string value to state
	 * @param city    assign the city string value to city
	 * @param zipCode assign the zip code value to zipCode
	 */
	public Address(String street, String state, String city, int zipCode) {

		this.street = street;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
	}

	/**
	 * A method to get the city
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * A method to set the city
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * A method to get the the state
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * A method to set the state
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * A method to get the street
	 * 
	 * @return street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * A method to set the street
	 * 
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * A method to get the zip code
	 * 
	 * @return the zip code
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * A method to set the zip code
	 * 
	 * @param zipCode
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * A method that will concatenate the employee address (zip code , street,ciry
	 * and state ) in one string
	 * 
	 */
	public String toString() {

		String result = getZipCode() + " " + getStreet() + " Street ," + getCity() + " City ," + getState() + " State";
		return result;
	}
}
