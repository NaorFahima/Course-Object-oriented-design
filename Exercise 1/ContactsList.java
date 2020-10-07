package Task_1;   //name: Naor Fahima ; ID:315783563 ; Number of task = 1

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class ContactsList {
	
	private ArrayList<Contact> allContact;
	private int numOfContacts;
	
	public ContactsList() {
		allContact = new ArrayList<>();
		this.numOfContacts = 0;
	}
	
	
	public void saveContact() throws FileNotFoundException, IOException  {
		try (ObjectOutputStream oOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("contacts.txt")))){
			oOut.writeInt(numOfContacts);
			for (int i = 0; i < allContact.size(); i++) {
				oOut.writeObject(allContact.get(i));
			} 
		}
		System.out.println("Contact Saved To File: "+ numOfContacts);
	}

	public void readContact() throws FileNotFoundException, IOException, ClassNotFoundException  {
		try (ObjectInputStream oIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("contacts.txt")))){
			if (oIn.available() == 0) {
				System.out.println("The file is empty!");
			} else {
				int size = oIn.readInt();
				while (size > 0) {
						addContact((Contact) oIn.readObject());
						size--;
				} 
			}
			numOfContacts = allContact.size();
		}
	}
	
	
	public Contact findContact(String firstName , String lastName) {
		for (int i = 0; i < allContact.size(); i++) {
			if (allContact.get(i).getFirstName().equals(firstName) && allContact.get(i).getLastName().equals(lastName)) {
				System.out.println(allContact.get(i));
				return allContact.get(i);
			}
		} 
		System.out.println("Contact Not Found!");
		return null;
	}
	
	public void addContact(Contact contact) {
		if (contact.getFirstName() != null) {
		for (int i = 0; i < allContact.size() ; i++) {
			if (allContact.get(i).compareTo(contact) == 0) {
				allContact.remove(i);
				allContact.add(i, contact);
				System.out.println("Contact Updated!");
				return;
				}
		}
				allContact.add(contact);
				numOfContacts++;
				System.out.println("Contact Added!");
				Collections.sort(allContact);
		}
	}
	
	public void removeContact(String firstName ,String lastName) {
		for (int i = 0; i < allContact.size(); i++) {
			if (allContact.get(i).getFirstName().equals(firstName) && allContact.get(i).getFirstName().equals(lastName)) {
				allContact.remove(i);
				numOfContacts--;
				System.out.println("Contact Remove!");
				return;
			}
		}
		System.out.println("Contact NOT in the list!");
	}
	
	public String toString() {
		String str = "Contact: "+ numOfContacts + "\n";
		String ch = "";
		for (Contact c : allContact) {
			if (!ch.equals(c.getFirstName().substring(0, 1))) {
				ch = c.getFirstName().substring(0, 1);
				str +="\n"+ ch.toUpperCase() + ":\n";
			}
			str += c;
		}
		return str;
	}
	
	
	public ArrayList<Contact> getAllContact() {
		return allContact;
	}
	public void setAllContact(ArrayList<Contact> allContact) {
		this.allContact = allContact;
	}
	public int getNumOfContacts() {
		return numOfContacts;
	}
	public void setNumOfContacts(int numOfContacts) {
		this.numOfContacts = numOfContacts;
	}
	
	
	

}
