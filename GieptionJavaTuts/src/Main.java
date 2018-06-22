public class Main {

	public static void main(String[] args) {

	Book BookBoy = new Book();
	BookBoy.tellStory();
		
	Book bookman = new Book(" Unreal Engine and C++ are the best");
	bookman.tellStory();
	
	int size = 10;
	
	int array_One[] = {1,2,3,4,5};
	int array_two[] = new int[size]; //allocate 10 container in array
	
	for (int i =0; i<size; i++) {
		array_two[i] = i;
	}

	for (int i =0; i<size; i++) {
		System.out.println("Position "+i+" :"+array_two[i]);
	}
	
	for (int i=0; i<array_One.length; i++) {
		System.out.println("Position "+i+" :"+array_One[i]);	
	}
	
/*	Apple apple = new Apple();
	Apple apple1 = new Apple();
	
	apple.isFresh = true;
	apple.isRed = true;
	apple.simpleMessage();
	
	
	System.out.println(apple.isFresh);
	verifyFresh(apple.isFresh);
	
	apple.compare(apple.isFresh,apple.isRed);
	
	System.out.println("\n");
	
	apple1.simpleMessage();
	System.out.println(apple1.isFresh);
	verifyFresh(apple1.isFresh);
	
	apple1.compare(apple1.isFresh,apple1.isRed);

	}
	
	private static void verifyFresh( boolean isFresh) {
		if(isFresh) {
			System.out.println("Fresh fruit");
		}
		else {
			System.out.println("Bad fruit");
		}
	}
	*/
	
	
	/*
	private static String name = "Global Variable";  // static, can be called anywhere in the class,
														// basically .h header file of a C++ class /* 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Global Variable " + name);
		
		String name2= "Local Variable"; 
		System.out.println("Local Variable "+name2);
		
	for (int i = 0 ; i<5; i++) {
		System.out.println(i);
		
	}
	
	int i = 2;
		while(i<100)
		{
			i=i+5;
			System.out.println(i);
		}
		System.out.println(Linear(2,3,10));
		
		System.out.println(add(2,3));
	}
	
	private static int Linear( int m , int x, int c) {
		int y = m + x + c;
		
		return y;
	}
	
	private static  int add( int a , int b) {
		int c = a+b;
		return c;
	}
	*/
	

	}
}