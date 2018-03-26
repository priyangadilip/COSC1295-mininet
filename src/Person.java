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
	
	public String getName() {
		return name;
	}
	
	public void setName(String iName) {
	  name = iName;	
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int iAge) {
		age = iAge;
	}
	
	public void display() {
		System.out.format("%40s %5s %30s %30s", name, age, status, imageURL);
		System.out.println();
	}
}
