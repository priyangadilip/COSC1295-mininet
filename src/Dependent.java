package mininet;

import java.util.*;

public class Dependent extends Person {
 private ArrayList<Adult> parents = new ArrayList<Adult>();

 public Dependent(String iName, String iImageURL, String iStatus, int iAge) {
	 super(iName, iImageURL, iStatus, iAge);
 }
 
 public void addParents(Adult father, Adult mother) {
	 parents.add(father);
	 parents.add(mother);
 }
}
