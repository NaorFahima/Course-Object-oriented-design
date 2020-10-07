package Task_2;   //name: Naor Fahima ; ID:315783563 ; Number of task = 2

import java.io.Serializable;

public class Contact implements Comparable<Contact> ,Serializable {

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String houseNumber;
	

	
	public Contact(String firstName, String lastName, String phoneNumber, String houseNumber,ContactLinkedList list) {
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
			System.out.println("The Phone Number needs at least 10 digits");
		} 		
		this.phoneNumber = phoneNumber;
	}


	public String getHouseNumber() {
		return houseNumber;
	}


	public void setHouseNumber(String houseNumber) {
		if (houseNumber.length() <9) {
			System.out.println("The House Number needs at least 9 digits");
		} 
		this.houseNumber = houseNumber;

	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) { //function that checks if two contacts are the same
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	public String toString() {
		return String.format("    %-15s %-15s %-15s %s\n", firstName,lastName,phoneNumber,houseNumber);
	}


	@Override
	public int compareTo(Contact o) { // check if 2 contact are the same
		return this.getFirstName().compareTo(o.getFirstName())
				+ this.getLastName().compareTo(o.getLastName());
	}


	
	
	
}
