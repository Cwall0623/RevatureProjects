package Day5;

public class Sumulator {
	public static void main(String[] args) {
		
		Dog d = new Dog();
		d.name = "brian";
		d.breed = "bull dog";
		d.age = 2;
		d.weight = 60;
		
	
		Dog fido = new Dog("Fido","Dane", 10, 10, true);
		System.out.println(d.name);
		System.out.println(fido.name);
		System.out.println(fido.age);
		System.out.println(fido.breed);
		System.out.println(fido.vaccination);
		
	}
}
