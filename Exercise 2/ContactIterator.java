package Task_2;

import java.util.Iterator;
import java.util.List;

public class ContactIterator implements Iterator<Contact>{

	List<Contact> allContact;
	int index;
	
	public ContactIterator(ContactLinkedList contactLinkedList) {
		allContact = contactLinkedList.getAllContact();
		index = 0;
	}

	@Override
	public boolean hasNext() {  // check if has next contact
		return index < allContact.size() ;
	}

	@Override
	public Contact next() { // give the next contact
		if (!hasNext())
			return null;
		return allContact.get(index++);
		
	}
	
	@Override
	public void remove() {
		allContact.remove(index--);
	}


}
