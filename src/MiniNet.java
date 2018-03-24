package mininet;

public class MiniNet {
	private static final boolean ENV_DEVELOPMENT = true;

	public static void main(String args[]) {
		Driver menuDriver = new Driver();
		
		try {
		  menuDriver.startMenu();
		} catch (Exception e) {
			System.out.println("There was some error. Please try again ");
			
			if(ENV_DEVELOPMENT) {
				e.printStackTrace();
			}
		}
		
	}
}
