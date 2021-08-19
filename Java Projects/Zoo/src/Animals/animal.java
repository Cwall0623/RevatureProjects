package Animals;

public class animal {
	public String name;
	public int age;
	public double weight;
	public tag tag;
	public void funFact() {
		System.out.println("animals are fun");
	}

public animal () {
	System.out.println("Animal no args called");
}

public animal(String name, int age, double weight, tag tag) {
	
	this.name = name;
	this.age = age;
	this.weight = weight;
	this.tag = tag;

}
}
