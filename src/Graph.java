package mininet;

import java.util.*;

public class Graph {
  private HashMap<Integer, Connection> network = new HashMap<Integer, Connection>();

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
  
  public Person getPersonByName(String name) {
	  int hash = name.hashCode();
	  
	  if(network.containsKey(hash)) {
		 Person person =(Person) network.get(hash).getPerson();
		 
		 return person;
	  }
	  
	  return null;
  }
}
