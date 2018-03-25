package mininet;

public abstract class Person {
	private String name;
	private String imageURL;
	private String status;
	private int age;
	private boolean isParent = false;
	
	public Person(String iName, String iImageURL, String iStatus, int iAge) {
		name = iName;
		imageURL = iImageURL;
		status = iStatus;
		age = iAge;
	}
}
