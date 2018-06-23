
public class Student extends Person implements LifeStyle{
	
	private int school_fees;

	public int getSchool_fees() {
		return school_fees;
	}

	public void setSchool_fees(int school_fees) {
		this.school_fees = school_fees;
	}
	
	public void details() {
		System.out.println("The school fees for this student is RM" + school_fees);
	}

	@Override
	public void humanLifeStyle() {
		System.out.println("Student is usually lazy, do last minute homework");
		
	}
}
