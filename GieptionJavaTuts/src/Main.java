
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
	
	private  int add( int a , int b) {
		int c = a+b;
		return c;
		
	}
}
