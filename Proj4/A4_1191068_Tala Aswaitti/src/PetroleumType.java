
/**
 * 
 * * @author Tala - 1191068 , Create the following PetroleumType class with the
 * following fields
 *
 */
public class PetroleumType {
	/**
	 * a static value for that represent diesel
	 */
	public static final int DIESEL = 1;
	/**
	 * a static value for that represent gasoline
	 */
	public static final int GASOLINE = 2;
	/**
	 * Gasoline price for instance
	 */
	private static double gasolinePrice = 5.23;
	/**
	 * Diesel price for instance
	 */
	private static double dieselPrice = 4.02;

	/**
	 * A method to get the gasoline price
	 * 
	 * @return gasoline price
	 */
	public static double getGasolinePrice() {
		return gasolinePrice;
	}

	/**
	 * A method to set the gasoline price , it should not be less than zero
	 * 
	 * @param gasolinePrice
	 */
	public static void setGasolinePrice(double gasolinePrice) {
		if (gasolinePrice >= 0)
			PetroleumType.gasolinePrice = gasolinePrice;
		else {
			throw new IllegalArgumentException("Invalid entery ,Gasoline price could not be negative");
		}
	}

	/**
	 * A method to get the diesel price
	 * 
	 * @return diesel price
	 */
	public static double getDieselPrice() {
		return dieselPrice;
	}

	/**
	 * A method to set the diesel price, it should not be less than zero
	 * 
	 * @param dieselPrice
	 */
	public static void setDieselPrice(double dieselPrice) {
		if (dieselPrice >= 0)
			PetroleumType.dieselPrice = dieselPrice;
		else {
			throw new IllegalArgumentException("Invalid entery ,Diesel price could not be negative");
		}
	}

}
