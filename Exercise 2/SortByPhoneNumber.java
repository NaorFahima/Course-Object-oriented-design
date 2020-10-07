package Task_2;

import java.util.Comparator;

public class SortByPhoneNumber implements Comparator<Contact>  {

	@Override
	public int compare(Contact o1, Contact o2) { // compre by phone
		 return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
	}

	
}
