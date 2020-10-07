package Task_1;   //name: Naor Fahima ; ID:315783563 ; Number of task = 1

import java.io.Serializable;

public class Contact implements Comparable<Contact> ,Serializable {

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String houseNumber;
	

	
	public Contact(String firstName, String lastName, String phoneNumber, String houseNumber,ContactsList list) {
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setHouseNumber(houseNumber);
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		if (firstName.length() < 3) {
			this.firstName = null;
			System.out.println("The First Name needs at least 3 characters");
		} else {
			this.firstName = firstName;
		}
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		if (lastName.length() < 3) {
			this.firstName = null;
			System.out.println("The Last Name needs at least 3 characters");
		} else {
			this.lastName = lastName;
		}	
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber.length() <10) {
			this.firstName = null;
			System.out.println("The Phone Number needs at least 10 digits");
		}
		this.phoneNumber = phoneNumber;
	}


	public String getHouseNumber() {
		return houseNumber;
	}


	public void setHouseNumber(String houseNumber) {
		if (houseNumber.length() <9) {
			this.firstName = null;
			System.out.println("The Phone Number needs at least 9 digits");
		}
		this.houseNumber = houseNumber;
	}


	public int compareTo(Contact other) {
		return firstName.compareTo(other.firstName) + lastName.compareTo(other.lastName);
	}

	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", houseNumber=" + houseNumber + "]\n";
	}
	
	
	
	
}
