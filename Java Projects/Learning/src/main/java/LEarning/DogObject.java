package LEarning;

public class DogObject {
	public String name;
	public int age;
	public String breed;
	
	public void bark() {
		
		System.out.println("Woof Woof");
	}
	public void feed() {
		System.out.println("You didnt state the type of food!");
		
	}
public void feed(String food) {
		System.out.println("you feed your dog some: " + food);
}
}
