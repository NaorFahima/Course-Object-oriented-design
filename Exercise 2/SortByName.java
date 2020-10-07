package Task_2;

import java.util.Comparator;

public class SortByName implements Comparator<Contact> {

	@Override
	public int compare(Contact o1, Contact o2) { // compre by name
		return o1.getFirstName().compareTo(o2.getFirstName()) + 
				o1.getLastName().compareTo(o2.getLastName());
	}

}
