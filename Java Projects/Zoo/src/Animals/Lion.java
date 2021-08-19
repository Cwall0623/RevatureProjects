package Animals;

public class Lion extends animal{
	public Lion(String name, int age, double weight, tag tag) {
		
	}
	
	public Lion() {
		this("Larry", 10, 100.00, new tag());	
	}
	public void funFact() {
		System.out.println("Lion hunts in prides");
		
	}
	float maneSize  = 16f;
	public void lionMainLength() {
		System.out.println("The Length of the mane" + maneSize);
	}
}
