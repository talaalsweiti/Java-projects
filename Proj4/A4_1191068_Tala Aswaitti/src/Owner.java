

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * * @author Tala - 1191068 , Create the following Owner class with the
 * following fields
 *
 */
public class Owner implements Cloneable {
	/**
	 * the vehicle owner name
	 */
	String name;
	/**
	 * the vehicle registration number
	 */
	String registerionNo;
	/**
	 * the owner address
	 */
	String address;
	/**
	 * the owner telephone number
	 */
	String tel;
	/**
	 * the vehicle registration
	 */
	Calendar dateOfRegistration;

	/**
	 * A no-argument constructor to set a default values
	 */
	public Owner() {
		name = "Ahmad";
		registerionNo = "500";
		address = "Hebron";
		tel = "0223187";
		dateOfRegistration = new GregorianCalendar();
	}

	/**
	 * A constructor with arguments using the 5 following attributes,to assign the
	 * values when the object is created
	 * 
	 * @param name
	 * @param registerionNo
	 * @param address
	 * @param tel
	 * @param dateOfRegistration
	 */
	public Owner(String name, String registerionNo, String address, String tel, Calendar dateOfRegistration) {
		setName(name);
		setRegisterionNo(registerionNo);
		setAddress(address);
		setTel(tel);
		setDateOfRegistration(dateOfRegistration);

	}

	/**
	 * A method to get the owner name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * A method to set the owner name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * A method to get the registerion number
	 * 
	 * @return registerion number
	 */
	public String getRegisterionNo() {
		return registerionNo;
	}

	/**
	 * A method to get the registerion number
	 * 
	 * @param registerionNo
	 */
	public void setRegisterionNo(String registerionNo) {
		this.registerionNo = registerionNo;
	}

	/**
	 * A method to get the owner address
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * A method to set the owner address
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * A method to get the owner telephone number
	 * 
	 * @return telephone number
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * A method to set the owner telephone number
	 * 
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * A method to get the date of registration
	 * 
	 * @return date of registration
	 */
	public Calendar getDateOfRegistration() {
		return dateOfRegistration;
	}

	/**
	 * A method to set the date of registration
	 * 
	 * @param dateOfRegistration
	 */
	public void setDateOfRegistration(Calendar dateOfRegistration) {

		this.dateOfRegistration = dateOfRegistration;
	}

	@Override
	/**
	 * override method to display the owner name
	 */
	public String toString() {
		return getName();
	}

	/**
	 * a method to deep clone any chosen object , return the cloned object
	 */
	public Object clone() throws CloneNotSupportedException {
		Owner ownerCpy = (Owner) super.clone();
		ownerCpy.dateOfRegistration = (Calendar) (dateOfRegistration.clone());
		return ownerCpy;
	}

}
