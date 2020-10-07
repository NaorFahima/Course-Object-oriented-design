package Task_2; //name: Naor Fahima ; ID:315783563 ; Number of task = 2

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class mainContact {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		Scanner sca = new Scanner(System.in);
		int answer;
		int index = 0;
		String ans;
		String FName, LName, phoneNumber, houseNumber;
		ContactLinkedList list = new ContactLinkedList();

		do {
			menu();
			answer = sca.nextInt();
			System.out.println();
			switch (answer) {

			case 1: // ADD/UPFATE CONTACT

				System.out.println("ADD/UPFATE CONTACT:");
				System.out.print("Enter First Name: ");
				FName = sca.next();
				System.out.print("Enter Last Name: ");
				LName = sca.next();
				System.out.print("Enter Mobile Number: ");
				phoneNumber = sca.next();
				System.out.print("Enter Home Number :");
				houseNumber = sca.next();

				Contact contact = new Contact(FName, LName, phoneNumber, houseNumber, list);
				list.add(contact);
				break;

			case 2: // REMOVE CONTACT
				do {
					System.out.println("REMOVE CONTACT:");
					System.out.println("1. By Name");
					System.out.println("2. By Home");
					System.out.println("3. By Mobile");
					System.out.print("Your Option: ");
					answer = sca.nextInt();
					switch (answer) {
					case 1: // REMOVE CONTACT By Name
						System.out.print("Enter First Name: ");
						FName = sca.next();
						System.out.print("Enter Last Name: ");
						LName = sca.next();
						System.out.println("Result: ");
						index = list.findContactByName(FName, LName);
						break;
					case 2: // REMOVE CONTACT By Home
						System.out.print("Enter Home Number: ");
						houseNumber = sca.next();
						System.out.println("Result: ");
						index = list.findContactByHome(houseNumber);
						break;
					case 3: // REMOVE CONTACT By Mobile
						System.out.print("Enter Phone Number: ");
						phoneNumber = sca.next();
						System.out.println("Result: ");
						index = list.findContactByPhone(phoneNumber);
						break;
					default:
						System.out.println("You need to choice number between (1-3)\n");
						break;
					}
				} while (answer < 1 || answer > 3);
				
				if (index != -1) {
					sca = new Scanner(System.in);
					System.out.print("Are You Sure? y/n: "); 
					ans = sca.nextLine();
					if (ans.charAt(0) == 'y') { // cheack if you shre you want to delete the contact
						list.remove(index);
						System.out.println("Result: Contact Removed!");
					}
				}
				break;

			case 3: // SAVE CONTACTS
				list.saveContactsToFile();
				break;

			case 4: // LOAD CONTACTS
				list.loadContactsFromFile();
				break;

			case 5: // SORT CONTACT
				do {
					System.out.println("SORT CONTACT:");
					System.out.println("1. By Name");
					System.out.println("2. By Home");
					System.out.println("3. By Mobile");
					System.out.print("Your Option: ");
					answer = sca.nextInt();
					switch (answer) {
					case 1: // SORT CONTACT By Name
						list.sort(new SortByName());
						list.print();;
						break;
					case 2: // SORT CONTACT By Home
						list.sort(new SortByHomePhone());
						list.print();;
						break;
					case 3: // SORT CONTACT By Phone
						list.sort(new SortByPhoneNumber());
						list.print();;
						break;
					default:
						System.out.println("You need to choice number between (1-3)\n");
						break;
					}
				} while (answer < 1 || answer > 3);
				break;
			case 6: // SEARCH CONTACT
				do {
					System.out.println("SEARCH CONTACT:");
					System.out.println("1. By Name");
					System.out.println("2. By Home");
					System.out.println("3. By Mobile");
					System.out.print("Your Option: ");
					answer = sca.nextInt();
					switch (answer) {
					case 1: // SEARCH CONTACT By Name
						System.out.print("Enter First Name: ");
						FName = sca.next();
						System.out.print("Enter Last Name: ");
						LName = sca.next();
						System.out.println("Result: ");
						index = list.findContactByName(FName, LName);
						break;
					case 2: // SEARCH CONTACT By Home
						System.out.print("Enter Home Number: ");
						houseNumber = sca.next();
						System.out.println("Result: ");
						index = list.findContactByHome(houseNumber);
						break;
					case 3: // SEARCH CONTACT By Phone
						System.out.print("Enter Phone Number: ");
						phoneNumber = sca.next();
						System.out.println("Result: ");
						index = list.findContactByPhone(phoneNumber);
						break;
					default:
						System.out.println("You need to choice number between (1-3)");
						break;
					}
				} while (answer < 1 || answer > 3);
				break;
			case 7: // PRINT LIST
				if (list.getAllContact().isEmpty()) {
					System.out.println("List is empty");
				} else {
					System.out.println(list);
				}
				break;

			default:
				System.out.println("Bye Bye");
				break;
			}
		} while (answer >= 1 && answer <= 7);
		sca.close();
	}

	
	public static void menu() {
		System.out.println("\n- - - - - - - - - - - - - - - ");
		System.out.println("- - - Contact Creator : - - -");
		System.out.println("- - - - - - - - - - - - - - -");
		System.out.println("1. Add/Update Contact");
		System.out.println("2. Remove Contact");
		System.out.println("3. Save Contacts To File");
		System.out.println("4. Load Contacts From File");
		System.out.println("5. Sort Contact By Name");
		System.out.println("6. Search Contact");
		System.out.println("7. Print All Contacts");
		System.out.println(" - - - - - - - - - - - - - - -");
		System.out.println("Choose your option or any other key to EXIT.");
		System.out.print("Your Option: ");
	}

}
