package mininet;

import java.util.HashMap;

public class Connection {
	private Person person;
	private HashMap<Integer, Relation> links = new HashMap<Integer, Relation>();
	
	public Connection(Person iPerson) {
		person = iPerson;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void linkWithPerson(Person p, Relation relation) {
		links.put(p.getName().hashCode(), relation);
	}
	
	public boolean isDirectFriend(Integer hashcode) {
		Relation r =  links.get(hashcode);
		
		if(r == null) {
			return false;
		}
		
		return true;
	}
}
