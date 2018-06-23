
public class Person {
		public Person() {
			System.out.println("person here");
		}
		public Person (int i) {
			System.out.println("person here : "+i);	
		}

		private int id;
		private String name;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}


