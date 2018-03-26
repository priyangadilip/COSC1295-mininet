package mininet;

import java.util.*;

public class Graph {
  private HashMap<Integer, Connection> network = new HashMap<Integer, Connection>();
  private final String DIVIDER = new String(new char[120]).replace("\0", "-");
  
  // Vertex
  public void addPerson(Person person) {
	  Connection initializeConnection = new Connection(person);
	  int nameHash = person.getName().hashCode();
	  
	  network.put(nameHash, initializeConnection);
  }

  // Edges
  public void connectPersons(String personAName, String personBName, Relation relation) {
	 Connection connectionA = network.get(personAName.hashCode());
	 Connection connectionB = network.get(personBName.hashCode());

	  Person personA = connectionA.getPerson();
      Person personB = connectionB.getPerson();
      
      boolean isLessthan4 = Math.abs(personA.getAge() - personB.getAge()) < 4;
      boolean greaterthan2 = personA.getAge() > 2 && personB.getAge() > 2;
      boolean areDependents = personA instanceof Dependent  && personB instanceof Dependent;
      
      if(personA instanceof Adult && personB instanceof Adult) {
    		 connectionA.linkWithPerson(connectionB.getPerson(), relation);
    		 connectionB.linkWithPerson(connectionA.getPerson(), relation);
      }
      
      if(isLessthan4 && greaterthan2 && areDependents) {
    		 connectionA.linkWithPerson(connectionB.getPerson(), relation);
    		 connectionB.linkWithPerson(connectionA.getPerson(), relation);
      }
  }

  public void deletePersonByName(String name) {
	  int hash = name.hashCode();
	  
	  if(network.containsKey(hash)) {
		  network.remove(hash);
	  }
  }
  
  public boolean isDirectFriend(String personAName, String personBName) {
		 Connection connectionA = network.get(personAName.hashCode());

		 return connectionA.isDirectFriend(personBName.hashCode());
  }
  
  public Person getPersonByName(String name) {
	  int hash = name.hashCode();
	  
	  if(network.containsKey(hash)) {
		 Person person =(Person) network.get(hash).getPerson();
		 
		 return person;
	  }
	  
	  return null;
  }
  
  public void linkDependentWithParents(Dependent dependent, String parentAName, String parentBName) {
	  String dependentName = dependent.getName();
	  
	  Connection connectionA = network.get(parentAName.hashCode());
	  Connection connectionB = network.get(parentBName.hashCode());
	  
	  Adult adultA = (Adult) connectionA.getPerson();
      Adult adultB = (Adult) connectionB.getPerson();
		 
      dependent.addParents(adultA, adultB);

	  connectPersons(dependentName, parentAName, Relation.PARENT);
	  connectPersons(dependentName, parentBName, Relation.PARENT);
	  
	  connectPersons(parentAName, dependentName,  Relation.COUPLE);
	  connectPersons(parentAName, parentBName,  Relation.COUPLE);
	  
	  connectPersons(parentBName, parentAName,  Relation.COUPLE);
	  connectPersons(parentBName, dependentName,  Relation.COUPLE);
	 
  }
  
  // Change it - Temp
  public void displayAll() {

	  System.out.println(DIVIDER);
	  System.out.printf("%40s %5s %30s %30s", "NAME", "AGE", "STATUS", "IMAGE URL");
	  System.out.println();
	  System.out.println(DIVIDER);
		
	  
	  for(Map.Entry<Integer, Connection> entry: network.entrySet()) {
		 Connection connection = (Connection) entry.getValue();
		 Person person = connection.getPerson();
		 
		 person.display();
	  }
	  
	  System.out.println(DIVIDER);
  }
}
