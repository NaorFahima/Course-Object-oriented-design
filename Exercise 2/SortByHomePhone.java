package Task_2;

import java.util.Comparator;

public class SortByHomePhone implements Comparator<Contact> {

	@Override
	public int compare(Contact o1, Contact o2) { // compare by home
	 return o1.getHouseNumber().compareTo(o2.getHouseNumber());
	}


}
