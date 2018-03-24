package mininet;

import java.util.*;

public class Driver {
	
	private Graph graph = new Graph();
	private static Scanner reader = new Scanner(System.in);
	
	private static final String MENU_OPTIONS = "\n MiniNet Menu \n================================= \n"
			+ "1. List everyone \n"
			+ "2. Add person \n"
			+ "3. Select person \n"
			+ "4. Update person \n"
			+ "5. Connect Persons \n"
			+ "6. Is direct friend \n"
			+ "7. Delete person \n"
			+ "8. Quit \n\n"
			+ "Enter an option :: ";
	
	public void startMenu() { 
		Options option = null;

		do {
			System.out.println(MENU_OPTIONS);
			
			// We have to do this because enum is 0 based
			int input = reader.nextInt() - 1;
			
			if(Options.ignoreOptions(input)) {
				System.out.println("Please enter a valid option :( \n");	
				continue;
			}

			option = Options.getOption(input);
			
			handleMenu(option);
			
		} while(option != Options.QUIT);
	}
	
	private void handleMenu(Options option) {
		switch(option) {
		case LIST_EVERYONE:
			graph.displayAll();
			break;
			
		case DELETE_PERSON:
			this.deletePerson();
			break;
		
		case SELECT_PERSON:
			this.selectPerson();
			break;
		
		case ADD_PERSON:
		    this.addPerson();
			break;
		
		case UPDATE_PERSON:
			this.updatePerson();
			break;
		
		case CONNECT_PERSONS:
			this.connectPersons();
			break;
			
		case IS_DIRECT_FRIEND:
			this.checkDirectFriend();
			break;
			
		case QUIT:
			reader.close();
			System.out.println("You have quit the program :(");
			break;		
		}
	}
	
	private void addPerson() {
	   System.out.println("\n Add new Person");
	   reader.nextLine();
	   
	   System.out.println("\n Enter name :: ");
	   String name = reader.nextLine();
	   
	   System.out.println("\n Enter age :: ");
	   int age = reader.nextInt();
	   
	   reader.nextLine();

	   System.out.println("\n Enter status :: ");
	   String status = reader.nextLine();
	   
	   System.out.println("\n Enter image url :: ");
	   String imageURL = reader.nextLine();
	   
	   Person person = null;
	   
	   if(age > 16) {
		    person = new Adult(name, imageURL, status, age);
	   }
	   else if(age < 16) {
		    person = new Dependent(name, "", "", age);

			   System.out.println("\n Enter Father's name :: ");
			   String fatherName = reader.nextLine();
			   
			   reader.nextLine();
			   
			   System.out.println("\n Enter Mother's name :: ");
			   String motherName = reader.nextLine();
			   
			   graph.linkDependentWithParents((Dependent)person, fatherName, motherName);
	   }
	   

	   graph.addPerson(person);
	  
	   graph.displayAll();
	}
	
	private void deletePerson() {
		reader.nextLine();
		System.out.println("\n Delete person");
		
		System.out.println("\n Enter name :: ");
		String name = reader.nextLine();
		
		graph.deletePersonByName(name);
		
		graph.displayAll();
	}
	
	private void selectPerson() {
		reader.nextLine();
		System.out.println("\n Select person");
		
		System.out.println("\n Enter name :: ");
		String name = reader.nextLine();
		
		Person person = (Person)graph.getPersonByName(name);
		
		person.display();
	}
	
	private void updatePerson() {
		reader.nextLine();
		System.out.println("\n Update person");

		System.out.println("\n Enter name :: ");
		String name = reader.nextLine();
		
		Person person = (Person)graph.getPersonByName(name);

	    System.out.println("\n Enter new name :: ");
		String newName = reader.nextLine();
	
			
		if(newName != null || "".equals(newName)) {
			person.setName(newName);
		}
		   
	    System.out.println("\n Enter new age :: ");
	    int newAge = reader.nextInt();
	    
	    person.setAge(newAge);
	}
	
	public void checkDirectFriend() {
		reader.nextLine();
		System.out.println("\n Check direct friend ::");

		System.out.println("\n Enter name of 1st person :: ");
		String personA = reader.nextLine();
		
		System.out.println("\n Enter name of 2nd person :: ");
		String personB = reader.nextLine();
		
		boolean isDirectFriend = graph.isDirectFriend(personA, personB);	
		
		System.out.println("\n Is direct friend :: "+ isDirectFriend);
	}
	
	public void connectPersons() {
		reader.nextLine();
		System.out.println("\n Connect persons ::");

		System.out.println("\n Enter the 1st person name :: ");
		String personA = reader.nextLine();

		System.out.println("\n Enter 2 name :: ");
		String personB = reader.nextLine();
		
		graph.connectPersons(personA, personB, Relation.FRIEND);
	}
}
