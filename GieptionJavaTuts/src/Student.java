public class Student extends Person {

	public static int result = 0;
	
	public static char grade = 'F';
	
	public static final char maxNumberofStudents = 100; //final is const
	
	public Student() {
		System.out.println("Student");
	}
	
	public Student(int i) {
		super(i);
		System.out.println("Student : " + i);
	}
	
	public static void studentResult() {
		System.out.println("Student 's result is excellent " + "its " + result +" which is " + grade);
	}

	/*
	@Override
	public void humanLifeStyle() {
		System.out.println("Student is lazy");
	}
	
	@Override
	public void money() {
		System.out.println("Student is Rich ");
		
	}*/
}