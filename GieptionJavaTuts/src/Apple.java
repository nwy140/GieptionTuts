
public class Apple {
	
	boolean isFresh = true;
	boolean isRed =false;
	
	public void simpleMessage() {
		System.out.println("An Apple");
	}
	
	public  void compare(boolean isF, boolean isR) {
		if(isF && isR) {
			System.out.println("Fruit apple is fresh and red");
		} else if(isF || isR) {
			System.out.println("Fruit apple is fresh or  red");
		 if (isF) { 
			System.out.println("Turn out fresh");
			
		} else if (isR) { 
			System.out.println("Turn out Red");			
		}
		}
	}
}
