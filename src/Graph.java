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
  }

  public void deletePersonByName(String name) {
  }
  
  // Change it - Temp
  public void displayAll() {
  }
}
