package Task_2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ContactLinkedList implements Iterable<Contact> {
	
	private Iterator<Contact> myIterator;
	private List<Contact> allContact;

	public ContactLinkedList() { // constracter
		allContact = new LinkedList<Contact>();
	}

	@Override
	public ContactIterator iterator() { // create iterator
		return new ContactIterator(this);
	}
	
	public boolean add(Contact contact) { // add contact to the list
		if (contact.getFirstName() != null && ( contact.getHouseNumber().length() >= 9 || contact.getPhoneNumber().length() >= 10)) {
		for (int i = 0; i < allContact.size() ; i++) {
			if (allContact.get(i).equals(contact)) {
				allContact.remove(i);
				allContact.add(i, contact);
				System.out.println("Contact Updated!");
				return true;
			}
		}
				allContact.add(contact);
				System.out.println("Contact Added!");
				Collections.sort(allContact, new SortByName());
				return true;
		}
		return false;
	}
	
	
	public Contact remove(int index) { // remove contact from the list
		if (index >= 0 && index < allContact.size()) {	
			Contact temp = allContact.get(index);
			allContact.remove(index);
			return temp;
		} else {
			System.out.println("Contact NOT in the list!");
			return null;
		}
	}
	
	public Contact get(int index) { // get contact from the list by index
		if (index >= 0 && index < allContact.size()) {	
			return allContact.get(index);
		} else {
			System.out.println("Contact NOT in the list!");
			return null;
		}
	}
	
	public int findContactByName(String firstName , String lastName) { // Search contact by name
		for (int i = 0; i < allContact.size(); i++) {
			if (allContact.get(i).getFirstName().equals(firstName) && allContact.get(i).getLastName().equals(lastName)) {
				System.out.println(allContact.get(i));
				return i;
			}
		} 
		System.out.println("Contact Not Found!");
		return -1;
	}
	
	public int findContactByHome(String homeNumber) { // Search contact by home number
		for (int i = 0; i < allContact.size(); i++) {
			if (allContact.get(i).getHouseNumber().equals(homeNumber)) {
				System.out.println(allContact.get(i));
				return i;
			}
		} 
		System.out.println("Contact Not Found!");
		return -1;
	}
	
	public int findContactByPhone(String phoneNumber) {  // Search contact by home number
		for (int i = 0; i < allContact.size(); i++) {
			if (allContact.get(i).getPhoneNumber().equals(phoneNumber)) {
				System.out.println(allContact.get(i));
				return i;
			}
		} 
		System.out.println("Contact Not Found!");
		return -1;
	}
	
	public void sort(Comparator<Contact> myComparator) { // sort the list
		allContact.sort(myComparator);
	}
	 
	public void saveContactsToFile() throws FileNotFoundException, IOException  { // save all contact to file
		try (ObjectOutputStream oOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("contacts.txt")))){
			oOut.writeInt(allContact.size());
			for (int i = 0; i < allContact.size(); i++) {
				oOut.writeObject(allContact.get(i));
			} 
		}
		System.out.println("Contact Saved To File: "+ allContact.size());
	}
	
	public void loadContactsFromFile() throws FileNotFoundException, IOException, ClassNotFoundException  { // load all contact from file
		try (ObjectInputStream oIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("contacts.txt")))){
			if (oIn.available() == 0) {
				System.out.println("The file is empty!");
			} else {
				int size = oIn.readInt();
				while (size > 0) {
						add((Contact) oIn.readObject());
						size--;
				}
				System.out.println(allContact.size() +" Contacts Loaded From File");
			}
		} catch (Exception e) {
			System.out.println("File Is Empty.");
		}
	}
	
	public String toString() {
		Collections.sort(allContact, new SortByName());
		String str = "Contact: "+ allContact.size() + "\n";
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
	
	public void print() {  // print all contact
		myIterator = iterator();
		Contact temp;
		while (myIterator.hasNext()) {
			temp = myIterator.next();
			System.out.printf("    %-15s %-15s %-15s %s\n", temp.getFirstName(),temp.getLastName(),temp.getPhoneNumber(),temp.getHouseNumber());
		}
	}

	public List<Contact> getAllContact() {
		return allContact;
	}

	public void setAllContact(List<Contact> allContact) {
		this.allContact = allContact;
	}
}
