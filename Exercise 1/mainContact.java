package Task_1;  //name: Naor Fahima ; ID:315783563 ; Number of task = 1

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class mainContact {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Scanner sca =new Scanner(System.in);
		int answer;
		String FName,LName,phoneNumber,houseNumber;
		ContactsList list = new ContactsList();
		
		do {
			menu();
			answer = sca.nextInt();
			switch (answer) {
			
			case 1:
				
				System.out.println("ADD/UPFATE CONTACT:");
				System.out.println("Enter First Name:");
				FName = sca.next();
				System.out.println("Enter Last Name:");
				LName = sca.next();
				System.out.println("Enter Mobile Number:");
				phoneNumber = sca.next();
				System.out.println("Enter Home Number:");
				houseNumber = sca.next();

				Contact contact = new Contact(FName, LName, phoneNumber, houseNumber,list);
				list.addContact(contact);
				break;
				
			case 2:
				
				System.out.println("REMOVE CONTACT:");
				System.out.println("Enter First Name:");
				FName = sca.next();
				System.out.println("Enter Last Name:");
				LName = sca.next();
				list.removeContact(FName, LName);
				break;
				
			case 3:
				
				list.saveContact();
				break;
				
			case 4:
				
				list.readContact();	
				break;
				
			case 5:
				
				System.out.println("REMOVE CONTACT:");
				System.out.println("Enter First Name:");
				FName = sca.next();
				System.out.println("Enter First Name:");
				LName = sca.next();
				list.findContact(FName, LName);
				break;
			
			case 6:
				if (list.getNumOfContacts() == 0) {
					System.out.println("List is empty");
				} else {
					System.out.println(list);
				}

				break;
				
			default:
				System.out.println("Bye Bye");
				break;
			}
			
		} while (answer>=1 && answer<=6 );

	}
	
	public static void menu() {
		System.out.println("\n- - - - - - - - - - - - - - - ");
		System.out.println("- - - Contact Creator : - - -");
		System.out.println("- - - - - - - - - - - - - - -");
		System.out.println("1. Add/Update Contact");
		System.out.println("2. Remove Contact");
		System.out.println("3. Save Contacts To File");
		System.out.println("4. Load Contacts From File");
		System.out.println("5. Search Contact By Name");
		System.out.println("6. Print All Contacts");
		System.out.println(" - - - - - - - - - - - - - - -");
		System.out.println("Choose your option or any other key to EXIT.");
		System.out.println("Your Option: ");
	}

}
