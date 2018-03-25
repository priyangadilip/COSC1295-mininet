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
}
