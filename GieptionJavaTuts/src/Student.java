
public class Student extends Person implements LifeStyle{

	@Override
	public void humanLifeStyle() {
		System.out.println("Student is lazy");
	}
	
	@Override
	public void money() {
		System.out.println("Student is Rich ");
		
	}
}
