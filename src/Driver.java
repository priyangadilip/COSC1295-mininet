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

	}
	
	private void deletePerson() {

	}
	
	private void selectPerson() {

	}
	
	private void updatePerson() {

	}
	
	public void checkDirectFriend() {

	}
	
	public void connectPersons() {

	}
}
